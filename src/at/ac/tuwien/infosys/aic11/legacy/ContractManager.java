package at.ac.tuwien.infosys.aic11.legacy;

import java.util.Vector;

import at.ac.tuwien.infosys.aic11.dto.Customer;
import at.ac.tuwien.infosys.aic11.dto.Offer;
import at.ac.tuwien.infosys.aic11.legacy.pojo.Contract;

public class ContractManager {

	private static Vector<ICallback> notifiers;
	
	static {
		notifiers = new Vector<ICallback>();
		
		Runnable r = new Runnable() {
			/**
			 * Legacy code which calls the callback function of a notifier.
			 * Indicates that a contract was signed and faxed back.
			 */
			@Override
			public void run()  {
				while( true ) {
					if( notifiers.size() > 0 ) {
						for(ICallback notifier : notifiers) {
							notifier.callback();
						}
						notifiers.clear();
					}
					else {
						try {
							// dirty code - but let's assume the legacy app was programmed in a
							// quick and dirty way.
							Thread.sleep(5000);
						}
						catch(Exception e){ }
					}
				}
			}
		};
		
		new Thread(r).start();
	}
	
	public static Contract createContract(Offer offer, Customer customer) {
		//
		// legacy code
		//
		return new Contract(customer, offer);
	}
	
	public static void shipContract(Contract contract, Customer customer, ICallback notifier) {
		//
		// legacy code
		//
		notifiers.add(notifier);
	}
	
}
