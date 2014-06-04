
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
				if (gamblerObject.saveBet(sender, team, bet)) {
					//returns true if sufficient funds
					sendMessage(channel, sender + " has bet " + bet + " gold on " + team + ".");
				}
				else {
					sendMessage(channel, sender + " has insufficient gold.");
				}
				
			} catch(NumberFormatException e) {
				sendMessage(channel, "Invalid input from " + sender + ".");
			}
		}
		
		//Check funds
		if (message.equalsIgnoreCase("!gold")) {
			sendMessage(channel, sender + " has " + gamblerObject.checkFunds(sender) + " gold.");
		}
	}
	

}


