package at.ac.tuwien.infosys.aic11.services.rating;

import java.util.Collections;
import java.util.logging.Logger;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.provider.JSONProvider;

import at.ac.tuwien.infosys.aic11.services.customerrelation.CustomerRelationsManagementException;

public class RatingTestClient {

	/**
	 * @param args
	 * @throws CustomerRelationsManagementException
	 */
	public static void main(String[] args)
			throws CustomerRelationsManagementException {
		Logger logger = Logger.getLogger(RatingTestClient.class.getName());

		JSONProvider provider = new JSONProvider();
		provider.setUnmarshallAsJaxbElement(true);
		WebClient client = WebClient.create("http://localhost:8092/",
				Collections.singletonList(provider));

		Rating r = JAXRSClientFactory.fromClient(client, Rating.class);

		try {
			r.getRating(2L);
		} catch (Exception e) {
			// expected no user
			logger.severe(e.getMessage());
		}

		try {
			at.ac.tuwien.infosys.aic11.dto.Rating rating = r.getRating(1L);
			logger.info(rating.getCustomerRating().toString());
		} catch (Exception e) {
			// expected no user
			logger.severe(e.getMessage());
		}
	}
}
