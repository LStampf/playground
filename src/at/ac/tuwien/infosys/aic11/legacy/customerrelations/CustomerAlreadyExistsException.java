package at.ac.tuwien.infosys.aic11.legacy.customerrelations;

@SuppressWarnings("serial")
public class CustomerAlreadyExistsException extends Exception {
	public CustomerAlreadyExistsException(String msg) {
		super(msg);
	}
}
