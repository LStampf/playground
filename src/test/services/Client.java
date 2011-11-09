package test.services;

import java.util.logging.Logger;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import at.ac.tuwien.infosys.aic11.dto.Addresses;
import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.services.ShippingService;

public class Client {

	private static Logger LOGGER = Logger.getLogger(Client.class.getName());
	
	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(ShippingService.class);
		factory.setAddress("http://localhost:9000/shipping");
		ShippingService shippingService = (ShippingService) factory.create();

		Customer c = new Customer();
		Addresses a = new Addresses();
		a.setStreet("Milchstrasse");
		c.setAddresses(a);
		
		//LOGGER.info(shippingService.ship());
	}
	
}
