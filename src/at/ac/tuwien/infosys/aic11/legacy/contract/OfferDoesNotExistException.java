package at.ac.tuwien.infosys.aic11.legacy.contract;

@SuppressWarnings("serial")
public class OfferDoesNotExistException extends Exception {

	public OfferDoesNotExistException(String msg) {
		super(msg);
	}
}
