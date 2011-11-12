package at.ac.tuwien.infosys.aic11.legacy.customerrelations;

import java.util.List;

import at.ac.tuwien.infosys.aic11.dto.Customer;

public class CustomerRelationsApp {

	public void createCustomer(Customer customer)
			throws CustomerAlreadyExistsException {
		if (CustomerDAO.get(customer.getCustomerId()) != null) {
			throw new CustomerAlreadyExistsException("id:"
					+ customer.getCustomerId() + " already taken!");
		}
		CustomerDAO.save(customer);
	}

	public List<Customer> getAllCustomers() {
		return CustomerDAO.getAll();
	}

	public Customer getCustomerById(Long id)
			throws CustomerDoesNotExistException {
		Customer customer;
		if ((customer = CustomerDAO.get(id)) != null) {
			return customer;
		} else {
			throw new CustomerDoesNotExistException("Customer with id:" + id
					+ " does not exist!");
		}
	}
}
