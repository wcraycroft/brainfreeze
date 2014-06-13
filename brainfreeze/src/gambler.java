import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class gambler {
	
	client clientObject = new client();
	MySQLAccess MySQLObject = new MySQLAccess();

	//Returns funds based on sender. If user doesn't exist, creates one with 500 gold.
	public int searchFunds(String sender) {
		try {
		int playerData[] = MySQLObject.GetPlayerData(sender);
		Integer gold = playerData[0];
		return gold;
		} catch (Exception ex) {
    		Logger lgr = Logger.getLogger(MySQLAccess.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            return 0;
		}
	}
	
	//Find user, check funds, update bet, returns new abs bet value
	public Integer saveBet (String sender, String team, int bet) {
		if (clientObject.betsOff) {
			//Bets off error
			return -1;
		}
		int playerData[] = MySQLObject.GetPlayerData(sender);
		Integer gold = playerData[0];
		Integer oldBet = playerData[1];
		//positive bet for blue, negative for purple, make sure to return abs
		Integer newBet = ((team == "blue") ? bet : -bet) + oldBet;
		if (gold >= Math.abs(newBet)) {
			MySQLObject.SetPlayerBet(sender, newBet);
			return Math.abs(newBet);
		}
		else {
			//insufficient funds error
			return -2;
		}
	}

	//Find bets, change funds
	public void closeBets (String team) {
		MySQLObject.CloseBets(team);
	}
}

