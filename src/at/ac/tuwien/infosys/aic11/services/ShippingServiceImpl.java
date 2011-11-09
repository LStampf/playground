package at.ac.tuwien.infosys.aic11.services;

import at.ac.tuwien.infosys.aic11.dto.Customer;

public class ShippingServiceImpl implements ShippingService {

	@Override
	public Customer ship()  {
		Customer c = new Customer();
		c.setFirstName("Hans");
		return c;
	}

}
