/**
 * 
 */
package hu.unideb.inf.konyvelo.Control;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.unideb.inf.konyvelo.MainMenu;
import hu.unideb.inf.konyvelo.DAO.DAOGet;
import hu.unideb.inf.konyvelo.DAO.DAOInsert;
import hu.unideb.inf.konyvelo.DAO.DAOUpdate;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;
import hu.unideb.inf.konyvelo.Model.TranzakcioL;
import hu.unideb.inf.konyvelo.Model.TranzakcioT;

/**
 * Osztály, mert beszúró műveleteket végez az adatbázisba.
 * Ha a beszúrandó elem már létezett akkor felülírja.
 */
public class InsertServices {
	
	private static Logger	logger = LoggerFactory.getLogger(InsertServices.class);

	/**
	 * Beszúr egy lakástranzakciót az adatbázisba.
	 * Ha létezett már akkor felülírja.
	 * 
	 * @param tranzakcio a beszúrandó lakástranzakció
	 */
	public void insertTranzakcioL(TranzakcioL tranzakcio) {
		DAOGet daoGet = new DAOGet();
		List<TranzakcioL> tranzakciok = daoGet.getTranzakciokL();
		List<Integer> idk= new ArrayList<Integer>();
		for(TranzakcioL tr:tranzakciok){
			idk.add(tr.getTranzakcioLID());
		}
		
		if (idk.contains(tranzakcio.getTranzakcioLID())) {
			DAOUpdate daoUpdate = new DAOUpdate();
			daoUpdate.updateTranzakcioL(tranzakcio);
		} else {
			DAOInsert daoInsert = new DAOInsert();
			daoInsert.insertTranzakcioL(tranzakcio);
		}
		logger.debug("Lakás tranzakció feltöltése megtörtént");
	}

	/**
	 * Beszúr egy társasháztranzakciót az adatbázisba.
	 * Ha már létezett akkor felülírja.
	 * 
	 * @param tranzakcio a beszúrandó társasháztranzakció
	 */
	public void insertTranzakcioT(TranzakcioT tranzakcio) {
		DAOGet daoGet = new DAOGet();
		List<TranzakcioT> tranzakciok = daoGet.getTranzakciokT();
		List<Integer> idk= new ArrayList<Integer>();
		for(TranzakcioT tr:tranzakciok){
			idk.add(tr.getTranzakcioTID());
		}
		
		if (idk.contains(tranzakcio.getTranzakcioTID())) {
			DAOUpdate daoUpdate = new DAOUpdate();
			daoUpdate.updateTranzakcioT(tranzakcio);
		} else {
			DAOInsert daoInsert = new DAOInsert();
			daoInsert.insertTranzakcioT(tranzakcio);
		}
		logger.debug("Társasház tranzakció feltöltése megtörtént");
	}

	/**
	 * Beszúr egy lakást az adatbázisba.
	 * Ha már létezett akkor felülírja.
	 * 
	 * @param lakas a beszúrandó lakás
	 */
	public void insertLakas(Lakas lakas) {
		DAOGet daoGet = new DAOGet();
		List<Lakas> lakasok = daoGet.getLakasokEgyszeru();
		List<Integer> idk= new ArrayList<Integer>();
		for(Lakas tr:lakasok){
			idk.add(tr.getId());
		}
		if(idk.contains(lakas.getId())){
			DAOUpdate daoUpdate = new DAOUpdate();
			daoUpdate.updateLakas(lakas);
		} else {
			DAOInsert daoInsert = new DAOInsert();
			daoInsert.insertLakas(lakas);
		}
		logger.debug("Lakás feltöltése megtörtént");
	}
	
	
	/**
	 * Beszúr egy társasházat az adatbázisba.
	 * Ha már létezett akkor felülírja.
	 * 
	 * @param tarsashaz a beszúrandó társasház
	 */
	public void insertTarsashaz(Tarsashaz tarsashaz) {
		DAOGet daoGet = new DAOGet();
		List<Tarsashaz> tarsashazak = daoGet.getTarsashazakEgyszeru();
		List<Integer> idk= new ArrayList<Integer>();
		for(Tarsashaz tr:tarsashazak){
			idk.add(tr.getId());
		}
		
		if(idk.contains(tarsashaz.getId())){
			DAOUpdate daoUpdate = new DAOUpdate();
			daoUpdate.updateTarsashaz(tarsashaz);
		} else {
			DAOInsert daoInsert = new DAOInsert();
			daoInsert.insertTarsashaz(tarsashaz);
		}
		logger.debug("Társasház feltöltése megtörtént");
	}

}
