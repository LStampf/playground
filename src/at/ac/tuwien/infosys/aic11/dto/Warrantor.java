package at.ac.tuwien.infosys.aic11.dto;

import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Warrantor extends Customer {

    private List<CreditRequest> warrantedRequests;

    public Warrantor() {
		this.warrantedRequests = new Vector<CreditRequest>();
	}
    
    @XmlElement(name = "warranted_requests")
    public List<CreditRequest> getWarrantedRequests() {
        return warrantedRequests;
    }

    public void setWarrantedRequests(List<CreditRequest> warrantedRequests) {
        this.warrantedRequests = warrantedRequests;
    }
    
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Warrantor[");
		sb.append("id=" + getCustomerId() + ", ");
		sb.append("firstName=" + getFirstName() + ", ");
		sb.append("middleName=" + getMiddleName() + ", ");
		sb.append("lastName=" + getLastName() + ", ");
		sb.append("address=" + getAddresses());
		sb.append("]");
		return sb.toString();
	}
}
