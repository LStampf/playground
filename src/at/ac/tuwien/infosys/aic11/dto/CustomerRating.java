package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer_rating")
@XmlEnum
public enum CustomerRating {
    AAA, AAPlus, AA, AAMinus, APlus, A, AMinus, Defaulting
}
