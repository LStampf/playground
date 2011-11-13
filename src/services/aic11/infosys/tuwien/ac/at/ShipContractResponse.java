
package services.aic11.infosys.tuwien.ac.at;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import dto.aic11.infosys.tuwien.ac.at.Offer;


/**
 * <p>Java class for ship_contractResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ship_contractResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://at.ac.tuwien.infosys.aic11.dto}offer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ship_contractResponse", propOrder = {
    "_return"
})
public class ShipContractResponse {

    @XmlElement(name = "return")
    protected Offer _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link Offer }
     *     
     */
    public Offer getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link Offer }
     *     
     */
    public void setReturn(Offer value) {
        this._return = value;
    }

}
