package at.ac.tuwien.infosys.aic11.dto;

import java.math.BigDecimal;
import java.util.List;

public class Customer {

    private Long customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private BigDecimal openBalance;
    private List<CreditRequest> creditRequests;
    private DisbursementPreference disbursementPreference;
    private Addresses addresses;
    private Rating rating;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getOpenBalance() {
        return openBalance;
    }

    public void setOpenBalance(BigDecimal openBalance) {
        this.openBalance = openBalance;
    }

    public List<CreditRequest> getCreditRequests() {
        return creditRequests;
    }

    public void setCreditRequests(List<CreditRequest> creditRequests) {
        this.creditRequests = creditRequests;
    }

    public DisbursementPreference getDisbursementPreference() {
        return disbursementPreference;
    }

    public void setDisbursementPreference(DisbursementPreference disbursementPreference) {
        this.disbursementPreference = disbursementPreference;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

}
