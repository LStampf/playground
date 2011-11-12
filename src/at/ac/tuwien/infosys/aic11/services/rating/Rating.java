package at.ac.tuwien.infosys.aic11.services.rating;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ratingservice/")
public interface Rating {

	@GET
	@Path("customer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	at.ac.tuwien.infosys.aic11.dto.Rating getRating(
			@PathParam("id") Long customerId) throws RatingException;

}
