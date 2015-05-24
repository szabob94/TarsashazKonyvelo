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
 * @author Bence
 *
 */
public class LekeroServices {

	public List<Tarsashaz> getTarsashazak(){
		DAOGet dao = new DAOGet();
		List<Tarsashaz> tarsashazak= dao.getTarsashazakEgyszeru();
		return tarsashazak;
	}
	
	public List<Lakas> getLakasok(){
		DAOGet dao = new DAOGet();
		List<Lakas> lakasok= dao.getLakasokEgyszeru();
		return lakasok;
	}
	
	public List<TranzakcioT> getTranzakcioTk(){
		DAOGet dao = new DAOGet();
		List<TranzakcioT> tranzakciok= dao.getTranzakciokT();
		return tranzakciok;
	}
	
	public List<TranzakcioL> getTranzakcioLek(){
		DAOGet dao = new DAOGet();
		List<TranzakcioL> tranzakciok= dao.getTranzakciokL();
		return tranzakciok;
	}
}
