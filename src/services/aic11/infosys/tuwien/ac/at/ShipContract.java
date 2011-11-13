
package services.aic11.infosys.tuwien.ac.at;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import dto.aic11.infosys.tuwien.ac.at.Offer;


/**
 * <p>Java class for ship_contract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ship_contract">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="offer" type="{http://at.ac.tuwien.infosys.aic11.dto}offer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ship_contract", propOrder = {
    "offer"
})
public class ShipContract {

    protected Offer offer;

    /**
     * Gets the value of the offer property.
     * 
     * @return
     *     possible object is
     *     {@link Offer }
     *     
     */
    public Offer getOffer() {
        return offer;
    }

    /**
     * Sets the value of the offer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Offer }
     *     
     */
    public void setOffer(Offer value) {
        this.offer = value;
    }

}
