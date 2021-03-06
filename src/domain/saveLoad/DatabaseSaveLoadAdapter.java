package domain.saveLoad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseSaveLoadAdapter {

	private static String url = "jdbc:postgresql://localhost:5432/needforspear";
	private static String user = "postgres";
	private static String password = "asd123";

	private DatabaseSaveLoadAdapter() {}

	public static void addUser(String u, String p){
		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			st.executeUpdate("CREATE TABLE IF NOT EXISTS users (username varchar(255), password varchar(255));");
			st.executeUpdate("INSERT INTO users (username, password) VALUES ('"+u+"', '"+p+"' )" );
			//st.executeQuery("CREATE TABLE IF NOT EXISTS users (username varchar(255), password varchar(255));");
			/*ResultSet rs = st.executeQuery("SELECT * FROM users");
			if(rs.next()) {
				System.out.println(rs.getString(1));
			}*/

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseSaveLoadAdapter.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static boolean userExist(String u, String p) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("SELECT username, password FROM users WHERE username = '"+u+"' AND password = '" + p +"';");
			if(rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseSaveLoadAdapter.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean usernameExist(String u) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("SELECT username FROM users WHERE username = '"+u+"';");
			if(rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DatabaseSaveLoadAdapter.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}

