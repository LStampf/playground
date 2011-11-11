package at.ac.tuwien.infosys.aic11.services.shipping;

import javax.jws.WebParam;
import javax.jws.WebService;

import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.Offer;

@WebService(serviceName = "ShippingService")
public interface ShippingService {

	//@WebMethod(action="writeAndShipContract")
	void writeAndShipContract(
			@WebParam(name="offer")Offer offer, 
			@WebParam(name="c")Customer c); 
	
}
