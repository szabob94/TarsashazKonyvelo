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
					.executeQuery("SELECT TARSASHAZID, CIM, EMELETSZAM, LAKASSZAM, TARTOZAS FROM tarsashaz");
			while (resoultSet.next()) {
				Tarsashaz tarsashaz = new Tarsashaz(resoultSet.getInt(1),
						resoultSet.getString(2),resoultSet.getInt(3) ,resoultSet.getInt(4),resoultSet.getInt(5), getLakasokByTarsashazId(resoultSet.getInt(1)), getTranzakciokTByTarsashazId(resoultSet.getInt(1)));
				tarsashazak.add(tarsashaz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tarsashazak;
	}
	
	public Tarsashaz getTarsashazByID(int id) {
		Tarsashaz tarsashaz = new Tarsashaz();
		try (Connection connection = ConnectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resoultSet = statement
					.executeQuery("SELECT TARSASHAZID, CIM, EMELETSZAM, LAKASSZAM, TARTOZAS FROM tarsashaz WHERE TARSASHAZID="+id);
			while (resoultSet.next()) {
				tarsashaz = new Tarsashaz(resoultSet.getInt(1),
						resoultSet.getString(2),resoultSet.getInt(3) ,resoultSet.getInt(4),resoultSet.getInt(5), getLakasokByTarsashazId(resoultSet.getInt(1)), getTranzakciokTByTarsashazId(resoultSet.getInt(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tarsashaz;
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
						resoultSet.getInt(6)
						, getTranzakciokLByLakasId(resoultSet.getInt(1)));
				lakasok.add(lakas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lakasok;
	}
	
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
						, getTranzakciokLByLakasId(resoultSet.getInt(1)));
				lakasok.add(lakas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lakasok;
	}
	
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
						, getTranzakciokLByLakasId(resoultSet.getInt(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lakas;
	}


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
		return tranzakciok;
	}
	
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
		return tranzakciok;
		
	}
	
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
		return tranzakcio;
		
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
		return tranzakciok;
	}
	
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
		return tranzakcio;
	}
}
