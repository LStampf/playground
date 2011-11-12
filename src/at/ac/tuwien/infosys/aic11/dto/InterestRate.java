package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "interest_rate")
public class InterestRate {

	private Double rate;

	@XmlElement(required = true)
	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("InterestRate[");
		sb.append("rate=" + rate);
		sb.append("]");
		return sb.toString();
	}
}
