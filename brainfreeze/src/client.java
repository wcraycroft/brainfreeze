
import java.util.*;
import java.io.*;
// import java.lang.*;

public class client {
	
	public Boolean betsOff = false;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String server = "irc.twitch.tv";
		String username = "brzbot";
		String password = "oauth:ss2hlvp1gtg6nui42xmbcobn27kt8sy";
		String channel = "#bronzebets";
		int port = 6667;
		
		//start IRCBot
		IRCBot bot = new IRCBot(username);
		 
		try {
			bot.setVerbose(true);
			bot.connect(server, port, password);
			bot.joinChannel(channel);
			}
		catch (Exception e){
			e.printStackTrace();
			}
		
		//MySQLAccess test = new MySQLAccess();
		
		//input gameID and run
		System.out.println("Enter game ID: ");
		String gameID = input.nextLine();
		SpecClient specClientObject = new SpecClient();
		specClientObject.launchClient(gameID);
		
		
	} 
}
	