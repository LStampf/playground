package at.ac.tuwien.infosys.aic11.legacy.customerrelations;

@SuppressWarnings("serial")
public class CustomerDoesNotExistException extends Exception {

	public CustomerDoesNotExistException(String msg) {
		super(msg);
	}

}
