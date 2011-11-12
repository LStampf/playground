package at.ac.tuwien.infosys.aic11.services.customerrelation;

import java.util.List;

import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.legacy.customerrelations.CustomerAlreadyExistsException;
import at.ac.tuwien.infosys.aic11.legacy.customerrelations.CustomerDoesNotExistException;
import at.ac.tuwien.infosys.aic11.legacy.customerrelations.CustomerRelationsLegacyApp;

public class CustomerRelationsManagementImpl implements
		CustomerRelationsManagement {

	CustomerRelationsLegacyApp legacy;

	public CustomerRelationsManagementImpl() {
		legacy = new CustomerRelationsLegacyApp();
	}

	@Override
	public Customer getCustomerById(Long id)
			throws CustomerRelationsManagementException {
		if (id == null) {
			throw new CustomerRelationsManagementException(
					"id must not be null");
		}
		try {
			Customer c = legacy.getCustomerById(id);
			return c;
		} catch (CustomerDoesNotExistException e) {
			throw new CustomerRelationsManagementException(e);
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		return legacy.getAllCustomers();
	}

	@Override
	public void saveCustomer(Customer customer)
			throws CustomerRelationsManagementException {
		if (validate(customer)) {
			try {
				legacy.createCustomer(customer);
			} catch (CustomerAlreadyExistsException e) {
				throw new CustomerRelationsManagementException(e);
			}
		} else {
			throw new CustomerRelationsManagementException(
					"object has not passed validation!");
		}

	}

	public boolean validate(Customer customer) {
		return (customer.getAddresses() != null)
				&& (customer.getCustomerId() != null)
				&& (customer.getFirstName() != null)
				&& (customer.getDisbursementPreference() != null)
				&& (customer.getLastName() != null)
				&& (customer.getOpenBalance() != null);
	}
}
