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
	
	public String getChannel() {
		return channel;
	}
	
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	public String getSender() {
		return sender;
	}
	
	public void setSender(String sender) {
		this.sender = sender.substring(0, 1).toUpperCase() + sender.substring(1);
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getHostname() {
		return hostname;
	}
	
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
