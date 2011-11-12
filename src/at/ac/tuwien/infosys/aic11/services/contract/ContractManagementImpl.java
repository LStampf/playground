package at.ac.tuwien.infosys.aic11.services.contract;

import at.ac.tuwien.infosys.aic11.dto.CreditRequest;
import at.ac.tuwien.infosys.aic11.dto.Offer;
import at.ac.tuwien.infosys.aic11.legacy.contract.ContractManagementLegacyApp;
import at.ac.tuwien.infosys.aic11.legacy.contract.OfferDoesNotExistException;

public class ContractManagementImpl implements ContractManagement {
	ContractManagementLegacyApp legacy;

	public ContractManagementImpl() {
		legacy = new ContractManagementLegacyApp();
	}

	@Override
	public Offer createOffer(CreditRequest creditRequest)
			throws ContractManagementException {
		if (validateCreditRequest(creditRequest)) {
			return legacy.generateOffer(creditRequest);
		} else {
			throw new ContractManagementException(
					"Validation of credit request failed!");
		}
	}

	@Override
	public void updateOffer(Offer offer) throws ContractManagementException {
		try {
			legacy.updateOffer(offer);
		} catch (OfferDoesNotExistException e) {
			throw new ContractManagementException(e);
		}
	}

	private boolean validateCreditRequest(CreditRequest request) {
		return (request.getDuration() != null) && (request.getMoney() != null)
				&& (request.getCustomer() != null);
	}

	@Override
	public void acceptOffer(Offer offer) throws ContractManagementException {
		try {
			legacy.acceptOffer(offer);
		} catch (OfferDoesNotExistException e) {
			throw new ContractManagementException(e);
		}
	}

	@Override
	public void declineOffer(Offer offer) throws ContractManagementException {
		try {
			legacy.declineOffer(offer);
		} catch (OfferDoesNotExistException e) {
			throw new ContractManagementException(e);
		}
	}
}
