/**
 * 
 */
package hu.unideb.inf.konyvelo.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.unideb.inf.konyvelo.MainMenu;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;
import hu.unideb.inf.konyvelo.Model.TranzakcioL;
import hu.unideb.inf.konyvelo.Model.TranzakcioT;

/**
 * Osztály, mely közvetlenül csatlakozik az adatbázihoz, és adatokkat szúr be a táblákba.
 *
 */
public class DAOInsert {
	
	private static Logger	logger = LoggerFactory.getLogger(DAOInsert.class);

	/**
	 * Beszúr a paraméterül kapott társasházat a TARSASHAZ táblába.
	 * 
	 * @param tarsashaz a beszúrandó társasház
	 */
	public void insertTarsashaz(Tarsashaz tarsashaz) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO TARSASHAZ (TARSASHAZID, CIM,EMELETSZAM,LAKASSZAM, TARTOZAS) VALUES(?,?,?,?,?)");
			preparedStatement.setInt(1, tarsashaz.getId());
			preparedStatement.setString(2, tarsashaz.getCim());
			preparedStatement.setInt(3, tarsashaz.getEmeletszam());
			preparedStatement.setInt(4, tarsashaz.getLakasszam());
			preparedStatement.setInt(5, tarsashaz.getTartozas());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("Társasház feltöltés");
	}

	/**
	 * Beszúr a paraméterül kapott lakást a LAKAS táblába.
	 * 
	 * @param lakas a beszúrandó lakás
	 */
	public void insertLakas(Lakas lakas) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO LAKAS (LAKASID, TULAJDONOS, TARSASHAZID, EMELET, AJTO, TARTOZAS)"
							+ " VALUES(?,?,?,?,?,?)");
			preparedStatement.setInt(1, lakas.getId());
			preparedStatement.setString(2, lakas.getTulajdonos());
			preparedStatement.setInt(3, lakas.getTarsashazID());
			preparedStatement.setInt(4, lakas.getEmelet());
			preparedStatement.setInt(5, lakas.getAjto());
			preparedStatement.setInt(6, lakas.getTartozas());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("Lakás feltöltés");
	}

	/**
	 * Beszúrja a paraméterül kapott lakás tranzakciót a TRANZAKCIOL táblába.
	 * 
	 * @param tranzakcioL a beszúrandó lakás tranzakció
	 */
	public void insertTranzakcioL(TranzakcioL tranzakcioL) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO TRANZAKCIOL (TRANZAKCIOLID, LAKASID, OSSZEG, DATUM, LEIRAS, BEFIZETO) "
							+ "VALUES(?,?,?,?,?,?)");
			preparedStatement.setInt(1, tranzakcioL.getTranzakcioLID());
			preparedStatement.setInt(2, tranzakcioL.getLakasID());
			preparedStatement.setInt(3, tranzakcioL.getOsszeg());
			preparedStatement.setDate(4, new Date(tranzakcioL.getDatum()
					.getMillis()));
			preparedStatement.setString(5, tranzakcioL.getLeiras());
			preparedStatement.setString(6, tranzakcioL.getBefizeto());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("TranzakcióL feltöltés");
	}

	/**
	 * Beszúrja a paraméterül kapott társasház tranzakciót a TRANZAKCIOT táblába.
	 * 
	 * @param tranzakcioT a beszúrandó társasház tranzakció
	 */
	public void insertTranzakcioT(TranzakcioT tranzakcioT) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO TRANZAKCIOT (TRANZAKCIOTID, TARSASHAZID, OSSZEG, DATUM, LEIRAS, KIIRO) "
							+ "VALUES(?,?,?,?,?,?)");
			preparedStatement.setInt(1, tranzakcioT.getTranzakcioTID());
			preparedStatement.setInt(2, tranzakcioT.getTarsashazID());
			preparedStatement.setInt(3, tranzakcioT.getOsszeg());
			preparedStatement.setDate(4, new Date(tranzakcioT.getDatum()
					.getMillis()));
			preparedStatement.setString(5, tranzakcioT.getLeiras());
			preparedStatement.setString(6, tranzakcioT.getKiiro());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("TranzakcióT feltöltése");
	}
}
