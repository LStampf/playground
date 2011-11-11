package at.ac.tuwien.infosys.aic11.services.rating;

import java.util.logging.Logger;

import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.Rating;
import at.ac.tuwien.infosys.aic11.dto.Warrantor;
import at.ac.tuwien.infosys.aic11.legacy.CustomerManager;
import at.ac.tuwien.infosys.aic11.legacy.WarrantorManager;

public class RatingServiceImpl implements RatingService {

	private static Logger LOGGER = Logger.getLogger(RatingServiceImpl.class
			.getName());

	@Override
	public Rating getCustomerRating(Long id) {
		LOGGER.info("Method getCustomerRating() called with id: " + id);

		Customer c = CustomerManager.getCustomer(id);
		if (c == null) {
			LOGGER.info("No customer(" + id + ") found.");
			// TODO: trigger exception
			return null;
		}

		LOGGER.info("Customer(" + id + ") has rating "
				+ c.getRating().toString());
		return c.getRating();
	}

	@Override
	public Rating getWarrantorRating(Long id) {
		LOGGER.info("Method getWarrantorRating() called with id: " + id);

		Warrantor w = WarrantorManager.getWarrantor(id);
		if (w == null) {
			LOGGER.info("No warrantor(" + id + ") found.");
			// TODO: trigger exception
			return null;
		}

		LOGGER.info("Warrantor(" + id + ") has rating "
				+ w.getRating().toString());
		return w.getRating();
	}

}
