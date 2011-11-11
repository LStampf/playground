package test.services;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.Offer;
import at.ac.tuwien.infosys.aic11.services.shipping.ShippingService;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(ShippingService.class);
		factory.setAddress("http://localhost:9000/shipping");
		System.out.println("ASDF");
		ShippingService shippingService = (ShippingService) factory.create();

		Customer c = new Customer();
		c.setCustomerId(1L);
		
		Offer o = new Offer();
		o.setOfferId(1234L);
		
		shippingService.writeAndShipContract(o, c);
	}

}