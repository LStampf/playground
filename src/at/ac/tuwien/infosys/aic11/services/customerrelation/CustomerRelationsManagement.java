package at.ac.tuwien.infosys.aic11.services.customerrelation;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import at.ac.tuwien.infosys.aic11.dto.Customer;

@WebService(name = "CustomerRelationsManagementService", targetNamespace = "at.ac.tuwien.infosys.aic11.services")
public interface CustomerRelationsManagement {

	@WebResult(name = "customer")
	public Customer getCustomerById(@WebParam(name = "customer_id") Long id)
			throws CustomerRelationsManagementException;

	@WebResult(name = "customers")
	public List<Customer> getAllCustomers();

	public void saveCustomer(@WebParam(name = "new_customer") Customer customer)
			throws CustomerRelationsManagementException;

}
