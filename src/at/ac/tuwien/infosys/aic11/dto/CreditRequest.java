package at.ac.tuwien.infosys.aic11.dto;

import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "credit_request")
public class CreditRequest {

	private Long requestId;
	private String reason;
	private Offer offer;
	private Money money;
	private Duration duration;
	private Customer customer;
	private List<Warrantor> warrantors;

	public CreditRequest() {
		this.warrantors = new Vector<Warrantor>();
	}
	
	@XmlAttribute(name = "request_id", required = true)
	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	@XmlElement(required = true)
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@XmlTransient
	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	@XmlElement(required = true)
	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	@XmlElement(required = true)
	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	@XmlElement(required = true)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Warrantor> getWarrantors() {
		return warrantors;
	}

	public void setWarrantors(List<Warrantor> warrantors) {
		this.warrantors = warrantors;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("CreditRequest[");
		sb.append("requestId=" + requestId + ", ");
		sb.append("reason=" + reason + ", ");
		sb.append("money=" + money + ", ");
		sb.append("duration=" + duration);
		sb.append("]");
		return sb.toString();
	}
}
