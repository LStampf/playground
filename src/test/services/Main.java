package test.services;

import java.util.logging.Logger;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import at.ac.tuwien.infosys.aic11.services.rating.RatingServiceImpl;
import at.ac.tuwien.infosys.aic11.services.shipping.ShippingServiceImpl;

public class Main {

	private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		LOGGER.info("Starting Server.");

		// Shipping Service
		Endpoint.publish("http://localhost:9080/shipping", new ShippingServiceImpl());
		
		// RatingService
		JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
		sf.setResourceClasses(RatingServiceImpl.class);
		sf.setBindingId(JAXRSBindingFactory.JAXRS_BINDING_ID);
		sf.setAddress("http://localhost:9080/");
		sf.create();

		LOGGER.info("Services started.");
	}

}
