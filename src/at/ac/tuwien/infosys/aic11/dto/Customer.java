package at.ac.tuwien.infosys.aic11.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

	private Long customerId;
	private String firstName;
	private String middleName;
	private String lastName;
	private BigDecimal openBalance;
	private List<CreditRequest> creditRequests;
	private DisbursementPreference disbursementPreference;
	private Addresses addresses;
	private Rating rating;

	@XmlAttribute(name = "customer_id", required = true)
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@XmlElement(name = "first_name", required = true)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@XmlElement(name = "middle_name")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@XmlElement(name = "last_name", required = true)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@XmlElement(name = "open_balance", required = true)
	public BigDecimal getOpenBalance() {
		return openBalance;
	}

	public void setOpenBalance(BigDecimal openBalance) {
		this.openBalance = openBalance;
	}

	@XmlElement(name = "credit_requests")
	public List<CreditRequest> getCreditRequests() {
		return creditRequests;
	}

	public void setCreditRequests(List<CreditRequest> creditRequests) {
		this.creditRequests = creditRequests;
	}

	@XmlElement(name = "disbursement_preference", required = true)
	public DisbursementPreference getDisbursementPreference() {
		return disbursementPreference;
	}

	public void setDisbursementPreference(
			DisbursementPreference disbursementPreference) {
		this.disbursementPreference = disbursementPreference;
	}

	@XmlElement(required = true)
	public Addresses getAddresses() {
		return addresses;
	}

	public void setAddresses(Addresses addresses) {
		this.addresses = addresses;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Customer[");
		sb.append("id=" + customerId + ", ");
		sb.append("firstName=" + firstName + ", ");
		sb.append("middleName=" + middleName + ", ");
		sb.append("lastName=" + lastName + ", ");
		sb.append("address=" + addresses);
		sb.append("]");
		return sb.toString();
	}

}
