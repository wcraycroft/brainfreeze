import java.io.File;


public class SpecClient {
		
	public void launchClient(String gameID) {
		//PH
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
