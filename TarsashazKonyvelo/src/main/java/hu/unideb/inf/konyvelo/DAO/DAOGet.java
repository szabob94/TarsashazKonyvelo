/**
 * 
 */
package hu.unideb.inf.konyvelo.DAO;

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

/**
 * @author Bence
 *
 */
public class DAOGet {

	public List<Tarsashaz> getTarsashazak() {
		List<Tarsashaz> tarsashazak = new ArrayList<Tarsashaz>();
		try (Connection connection = ConnectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resoultSet = statement
					.executeQuery("SELECT TARSASHAZID, CIM, TARTOZAS FROM tarsashaz");
			while (resoultSet.next()) {
				Tarsashaz tarsashaz = new Tarsashaz(resoultSet.getInt(1),
						resoultSet.getString(2), resoultSet.getInt(3));
				tarsashazak.add(tarsashaz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tarsashazak;
	}

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
						resoultSet.getInt(6));
				lakasok.add(lakas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lakasok;
	}

	public List<TranzakcioL> getTranzakciokL() {
		List<TranzakcioL> tranzakciok = new ArrayList<TranzakcioL>();
		try (Connection connection = ConnectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resoultSet = statement
					.executeQuery("SELECT * FROM tranzakcioL");
			while (resoultSet.next()) {
				TranzakcioL tranzakcio = new TranzakcioL(resoultSet.getInt(1),
						resoultSet.getInt(2), resoultSet.getInt(3),
						new DateTime(resoultSet.getDate(4)),
						resoultSet.getString(5), resoultSet.getString(6));
				tranzakciok.add(tranzakcio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tranzakciok;
	}

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
		return tranzakciok;
	}
}
