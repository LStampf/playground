package at.ac.tuwien.infosys.aic11.consoleclient.command;

public class CommandParser {
	
	public static Command parse(String cmd) throws CommandException
	{
		cmd = cmd.toLowerCase();
		if( cmd.equals("pcr") || 
			cmd.equals("placecreditrequest") || 
			cmd.equals("request") )
		{
			return Command.PlaceCreditRequest;
		}
		else if( cmd.equals("do") ||
				 cmd.equals("declineoffer") ||
				 cmd.equals("decline") )
		{
			return Command.DeclineOffer;
		}
		else if( cmd.equals("ao") ||
				 cmd.equals("acceptoffer") ||
				 cmd.equals("accept") )
		{
			return Command.AcceptOffer;
		}
		else if( cmd.equals("ur") ||
				 cmd.equals("updaterequest") ||
				 cmd.equals("update") )
		{
			return Command.UpdateRequest;
		}
		else if( cmd.equals("?") ||
				 cmd.equals("help") ||
				 cmd.equals("h") )
		{
			return Command.Help;
		}
		else if( cmd.equals("exit") )
		{
			return Command.Exit;
		}
		else if( cmd.equals("nc") ||
				 cmd.equals("newcustomer") )
		{
			return Command.NewCustomer;
		}
			
		throw new CommandException("Invalid command");
	}
	
}
