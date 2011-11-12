package test;

import java.util.logging.Logger;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.service.invoker.SingletonFactory;

import at.ac.tuwien.infosys.aic11.services.util.JAXWSMethodInvokerWithLogging;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWorldImpl implementor = new HelloWorldImpl();
		JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
		svrFactory.setServiceClass(HelloWorld.class);
		svrFactory.setAddress("http://localhost:9000/helloWorld");
		svrFactory.setServiceBean(implementor);
		JAXWSMethodInvokerWithLogging inv = new JAXWSMethodInvokerWithLogging(
				new SingletonFactory(implementor), Logger.getAnonymousLogger());
		svrFactory.setInvoker(inv);
		svrFactory.getInInterceptors().add(new LoggingInInterceptor());
		svrFactory.getOutInterceptors().add(new LoggingOutInterceptor());
		svrFactory.create();
	}
}
