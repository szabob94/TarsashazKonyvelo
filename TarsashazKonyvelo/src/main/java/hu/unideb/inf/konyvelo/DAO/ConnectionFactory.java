/**
 * 
 */
package hu.unideb.inf.konyvelo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Bence
 *
 */
public class ConnectionFactory {
	
	private static ConnectionFactory factory = new ConnectionFactory();
	
	static final String DB_URL="";
	static final String DB_USER="";
	static final String DB_PASS="";
	
	private ConnectionFactory(){
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		} catch (SQLException e) {
			System.out.println("Baj van");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	private Connection createConnection(){
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;	
	}
	
	public static Connection getConnection(){
		return factory.createConnection();
	}

}
