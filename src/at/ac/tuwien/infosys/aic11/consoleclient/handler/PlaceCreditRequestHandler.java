package at.ac.tuwien.infosys.aic11.consoleclient.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.provider.JSONProvider;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.handler.WSHandlerConstants;

import at.ac.tuwien.infosys.aic11.dto.CreditRequest;
import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.Offer;
import at.ac.tuwien.infosys.aic11.dto.Warrantor;
import at.ac.tuwien.infosys.aic11.services.contract.ClientKeystorePasswordCallback;
import at.ac.tuwien.infosys.aic11.services.contract.ContractManagement;
import at.ac.tuwien.infosys.aic11.services.contract.ContractManagementException;
import at.ac.tuwien.infosys.aic11.services.customerrelation.CustomerRelationsManagement;
import at.ac.tuwien.infosys.aic11.services.customerrelation.CustomerRelationsManagementException;
import at.ac.tuwien.infosys.aic11.services.rating.Rating;
import at.ac.tuwien.infosys.aic11.services.rating.RatingException;

public class PlaceCreditRequestHandler {

	private CustomerRelationsManagement customerService;
	private ContractManagement contractService;
	private Rating ratingService;

	public PlaceCreditRequestHandler() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(CustomerRelationsManagement.class);
		factory.setAddress("http://localhost:8090/CustomerRelationsManagementService");
		this.customerService = (CustomerRelationsManagement) factory.create();

		JSONProvider provider = new JSONProvider();
		provider.setUnmarshallAsJaxbElement(true);
		WebClient client = WebClient.create("http://localhost:8092/",
				Collections.singletonList(provider));

		this.ratingService = JAXRSClientFactory
				.fromClient(client, Rating.class);

		factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(ContractManagement.class);
		factory.setAddress("http://localhost:8091/ContractManagementService");

		Map<String, Object> inProps = new HashMap<String, Object>();

		inProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.TIMESTAMP
				+ " " + WSHandlerConstants.SIGNATURE + " "
				+ WSHandlerConstants.ENCRYPT);
		inProps.put(WSHandlerConstants.PW_CALLBACK_CLASS,
				ClientKeystorePasswordCallback.class.getName());
		inProps.put(WSHandlerConstants.SIG_PROP_FILE,
				"keys/clientKeystore.properties");
		inProps.put(WSHandlerConstants.DEC_PROP_FILE,
				"keys/clientKeystore.properties");

		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
		factory.getInInterceptors().add(wssIn);
		// factory.getInInterceptors().add(new LoggingInInterceptor());

		Map<String, Object> outProps = new HashMap<String, Object>();

		outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.TIMESTAMP
				+ " " + WSHandlerConstants.SIGNATURE + " "
				+ WSHandlerConstants.ENCRYPT);
		outProps.put(WSHandlerConstants.USER, "clientkey");
		outProps.put(WSHandlerConstants.ENCRYPTION_USER,
				"contractmanagementkey");
		outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS,
				ClientKeystorePasswordCallback.class.getName());
		outProps.put(WSHandlerConstants.SIG_PROP_FILE,
				"keys/clientKeystore.properties");
		outProps.put(WSHandlerConstants.ENC_PROP_FILE,
				"keys/clientKeystore.properties");

		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
		factory.getOutInterceptors().add(wssOut);
		// factory.getOutInterceptors().add(new LoggingOutInterceptor());

		this.contractService = (ContractManagement) factory.create();
	}

	public CreditRequest handle(CreditRequest creditRequest, InputStream in,
			OutputStream out) throws IOException,
			CustomerRelationsManagementException, ContractManagementException,
			RatingException {
		return this.updateOffer(creditRequest, in, out);
	}

	public CreditRequest updateOffer(CreditRequest creditRequest,
			InputStream in, OutputStream out) throws IOException,
			CustomerRelationsManagementException, ContractManagementException,
			RatingException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		PrintWriter writer = new PrintWriter(out, true);
		String line;
		List<Customer> customers = this.customerService.getAllCustomers();

		if (creditRequest.getCustomer() == null) {
			// printing all customers -----------------
			if (customers != null && customers.size() > 0) {
				writer.println("Available customers:");
				for (Customer c : customers) {
					writer.printf("%3d %s\n", c.getCustomerId(), c.toString());
				}
			} else {
				writer.println("No customers available.");
				return null;
			}

			// select customer -----------------
			while (true) {
				writer.printf("Choose customer: ");
				line = reader.readLine();

				try {
					long id = Long.parseLong(line);
					for (Customer c : customers) {
						if (c.getCustomerId() == id) {
							creditRequest.setCustomer(c);
							c.setRating(this.ratingService.getRating(c
									.getCustomerId()));
							break;
						}
					}

					if (creditRequest.getCustomer() != null) {
						break;
					} else {
						throw new NumberFormatException();
					}
				} catch (NumberFormatException nfe) {
					writer.println("Invalid customer id.");
				}
			}
		}

		writer.println(creditRequest.getCustomer() + " selected.");

		// select mount and currency -----------------
		while (true) {
			writer.printf("Enter amount of money ["
					+ creditRequest.getMoney().getAmount() + "]: ");
			line = reader.readLine();

			try {
				if (line.length() > 0) {
					long amount = Long.parseLong(line);
					creditRequest.getMoney().setAmount(amount);
				}
				break;
			} catch (NumberFormatException nfe) {
				writer.println("Invalid amount of money.");
			}
		}

		writer.printf("Enter currency code ["
				+ creditRequest.getMoney().getCurrencyCode() + "]: ");
		line = reader.readLine();
		creditRequest.getMoney().setCurrencyCode(
				line.length() > 0 ? line : creditRequest.getMoney()
						.getCurrencyCode());

		// set reason ----------------------------
		writer.printf("Enter reason [" + creditRequest.getReason() + "]: ");
		line = reader.readLine();
		creditRequest.setReason(line);

		// get duration --------------------------
		while (true) {
			writer.printf("Enter duration of credit (in years) ["
					+ creditRequest.getDuration().getYears() + "]: ");
			line = reader.readLine();

			try {
				if (line.length() > 0) {
					int years = Integer.parseInt(line);
					creditRequest.getDuration().setYears(years);
				}
				break;
			} catch (NumberFormatException nfe) {
				writer.println("Invalid number of years.");
			}
		}

		// select warrantors -----------------
		writer.println("Warrantors: ");
		while (true) {
			// displaying only warrantors which are not added
			boolean addedWarrantor = false;
			for (Customer c : customers) {
				addedWarrantor = false;
				
				// skipping itself
				if (c == creditRequest.getCustomer()) {
					continue;
				}
				
				for(Warrantor w : creditRequest.getWarrantors()) {
					if( w.getCustomerId() == c.getCustomerId() ) {
						addedWarrantor = true;
						break;
					}
				}
				if( !addedWarrantor ) {
					writer.printf("%3d %s\n", c.getCustomerId(), c.toString());
				}
			}
			
			writer.printf("Select warrantor (0 for exit) [0]: ");
			line = reader.readLine();
			if (line.length() == 0 || line.equals("0")) {
				break;
			}

			try {
				long id = Long.parseLong(line);
				boolean added = false;
				for (Customer c : customers) {
					if (c.getCustomerId() == id) {
						Warrantor w = new Warrantor();
						w.setAddresses(c.getAddresses());
						w.setCreditRequests(c.getCreditRequests());
						w.setCustomerId(c.getCustomerId());
						w.setDisbursementPreference(c.getDisbursementPreference());
						w.setFirstName(c.getFirstName());
						w.setLastName(c.getLastName());
						w.setMiddleName(c.getMiddleName());
						w.setOpenBalance(c.getOpenBalance());
						w.setRating(this.ratingService.getRating(c.getCustomerId()));
						w.setWarrantedRequests(new Vector<CreditRequest>());
						
						creditRequest.getWarrantors().add(w);
						added = true;
						break;
					}
				}

				if (added) {
					continue;
				} else {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException nfe) {
				writer.println("Invalid customer id.");
			}
		}

		Offer offer = this.contractService.createOffer(creditRequest);
		creditRequest.setOffer(offer);

		writer.println(offer);
		writer.println(offer.getInterestRate());
		writer.println("Ratings: ");
		writer.println(creditRequest.getCustomer().getRating().getCustomerRating().toString() + " " + creditRequest.getCustomer());
		for(Warrantor warrantor : creditRequest.getWarrantors()) {
			writer.println( warrantor.getRating().getCustomerRating().toString() + " " + warrantor);
		}

		return creditRequest;
	}

	public void acceptOffer(CreditRequest creditRequest)
			throws ContractManagementException {
		this.contractService.acceptOffer(creditRequest.getOffer());
	}

	public void declineOffer(CreditRequest creditRequest)
			throws ContractManagementException {
		this.contractService.declineOffer(creditRequest.getOffer());
	}
}
