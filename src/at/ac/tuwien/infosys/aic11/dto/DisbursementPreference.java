package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso(value = { Cheque.class, BankTransfer.class })
public abstract class DisbursementPreference {

}
