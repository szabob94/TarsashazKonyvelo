/**
 * 
 */
package hu.unideb.inf.konyvelo.Control;

import hu.unideb.inf.konyvelo.DAO.DAOGet;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;
import hu.unideb.inf.konyvelo.Model.TranzakcioL;
import hu.unideb.inf.konyvelo.Model.TranzakcioT;

import java.util.List;

/**
 *Osztály, mely adatokat kér le az adatbázisból.
 */
public class LekeroServices {

	/**
	 * Lekéri az adatbázisból a társasházakat egyszerűen.
	 * 
	 * @return a társasházak listája
	 */
	public List<Tarsashaz> getTarsashazak(){
		DAOGet dao = new DAOGet();
		List<Tarsashaz> tarsashazak= dao.getTarsashazakEgyszeru();
		return tarsashazak;
	}
	
	/**
	 * Lekér az adatbázisból egy társasházat azonosító szerint.
	 * 
	 * @param id a lekérendő társasház azonosítója
	 * @return az azonosító szerint lekért társasház
	 */
	public Tarsashaz getTarsashazByID(int id){
		DAOGet dao = new DAOGet();
		Tarsashaz tarsashaz= dao.getTarsashazByID(id);
		return tarsashaz;
	}
	
	/**
	 * Lekéri az adatbázisból a lakások listáját egyszerűen.
	 * 
	 * @return a lakások listája
	 */
	public List<Lakas> getLakasok(){
		DAOGet dao = new DAOGet();
		List<Lakas> lakasok= dao.getLakasokEgyszeru();
		return lakasok;
	}
	
	/**
	 * Lekéri az adatbázisból egy lakást azonosító szerint.
	 * 
	 * @param id a lekérendő lakás azonosítója
	 * @return az azonosító szerint lekért lakás
	 */
	public Lakas getLakasByID(int id){
		DAOGet dao = new DAOGet();
		Lakas lakas= dao.getLakasokById(id);
		return lakas;
	}
	
	/**
	 * Lekéri az adatbázisból a társasháztranzakciókat.
	 * 
	 * @return a társasháztranzakciók listája
	 */
	public List<TranzakcioT> getTranzakcioTk(){
		DAOGet dao = new DAOGet();
		List<TranzakcioT> tranzakciok= dao.getTranzakciokT();
		return tranzakciok;
	}
	
	/**
	 * Lekéri az adatbázisból a lakástranzakciókat.
	 * 
	 * @return a lakástranzakciók listája
	 */
	public List<TranzakcioL> getTranzakcioLek(){
		DAOGet dao = new DAOGet();
		List<TranzakcioL> tranzakciok= dao.getTranzakciokL();
		return tranzakciok;
	}
}
