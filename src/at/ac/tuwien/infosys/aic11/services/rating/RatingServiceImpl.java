package at.ac.tuwien.infosys.aic11.services.rating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.Rating;
import at.ac.tuwien.infosys.aic11.dto.Warrantor;
import at.ac.tuwien.infosys.aic11.legacy.CustomerManager;
import at.ac.tuwien.infosys.aic11.legacy.WarrantorManager;

public class RatingServiceImpl implements RatingService {

	private static Logger LOGGER = LoggerFactory
			.getLogger(RatingServiceImpl.class);

	@Override
	public Rating getCustomerRating(Long id) {
		LOGGER.info("Method getCustomerRating() called with id: {} ", id);

		Customer c = CustomerManager.getCustomer(id);
		if (c == null) {
			LOGGER.info("No customer({}) found.", id);
			// TODO: trigger exception
			return null;
		}

		LOGGER.info("Customer({}) has rating {}", id, c.getRating()
				.getCustomerRating());
		return c.getRating();
	}

	@Override
	public Rating getWarrantorRating(Long id) {
		LOGGER.info("Method getWarrantorRating() called with id: {} ", id);

		Warrantor w = WarrantorManager.getWarrantor(id);
		if (w == null) {
			LOGGER.info("No warrantor({}) found.", id);
			// TODO: trigger exception
			return null;
		}

		LOGGER.info("Warrantor({}) has rating {} ", id, w.getRating()
				.getCustomerRating());
		return w.getRating();
	}

}
