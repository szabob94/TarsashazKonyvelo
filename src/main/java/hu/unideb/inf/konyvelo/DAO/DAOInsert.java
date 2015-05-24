/**
 * 
 */
package hu.unideb.inf.konyvelo.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;
import hu.unideb.inf.konyvelo.Model.TranzakcioL;
import hu.unideb.inf.konyvelo.Model.TranzakcioT;

/**
 * @author Bence
 *
 */
public class DAOInsert {

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
	}

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
	}

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
	}

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
	}
}
