//
//
//
//

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
		
		ChatMessage newChatMessage = new ChatMessage(channel, sender, login, hostname, message);
		respondToMessage(newChatMessage);
	}
	
	private void respondToMessage(ChatMessage inputMessage) {
		IRCCommand userCommand = parseCommand(inputMessage.getMessage());
		switch(userCommand) {
		case NOT_COMMAND:
			break;
		case BET_BLUE:
			betBlueMessageAction(inputMessage);
			break;
		case BET_PURPLE:
			betPurpleMessageAction(inputMessage);
			break;
		case GOLD:
			goldCheckAction(inputMessage);
			break;
		case HELLO:
			helloMessageAction(inputMessage);
			break;
		}
	}
	
	private void betBlueMessageAction(ChatMessage inputMessage) {
		betAction(inputMessage, IRCCommand.BET_BLUE);
	}
	
	private void betPurpleMessageAction(ChatMessage inputMessage) {
		betAction(inputMessage, IRCCommand.BET_PURPLE);
	}
	
	private void betAction(ChatMessage inputMessage, IRCCommand command) {
		String[] splitMessage = inputMessage.getMessage().split("\\s");
		if(splitMessage.length < 2){
			throw new IllegalArgumentException(inputMessage.getSender() + "'s message did not contain a command and value, instead was " + inputMessage.getMessage());
		} else {
			Integer betValue = Integer.valueOf(splitMessage[1]);
			String team = (command == IRCCommand.BET_BLUE) ? "blue" : "purple";
			//adds new bet to any current bet, returns total (-1,-2 if error)
			Integer newBetValue = gamblerObject.saveBet(inputMessage.getSender(), team, betValue);
			if (newBetValue < 0) {
				System.out.println(inputMessage.getSender() + " was unable to place their bet.");
			} else {
				printBetMessage(inputMessage,newBetValue,command);
			}
		}
	}
	
	private void printBetMessage(ChatMessage inputMessage, int betValue, IRCCommand command) {
		
		String team = (command == IRCCommand.BET_BLUE) ? "blue" : "purple";
		sendMessage(inputMessage.getChannel(), inputMessage.getSender() + " has bet " + betValue + " gold on " + team + " team.");
	}
	
	private void goldCheckAction(ChatMessage inputMessage) {
		sendMessage(inputMessage.getChannel(), inputMessage.getSender() + " has " + gamblerObject.searchFunds(inputMessage.getSender()) + " gold.");
	}
	
	private void helloMessageAction(ChatMessage inputMessage) {
		sendMessage(inputMessage.getChannel(), "Hi " + inputMessage.getSender() + "!");
	}
	
	private IRCCommand parseCommand(String inputCommand) {
		IRCCommand returnValue = IRCCommand.NOT_COMMAND;
		
		if (inputCommand.startsWith("!betblue")) {
			returnValue = IRCCommand.BET_BLUE;
		} else if (inputCommand.startsWith("!betpurple")) {
			returnValue = IRCCommand.BET_PURPLE;
		} else if (inputCommand.startsWith("!gold")) {
			returnValue = IRCCommand.GOLD;
		} else if (inputCommand.startsWith("!hello")) {
			returnValue = IRCCommand.HELLO;
		}
		return returnValue;
	}
}

	
	


//		Check for bets
//		if (message.startsWith("!bet ") && (message.endsWith("blue") || message.endsWith("purple"))) {
//			
//			
//			try {
//				check for integer and store bet value int and team string
//				int bet = Integer.parseInt(message.split(" ")[1]);
//				String team = message.split(" ")[2];
//				save bet
//				String reply = gamblerObject.saveBet(sender, team, bet);
//				if (reply == "closed") {
//					sendMessage(channel, sender + ": Bets are closed.");
//				}
//				else if (reply == "insufficient funds") {
//					sendMessage(channel, sender + ": you do not have sufficient gold.");
//				}
//				else {
//					sendMessage(channel, sender + " has bet " + reply + " gold on " + team + ".");
//				}
//			} catch(NumberFormatException e) {
//				sendMessage(channel, "Invalid input from " + sender + ".");
//			}
//		}



