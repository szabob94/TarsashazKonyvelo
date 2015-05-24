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
public class DAOUpdate {

	public void updateTarsashaz(Tarsashaz tarsashaz) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE TARSASHAZ SET CIM = ?, TARTOZAS = ?, EMELETSZAM = ?, LAKASSZAM = ? WHERE TARSASHAZID = ?");
			preparedStatement.setString(1, tarsashaz.getCim());
			preparedStatement.setInt(2, tarsashaz.getTartozas());
			preparedStatement.setInt(3, tarsashaz.getEmeletszam());
			preparedStatement.setInt(4, tarsashaz.getLakasszam());
			preparedStatement.setInt(5, tarsashaz.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateLakas(Lakas lakas) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE LAKAS SET TULAJDONOS = ?, EMELET = ?, AJTO = ?, TARTOZAS = ?"
							+ " WHERE LAKASID = ?");
			preparedStatement.setString(1, lakas.getTulajdonos());
			preparedStatement.setInt(2, lakas.getEmelet());
			preparedStatement.setInt(3, lakas.getAjto());
			preparedStatement.setInt(4, lakas.getTartozas());
			preparedStatement.setInt(5, lakas.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateTranzakcioL(TranzakcioL tranzakcioL) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE TRANZAKCIOL SET LAKASID = ?, OSSZEG = ?, DATUM = ?, LEIRAS = ?, BEFIZETO = ?"
							+ " WHERE TRANZAKCIOLID = ?");
			preparedStatement.setInt(1, tranzakcioL.getLakasID());
			preparedStatement.setInt(2, tranzakcioL.getOsszeg());
			preparedStatement.setDate(3, new Date(tranzakcioL.getDatum()
					.getMillis()));
			preparedStatement.setString(4, tranzakcioL.getLeiras());
			preparedStatement.setString(5, tranzakcioL.getBefizeto());
			preparedStatement.setInt(6, tranzakcioL.getTranzakcioLID());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateTranzakcioT(TranzakcioT tranzakcioT) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE TRANZAKCIOT SET TARSASHAZID = ?, OSSZEG = ?, DATUM = ?, LEIRAS = ?, KIIRO = ?"
							+ " WHERE TRANZAKCIOTID = ?");
			preparedStatement.setInt(1, tranzakcioT.getTarsashazID());
			preparedStatement.setInt(2, tranzakcioT.getOsszeg());
			preparedStatement.setDate(3, new Date(tranzakcioT.getDatum()
					.getMillis()));
			preparedStatement.setString(4, tranzakcioT.getLeiras());
			preparedStatement.setString(5, tranzakcioT.getKiiro());
			preparedStatement.setInt(6, tranzakcioT.getTranzakcioTID());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
