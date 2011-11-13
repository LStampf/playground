
package services.aic11.infosys.tuwien.ac.at;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the services.aic11.infosys.tuwien.ac.at package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ShippingException_QNAME = new QName("at.ac.tuwien.infosys.aic11.services", "ShippingException");
    private final static QName _ShipContractResponse_QNAME = new QName("http://at.ac.tuwien.infosys.aic11.services", "ship_contractResponse");
    private final static QName _ShipContract_QNAME = new QName("http://at.ac.tuwien.infosys.aic11.services", "ship_contract");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: services.aic11.infosys.tuwien.ac.at
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ShipContractResponse }
     * 
     */
    public ShipContractResponse createShipContractResponse() {
        return new ShipContractResponse();
    }

    /**
     * Create an instance of {@link ShipContract }
     * 
     */
    public ShipContract createShipContract() {
        return new ShipContract();
    }

    /**
     * Create an instance of {@link ShippingException }
     * 
     */
    public ShippingException createShippingException() {
        return new ShippingException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShippingException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "at.ac.tuwien.infosys.aic11.services", name = "ShippingException")
    public JAXBElement<ShippingException> createShippingException(ShippingException value) {
        return new JAXBElement<ShippingException>(_ShippingException_QNAME, ShippingException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShipContractResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://at.ac.tuwien.infosys.aic11.services", name = "ship_contractResponse")
    public JAXBElement<ShipContractResponse> createShipContractResponse(ShipContractResponse value) {
        return new JAXBElement<ShipContractResponse>(_ShipContractResponse_QNAME, ShipContractResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShipContract }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://at.ac.tuwien.infosys.aic11.services", name = "ship_contract")
    public JAXBElement<ShipContract> createShipContract(ShipContract value) {
        return new JAXBElement<ShipContract>(_ShipContract_QNAME, ShipContract.class, null, value);
    }

}
