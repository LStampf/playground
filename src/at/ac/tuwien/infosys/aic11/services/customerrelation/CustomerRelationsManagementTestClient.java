package at.ac.tuwien.infosys.aic11.services.customerrelation;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import at.ac.tuwien.infosys.aic11.dto.Addresses;
import at.ac.tuwien.infosys.aic11.dto.Cheque;
import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.Warrantor;

public class CustomerRelationsManagementTestClient {

	/**
	 * @param args
	 * @throws CustomerRelationsManagementException
	 */
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(CustomerRelationsManagementImpl.class
				.getName());

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(CustomerRelationsManagement.class);
		factory.setAddress("http://localhost:8090/CustomerRelationsManagementService");
		CustomerRelationsManagement customerService = (CustomerRelationsManagement) factory
				.create();

		try {
			logger.info("Initial size: " + customerService.getCustomerById(1L).getFirstName());
		} catch (CustomerRelationsManagementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		Customer c = new Customer();
		c.setCustomerId(1L);

		try {
			customerService.saveCustomer(c);
		} catch (CustomerRelationsManagementException e) {
			// expected
		}

		Addresses address = new Addresses();
		address.setCity("Vienna");
		address.setDoor("42");
		address.setId("1");
		address.setHouse("House2");
		address.setStreet("wonderstreet");
		address.setZipCode("666");

		c.setFirstName("Lukas");
		c.setLastName("Stampf");
		Cheque pref = new Cheque();
		pref.setName("cheque");
		c.setDisbursementPreference(pref);
		c.setAddresses(address);
		c.setOpenBalance(new BigDecimal(0));
		try {
			customerService.saveCustomer(c);
		} catch (CustomerRelationsManagementException e) {
			logger.severe("Exception:" + e.getMessage());
		}

		Warrantor w = new Warrantor();
		w.setCustomerId(1L);
		w.setAddresses(address);
		w.setFirstName("Claudiu");
		w.setLastName("Gavrilete");
		w.setDisbursementPreference(pref);
		w.setAddresses(address);
		w.setOpenBalance(new BigDecimal(10));

		try {
			customerService.saveCustomer(w);
		} catch (CustomerRelationsManagementException e) {
			// Expected
		}

		w.setCustomerId(2L);

		try {
			customerService.saveCustomer(w);
		} catch (CustomerRelationsManagementException e) {
			logger.severe("Exception:" + e.getMessage());
		}

		List<Customer> customers = customerService.getAllCustomers();
		logger.info(customers.size() + " " + customers.get(0).getFirstName()
				+ " " + customers.get(1).getFirstName());

	}

}
