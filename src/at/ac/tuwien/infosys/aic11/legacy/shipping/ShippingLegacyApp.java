package at.ac.tuwien.infosys.aic11.legacy.shipping;

import java.util.logging.Logger;

import at.ac.tuwien.infosys.aic11.dto.Offer;

public class ShippingLegacyApp {

	private static final Logger LOGGER = Logger
			.getLogger(ShippingLegacyApp.class.getName());

	public void writeAndshipContract(Offer offer) throws InterruptedException {
		LOGGER.info("begin shipping contract!");
		long seconds = 5 + Math.round(Math.random() * 10);
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			LOGGER.severe("contract was interrupted while shipping!");
			throw e;
		}
		LOGGER.info("contract was signed!");
	}

}
