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
	private Hashtable<Long, Customer> data;
	private static CustomerDAO instance;

	public synchronized static CustomerDAO getInstance() {
		if (instance == null) {
			instance = new CustomerDAO();
		}
		return instance;
	}

	public CustomerDAO() {
		data = new Hashtable<Long, Customer>();
	}

	public synchronized List<Customer> getAll() {
		List<Customer> ret = new ArrayList<Customer>();
		for (Customer customer : data.values()) {
			ret.add(customer);
		}
		return ret;
	}

	public synchronized void save(Customer customer) {
		data.put(customer.getCustomerId(), customer);
	}

	public synchronized Customer get(Long customerId) {
		return data.get(customerId);
	}
}
