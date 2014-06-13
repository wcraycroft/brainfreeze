import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLAccess {

	private static int startingGold = 500;
	private static int startingBet = 0;
	private String url = "jdbc:mysql://localhost:3306/gamblerdb?allowMultiQueries=true";
    private String user = "testuser";
    private String password = "test623";
    
    //Returns gold and bet in int[]
    public int[] GetPlayerData(String name) {
    	Connection con = null;
    	PreparedStatement pst = null;
    	ResultSet rs = null;
    	int[] r = {0, 0};
    	boolean exist = false;
    	
    	try {
    		con = DriverManager.getConnection(url, user, password);
    		pst = con.prepareStatement("SELECT * FROM Players WHERE Name = ?");
    		pst.setString(1, name);
    		rs = pst.executeQuery();
    		exist = rs.next();
    		//Check if player exists
    		if (!exist) {
    			SetNewPlayerData(name);
    			r[0] = 500;
    			r[1] = 0;
    			System.out.println("New player " + Integer.toString(r[0]) + " " + Integer.toString(r[1]));
    			return r;
    		} else {
    			r[0] = rs.getInt("Gold");
    			r[1] = rs.getInt("Bet");
    			System.out.println(name + " " + Integer.toString(r[0]) + " " + Integer.toString(r[1]));
    			return r;
    		}
    			
    		
    	} catch (SQLException ex) {
    		Logger lgr = Logger.getLogger(MySQLAccess.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            return null;
    	}
    	//close
    	finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(MySQLAccess.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
    
    //Creates new entry with 500, 0
    public void SetNewPlayerData (String name) {
    	Connection con = null;
    	PreparedStatement pst = null;
    	
    	try {
    		con = DriverManager.getConnection(url, user, password);    				
    		pst = con.prepareStatement("INSERT INTO Players(Id, Name, Gold, Bet) VALUES(default, ?, ?, ?)");
    		pst.setString(1, name);
    		pst.setInt(2, startingGold);
    		pst.setInt(3, startingBet);
    		pst.executeUpdate();
    		
    	} catch (SQLException ex) {
    		Logger lgr = Logger.getLogger(MySQLAccess.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
    	}
    	//close
    	finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(MySQLAccess.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
    
    //Updates Bet
    public void SetPlayerBet(String name, Integer bet) {
    	Connection con = null;
    	PreparedStatement pst = null;
    	
    	try {
    		con = DriverManager.getConnection(url, user, password);    				
    		pst = con.prepareStatement("UPDATE Players set Bet = ? where name = ?");
    		pst.setInt(1, bet);
    		pst.setString(2, name);
    		pst.executeUpdate();
    		
    	} catch (SQLException ex) {
    		Logger lgr = Logger.getLogger(MySQLAccess.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
    	}
    	//close
    	finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(MySQLAccess.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
    //Update Gold
    public void SetPlayerGold(String name, Integer gold, Integer bet) {
    	Connection con = null;
    	PreparedStatement pst = null;
    	
        try {
    		String player = name;
    		con = DriverManager.getConnection(url, user, password);    				
    		pst = con.prepareStatement("UPDATE Players set Gold = ? where name = ?");
    		pst.setInt(1, gold);
    		pst.setString(2, name);
    		pst.executeUpdate();
    		
    	} catch (SQLException ex) {
    		Logger lgr = Logger.getLogger(MySQLAccess.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
    	}
    	//close
    	finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(MySQLAccess.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
    
	public void prepTest() {
		Connection con = null;
		PreparedStatement pst = null;
		
        

        try {

            String player = "bronzebets";
            con = DriverManager.getConnection(url, user, password);

            pst = con.prepareStatement("INSERT INTO Players(Name) VALUES(?)");
            pst.setString(1, player);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(MySQLAccess.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(MySQLAccess.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
	
}	
	
	
	
	
	
	
	
//	public void MySQLTest() {
//	
//	Connection con = null;
//	Statement st = null;
//    ResultSet rs = null;
//
//    String url = "jdbc:mysql://localhost:3306/gamblerdb";
//    String user = "testuser";
//    String password = "test623";
//
//    try {
//        con = DriverManager.getConnection(url, user, password);
//        st = con.createStatement();
//        rs = st.executeQuery("SELECT VERSION()");
//
//        if (rs.next()) {
//            System.out.println(rs.getString(1));
//        }
//
//    } catch (SQLException ex) {
//        Logger lgr = Logger.getLogger(MySQLAccess.class.getName());
//        lgr.log(Level.SEVERE, ex.getMessage(), ex);
//
//    } finally {
//        try {
//            if (rs != null) {
//                rs.close();
//            }
//            if (st != null) {
//                st.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//
//        } catch (SQLException ex) {
//            Logger lgr = Logger.getLogger(MySQLAccess.class.getName());
//            lgr.log(Level.WARNING, ex.getMessage(), ex);
//        }
//      }
//    }
//}
