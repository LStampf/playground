package test.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import at.ac.tuwien.infosys.aic11.services.rating.RatingServiceImpl;

public class Main {

	private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		LOGGER.info("Starting Server.");

		// Endpoint.publish("http://localhost:9000/shipping", new
		// ShippingServiceImpl());
		JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
		sf.setResourceClasses(RatingServiceImpl.class);
		sf.setBindingId(JAXRSBindingFactory.JAXRS_BINDING_ID);
		sf.setAddress("http://localhost:9080/");
		sf.create();

		LOGGER.info("Services started.");
	}

}
