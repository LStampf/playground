package at.ac.tuwien.infosys.aic11.services.shipping;

import java.util.logging.Logger;

import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.Offer;
import at.ac.tuwien.infosys.aic11.legacy.ContractCallback;
import at.ac.tuwien.infosys.aic11.legacy.ContractManager;
import at.ac.tuwien.infosys.aic11.legacy.pojo.Contract;

public class ShippingServiceImpl implements ShippingService {

	private static Logger LOGGER = Logger.getLogger(ShippingServiceImpl.class.getName());
	
	@Override
	public void writeAndShipContract(Offer offer, Customer c) {
		LOGGER.info("Method writeAndShipContract() called with offer: " + offer.getOfferId() +
				" and customer: " + c.getCustomerId());
		
		Contract contract = ContractManager.createContract(offer, c);
		LOGGER.info("Contract created for offer(" + offer.getOfferId() + ") and customer(" +
				c.getCustomerId() + ")");
		
		ContractManager.shipContract(contract, c, new ContractCallback(contract) {
			
			@Override
			public void callback() {
				LOGGER.info("Contract signed and faxed from customer(" + 
						this.getContract().getCustomer().getCustomerId() + ")");
			}
			
		});
		LOGGER.info("Contract was shipped to customer.");
	}

}
