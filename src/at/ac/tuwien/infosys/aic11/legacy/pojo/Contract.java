package at.ac.tuwien.infosys.aic11.legacy.pojo;

import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.Offer;

public class Contract {
	private Customer customer;
	private Offer offer;
	
	public Contract(Customer customer, Offer offer) {
		this.customer = customer;
		this.offer = offer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
	public Offer getOffer() {
		return offer;
	}
}
