package at.ac.tuwien.infosys.aic11.services.rating;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import at.ac.tuwien.infosys.aic11.dto.Rating;

@Path("rating")
public interface RatingService {

	@GET
	@Path("customer/{id}")
	@Produces("application/json")
	Rating getCustomerRating(@PathParam("id") Long id);

	@GET
	@Path("warrantor/{id}")
	@Produces("application/json")
	Rating getWarrantorRating(@PathParam("id") Long id);
}
