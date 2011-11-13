
package dto.aic11.infosys.tuwien.ac.at;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bankTransfer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bankTransfer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://at.ac.tuwien.infosys.aic11.dto}disbursementPreference">
 *       &lt;sequence>
 *         &lt;element name="bank_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bic" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iban" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bankTransfer", propOrder = {
    "bankName",
    "bic",
    "iban"
})
public class BankTransfer
    extends DisbursementPreference
{

    @XmlElement(name = "bank_name", required = true)
    protected String bankName;
    @XmlElement(required = true)
    protected String bic;
    @XmlElement(required = true)
    protected String iban;

    /**
     * Gets the value of the bankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the value of the bankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankName(String value) {
        this.bankName = value;
    }

    /**
     * Gets the value of the bic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBic() {
        return bic;
    }

    /**
     * Sets the value of the bic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBic(String value) {
        this.bic = value;
    }

    /**
     * Gets the value of the iban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIban() {
        return iban;
    }

    /**
     * Sets the value of the iban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIban(String value) {
        this.iban = value;
    }

}
