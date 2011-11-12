package at.ac.tuwien.infosys.aic11.services.util;

import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxws.JAXWSMethodInvoker;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.service.invoker.Factory;
import org.apache.cxf.service.invoker.SingletonFactory;

public class JAXWSMethodInvokerWithLogging extends JAXWSMethodInvoker {

	private Logger logger;
	private static String lineSeparator = System.getProperty("line.separator");

	public JAXWSMethodInvokerWithLogging(final Object bean, Logger logger) {
		super(new SingletonFactory(bean));
		this.logger = logger;
	}

	public JAXWSMethodInvokerWithLogging(Factory factory, Logger logger) {
		super(factory);
		this.logger = logger;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Object invoke(Exchange exchange, final Object serviceObject,
			Method m, List<Object> params) {
		logMethodCall(m, params);

		try {
			List ret = CastUtils.cast((List) super.invoke(exchange,
					serviceObject, m, params));
			logMethodReturn(m, ret);
			return ret;
		} catch (Fault f) {
			logFault(m, f);
			throw f;
		}

	}

	@SuppressWarnings("rawtypes")
	private void logMethodReturn(Method m, List lst) {
		StringBuilder sb = new StringBuilder();

		sb.append("Method finished execution!");
		if (lst.get(0) != null) {
			sb.append(" Returnvalue: ");
			for (Object obj : lst) {
				sb.append(obj.getClass().getName());
				sb.append(" ");
				sb.append(obj);
				sb.append(" , ");
			}
		}
		logger.logp(Level.INFO, m.getDeclaringClass().getName(), m.getName(),
				sb.toString());
	}

	private void logFault(Method m, Fault f) {
		StringBuilder sb = new StringBuilder();

		sb.append("Method ended in Fault! ");
		sb.append("ErrorMessage: " + f.getMessage());

		logger.logp(Level.SEVERE, m.getDeclaringClass().getName(), m.getName(),
				sb.toString());
	}

	private void logMethodCall(Method m, List<Object> params) {
		StringBuilder sb = new StringBuilder();

		sb.append("Method was called");
		if (!params.isEmpty()) {
			sb.append(" with parameters:");
			sb.append(lineSeparator);
			for (Object obj : params) {
				sb.append(obj.getClass().getName());
				sb.append(" ");
				sb.append(obj);
				sb.append(lineSeparator);
			}
		}
		logger.logp(Level.INFO, m.getDeclaringClass().getName(), m.getName(),
				sb.toString());
	}

}
