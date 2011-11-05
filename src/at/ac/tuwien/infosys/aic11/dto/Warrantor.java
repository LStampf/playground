package at.ac.tuwien.infosys.aic11.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Warrantor extends Customer {

    private List<CreditRequest> warrantedRequests;

    @XmlElement(name = "warranted_requests")
    public List<CreditRequest> getWarrantedRequests() {
        return warrantedRequests;
    }

    public void setWarrantedRequests(List<CreditRequest> warrantedRequests) {
        this.warrantedRequests = warrantedRequests;
    }
}
