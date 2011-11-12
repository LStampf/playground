package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Rating {

	private Customer customer;
	private CustomerRating customerRating;

	// @XmlElement(required = true)
	@XmlTransient
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@XmlElement(name = "customer_rating", required = true)
	public CustomerRating getCustomerRating() {
		return customerRating;
	}

	public void setCustomerRating(CustomerRating customerRating) {
		this.customerRating = customerRating;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Rating[");
		sb.append("customer=" + customer + ", ");
		sb.append("customerRating=" + customerRating);
		sb.append("]");
		return sb.toString();
	}

}
