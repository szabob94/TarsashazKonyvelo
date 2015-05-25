/**
 * 
 */
package hu.unideb.inf.konyvelo.Control;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.unideb.inf.konyvelo.MainMenu;
import hu.unideb.inf.konyvelo.DAO.DAODelete;
import hu.unideb.inf.konyvelo.DAO.DAOGet;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;
import hu.unideb.inf.konyvelo.Model.TranzakcioL;
import hu.unideb.inf.konyvelo.Model.TranzakcioT;

/**
 * Osztály, mely az adatbázisból való törléseket intézi.
 *
 */
public class DeleteServices {
	
	private static Logger	logger = LoggerFactory.getLogger(DeleteServices.class);
	
	/**
	 * Kitöröl egy társasházat az adatbázisból.
	 * 
	 * @param tarsashaz a kitörlendő társasház
	 */
	public void deleteTarsashaz(Tarsashaz tarsashaz){
		DAOGet daoGet = new DAOGet();
		List<Tarsashaz> tarsashazak = daoGet.getTarsashazakEgyszeru();
		for(Tarsashaz th:tarsashazak)
			if(th.getId()==tarsashaz.getId()){
				DAODelete daoDelete = new DAODelete();
				daoDelete.deleteTarsashaz(tarsashaz);
			}
		logger.debug("Társasház törlése megtörtént");
		
	}
	
	/**
	 * Kitöröl egy lakást az adatbázisból.
	 * 
	 * @param lakas a kitörlendő lakás
	 */
	public void deleteLakas(Lakas lakas){
		DAOGet daoGet = new DAOGet();
		List<Lakas> lakasok = daoGet.getLakasokEgyszeru();
		for(Lakas lak:lakasok)
			if(lak.getId()==lakas.getId()){
				DAODelete daoDelete = new DAODelete();
				daoDelete.deleteLakas(lakas);
			}
		logger.debug("Lakás törlése megtörtént");
	}
	
	/**
	 * Kitöröl egy lakástranzakciót az adatbázisból.
	 * 
	 * @param tranzakcio a kitörlendő lakástranzakció
	 */
	public void deleteTranzakcioL(TranzakcioL tranzakcio){
		DAOGet daoGet = new DAOGet();
		List<TranzakcioL> tranzakciok = daoGet.getTranzakciokL();
		for(TranzakcioL tranz:tranzakciok)
			if(tranz.getTranzakcioLID()==tranzakcio.getTranzakcioLID()){
				DAODelete daoDelete = new DAODelete();
				daoDelete.deleteTranzakcioL(tranzakcio);;
			}
		logger.debug("TranzakcióL törlése megtörtént");
	}
	
	/**
	 * kitöröl egy társasháztranzakciót az adatbázisból.
	 * 
	 * @param tranzakcio a kitörlendő társasháztranzakció
	 */
	public void deleteTranzakcioT(TranzakcioT tranzakcio){
		DAOGet daoGet = new DAOGet();
		List<TranzakcioT> tranzakciok = daoGet.getTranzakciokT();
		for(TranzakcioT tranz:tranzakciok)
			if(tranz.getTranzakcioTID()==tranzakcio.getTranzakcioTID()){
				DAODelete daoDelete = new DAODelete();
				daoDelete.deleteTranzakcioT(tranzakcio);;
			}
		logger.debug("TranzakcioT törlése megtörtént");
	}

}
