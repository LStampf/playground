package at.ac.tuwien.infosys.aic11.services.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.provider.JSONProvider;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.service.invoker.Invoker;
import org.apache.cxf.service.invoker.SingletonFactory;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.handler.WSHandlerConstants;

import at.ac.tuwien.infosys.aic11.services.contract.ContractManagement;
import at.ac.tuwien.infosys.aic11.services.contract.ContractManagementImpl;
import at.ac.tuwien.infosys.aic11.services.contract.ServiceKeystorePasswordCallback;
import at.ac.tuwien.infosys.aic11.services.customerrelation.CustomerRelationsManagement;
import at.ac.tuwien.infosys.aic11.services.customerrelation.CustomerRelationsManagementImpl;
import at.ac.tuwien.infosys.aic11.services.rating.RatingExceptionMapper;
import at.ac.tuwien.infosys.aic11.services.rating.RatingImpl;
import at.ac.tuwien.infosys.aic11.services.shipping.Shipping;
import at.ac.tuwien.infosys.aic11.services.shipping.ShippingImpl;
import at.ac.tuwien.infosys.aic11.services.util.JAXWSMethodInvokerWithLogging;

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		startCRMService();
		startRatingService();
		startContractService();
		startShippingService();
	}

	private static void startShippingService() {
		logger.info("Starting Shipping Service.");

		ShippingImpl implementor = new ShippingImpl();
		JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
		svrFactory.setServiceClass(Shipping.class);
		svrFactory.setServiceBean(implementor);
		svrFactory.setAddress("http://localhost:8093/ShippingService");
		svrFactory.create();

		logger.info("shipping Service started!");

	}

	private static void startRatingService() {
		logger.info("Starting rating service.");

		JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
		sf.setServiceClass(RatingImpl.class);
		sf.setAddress("http://localhost:8092/");
		sf.setBindingId(JAXRSBindingFactory.JAXRS_BINDING_ID);
		List<Object> provider = new ArrayList<Object>();
		provider.add(new RatingExceptionMapper());
		provider.add(new JSONProvider());
		sf.setProviders(provider);
		sf.create();

		logger.info("rating service started.");
	}

	private static void startCRMService() {
		logger.info("Starting CRM Service.");

		CustomerRelationsManagementImpl implementor = new CustomerRelationsManagementImpl();
		JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
		svrFactory.setServiceClass(CustomerRelationsManagement.class);
		svrFactory.setServiceBean(implementor);
		svrFactory
				.setAddress("http://localhost:8090/CustomerRelationsManagementService");
		Invoker inv = new JAXWSMethodInvokerWithLogging(new SingletonFactory(
				implementor), logger);
		svrFactory.setInvoker(inv);
		svrFactory.create();

		logger.info("CRM Service started!");
	}

	private static void startContractService() {
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
