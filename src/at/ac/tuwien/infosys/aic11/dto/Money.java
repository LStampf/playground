package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Money {

	private String currencyCode;
	private Long amount;

	@XmlElement(name = "currency_code", required = true)
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@XmlElement(required = true)
	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Money[");
		sb.append("currencyCode=" + currencyCode + ", ");
		sb.append("amount=" + amount);
		sb.append("]");
		return sb.toString();
	}

}
