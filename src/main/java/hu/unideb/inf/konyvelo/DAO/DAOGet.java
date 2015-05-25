/**
 * 
 */
package hu.unideb.inf.konyvelo.DAO;

import hu.unideb.inf.konyvelo.MainMenu;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;
import hu.unideb.inf.konyvelo.Model.TranzakcioL;
import hu.unideb.inf.konyvelo.Model.TranzakcioT;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Osztály, amely közvetlenül elérést biztosít az adatbázis adataihoz.
 */
public class DAOGet {
	
	private static Logger	logger = LoggerFactory.getLogger(DAOGet.class);

	/**
	 * Lekéri az összes társasházat, a hozzájuk tartozó társasház tranzakciókat, lakásokat, lakásokhoz tartozó tranzakciókat.
	 * 
	 * @return a társasházak listája
	 */
	public List<Tarsashaz> getTarsashazak() {
		List<Tarsashaz> tarsashazak = new ArrayList<Tarsashaz>();
		try (Connection connection = ConnectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resoultSet = statement
					.executeQuery("SELECT TARSASHAZID, CIM, EMELETSZAM, LAKASSZAM, TARTOZAS FROM tarsashaz");
			while (resoultSet.next()) {
				Tarsashaz tarsashaz = new Tarsashaz(resoultSet.getInt(1),
						resoultSet.getString(2),resoultSet.getInt(3) ,resoultSet.getInt(4),resoultSet.getInt(5), getLakasokByTarsashazId(resoultSet.getInt(1)), getTranzakciokTByTarsashazId(resoultSet.getInt(1)));
				tarsashazak.add(tarsashaz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("Társasházak lekérdezve");
		return tarsashazak;
	}
	
	/**
	 * Lekéri az adatbázisból a társasházakat egyszerűsítve.
	 * 
	 * @return a társasházak listája
	 */
	public List<Tarsashaz> getTarsashazakEgyszeru() {
		List<Tarsashaz> tarsashazak = new ArrayList<Tarsashaz>();
		try (Connection connection = ConnectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resoultSet = statement
					.executeQuery("SELECT TARSASHAZID, CIM, EMELETSZAM, LAKASSZAM, TARTOZAS FROM tarsashaz");
			while (resoultSet.next()) {
				Tarsashaz tarsashaz = new Tarsashaz(resoultSet.getInt(1),
						resoultSet.getString(2),resoultSet.getInt(3) ,resoultSet.getInt(4),resoultSet.getInt(5),new ArrayList<Lakas>() , new ArrayList<TranzakcioT>() );
				tarsashazak.add(tarsashaz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("Társasházak lekérdezve egyszerűsítve");
		return tarsashazak;
	}
	
	/**
	 * Lekér egy társasházat az adatbázisból azonosító alapján.
	 * 
	 * @param id a társasház azonosítója
	 * @return az azonosító alapján lekért társasház
	 */
	public Tarsashaz getTarsashazByID(int id) {
		Tarsashaz tarsashaz = new Tarsashaz();
		try (Connection connection = ConnectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resoultSet = statement
					.executeQuery("SELECT TARSASHAZID, CIM, EMELETSZAM, LAKASSZAM, TARTOZAS FROM tarsashaz WHERE TARSASHAZID="+id);
			while (resoultSet.next()) {
				tarsashaz = new Tarsashaz(resoultSet.getInt(1),
						resoultSet.getString(2),resoultSet.getInt(3) ,resoultSet.getInt(4),resoultSet.getInt(5), new ArrayList<Lakas>(), new ArrayList<TranzakcioT>());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("Társasházak lekérdezve id alapján");
		return tarsashaz;
	}

	/**
	 * Lekéri az adatbázisból a lakásokat és a hozzájuk tartozó lakás tranzakciókat.
	 * 
	 * @return a lakások listája
	 */
	public List<Lakas> getLakasok() {
		List<Lakas> lakasok = new ArrayList<Lakas>();
		try (Connection connection = ConnectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resoultSet = statement
					.executeQuery("SELECT * FROM lakas");
			while (resoultSet.next()) {
				Lakas lakas = new Lakas(resoultSet.getInt(1),
						resoultSet.getString(2), resoultSet.getInt(3),
						resoultSet.getInt(4), resoultSet.getInt(5),
						resoultSet.getInt(6)
						, getTranzakciokLByLakasId(resoultSet.getInt(1)));
				lakasok.add(lakas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("Lakások lekérdezve");
		return lakasok;
	}
	
	/**
	 * Lekéri az adatbázisból a lakások listáját egyszerűsítve.
	 * 
	 * @return a lakások listája
	 */
	public List<Lakas> getLakasokEgyszeru() {
		List<Lakas> lakasok = new ArrayList<Lakas>();
		try (Connection connection = ConnectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resoultSet = statement
					.executeQuery("SELECT * FROM lakas");
			while (resoultSet.next()) {
				Lakas lakas = new Lakas(resoultSet.getInt(1),
						resoultSet.getString(2), resoultSet.getInt(3),
						resoultSet.getInt(4), resoultSet.getInt(5),
						resoultSet.getInt(6)
						, new ArrayList<TranzakcioL>());
				lakasok.add(lakas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("Lakások lekérdezve egyszerűsítve");
		return lakasok;
	}
	
	/**
	 * Lekéri az adatbázisból a lakások listáját, melyek társasház azonosítója megyegyezik a paraméterül kapott azonosítóval.
	 * 
	 * @param id a társasház azonosítója
	 * @return a társasházhoz tartozó lakások listája
	 */
	public List<Lakas> getLakasokByTarsashazId(int id) {
		List<Lakas> lakasok = new ArrayList<Lakas>();
		try (Connection connection = ConnectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resoultSet = statement
					.executeQuery("SELECT * FROM lakas WHERE TARSASHAZID="+id);
			while (resoultSet.next()) {
				Lakas lakas = new Lakas(resoultSet.getInt(1),
						resoultSet.getString(2), resoultSet.getInt(3),
						resoultSet.getInt(4), resoultSet.getInt(5),
						resoultSet.getInt(6)
						, new ArrayList<TranzakcioL>());
				lakasok.add(lakas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("Lakások lekérdezve társasház alapján");
		return lakasok;
	}
	
	/**
	 * Lekér egy lakást az adatbázisból a paraméterül kapott azonosító alapján.
	 * 
	 * @param id a lakás azonosítója
	 * @return a paraméterül kapott azonosítójú lakás
	 */
	public Lakas getLakasokById(int id) {
		Lakas lakas = new Lakas();
		try (Connection connection = ConnectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resoultSet = statement
					.executeQuery("SELECT * FROM lakas WHERE LAKASID="+id);
			while (resoultSet.next()) {
				lakas = new Lakas(resoultSet.getInt(1),
						resoultSet.getString(2), resoultSet.getInt(3),
						resoultSet.getInt(4), resoultSet.getInt(5),
						resoultSet.getInt(6)
						, new ArrayList<TranzakcioL>());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("Lakás lekérdezve id alapján");
		return lakas;
	}


	/**
	 * Lekéri az adatbázisból a lakás tranzakciók listáját.
	 * 
	 * @return a lakás tranzakciók listája
	 */
	public List<TranzakcioL> getTranzakciokL() {
		List<TranzakcioL> tranzakciok = new ArrayList<TranzakcioL>();
		try (Connection connection = ConnectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM tranzakcioL");
			while (resultSet.next()) {
				TranzakcioL tranzakcio = new TranzakcioL(resultSet.getInt(1),
						resultSet.getInt(2), resultSet.getInt(3),
						new DateTime(resultSet.getDate(4)),
						resultSet.getString(5), resultSet.getString(6));
				tranzakciok.add(tranzakcio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("TranzakcióL lekérdezve");
		return tranzakciok;
	}
	
	/**
	 * Lekéri az adatbázisból a lakás tranzakciók listáját, melyek a paraméterül kapott lakáshoz tartoznak.
	 * 
	 * @param id a lakás azonosítója
	 * @return a lakáshoz tartozó tranzakciók listája
	 */
	public List<TranzakcioL> getTranzakciokLByLakasId(int id){
		List<TranzakcioL> tranzakciok=new ArrayList<TranzakcioL>();
		try(Connection connection=ConnectionFactory.getConnection()){
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM TRANZAKCIOL WHERE LAKASID="+id);
			while(resultSet.next()){
				TranzakcioL tranzakcio = new TranzakcioL(resultSet.getInt(1),
						resultSet.getInt(2), resultSet.getInt(3),
						new DateTime(resultSet.getDate(4)),
						resultSet.getString(5), resultSet.getString(6));
				tranzakciok.add(tranzakcio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("TranzakcióL lekérdezve lakás szerint");
		return tranzakciok;
		
	}
	
	/**
	 * Lekér egy lakás tranzakciót az azonosítója alapján az adatbázisból.
	 * 
	 * @param id a lakás tranzakció azonosítója
	 * @return a paraméterül kapott azonosítóval rendelkező lakás tranzakció
	 */
	public TranzakcioL getTranzakciokLByTranzakcioID(int id){
		TranzakcioL tranzakcio=new TranzakcioL();
		try(Connection connection=ConnectionFactory.getConnection()){
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM TRANZAKCIOL WHERE TRANZAKCIOLID="+id);
			while(resultSet.next()){
				tranzakcio = new TranzakcioL(resultSet.getInt(1),
						resultSet.getInt(2), resultSet.getInt(3),
						new DateTime(resultSet.getDate(4)),
						resultSet.getString(5), resultSet.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("TranzakcióL lekérdezve id szerint");
		return tranzakcio;
		
	}

	/**
	 * Lekéri az adatbázisból a társasház tranzakciók listáját.
	 * 
	 * @return a társasház tranzakciók listája
	 */
	public List<TranzakcioT> getTranzakciokT() {
		List<TranzakcioT> tranzakciok = new ArrayList<TranzakcioT>();
		try (Connection connection = ConnectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resoultSet = statement
					.executeQuery("SELECT * FROM tranzakcioT");
			while (resoultSet.next()) {
				TranzakcioT tranzakcio = new TranzakcioT(resoultSet.getInt(1),
						resoultSet.getInt(2), resoultSet.getInt(3),
						new DateTime(resoultSet.getDate(4)),
						resoultSet.getString(5), resoultSet.getString(6));
				tranzakciok.add(tranzakcio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("TranzakcióT lekérdezve");
		return tranzakciok;
	}
	
	/**
	 * Lekéri az adatbázisból a társasház tranzakciók listáját, melyek a paraméterül kapott társasházhoz tartoznak.
	 * 
	 * @param id a társasház azonosítója
	 * @return a társasházhoz tartozó tranzakciók listája
	 */
	public List<TranzakcioT> getTranzakciokTByTarsashazId(int id) {
		List<TranzakcioT> tranzakciok = new ArrayList<TranzakcioT>();
		try (Connection connection = ConnectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resoultSet = statement
					.executeQuery("SELECT * FROM tranzakcioT WHERE TARSASHAZID="+id);
			while (resoultSet.next()) {
				TranzakcioT tranzakcio = new TranzakcioT(resoultSet.getInt(1),
						resoultSet.getInt(2), resoultSet.getInt(3),
						new DateTime(resoultSet.getDate(4)),
						resoultSet.getString(5), resoultSet.getString(6));
				tranzakciok.add(tranzakcio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("TranzakcióT lekérdezve társasház alapján");
		return tranzakciok;
	}
	
	/**
	 * Lekér egy társasház tranzakciót az azonosítója alapján az adatbázisból.
	 * 
	 * @param id a társasház tranzakció azonosítója
	 * @return a paraméterül kapott azonosítóval rendelkező társasház tranzakció
	 */
	public TranzakcioT getTranzakciokTByTranzakcioID(int id) {
		TranzakcioT tranzakcio = new TranzakcioT();
		try (Connection connection = ConnectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resoultSet = statement
					.executeQuery("SELECT * FROM tranzakcioT WHERE TRANZAKCIOTID="+id);
			while (resoultSet.next()) {
						tranzakcio = new TranzakcioT(resoultSet.getInt(1),
						resoultSet.getInt(2), resoultSet.getInt(3),
						new DateTime(resoultSet.getDate(4)),
						resoultSet.getString(5), resoultSet.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("TranzakcióT lekérdezve id alapján");
		return tranzakcio;
	}
}
