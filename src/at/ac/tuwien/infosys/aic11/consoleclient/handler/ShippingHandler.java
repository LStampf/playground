package at.ac.tuwien.infosys.aic11.consoleclient.handler;

import java.util.concurrent.Future;

import services.aic11.infosys.tuwien.ac.at.ShipContractCallback;
import services.aic11.infosys.tuwien.ac.at.Shipping;
import services.aic11.infosys.tuwien.ac.at.ShippingService;
import dto.aic11.infosys.tuwien.ac.at.InterestRate;
import dto.aic11.infosys.tuwien.ac.at.Offer;

public class ShippingHandler {

	private ShipContractCallback callback = null;
	private Shipping shippingService = null;
	
	public ShippingHandler() {
		this.callback = new ShipContractCallback();
		this.shippingService = new ShippingService().getShippingPort();
	}
	
	public void handle(at.ac.tuwien.infosys.aic11.dto.Offer offer) throws InterruptedException {
		Offer externalOffer = new Offer();
		
		// mapping - TODO
		externalOffer.setComments( offer.getComments() );
		externalOffer.setOfferId( offer.getOfferId() );
		InterestRate externalRate = new InterestRate();
		externalRate.setRate( offer.getInterestRate().getRate() );
		externalOffer.setInterestRate( externalRate );
		
		Future<?> future = this.shippingService.shipContractAsync(externalOffer, this.callback);
		while (!future.isDone()) {
			Thread.sleep(100);
		}
	}
	
}
