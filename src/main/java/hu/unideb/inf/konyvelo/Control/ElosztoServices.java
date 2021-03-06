/**
 * 
 */
package hu.unideb.inf.konyvelo.Control;

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
 * Osztály, amely a tranzakciók elosztásáért felel.
 *
 */
public class ElosztoServices {
	
	private static Logger	logger = LoggerFactory.getLogger(ElosztoServices.class);
	
	/**
	 * Elosztja a társasháztranzakció összegét a társasház lakásai között.
	 * 
	 * @param tranzakcioID az elosztandó tranzakció azonosítója
	 */
	public void elosztT(int tranzakcioID){
		DAOGet get = new DAOGet();
		TranzakcioT tranzakcio = get.getTranzakciokTByTranzakcioID(tranzakcioID);
		Tarsashaz tarsashaz = get.getTarsashazByID(tranzakcio.getTarsashazID());
		DAOUpdate daoUpdate = new DAOUpdate();
		int egyfore=tranzakcio.getOsszeg()/tarsashaz.getLakasszam();
		tarsashaz.setTartozas(tarsashaz.getTartozas()+tranzakcio.getOsszeg());
		daoUpdate.updateTarsashaz(tarsashaz);
		List<Lakas> lakasok = get.getLakasokByTarsashazId(tarsashaz.getId());
		for(Lakas lakas:lakasok){
			lakas.setTartozas(lakas.getTartozas()+egyfore);
			daoUpdate.updateLakas(lakas);
		}
		logger.debug("Társasház tranzakció szétosztása megtörtént");
		
	}
	
	/**
	 * Levonja a kapott lakástranzakció összegés a társasház tartozásaiból.
	 * 
	 * @param tranzakcioID a levonandó tranzakció azonosítója
	 */
	public void elosztL(int tranzakcioID){
		DAOGet get = new DAOGet();
		TranzakcioL tranzakcio = get.getTranzakciokLByTranzakcioID(tranzakcioID);
		Lakas lakas = get.getLakasokById(tranzakcio.getLakasID());
		Tarsashaz tarsashaz = get.getTarsashazByID(lakas.getTarsashazID());
		DAOUpdate daoUpdate = new DAOUpdate();
		lakas.setTartozas(lakas.getTartozas()-tranzakcio.getOsszeg());
		daoUpdate.updateLakas(lakas);
		tarsashaz.setTartozas(tarsashaz.getTartozas()-tranzakcio.getOsszeg());
		daoUpdate.updateTarsashaz(tarsashaz);
		logger.debug("Lakás tranzakció szétosztása megtörtént");
	}
}
