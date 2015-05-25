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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Bence
 *
 */
public class DAODelete {
	
	private static Logger	logger = LoggerFactory.getLogger(DAODelete.class);

	public void deleteTarsashaz(Tarsashaz tarsashaz) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM TARSASHAZ WHERE TARSASHAZID="
							+ tarsashaz.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("Társasház törlése");
	}

	public void deleteLakas(Lakas lakas) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM LAKAS WHERE LAKASID="
							+ lakas.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("Lakás törlése");
	}

	public void deleteTranzakcioL(TranzakcioL tranzakcioL) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM TRANZAKCIOL WHERE TRANZAKCIOLID="
							+ tranzakcioL.getTranzakcioLID());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("TranzakcióL törlése");
	}

	public void deleteTranzakcioT(TranzakcioT tranzakcioT) {
		try (Connection connection = ConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM TRANZAKCIOT WHERE TRANZAKCIOTID="
							+ tranzakcioT.getTranzakcioTID());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("TranzakcióT törlése");
	}
}
