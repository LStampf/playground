package at.ac.tuwien.infosys.aic11.legacy.customerrelations;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import at.ac.tuwien.infosys.aic11.dto.Customer;

/**
 * Mockup of a CustomerDAO
 * 
 **/

public class CustomerDAO {
	private static Hashtable<Long, Customer> data;

	static {
		data = new Hashtable<Long, Customer>();
	}

	public synchronized static List<Customer> getAll() {
		List<Customer> ret = new ArrayList<Customer>();
		for (Customer customer : data.values()) {
			ret.add(customer);
		}
		return ret;
	}

	public synchronized static void save(Customer customer) {
		data.put(customer.getCustomerId(), customer);
	}

	public synchronized static Customer get(Long customerId) {
		return data.get(customerId);
	}
}
