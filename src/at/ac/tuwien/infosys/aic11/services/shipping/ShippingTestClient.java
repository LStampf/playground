package at.ac.tuwien.infosys.aic11.services.shipping;

import java.util.concurrent.Future;

import dto.aic11.infosys.tuwien.ac.at.Offer;

import services.aic11.infosys.tuwien.ac.at.ShipContractCallback;
import services.aic11.infosys.tuwien.ac.at.Shipping;
import services.aic11.infosys.tuwien.ac.at.ShippingService;

public class ShippingTestClient {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ShipContractCallback callback = new ShipContractCallback();
		Shipping shippingService = new ShippingService().getShippingPort();

		Offer offer = new Offer();
		offer.setOfferId(1);

		Future<?> future = shippingService.shipContractAsync(offer, callback);
		while (!future.isDone()) {
			Thread.sleep(100);
		}
		
	}
}
