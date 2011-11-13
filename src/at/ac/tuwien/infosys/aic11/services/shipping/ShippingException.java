package at.ac.tuwien.infosys.aic11.services.shipping;

import javax.xml.ws.WebFault;

@SuppressWarnings("serial")
@WebFault(name = "ShippingException", targetNamespace = "at.ac.tuwien.infosys.aic11.services")
public class ShippingException extends Exception {

	public ShippingException(Throwable t) {
		super(t);
	}

	public ShippingException(String msg) {
		super(msg);
	}

}
