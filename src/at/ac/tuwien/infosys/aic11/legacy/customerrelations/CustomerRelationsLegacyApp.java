package at.ac.tuwien.infosys.aic11.legacy.customerrelations;

import java.util.List;

import at.ac.tuwien.infosys.aic11.dto.Customer;

public class CustomerRelationsLegacyApp {

	public void createCustomer(Customer customer)
			throws CustomerAlreadyExistsException {
		if (CustomerDAO.getInstance().get(customer.getCustomerId()) != null) {
			throw new CustomerAlreadyExistsException("id:"
					+ customer.getCustomerId() + " already taken!");
		}
		CustomerDAO.getInstance().save(customer);
	}

	public List<Customer> getAllCustomers() {
		return CustomerDAO.getInstance().getAll();
	}

	public Customer getCustomerById(Long id)
			throws CustomerDoesNotExistException {
		Customer customer;
		if ((customer = CustomerDAO.getInstance().get(id)) != null) {
			return customer;
		} else {
			throw new CustomerDoesNotExistException("Customer with id:" + id
					+ " does not exist!");
		}
	}
}
