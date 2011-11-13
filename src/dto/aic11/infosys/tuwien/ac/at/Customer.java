
package dto.aic11.infosys.tuwien.ac.at;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addresses" type="{http://at.ac.tuwien.infosys.aic11.dto}addresses"/>
 *         &lt;element name="credit_requests" type="{http://at.ac.tuwien.infosys.aic11.dto}creditRequest" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="disbursement_preference" type="{http://at.ac.tuwien.infosys.aic11.dto}disbursementPreference"/>
 *         &lt;element name="first_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="last_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="middle_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="open_balance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="rating" type="{http://at.ac.tuwien.infosys.aic11.dto}rating" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="customer_id" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customer", propOrder = {
    "addresses",
    "creditRequests",
    "disbursementPreference",
    "firstName",
    "lastName",
    "middleName",
    "openBalance",
    "rating"
})
@XmlSeeAlso({
    Warrantor.class
})
public class Customer {

    @XmlElement(required = true)
    protected Addresses addresses;
    @XmlElement(name = "credit_requests")
    protected List<CreditRequest> creditRequests;
    @XmlElement(name = "disbursement_preference", required = true)
    protected DisbursementPreference disbursementPreference;
    @XmlElement(name = "first_name", required = true)
    protected String firstName;
    @XmlElement(name = "last_name", required = true)
    protected String lastName;
    @XmlElement(name = "middle_name")
    protected String middleName;
    @XmlElement(name = "open_balance", required = true)
    protected BigDecimal openBalance;
    protected Rating rating;
    @XmlAttribute(name = "customer_id", required = true)
    protected long customerId;

    /**
     * Gets the value of the addresses property.
     * 
     * @return
     *     possible object is
     *     {@link Addresses }
     *     
     */
    public Addresses getAddresses() {
        return addresses;
    }

    /**
     * Sets the value of the addresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link Addresses }
     *     
     */
    public void setAddresses(Addresses value) {
        this.addresses = value;
    }

    /**
     * Gets the value of the creditRequests property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditRequests property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditRequests().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditRequest }
     * 
     * 
     */
    public List<CreditRequest> getCreditRequests() {
        if (creditRequests == null) {
            creditRequests = new ArrayList<CreditRequest>();
        }
        return this.creditRequests;
    }

    /**
     * Gets the value of the disbursementPreference property.
     * 
     * @return
     *     possible object is
     *     {@link DisbursementPreference }
     *     
     */
    public DisbursementPreference getDisbursementPreference() {
        return disbursementPreference;
    }

    /**
     * Sets the value of the disbursementPreference property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisbursementPreference }
     *     
     */
    public void setDisbursementPreference(DisbursementPreference value) {
        this.disbursementPreference = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the middleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the value of the middleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiddleName(String value) {
        this.middleName = value;
    }

    /**
     * Gets the value of the openBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOpenBalance() {
        return openBalance;
    }

    /**
     * Sets the value of the openBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOpenBalance(BigDecimal value) {
        this.openBalance = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link Rating }
     *     
     */
    public Rating getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rating }
     *     
     */
    public void setRating(Rating value) {
        this.rating = value;
    }

    /**
     * Gets the value of the customerId property.
     * 
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     * 
     */
    public void setCustomerId(long value) {
        this.customerId = value;
    }

}
