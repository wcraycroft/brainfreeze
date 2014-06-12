//
//
//
//

public class ChatMessage {
		
	private String channel, sender, login, hostname, message;
	
	public ChatMessage(String channel, String sender, String login, String hostname, String message) {
		setChannel(channel);
		setSender(sender);
		setLogin(login);
		setHostname(hostname);
		setMessage(message);
	}
	
	//Getters
	public String getChannel() {
		return channel;
	}
	
	public String getSender() {
		return sender;
	}
	
	public String getLogin() {
		return login;
	}

	public String getHostname() {
		return hostname;
	}

	public String getMessage() {
		return message;
	}
	
	//Setters
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	public void setSender(String sender) {
		this.sender = sender.substring(0, 1).toUpperCase() + sender.substring(1);
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
