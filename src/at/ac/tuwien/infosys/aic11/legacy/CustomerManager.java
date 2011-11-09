package at.ac.tuwien.infosys.aic11.legacy;

import java.util.HashMap;

import at.ac.tuwien.infosys.aic11.dto.Addresses;
import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.CustomerRating;
import at.ac.tuwien.infosys.aic11.dto.Rating;

public class CustomerManager {

	private static HashMap<Long, Customer> customers;
	
	static {
		customers = new HashMap<Long, Customer>();
		
		initWithValues();
	}
	
	private static void initWithValues() {
		// CUSTOMER 1 ----------------------------------------------------
		Customer c1 = new Customer();
		c1.setCustomerId(1L);
		
		Addresses a1 = new Addresses();
		a1.setId("1");
		a1.setStreet("Milchstrasse");
		a1.setHouse("1");
		a1.setCity("Wien");
		a1.setDoor("1a");
		a1.setZipCode("1010");
		
		Rating r1 = new Rating();
		r1.setCustomerId(c1.getCustomerId());
		r1.setCustomerRating(CustomerRating.AA);

		c1.setFirstName("Max");
		c1.setLastName("Mustermann");
		c1.setAddresses(a1);
		c1.setRating(r1);
		
		customers.put(c1.getCustomerId(), c1);
	}
	
	public static Customer getCustomer(Long id) {
		if( customers.containsKey(id) ) {
			return customers.get(id);
		}
		
		return null;
	}
	
}
