package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Offer {

	private Long offerId;
	private String comments;
	private InterestRate interestRate;
	private CreditRequest creditRequest;

	@XmlAttribute(name = "offer_id", required = true)
	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	@XmlElement(required = true)
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@XmlElement(name = "interest_rate", required = true)
	public InterestRate getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(InterestRate interestRate) {
		this.interestRate = interestRate;
	}

	@XmlElement(name = "credit_request", required = true)
	public CreditRequest getCreditRequest() {
		return creditRequest;
	}

	public void setCreditRequest(CreditRequest creditRequest) {
		this.creditRequest = creditRequest;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Offer[");
		sb.append("id=" + offerId + ", ");
		sb.append("comments=" + comments);
		sb.append("]");
		return sb.toString();
	}

}
