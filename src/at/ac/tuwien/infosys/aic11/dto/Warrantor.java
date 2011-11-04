package at.ac.tuwien.infosys.aic11.dto;

import java.util.List;

public class Warrantor extends Customer {

    private List<CreditRequest> warrantedRequests;

    public List<CreditRequest> getWarrantedRequests() {
        return warrantedRequests;
    }

    public void setWarrantedRequests(List<CreditRequest> warrantedRequests) {
        this.warrantedRequests = warrantedRequests;
    }
}
