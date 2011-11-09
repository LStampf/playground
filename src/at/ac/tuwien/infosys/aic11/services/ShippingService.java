package at.ac.tuwien.infosys.aic11.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import at.ac.tuwien.infosys.aic11.dto.Customer;

@Path("shipping")
public interface ShippingService {

	@GET
	@Path("ships")
	@Produces("application/xml")
	public Customer ship();
	
}
