package at.ac.tuwien.infosys.aic11.dto;

import java.util.List;

public class CreditRequest {

    private Long requestId;
    private String reason;
    private Offer offer;
    private Money money;
    private Duration duration;
    private Customer customer;
    private List<Warrantor> warrantors;

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

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

}
