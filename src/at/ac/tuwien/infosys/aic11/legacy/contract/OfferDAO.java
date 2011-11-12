package at.ac.tuwien.infosys.aic11.legacy.contract;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import at.ac.tuwien.infosys.aic11.dto.Offer;

public class OfferDAO {
	private Hashtable<Long, Offer> data;
	private static OfferDAO instance;

	public synchronized static OfferDAO getInstance() {
		if (instance == null) {
			instance = new OfferDAO();
		}
		return instance;
	}

	public OfferDAO() {
		data = new Hashtable<Long, Offer>();
	}

	public synchronized List<Offer> getAll() {
		List<Offer> ret = new ArrayList<Offer>();
		for (Offer Offer : data.values()) {
			ret.add(Offer);
		}
		return ret;
	}

	public synchronized void save(Offer offer) {
		data.put(offer.getOfferId(), offer);
	}

	public synchronized void delete(Offer offer) {
		data.remove(offer.getOfferId());
	}

	public synchronized Offer get(Long offerId) {
		return data.get(offerId);
	}
}