
package dto.aic11.infosys.tuwien.ac.at;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for offer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="offer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="credit_request" type="{http://at.ac.tuwien.infosys.aic11.dto}creditRequest"/>
 *         &lt;element name="interest_rate" type="{http://at.ac.tuwien.infosys.aic11.dto}interestRate"/>
 *       &lt;/sequence>
 *       &lt;attribute name="offer_id" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "offer", propOrder = {
    "comments",
    "creditRequest",
    "interestRate"
})
public class Offer {

    @XmlElement(required = true)
    protected String comments;
    @XmlElement(name = "credit_request", required = true)
    protected CreditRequest creditRequest;
    @XmlElement(name = "interest_rate", required = true)
    protected InterestRate interestRate;
    @XmlAttribute(name = "offer_id", required = true)
    protected long offerId;

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the creditRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CreditRequest }
     *     
     */
    public CreditRequest getCreditRequest() {
        return creditRequest;
    }

    /**
     * Sets the value of the creditRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditRequest }
     *     
     */
    public void setCreditRequest(CreditRequest value) {
        this.creditRequest = value;
    }

    /**
     * Gets the value of the interestRate property.
     * 
     * @return
     *     possible object is
     *     {@link InterestRate }
     *     
     */
    public InterestRate getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the value of the interestRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterestRate }
     *     
     */
    public void setInterestRate(InterestRate value) {
        this.interestRate = value;
    }

    /**
     * Gets the value of the offerId property.
     * 
     */
    public long getOfferId() {
        return offerId;
    }

    /**
     * Sets the value of the offerId property.
     * 
     */
    public void setOfferId(long value) {
        this.offerId = value;
    }

}
