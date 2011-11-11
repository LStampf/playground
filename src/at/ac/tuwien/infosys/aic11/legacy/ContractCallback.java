package at.ac.tuwien.infosys.aic11.legacy;

import at.ac.tuwien.infosys.aic11.legacy.pojo.Contract;

public abstract class ContractCallback implements ICallback {

	private Contract c;
	
	public ContractCallback(Contract c) {
		this.c = c;
	}

	public Contract getContract() {
		return c;
	}
	
	public void setContract(Contract c) {
		this.c = c;
	}
}
