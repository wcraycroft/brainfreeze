//no need to rewrite any of this for now
//shit's a mess and it doesn't work(SHOCKER I KNOW!!)
//gonna rewrite it all and give MySQL a go
//

import java.io.*;
import java.util.*;

public class gambler {
	
	private static int startingGold = 500;
	private Scanner sc;
	private FileWriter fw;
	private PrintWriter pw;
	
	client clientObject = new client ();
	
	public void openFile() {
		try {
			sc = new Scanner(new File("data.txt"));
			fw = new FileWriter("data.txt");
			pw = new PrintWriter(fw);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void closeFile() {
		pw.close();
	}
	
//	Checks if user exists. If false creates user with 500 gold.
//	public void userExists(String sender) {
//		String name = "";
//		String funds = "";
//		String bet = "";
//		while(sc.hasNext() && name != sender) {
//			name = sc.next();
//			funds = sc.next();
//			bet = sc.next();
//		}
//		if (name != sender) {
//			funds = "500";
//			f.format("%s%s%s", sender + " ", funds + " ", "0");
//		}
//	}
	
	
	//Returns funds based on sender. If user doesn't exist, creates one with 500 gold.
	public int searchFunds(String sender) {
		
		openFile();
		String name = "";
		String funds = "";
		String bet = "";
		while(sc.hasNext() && name != sender) {
			name = sc.next();
			funds = sc.next();
			bet = sc.next();
		}
		if (name != sender) {
			funds = Integer.toString(startingGold);
			pw.println(sender + " " + funds + " " + "0");
		}
		closeFile();
		return 499;
	}
	
	//Places bet, positive for blue, negative for purple
	public String placeBet(String sender, String team, int newBet) {
		openFile();
		String name = "";
		String funds = "";
		String bet = "";
		while(sc.hasNext() && name != sender) {
			name = sc.next();
			funds = sc.next();
			bet = sc.next();
		}
		if (team == "purple") {
			//turn bet negative for purple
			newBet -= 2 * newBet;
		}
		int finalBet  = Integer.parseInt(bet) + newBet;
		//Update file (to do)
		
		closeFile();
		return Integer.toString(finalBet);
	}
	
	
	
	//Find user, check funds, place bet, returns new bet value (-1 for error)
	public Integer saveBet (String sender, String team, int bet) {
		if (clientObject.betsOff) {
			return -1;
		}
		int funds = searchFunds(sender);
		if (funds >= bet) {
			String newBet = placeBet(sender, team, bet);
			//return Integer.parseInt(newBet);
			return bet;
		}
		else {
			return -1;
		}
	}
	

	//Find bets, change funds
	public void closeBets (String team) {
		
	}
}
