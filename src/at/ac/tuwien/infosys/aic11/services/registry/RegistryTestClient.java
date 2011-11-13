package at.ac.tuwien.infosys.aic11.services.registry;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import at.ac.tuwien.infosys.aic11.services.Address;
import at.ac.tuwien.infosys.aic11.services.Customer;
import at.ac.tuwien.infosys.aic11.services.Money;

public class RegistryTestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IRegistryService registry = new RegistryService().getRegistryService();
		Cheque cheque = new Cheque();
		cheque.setName("test");
		try {
			WsdlEndpoint endpoint = registry.query(cheque);
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory
					.newInstance();
			Client client = dcf.createClient(endpoint.getLocation() + "?wsdl");

			Money m = new Money();
			m.setAmount(20);

			at.ac.tuwien.infosys.aic11.services.Cheque cheque2 = new at.ac.tuwien.infosys.aic11.services.Cheque();
			cheque2.setName("test");

			Customer customer = new Customer();
			customer.setCustomerId(1L);
			customer.setFirstName("Lukas");

			Address adr = new Address();
			adr.setCity("city");
			customer.setAddress(adr);

			Object[] objs = client.invoke("start_money_transfer_process",
					cheque, m, customer);

			System.out.println("ASD");
			
		} catch (InvalidParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
