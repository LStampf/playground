package at.ac.tuwien.infosys.aic11.consoleclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import at.ac.tuwien.infosys.aic11.consoleclient.command.Command;
import at.ac.tuwien.infosys.aic11.consoleclient.command.CommandException;
import at.ac.tuwien.infosys.aic11.consoleclient.command.CommandParser;
import at.ac.tuwien.infosys.aic11.consoleclient.handler.NewCustomerHandler;
import at.ac.tuwien.infosys.aic11.consoleclient.handler.PlaceCreditRequestHandler;
import at.ac.tuwien.infosys.aic11.consoleclient.handler.ShippingHandler;
import at.ac.tuwien.infosys.aic11.dto.CreditRequest;
import at.ac.tuwien.infosys.aic11.dto.Duration;
import at.ac.tuwien.infosys.aic11.dto.Money;

public class Main {
	
	public static void main(String[] args) {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String line;
		CreditRequest creditRequest = null;
		PlaceCreditRequestHandler pcrHandler = new PlaceCreditRequestHandler();
		
		while(true) {
			System.out.print("CreditSystem > ");
			try
			{
				line = stdin.readLine();
				Command cmd = CommandParser.parse(line);
				
				if( cmd == Command.Exit )
				{
					break;
				}
				else if( cmd == Command.Help )
				{
					System.out.printf("%-40s Create new customer.\n", "nc | newCustomer");
					System.out.printf("%-40s Place credit requst.\n", "pcr | placeCreditRequest | request");
					System.out.printf("%-40s Decline offer.\n", "do | declineOffer | decline");
					System.out.printf("%-40s Accept offer.\n", "ao | acceptOffer | accept");
					System.out.printf("%-40s Update offer.\n", "uo | updateOffer | update");
					System.out.printf("%-40s Show this content.\n", "h | help | ?");
					System.out.printf("%-40s Exit CreditSystem.\n", "exit");
				}
				else if( cmd == Command.NewCustomer)
				{
					new NewCustomerHandler().handle(System.in, System.out);
				}
				else if( cmd == Command.PlaceCreditRequest )
				{
					creditRequest = new CreditRequest();
					Duration d = new Duration();
					d.setYears(5);
					creditRequest.setDuration(d);
					
					Money m = new Money();
					m.setAmount(1000L);
					m.setCurrencyCode("EUR");
					creditRequest.setMoney(m);
					
					creditRequest = pcrHandler.handle(creditRequest, System.in, System.out);
				}
				else if( cmd == Command.AcceptOffer )
				{
					if( creditRequest == null ) {
						System.out.println("No offer created. Use 'pcr' first");
						continue;
					}
					
					pcrHandler.acceptOffer(creditRequest);
					System.out.println("Offer accepted. Shipping initiated");
					new ShippingHandler().handle(creditRequest.getOffer());
					System.out.println("Signed contract received from customer");
					creditRequest = null;
				}
				else if( cmd == Command.DeclineOffer )
				{
					if( creditRequest == null ) {
						System.out.println("No offer created. Use 'pcr' first");
						continue;
					}
					
					pcrHandler.declineOffer(creditRequest);
					System.out.println("Offer declined");
					creditRequest = null;
				}
				else if( cmd == Command.UpdateRequest )
				{
					if( creditRequest == null ) {
						System.out.println("No offer created. Use 'pcr' first");
						continue;
					}
					
					creditRequest = pcrHandler.updateOffer(creditRequest, System.in, System.out);
					System.out.println("Offer updated");
				}
			}
			catch(CommandException ce)
			{
				System.out.println(ce.getMessage());
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
}
