package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cheque extends DisbursementPreference {

    private String name;

    @XmlElement(required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cheque[");
		sb.append("name=" + name);
		sb.append("]");
		return sb.toString();
	}
}
