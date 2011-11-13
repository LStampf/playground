
package dto.aic11.infosys.tuwien.ac.at;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dto.aic11.infosys.tuwien.ac.at package. 
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

    private final static QName _Cheque_QNAME = new QName("http://at.ac.tuwien.infosys.aic11.dto", "cheque");
    private final static QName _Warrantor_QNAME = new QName("http://at.ac.tuwien.infosys.aic11.dto", "warrantor");
    private final static QName _Addresses_QNAME = new QName("http://at.ac.tuwien.infosys.aic11.dto", "addresses");
    private final static QName _InterestRate_QNAME = new QName("http://at.ac.tuwien.infosys.aic11.dto", "interest_rate");
    private final static QName _Money_QNAME = new QName("http://at.ac.tuwien.infosys.aic11.dto", "money");
    private final static QName _Rating_QNAME = new QName("http://at.ac.tuwien.infosys.aic11.dto", "rating");
    private final static QName _CreditRequest_QNAME = new QName("http://at.ac.tuwien.infosys.aic11.dto", "credit_request");
    private final static QName _Duration_QNAME = new QName("http://at.ac.tuwien.infosys.aic11.dto", "duration");
    private final static QName _Customer_QNAME = new QName("http://at.ac.tuwien.infosys.aic11.dto", "customer");
    private final static QName _BankTransfer_QNAME = new QName("http://at.ac.tuwien.infosys.aic11.dto", "bank_transfer");
    private final static QName _Offer_QNAME = new QName("http://at.ac.tuwien.infosys.aic11.dto", "offer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dto.aic11.infosys.tuwien.ac.at
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Duration }
     * 
     */
    public Duration createDuration() {
        return new Duration();
    }

    /**
     * Create an instance of {@link CreditRequest }
     * 
     */
    public CreditRequest createCreditRequest() {
        return new CreditRequest();
    }

    /**
     * Create an instance of {@link Money }
     * 
     */
    public Money createMoney() {
        return new Money();
    }

    /**
     * Create an instance of {@link Rating }
     * 
     */
    public Rating createRating() {
        return new Rating();
    }

    /**
     * Create an instance of {@link Offer }
     * 
     */
    public Offer createOffer() {
        return new Offer();
    }

    /**
     * Create an instance of {@link Warrantor }
     * 
     */
    public Warrantor createWarrantor() {
        return new Warrantor();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link Addresses }
     * 
     */
    public Addresses createAddresses() {
        return new Addresses();
    }

    /**
     * Create an instance of {@link Cheque }
     * 
     */
    public Cheque createCheque() {
        return new Cheque();
    }

    /**
     * Create an instance of {@link InterestRate }
     * 
     */
    public InterestRate createInterestRate() {
        return new InterestRate();
    }

    /**
     * Create an instance of {@link BankTransfer }
     * 
     */
    public BankTransfer createBankTransfer() {
        return new BankTransfer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cheque }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://at.ac.tuwien.infosys.aic11.dto", name = "cheque")
    public JAXBElement<Cheque> createCheque(Cheque value) {
        return new JAXBElement<Cheque>(_Cheque_QNAME, Cheque.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Warrantor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://at.ac.tuwien.infosys.aic11.dto", name = "warrantor")
    public JAXBElement<Warrantor> createWarrantor(Warrantor value) {
        return new JAXBElement<Warrantor>(_Warrantor_QNAME, Warrantor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Addresses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://at.ac.tuwien.infosys.aic11.dto", name = "addresses")
    public JAXBElement<Addresses> createAddresses(Addresses value) {
        return new JAXBElement<Addresses>(_Addresses_QNAME, Addresses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InterestRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://at.ac.tuwien.infosys.aic11.dto", name = "interest_rate")
    public JAXBElement<InterestRate> createInterestRate(InterestRate value) {
        return new JAXBElement<InterestRate>(_InterestRate_QNAME, InterestRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Money }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://at.ac.tuwien.infosys.aic11.dto", name = "money")
    public JAXBElement<Money> createMoney(Money value) {
        return new JAXBElement<Money>(_Money_QNAME, Money.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Rating }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://at.ac.tuwien.infosys.aic11.dto", name = "rating")
    public JAXBElement<Rating> createRating(Rating value) {
        return new JAXBElement<Rating>(_Rating_QNAME, Rating.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://at.ac.tuwien.infosys.aic11.dto", name = "credit_request")
    public JAXBElement<CreditRequest> createCreditRequest(CreditRequest value) {
        return new JAXBElement<CreditRequest>(_CreditRequest_QNAME, CreditRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://at.ac.tuwien.infosys.aic11.dto", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://at.ac.tuwien.infosys.aic11.dto", name = "customer")
    public JAXBElement<Customer> createCustomer(Customer value) {
        return new JAXBElement<Customer>(_Customer_QNAME, Customer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BankTransfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://at.ac.tuwien.infosys.aic11.dto", name = "bank_transfer")
    public JAXBElement<BankTransfer> createBankTransfer(BankTransfer value) {
        return new JAXBElement<BankTransfer>(_BankTransfer_QNAME, BankTransfer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Offer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://at.ac.tuwien.infosys.aic11.dto", name = "offer")
    public JAXBElement<Offer> createOffer(Offer value) {
        return new JAXBElement<Offer>(_Offer_QNAME, Offer.class, null, value);
    }

}
