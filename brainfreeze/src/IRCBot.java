
import org.jibble.pircbot.*;

public class IRCBot extends PircBot {

	//Constructor
	public IRCBot(String name){
		setName(name);
		setLogin(name);
	}
	
	client clientObject = new client ();
	gambler gamblerObject = new gambler ();
	
	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		
		//Capitalize first letter of sender
		sender = sender.substring(0, 1).toUpperCase() + sender.substring(1);
		
		//Hello!
		if (message.equalsIgnoreCase("!hello")) {
			sendMessage(channel, "Hello " + sender + "!");
		}
		
		//Check for bets
		if (message.startsWith("!bet ") && (message.endsWith("blue") || message.endsWith("purple"))) {
			
			
			try {
				//check for integer and store bet value (int) and team (string)
				int bet = Integer.parseInt(message.split(" ")[1]);
				String team = message.split(" ")[2];
				//save bet
				String reply = gamblerObject.saveBet(sender, team, bet);
				if (reply == "closed") 
					sendMessage(channel, sender + ": Bets are closed.");
				else if (reply == "insufficient funds") 
					sendMessage(channel, sender + ": you do not have sufficient gold.");
				else 
					sendMessage(channel, sender + " has bet " + reply + " gold on " + team + ".");
				
			} catch(NumberFormatException e) {
				sendMessage(channel, "Invalid input from " + sender + ".");
			}
		}
		
		//Check funds
		if (message.equalsIgnoreCase("!gold")) {
			sendMessage(channel, sender + " has " + gamblerObject.searchFunds(sender) + " gold.");
		}
	}
	

}


