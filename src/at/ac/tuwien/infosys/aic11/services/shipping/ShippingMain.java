package at.ac.tuwien.infosys.aic11.services.shipping;

import java.util.logging.Logger;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class ShippingMain {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(ShippingMain.class.getName());

		logger.info("Starting Shipping Service.");

		ShippingImpl implementor = new ShippingImpl();
		JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
		svrFactory.setServiceClass(Shipping.class);
		svrFactory.setServiceBean(implementor);
		svrFactory
				.setAddress("http://localhost:8093/ShippingService");
		svrFactory.create();

		logger.info("shipping Service started!");

	}
}
