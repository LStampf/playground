package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Duration {

	private Integer years;

	@XmlElement(required = true)
	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Duration[");
		sb.append("years=" + years);
		sb.append("]");
		return sb.toString();
	}
}
