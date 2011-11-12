package at.ac.tuwien.infosys.aic11.legacy.rating;

import java.math.BigDecimal;

import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.CustomerRating;
import at.ac.tuwien.infosys.aic11.dto.Rating;
import at.ac.tuwien.infosys.aic11.legacy.customerrelations.CustomerDoesNotExistException;
import at.ac.tuwien.infosys.aic11.legacy.customerrelations.CustomerRelationsLegacyApp;

public class RatingLegacyApp {

	public Rating getRatingForCustomer(Long id)
			throws CustomerDoesNotExistException {

		try {
			Customer c = new CustomerRelationsLegacyApp().getCustomerById(id);
			Rating r = new Rating();
			r.setCustomer(c);
			r.setCustomerRating(getRatingForOpenBalance(c.getOpenBalance()));
			return r;
		} catch (CustomerDoesNotExistException e) {
			throw e;
		}

	}

	private CustomerRating getRatingForOpenBalance(BigDecimal balance) {

		if (balance.compareTo(new BigDecimal(1000)) < 0) {
			return CustomerRating.AAA;
		}

		if (balance.compareTo(new BigDecimal(5000)) < 0) {
			return CustomerRating.AAPlus;
		}

		if (balance.compareTo(new BigDecimal(10000)) < 0) {
			return CustomerRating.AA;
		}

		if (balance.compareTo(new BigDecimal(20000)) < 0) {
			return CustomerRating.AAMinus;
		}

		if (balance.compareTo(new BigDecimal(40000)) < 0) {
			return CustomerRating.APlus;
		}

		if (balance.compareTo(new BigDecimal(50000)) < 0) {
			return CustomerRating.A;
		}

		if (balance.compareTo(new BigDecimal(100000)) < 0) {
			return CustomerRating.AMinus;
		}
		return CustomerRating.Defaulting;
	}
}
