package at.ac.tuwien.infosys.aic11.services.rating;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.provider.JSONProvider;

import at.ac.tuwien.infosys.aic11.dto.Addresses;
import at.ac.tuwien.infosys.aic11.dto.Cheque;
import at.ac.tuwien.infosys.aic11.dto.Warrantor;
import at.ac.tuwien.infosys.aic11.legacy.customerrelations.CustomerDAO;

public class RatingMain {

	public static void main(String[] args) {

		Logger logger = Logger.getLogger(RatingMain.class.getName());
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

		logger.info("insert testdata");

		Warrantor w = new Warrantor();
		w.setCustomerId(1L);
		Addresses address = new Addresses();
		address.setCity("Vienna");
		address.setDoor("42");
		address.setId("1");
		address.setHouse("House2");
		address.setStreet("wonderstreet");
		address.setZipCode("666");

		w.setFirstName("Lukas");
		w.setLastName("Stampf");
		Cheque pref = new Cheque();
		pref.setName("cheque");
		w.setDisbursementPreference(pref);
		w.setAddresses(address);
		w.setOpenBalance(new BigDecimal(0));

		CustomerDAO.getInstance().save(w);
	}

}
