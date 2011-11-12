package at.ac.tuwien.infosys.aic11.services.customerrelation;

import java.util.logging.Logger;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.service.invoker.Invoker;
import org.apache.cxf.service.invoker.SingletonFactory;

import at.ac.tuwien.aic11.services.util.JAXWSMethodInvokerWithLogging;

public class CustomerRelationsManagementMain {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(CustomerRelationsManagementImpl.class
				.getName());

		logger.info("Starting Server.");

		CustomerRelationsManagementImpl implementor = new CustomerRelationsManagementImpl();
		JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
		svrFactory.setServiceClass(CustomerRelationsManagement.class);
		svrFactory.setServiceBean(implementor);
		svrFactory
				.setAddress("http://localhost:8090/customerRelationsManagement");
		Invoker inv = new JAXWSMethodInvokerWithLogging(new SingletonFactory(
				implementor), logger);
		svrFactory.setInvoker(inv);
		svrFactory.create();

		logger.info("Services started.");
	}

}
