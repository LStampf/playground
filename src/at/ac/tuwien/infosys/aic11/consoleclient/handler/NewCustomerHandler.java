package at.ac.tuwien.infosys.aic11.consoleclient.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import at.ac.tuwien.infosys.aic11.dto.Addresses;
import at.ac.tuwien.infosys.aic11.dto.BankTransfer;
import at.ac.tuwien.infosys.aic11.dto.Cheque;
import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.services.customerrelation.CustomerRelationsManagement;
import at.ac.tuwien.infosys.aic11.services.customerrelation.CustomerRelationsManagementException;

public class NewCustomerHandler {

	public void handle(InputStream in, OutputStream out) throws IOException, CustomerRelationsManagementException {
		Customer customer = new Customer();
		Addresses address = new Addresses();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		PrintWriter writer = new PrintWriter(out, true);
		String line;
		
		// getting customer data ----------------------------	
		writer.printf("Customer firstnameÊ[Max]: ");
		line = reader.readLine();
		customer.setFirstName(line.length() > 0 ? line : "Max");
		
		writer.printf("Customer lastnameÊ[Mustermann]: ");
		line = reader.readLine();
		customer.setLastName(line.length() > 0 ? line : "Mustermann");
		
		writer.printf("Customer streetÊ[Street 1]: ");
		line = reader.readLine();
		address.setStreet(line.length() > 0 ? line : "Street 1");
		
		writer.printf("Customer zip [1010]: ");
		line = reader.readLine();
		address.setZipCode(line.length() > 0 ? line : "1010");
		
		writer.printf("Customer city [Vienna]: ");
		line = reader.readLine();
		address.setCity(line.length() > 0 ? line : "Vienna");
		
		writer.printf("Customer disbursement preference (Bank transfer | Cheque) [C]: ");
		line = reader.readLine();
		if( line.equals("B") ) {
			BankTransfer disbursement = new BankTransfer();
			
			writer.printf("IBAN [01234]: ");
			line = reader.readLine();
			disbursement.setIban(line.length() > 0 ? line : "01234");
			
			writer.printf("BIC [01234]: ");
			line = reader.readLine();
			disbursement.setBic(line.length() > 0 ? line : "01234");
			
			writer.printf("Bank name [Bank 101]: ");
			line = reader.readLine();
			disbursement.setIban(line.length() > 0 ? line : "Bank 101");
			
			customer.setDisbursementPreference(disbursement);
		}
		else {
			Cheque disbursement = new Cheque();
			
			writer.printf("Cheque name [Max Muster]: ");
			line = reader.readLine();
			disbursement.setName(line.length() > 0 ? line : "Max Muster");
			
			customer.setDisbursementPreference(disbursement);
		}
		customer.setOpenBalance(new BigDecimal(0.0f));
		customer.setAddresses(address);
		
		// saving customer -----------------------------------
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(CustomerRelationsManagement.class);
		factory.setAddress("http://localhost:8090/CustomerRelationsManagementService");
		CustomerRelationsManagement customerService = (CustomerRelationsManagement) factory.create();
		
		List<Customer> customers = customerService.getAllCustomers();
		long maxId = 0;
		if( customers != null )
		{
			for(Customer c : customers) {
				maxId = Math.max(maxId, c.getCustomerId());
			}
		}
		customer.setCustomerId(maxId + 1);
		
		customerService.saveCustomer(customer);
		writer.println("Customer saved.");
		
	}
	
}
