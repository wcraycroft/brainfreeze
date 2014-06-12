import java.io.File;
import java.io.IOException;
import java.util.*;




public class SpecClient {
		
	public void launchClient(String gameID) {
		
		File base = new File("C:\\Program Files (x86)\\League of Legends\\League of Legends\\");
        File lol = findMostRecent(base, "League of Legends.exe", "lol_game_client");
        File air = findMostRecent(base, "LolClient.exe");
        
        String lolPath = lol.getAbsolutePath();
        String airPath = air.getAbsolutePath();
        final String GAME_DIR_PARAM = lolPath.substring(0, lolPath.lastIndexOf(File.separator));
        final String AIR_EXE_PARAM = air.getAbsolutePath();
        final String AIR_DIR_PARAM = airPath.substring(0, airPath.lastIndexOf(File.separator));
        //final String AIR_IMAGES_PARAM = airPath.substring(0, airPath.lastIndexOf(File.separator)) + "\\assets\\images\\";
        //final String AIR_CHAMPION_IMAGES_PARAM = airPath.substring(0, airPath.lastIndexOf(File.separator)) + "\\assets\\images\\champions\\";
        
        String[] cmd = new String[] {
                GAME_DIR_PARAM + File.separator + "League of Legends.exe",
                "8394",
                "LoLLauncher.exe",
                AIR_EXE_PARAM,
                gameID };
        File dir = new File(GAME_DIR_PARAM); 
        
        try {
            // Run (consume output)
            Process game = Runtime.getRuntime().exec(cmd, null, dir);
            new StreamGobbler(game.getInputStream());
            new StreamGobbler(game.getErrorStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
		
	
	public static File findMostRecent(File base, String name) {
        return findMostRecent(base, name, null);
    }
	
	public static File findMostRecent(File base, String name, String ignore) {
        if (base.isFile()) {
            if (base.getName().matches(name))
                return base;
            else
                return null;
        }

        if (base.getName().equals(ignore))
            return null;

        File[] contents = base.listFiles();
        File mostRecent = null;
        for (File f : contents) {
            File result = findMostRecent(f, name, ignore);
            if (result == null)
                continue;

            if (mostRecent == null)
                mostRecent = result;
            else if (mostRecent.lastModified() < result.lastModified())
                mostRecent = result;
        }

        return mostRecent;
    }
}
	