package at.ac.tuwien.infosys.aic11.dto;

public class Rating {

    private Customer customer;
    private CustomerRating customerRating;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerRating getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(CustomerRating customerRating) {
        this.customerRating = customerRating;
    }

}
