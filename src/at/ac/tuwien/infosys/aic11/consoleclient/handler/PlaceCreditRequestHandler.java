package at.ac.tuwien.infosys.aic11.consoleclient.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.handler.WSHandlerConstants;

import at.ac.tuwien.infosys.aic11.dto.CreditRequest;
import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.Duration;
import at.ac.tuwien.infosys.aic11.dto.Money;
import at.ac.tuwien.infosys.aic11.dto.Offer;
import at.ac.tuwien.infosys.aic11.dto.Warrantor;
import at.ac.tuwien.infosys.aic11.services.contract.ClientKeystorePasswordCallback;
import at.ac.tuwien.infosys.aic11.services.contract.ContractManagement;
import at.ac.tuwien.infosys.aic11.services.contract.ContractManagementException;
import at.ac.tuwien.infosys.aic11.services.customerrelation.CustomerRelationsManagement;
import at.ac.tuwien.infosys.aic11.services.customerrelation.CustomerRelationsManagementException;

public class PlaceCreditRequestHandler {
	
	private CustomerRelationsManagement customerService;
	private ContractManagement contractService;
	
	public PlaceCreditRequestHandler() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(CustomerRelationsManagement.class);
		factory.setAddress("http://localhost:8090/CustomerRelationsManagementService");
		this.customerService = (CustomerRelationsManagement) factory.create();
		
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
	
	public CreditRequest handle(CreditRequest creditRequest, InputStream in, OutputStream out) throws IOException, CustomerRelationsManagementException, ContractManagementException {
		return this.updateOffer(creditRequest, in, out);
	}
	
	public CreditRequest updateOffer(CreditRequest creditRequest, InputStream in, OutputStream out) throws IOException, CustomerRelationsManagementException, ContractManagementException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		PrintWriter writer = new PrintWriter(out, true);
		String line;
		
		if( creditRequest.getCustomer() == null ) {
			// printing all customers -----------------
			List<Customer> customers = this.customerService.getAllCustomers();
			if( customers != null && customers.size() > 0 )
			{
				writer.println("Available customers:");
				for(Customer c : customers) {
					writer.printf("%3d %s\n", c.getCustomerId(), c.toString());
				}
			}
			else
			{
				writer.println("No customers available.");
				return null;
			}
			
			// select customer -----------------
			while( true ) {
				writer.printf("Choose customer: ");
				line = reader.readLine();
				
				try {
					long id = Long.parseLong(line);
					for(Customer c : customers) {
						if( c.getCustomerId() == id ) {
							creditRequest.setCustomer(c);
							break;
						}
					}
					
					if( creditRequest.getCustomer() != null ) {
						break;
					}
					else {
						throw new NumberFormatException();
					}
				} 
				catch( NumberFormatException nfe ) {
					writer.println("Invalid customer id.");
				}
			}
		}
		
		writer.println(creditRequest.getCustomer() + " selected.");
		
		// select mount and currency -----------------
		while( true ) {
			writer.printf("Enter amount of money [" + creditRequest.getMoney().getAmount() + "]: ");
			line = reader.readLine();
			
			try {
				if( line.length() > 0 ) {
					long amount = Long.parseLong(line);
					creditRequest.getMoney().setAmount(amount);
				}
				break;
			} 
			catch( NumberFormatException nfe ) {
				writer.println("Invalid amount of money.");
			}
		}
		
		writer.printf("Enter currency code [" + creditRequest.getMoney().getCurrencyCode() + "]: ");
		line = reader.readLine();
		creditRequest.getMoney().setCurrencyCode(line.length() > 0 ? line : creditRequest.getMoney().getCurrencyCode());
		
		// TODO: get reason
		
		// get duration --------------------------
		while( true ) {
			writer.printf("Enter duration of credit (in years) [" + creditRequest.getDuration().getYears() + "]: ");
			line = reader.readLine();
			
			try {
				if( line.length() > 0 )
				{
					int years = Integer.parseInt(line);
					creditRequest.getDuration().setYears(years);
				}
				break;
			} 
			catch( NumberFormatException nfe ) {
				writer.println("Invalid number of years.");
			}
		}
		
		// select warrantors -----------------
		// TODO: causes casting problems
		/*
		writer.println("Warrantors: ");
		while( true ) {
			for(Customer c : customers) {
				if( c != creditRequest.getCustomer() && !creditRequest.getWarrantors().contains(c) ) {
					writer.printf("%3d %s\n", c.getCustomerId(), c.toString());
				}
			}
			writer.printf("Select warrantor [0]: ");
			line = reader.readLine();
			if( line.length() == 0 && line.equals("0") ) {
				break;
			}
			
			try {
				long id = Long.parseLong(line);
				boolean added = false;
				for(Customer c : customers) {
					if( c.getCustomerId() == id ) {
						creditRequest.getWarrantors().add((Warrantor)c);
						added = true;
						break;
					}
				}
				
				if( added ) {
					break;
				}
				else {
					throw new NumberFormatException();
				}
			} 
			catch( NumberFormatException nfe ) {
				writer.println("Invalid customer id.");
			}
		}
		*/
		
		Offer offer = this.contractService.createOffer(creditRequest);
		creditRequest.setOffer(offer);
		
		writer.println(offer);
		writer.println(offer.getInterestRate());
		
		return creditRequest;
	}
	
	public void acceptOffer(CreditRequest creditRequest) throws ContractManagementException {
		this.contractService.acceptOffer(creditRequest.getOffer());
	}
	
	public void declineOffer(CreditRequest creditRequest) throws ContractManagementException {
		this.contractService.declineOffer(creditRequest.getOffer());
	}
}
