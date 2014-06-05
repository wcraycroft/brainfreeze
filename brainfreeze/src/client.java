import java.util.*;
import java.io.*;
// import java.lang.*;

public class client {
	
	public Boolean betsOff = false;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String server = "irc.twitch.tv";
		String username = "brzbot";
		String password = "not real pw";
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
		
		//Create data file if none exists
		File data = new File("C:\\Users\\Will\\workspace\\brainfreeze\\data.txt");
		if(data.exists()) {
			System.out.println(data.getName() + " was found.");
		}
		else {
			final Formatter f;
			try {
				f = new Formatter("data.txt");
				System.out.println("Cannot find data file. New File created.");
			} 
			catch(Exception e) {
				System.out.println("Error creating file.");
			}
					
		}
		
		//System.out.println("Working Directory = " + System.getProperty("user.dir"));
		
		//input gameID and run
		String gameID = input.nextLine();
		launchClient(gameID);
		
	}
	
	public static void launchClient(String gameID) {
		
	try{
			
			ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\League of Legends\\League of Legends\\RADS\\solutions\\lol_game_client_sln\\releases\\0.0.1.41\\deploy\\League of Legends.exe",
					"8394", "LoLLauncher.exe", " ", "spectator 216.133.234.17:8088 1XjjK3vqce3MxBKy1IdPRfz+fdubDMse 1407284402 NA1");
			pb.directory(new File("C:\\Program Files (x86)\\League of Legends\\League of Legends\\RADS\\solutions\\lol_game_client_sln\\releases\\0.0.1.41\\deploy"));
			Process process = pb.start();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}



//    \\RADS\\solutions\\lol_game_client_sln\\releases\\0.0.1.41\\deploy"
		
//	try{
//			
//			String[] cmdArray = new String[5];
//			cmdArray[0] = "C:\\Program Files (x86)\\League of Legends\\League of Legends\\RADS\\solutions\\lol_game_client_sln\\releases\\0.0.1.41\\deploy\\League of Legends.exe";
//			cmdArray[1] = "8394";
//			cmdArray[2] = "C:\\Program Files (x86)\\League of Legends\\League of Legends\\LoLLauncher.exe";
//			cmdArray[3] = " ";
//			cmdArray[4] = "spectator 216.133.234.17:8088 6SLtNSdBWCYsieVaXeJprQPRbdmSJ35N 1407231856 NA1";
//			
//			System.out.println("Launching client...");
//			
//			Process process = Runtime.getRuntime().exec(cmdArray,null);
//			
//			System.out.println("Launcher should now open.");
//			
//		} catch (Exception ex)  {
//			ex.printStackTrace(); }
	



// These are all attempts to launch the league client with specific parameters
// Both are able to launch the exe but it isn't reading the parameters for some reason
		
		
//		try{
//			Process process = new ProcessBuilder("C:\\Program Files (x86)\\League of Legends\\League of Legends\\RADS\\solutions\\lol_game_client_sln\\releases\\0.0.1.41\\deploy\\League of Legends.exe"
//					, "8394", "LoLLauncher.exe", "", "spectator 216.133.234.17:8088 7/oW8/eYz7r8RWrgp2tsmHPNTAlfdk1h 1406755792 NA1").start();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
		
		

	
		
		
		
//		try {
//		    // Execute command
//		    String command = "cmd /c start cmd.exe";
//		    Process child = Runtime.getRuntime().exec(command);
//
//		    // Get output stream to write from it
//		    OutputStream out = child.getOutputStream();
//
//		    out.write("cd C:/ /r/n".getBytes());
//		    out.flush();
//		    out.write("dir /r/n".getBytes());
//		    out.close();
//		} catch (IOException e) {
//		} 
		
		