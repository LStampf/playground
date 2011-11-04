package at.ac.tuwien.infosys.aic11.dto;

public class Offer {

    private Long offerId;
    private String comments;
    private InterestRate interestRate;
    private CreditRequest creditRequest;

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public InterestRate getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(InterestRate interestRate) {
        this.interestRate = interestRate;
    }

    public CreditRequest getCreditRequest() {
        return creditRequest;
    }

    public void setCreditRequest(CreditRequest creditRequest) {
        this.creditRequest = creditRequest;
    }

}
