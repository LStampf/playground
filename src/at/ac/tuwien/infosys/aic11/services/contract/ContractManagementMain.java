package at.ac.tuwien.infosys.aic11.services.contract;

import java.util.logging.Logger;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.service.invoker.Invoker;
import org.apache.cxf.service.invoker.SingletonFactory;

import at.ac.tuwien.infosys.aic11.services.util.JAXWSMethodInvokerWithLogging;

public class ContractManagementMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Logger logger = Logger
				.getLogger(ContractManagementImpl.class.getName());

		logger.info("Starting ContractManagementService.");

		ContractManagementImpl implementor = new ContractManagementImpl();
		JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
		svrFactory.setServiceClass(ContractManagement.class);
		svrFactory.setServiceBean(implementor);
		svrFactory
				.setAddress("http://localhost:8091/ContractManagementService");
		Invoker inv = new JAXWSMethodInvokerWithLogging(new SingletonFactory(
				implementor), logger);
		svrFactory.setInvoker(inv);
		svrFactory.create();

		logger.info("ContractManagementService started!");
	}

}
