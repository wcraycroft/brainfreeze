
public class client {
	
	public Boolean gameRunning = false;
	
	public static void main(String[] args) {
		
		String server = "irc.twitch.tv";
		String username = "brzbot";
		String password = "not my real pw";
		String channel = "#bronzebets";
		int port = 6667;
		
		IRCBot bot = new IRCBot(username);
		
		try {
			bot.setVerbose(true);
			bot.connect(server, port, password);
			bot.joinChannel(channel);
			}
		catch (Exception e){
			e.printStackTrace();
			}
	
	}
	
}
