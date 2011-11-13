package at.ac.tuwien.infosys.aic11.services.shipping;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.Offer;

@WebService(serviceName = "ShippingService", targetNamespace = "http://at.ac.tuwien.infosys.aic11.services")
public interface ShippingService {

	@WebMethod(operationName = "ship_contract")
	void shipContract(@WebParam(name = "offer") Offer offer,
			@WebParam(name = "customer") Customer customer);

}
