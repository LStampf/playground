package at.ac.tuwien.infosys.aic11.legacy;

import java.util.HashMap;

import at.ac.tuwien.infosys.aic11.dto.Addresses;
import at.ac.tuwien.infosys.aic11.dto.CustomerRating;
import at.ac.tuwien.infosys.aic11.dto.Rating;
import at.ac.tuwien.infosys.aic11.dto.Warrantor;

public class WarrantorManager {

	private static HashMap<Long, Warrantor> warrantors;

	static {
		warrantors = new HashMap<Long, Warrantor>();

		initWithValues();
	}

	private static void initWithValues() {
		// CUSTOMER 1 ----------------------------------------------------
		Warrantor w1 = new Warrantor();
		w1.setCustomerId(100L);

		Addresses a1 = new Addresses();
		a1.setId("w1");
		a1.setStreet("Milchstrasse");
		a1.setHouse("1");
		a1.setCity("Wien");
		a1.setDoor("1a");
		a1.setZipCode("1010");

		Rating r1 = new Rating();
		r1.setCustomer(w1);
		r1.setCustomerRating(CustomerRating.AA);

		w1.setFirstName("Max");
		w1.setLastName("Mustermann");
		w1.setAddresses(a1);
		w1.setRating(r1);

		warrantors.put(w1.getCustomerId(), w1);
	}

	public static Warrantor getWarrantor(Long id) {
		if (warrantors.containsKey(id)) {
			return warrantors.get(id);
		}

		return null;
	}

}
