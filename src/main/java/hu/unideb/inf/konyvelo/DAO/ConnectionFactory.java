/**
 * 
 */
package hu.unideb.inf.konyvelo.DAO;

import hu.unideb.inf.konyvelo.MainMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Osztály, amely felépíti a kapcsolatot az adatbázissal.
 */
public class ConnectionFactory {
	
	/**
	 * A kapcsolat felépítő saját példánya magáról.
	 */
	private static ConnectionFactory factory = new ConnectionFactory();
	private static Logger	logger = LoggerFactory.getLogger(ConnectionFactory.class);
	
	/**
	 * Az adatbázis URL-je.
	 */
	static final String DB_URL="";
	
	/**
	 * Az adatbáziskapcsolathoz használt felhasznál név.
	 */
	static final String DB_USER="";
	
	/**
	 * Az adatbáziskapcsolathoz használt jelszó.
	 */
	static final String DB_PASS="";
	
	/**
	 * A kapcsolat felépítő konstruktora, amely regisztrálja az adatbázis vezérlőt.
	 */
	private ConnectionFactory(){
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		} catch (SQLException e) {
			System.out.println("Baj van");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * A regisztrált kapcsolatot hozza létre, majd visszaadja azt.
	 * 
	 * @return a regisztrált kapcsolat
	 */
	private Connection createConnection(){
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;	
	}
	
	/**
	 * A kapcsolatfelépítő példányát adja visszatérési értékül.
	 * 
	 * @return a kapcsolatfelépítő példánya
	 */
	public static Connection getConnection(){
		logger.debug("Kapcsolat létrejött");
		return factory.createConnection();
	}

}
