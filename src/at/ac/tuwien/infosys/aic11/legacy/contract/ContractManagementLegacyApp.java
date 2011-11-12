package at.ac.tuwien.infosys.aic11.legacy.contract;

import at.ac.tuwien.infosys.aic11.dto.CreditRequest;
import at.ac.tuwien.infosys.aic11.dto.InterestRate;
import at.ac.tuwien.infosys.aic11.dto.Offer;

public class ContractManagementLegacyApp {

	private static long cnt = 0;

	public Offer generateOffer(CreditRequest creditRequest) {
		Offer ret = new Offer();
		ret.setCreditRequest(creditRequest);

		InterestRate rate = new InterestRate();
		rate.setRate(Math.random() * 10);
		ret.setInterestRate(rate);

		ret.setOfferId(cnt++);

		ret.setComments("comment");

		OfferDAO.getInstance().save(ret);

		return ret;
	}

	public void acceptOffer(Offer offer) throws OfferDoesNotExistException {
		if (OfferDAO.getInstance().get(offer.getOfferId()) == null) {
			throw new OfferDoesNotExistException("offer with id: "
					+ offer.getOfferId() + " does not exist!");
		} else {
			// whatever
		}
	}

	public void declineOffer(Offer offer) throws OfferDoesNotExistException {
		if (OfferDAO.getInstance().get(offer.getOfferId()) == null) {
			throw new OfferDoesNotExistException("offer with id: "
					+ offer.getOfferId() + " does not exist!");
		} else {
			OfferDAO.getInstance().delete(offer);
		}
	}

	public void updateOffer(Offer offer) throws OfferDoesNotExistException {
		if (OfferDAO.getInstance().get(offer.getOfferId()) == null) {
			throw new OfferDoesNotExistException("offer with id: "
					+ offer.getOfferId() + " does not exist!");
		} else {
			OfferDAO.getInstance().save(offer);
		}
	}
}
