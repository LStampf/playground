package at.ac.tuwien.infosys.aic11.services.customerrelation;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import at.ac.tuwien.infosys.aic11.dto.Customer;

@WebService(name = "CustomerRelationsManagementService", targetNamespace = "http://at.ac.tuwien.infosys.aic11.services")
public interface CustomerRelationsManagement {

	@WebMethod(operationName = "get_customer_by_id")
	@WebResult(name = "customer")
	public Customer getCustomerById(@WebParam(name = "customer_id") Long id)
			throws CustomerRelationsManagementException;

	@WebMethod(operationName = "get_all_customers")
	@WebResult(name = "customers")
	public List<Customer> getAllCustomers();

	@WebMethod(operationName = "save_customer")
	public void saveCustomer(@WebParam(name = "new_customer") Customer customer)
			throws CustomerRelationsManagementException;

}
