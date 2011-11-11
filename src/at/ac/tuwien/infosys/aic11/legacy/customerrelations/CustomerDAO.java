package at.ac.tuwien.infosys.aic11.legacy.customerrelations;

import java.util.Hashtable;

import at.ac.tuwien.infosys.aic11.dto.Customer;

/**
 * Mockup of a CustomerDAO Object
 * 
 **/

public class CustomerDAO {
	private static Hashtable<Long, Customer> data;

	static {
		data = new Hashtable<Long, Customer>();
	}

	public synchronized static void save(Customer customer) {
		data.put(customer.getCustomerId(), customer);
	}

	public synchronized static Customer get(Long customerId) {
		return data.get(customerId);
	}
}
