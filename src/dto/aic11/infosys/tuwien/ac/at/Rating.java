
package dto.aic11.infosys.tuwien.ac.at;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rating complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rating">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customer_rating" type="{http://at.ac.tuwien.infosys.aic11.dto}customerRating"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rating", propOrder = {
    "customerRating"
})
public class Rating {

    @XmlElement(name = "customer_rating", required = true)
    protected CustomerRating customerRating;

    /**
     * Gets the value of the customerRating property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerRating }
     *     
     */
    public CustomerRating getCustomerRating() {
        return customerRating;
    }

    /**
     * Sets the value of the customerRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerRating }
     *     
     */
    public void setCustomerRating(CustomerRating value) {
        this.customerRating = value;
    }

}
