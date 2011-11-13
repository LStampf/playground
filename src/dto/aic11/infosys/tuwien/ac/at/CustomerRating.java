
package dto.aic11.infosys.tuwien.ac.at;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerRating.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="customerRating">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AAA"/>
 *     &lt;enumeration value="AAPlus"/>
 *     &lt;enumeration value="AA"/>
 *     &lt;enumeration value="AAMinus"/>
 *     &lt;enumeration value="APlus"/>
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="AMinus"/>
 *     &lt;enumeration value="Defaulting"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "customerRating")
@XmlEnum
public enum CustomerRating {

    AAA("AAA"),
    @XmlEnumValue("AAPlus")
    AA_PLUS("AAPlus"),
    AA("AA"),
    @XmlEnumValue("AAMinus")
    AA_MINUS("AAMinus"),
    @XmlEnumValue("APlus")
    A_PLUS("APlus"),
    A("A"),
    @XmlEnumValue("AMinus")
    A_MINUS("AMinus"),
    @XmlEnumValue("Defaulting")
    DEFAULTING("Defaulting");
    private final String value;

    CustomerRating(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CustomerRating fromValue(String v) {
        for (CustomerRating c: CustomerRating.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
