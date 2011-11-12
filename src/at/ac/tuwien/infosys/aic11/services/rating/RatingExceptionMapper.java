package at.ac.tuwien.infosys.aic11.services.rating;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RatingExceptionMapper implements ExceptionMapper<RatingException> {

	@Override
	public Response toResponse(RatingException ex) {
		return Response.status(Response.Status.BAD_REQUEST)
				.entity(ex.getMessage()).build();
	}

}
