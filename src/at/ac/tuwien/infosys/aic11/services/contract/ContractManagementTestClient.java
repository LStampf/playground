package at.ac.tuwien.infosys.aic11.services.contract;

import java.math.BigDecimal;
import java.util.logging.Logger;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import at.ac.tuwien.infosys.aic11.dto.Addresses;
import at.ac.tuwien.infosys.aic11.dto.Cheque;
import at.ac.tuwien.infosys.aic11.dto.CreditRequest;
import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.Duration;
import at.ac.tuwien.infosys.aic11.dto.Money;
import at.ac.tuwien.infosys.aic11.dto.Offer;

public class ContractManagementTestClient {
	public static void main(String[] args) {
		Logger logger = Logger
				.getLogger(ContractManagementImpl.class.getName());

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(ContractManagement.class);
		factory.setAddress("http://localhost:8091/ContractManagementService");
		ContractManagement contractService = (ContractManagement) factory
				.create();

		try {
			contractService.createOffer(new CreditRequest());
		} catch (ContractManagementException e) {
			// expected
		}

		CreditRequest cr = new CreditRequest();
		cr.setRequestId(1L);
		Customer c = new Customer();
		c.setCustomerId(1L);
		Addresses address = new Addresses();
		address.setCity("Vienna");
		address.setDoor("42");
		address.setId("1");
		address.setHouse("House2");
		address.setStreet("wonderstreet");
		address.setZipCode("666");

		c.setFirstName("Lukas");
		c.setLastName("Stampf");
		Cheque pref = new Cheque();
		pref.setName("cheque");
		c.setDisbursementPreference(pref);
		c.setAddresses(address);
		c.setOpenBalance(new BigDecimal(0));
		cr.setCustomer(c);

		Money money = new Money();
		money.setAmount(10000L);
		money.setCurrencyCode("EURO");
		cr.setMoney(money);

		Duration dur = new Duration();
		dur.setYears(50);
		cr.setDuration(dur);

		cr.setReason("so halt");

		Offer offer = null;
		try {
			offer = contractService.createOffer(cr);
		} catch (ContractManagementException e) {
			logger.severe(e.getMessage());
		}

		offer.setComments("BLABLA");
		offer.setOfferId(2L);
		try {
			contractService.updateOffer(offer);
		} catch (ContractManagementException e) {
			// expected
		}

		offer.setOfferId(0L);
		try {
			contractService.updateOffer(offer);
		} catch (ContractManagementException e) {
			logger.severe(e.getMessage());
		}

		try {
			contractService.declineOffer(offer);
		} catch (ContractManagementException e) {
			logger.severe(e.getMessage());
		}

	}
}
