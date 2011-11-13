
package dto.aic11.infosys.tuwien.ac.at;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for warrantor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="warrantor">
 *   &lt;complexContent>
 *     &lt;extension base="{http://at.ac.tuwien.infosys.aic11.dto}customer">
 *       &lt;sequence>
 *         &lt;element name="warranted_requests" type="{http://at.ac.tuwien.infosys.aic11.dto}creditRequest" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "warrantor", propOrder = {
    "warrantedRequests"
})
public class Warrantor
    extends Customer
{

    @XmlElement(name = "warranted_requests")
    protected List<CreditRequest> warrantedRequests;

    /**
     * Gets the value of the warrantedRequests property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the warrantedRequests property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWarrantedRequests().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditRequest }
     * 
     * 
     */
    public List<CreditRequest> getWarrantedRequests() {
        if (warrantedRequests == null) {
            warrantedRequests = new ArrayList<CreditRequest>();
        }
        return this.warrantedRequests;
    }

}
