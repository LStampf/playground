package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bank_transfer")
public class BankTransfer extends DisbursementPreference {

	private String bankName;
	private String bic;
	private String iban;

	@XmlElement(name = "bank_name", required = true)
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@XmlElement(required = true)
	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	@XmlElement(required = true)
	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("BankTransfer[");
		sb.append("bankName=" + bankName + ", ");
		sb.append("bic=" + bic + ", ");
		sb.append("iban=" + iban + ", ");
		sb.append("]");
		return sb.toString();
	}
}
