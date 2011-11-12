package at.ac.tuwien.infosys.aic11.services.contract;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.service.invoker.Invoker;
import org.apache.cxf.service.invoker.SingletonFactory;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.handler.WSHandlerConstants;

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

		Map<String, Object> inProps = new HashMap<String, Object>();

		inProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.TIMESTAMP
				+ " " + WSHandlerConstants.SIGNATURE + " "
				+ WSHandlerConstants.ENCRYPT);
		inProps.put(WSHandlerConstants.PW_CALLBACK_CLASS,
				ServiceKeystorePasswordCallback.class.getName());
		inProps.put(WSHandlerConstants.SIG_PROP_FILE,
				"keys/serviceKeystore.properties");
		inProps.put(WSHandlerConstants.DEC_PROP_FILE,
				"keys/serviceKeystore.properties");

		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
		svrFactory.getInInterceptors().add(wssIn);
		// svrFactory.getInInterceptors().add(new LoggingInInterceptor());

		Map<String, Object> outProps = new HashMap<String, Object>();

		outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.TIMESTAMP
				+ " " + WSHandlerConstants.SIGNATURE + " "
				+ WSHandlerConstants.ENCRYPT);
		outProps.put(WSHandlerConstants.USER, "contractmanagementkey");
		outProps.put(WSHandlerConstants.ENCRYPTION_USER,
				WSHandlerConstants.USE_REQ_SIG_CERT);
		outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS,
				ServiceKeystorePasswordCallback.class.getName());
		outProps.put(WSHandlerConstants.SIG_PROP_FILE,
				"keys/serviceKeystore.properties");
		outProps.put(WSHandlerConstants.ENC_PROP_FILE,
				"keys/serviceKeystore.properties");

		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
		svrFactory.getOutInterceptors().add(wssOut);
		// svrFactory.getOutInterceptors().add(new LoggingOutInterceptor());
		svrFactory.create();

		logger.info("ContractManagementService started!");
	}

}
