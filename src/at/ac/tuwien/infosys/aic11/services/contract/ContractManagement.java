package at.ac.tuwien.infosys.aic11.services.contract;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import at.ac.tuwien.infosys.aic11.dto.CreditRequest;
import at.ac.tuwien.infosys.aic11.dto.Offer;

@WebService(name = "ContractManagementService", targetNamespace = "http://at.ac.tuwien.infosys.aic11.services")
public interface ContractManagement {

	@WebMethod(operationName = "create_offer")
	public Offer createOffer(
			@WebParam(name = "credit_request") CreditRequest creditRequest)
			throws ContractManagementException;

	@WebMethod(operationName = "accept_offer")
	void acceptOffer(@WebParam(name = "offer") Offer offer)
			throws ContractManagementException;

	@WebMethod(operationName = "decline_offer")
	void declineOffer(@WebParam(name = "offer") Offer offer)
			throws ContractManagementException;

	@WebMethod(operationName = "update_offer")
	void updateOffer(@WebParam(name = "offer") Offer offer)
			throws ContractManagementException;
}
