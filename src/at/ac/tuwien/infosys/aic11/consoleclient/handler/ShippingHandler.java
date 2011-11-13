package at.ac.tuwien.infosys.aic11.consoleclient.handler;

import java.util.concurrent.Future;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import at.ac.tuwien.infosys.aic11.services.Address;
import at.ac.tuwien.infosys.aic11.services.registry.IRegistryService;
import at.ac.tuwien.infosys.aic11.services.registry.InvalidParameterException;
import at.ac.tuwien.infosys.aic11.services.registry.RegistryService;
import at.ac.tuwien.infosys.aic11.services.registry.WsdlEndpoint;

import services.aic11.infosys.tuwien.ac.at.ShipContractCallback;
import services.aic11.infosys.tuwien.ac.at.Shipping;
import services.aic11.infosys.tuwien.ac.at.ShippingService;
import dto.aic11.infosys.tuwien.ac.at.Addresses;
import dto.aic11.infosys.tuwien.ac.at.BankTransfer;
import dto.aic11.infosys.tuwien.ac.at.Cheque;
import dto.aic11.infosys.tuwien.ac.at.CreditRequest;
import dto.aic11.infosys.tuwien.ac.at.Customer;
import dto.aic11.infosys.tuwien.ac.at.CustomerRating;
import dto.aic11.infosys.tuwien.ac.at.DisbursementPreference;
import dto.aic11.infosys.tuwien.ac.at.Duration;
import dto.aic11.infosys.tuwien.ac.at.InterestRate;
import dto.aic11.infosys.tuwien.ac.at.Money;
import dto.aic11.infosys.tuwien.ac.at.Offer;
import dto.aic11.infosys.tuwien.ac.at.Rating;

public class ShippingHandler {

	private ShipContractCallback callback = null;
	private Shipping shippingService = null;
	
	public ShippingHandler() {
		this.callback = new ShipContractCallback();
		this.shippingService = new ShippingService().getShippingPort();
	}
	
	public void handle(at.ac.tuwien.infosys.aic11.dto.Offer offer) throws Exception {
		Offer externalOffer = new Offer();
		CreditRequest externalCreditRequest = new CreditRequest();
		Customer externalCustomer = new Customer();
		Addresses externalAddresses = new Addresses();
		DisbursementPreference externalDisbursement = null; 
		Rating externalRating = new Rating();
		
		at.ac.tuwien.infosys.aic11.services.registry.DisbursementPreference registryDisbursement = null;
		
		// mapping
		switch( offer.getCreditRequest().getCustomer().getRating().getCustomerRating() )
		{
			case AA: externalRating.setCustomerRating(CustomerRating.AA); break;
			case A: externalRating.setCustomerRating(CustomerRating.A); break;
			case AAA: externalRating.setCustomerRating(CustomerRating.AAA); break;
			case AAMinus: externalRating.setCustomerRating(CustomerRating.AA_MINUS); break;
			case AAPlus: externalRating.setCustomerRating(CustomerRating.AA_PLUS); break;
			case AMinus: externalRating.setCustomerRating(CustomerRating.A_MINUS); break;
			case APlus: externalRating.setCustomerRating(CustomerRating.A_PLUS); break;
		}
		
		if( offer.getCreditRequest().getCustomer().getDisbursementPreference() instanceof 
				at.ac.tuwien.infosys.aic11.dto.BankTransfer) {
			externalDisbursement = new BankTransfer();
			((BankTransfer)externalDisbursement).setBankName(
					((at.ac.tuwien.infosys.aic11.dto.BankTransfer)offer.getCreditRequest().getCustomer().getDisbursementPreference()).getBankName());
			((BankTransfer)externalDisbursement).setBic(
					((at.ac.tuwien.infosys.aic11.dto.BankTransfer)offer.getCreditRequest().getCustomer().getDisbursementPreference()).getBic());
			((BankTransfer)externalDisbursement).setIban(
					((at.ac.tuwien.infosys.aic11.dto.BankTransfer)offer.getCreditRequest().getCustomer().getDisbursementPreference()).getIban());
			
			registryDisbursement = new at.ac.tuwien.infosys.aic11.services.registry.BankTransfer();
			((at.ac.tuwien.infosys.aic11.services.registry.BankTransfer)registryDisbursement).setBankName(
					((at.ac.tuwien.infosys.aic11.dto.BankTransfer)offer.getCreditRequest().getCustomer().getDisbursementPreference()).getBankName());
			((at.ac.tuwien.infosys.aic11.services.registry.BankTransfer)registryDisbursement).setBic(
					((at.ac.tuwien.infosys.aic11.dto.BankTransfer)offer.getCreditRequest().getCustomer().getDisbursementPreference()).getBic());
			((at.ac.tuwien.infosys.aic11.services.registry.BankTransfer)registryDisbursement).setIban(
					((at.ac.tuwien.infosys.aic11.dto.BankTransfer)offer.getCreditRequest().getCustomer().getDisbursementPreference()).getIban());
		}
		else if( offer.getCreditRequest().getCustomer().getDisbursementPreference() instanceof 
				at.ac.tuwien.infosys.aic11.dto.Cheque) {
			externalDisbursement = new Cheque();
			((Cheque)externalDisbursement).setName(
					((at.ac.tuwien.infosys.aic11.dto.Cheque)offer.getCreditRequest().getCustomer().getDisbursementPreference()).getName());
			
			registryDisbursement = new at.ac.tuwien.infosys.aic11.services.registry.Cheque();
			((at.ac.tuwien.infosys.aic11.services.registry.Cheque)registryDisbursement).setName(
					((at.ac.tuwien.infosys.aic11.dto.Cheque)offer.getCreditRequest().getCustomer().getDisbursementPreference()).getName());
		}
		
		externalAddresses.setId(offer.getCreditRequest().getCustomer().getAddresses().getId());
		externalAddresses.setCity(offer.getCreditRequest().getCustomer().getAddresses().getCity());
		externalAddresses.setDoor(offer.getCreditRequest().getCustomer().getAddresses().getDoor());
		externalAddresses.setHouse(offer.getCreditRequest().getCustomer().getAddresses().getHouse());
		externalAddresses.setStreet(offer.getCreditRequest().getCustomer().getAddresses().getStreet());
		externalAddresses.setZipCode(offer.getCreditRequest().getCustomer().getAddresses().getZipCode());
		
		externalCustomer.setCustomerId( offer.getCreditRequest().getCustomer().getCustomerId() );
		externalCustomer.setAddresses( externalAddresses );
		externalCustomer.setDisbursementPreference( externalDisbursement );
		externalCustomer.setFirstName( offer.getCreditRequest().getCustomer().getFirstName() );
		externalCustomer.setLastName( offer.getCreditRequest().getCustomer().getLastName() );
		externalCustomer.setMiddleName( offer.getCreditRequest().getCustomer().getMiddleName() );
		externalCustomer.setOpenBalance( offer.getCreditRequest().getCustomer().getOpenBalance() );
		externalCustomer.setRating( externalRating );
		
		Duration externalDuration = new Duration();
		externalDuration.setYears( offer.getCreditRequest().getDuration().getYears() );
		
		Money externalMoney = new Money();
		externalMoney.setAmount( offer.getCreditRequest().getMoney().getAmount() );
		externalMoney.setCurrencyCode( offer.getCreditRequest().getMoney().getCurrencyCode() );
		
		externalCreditRequest.setCustomer( externalCustomer );
		externalCreditRequest.setDuration( externalDuration );
		externalCreditRequest.setMoney( externalMoney );
		externalCreditRequest.setReason( offer.getCreditRequest().getReason() );
		
		externalOffer.setCreditRequest( externalCreditRequest );
		externalOffer.setComments( offer.getComments() );
		externalOffer.setOfferId( offer.getOfferId() );
		InterestRate externalRate = new InterestRate();
		externalRate.setRate( offer.getInterestRate().getRate() );
		externalOffer.setInterestRate( externalRate );
		
		IRegistryService registry = new RegistryService().getRegistryService();
		WsdlEndpoint endpoint = registry.query(registryDisbursement);
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient(endpoint.getLocation() + "?wsdl");

		// TODO: mapping fault
		//Object[] objs = client.invoke("start_money_transfer_process",
		//		registryDisbursement, externalMoney, externalCustomer);
		
		Future<?> future = this.shippingService.shipContractAsync(externalOffer, this.callback);
		while (!future.isDone()) {
			Thread.sleep(100);
		}
	}
	
}
