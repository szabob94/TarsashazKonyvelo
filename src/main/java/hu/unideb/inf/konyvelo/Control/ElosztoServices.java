/**
 * 
 */
package hu.unideb.inf.konyvelo.Control;

import hu.unideb.inf.konyvelo.DAO.DAOGet;
import hu.unideb.inf.konyvelo.DAO.DAOInsert;
import hu.unideb.inf.konyvelo.DAO.DAOUpdate;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;
import hu.unideb.inf.konyvelo.Model.TranzakcioL;
import hu.unideb.inf.konyvelo.Model.TranzakcioT;

/**
 * @author Bence
 *
 */
public class ElosztoServices {
	
	public void elosztT(int tranzakcioID, int  tarsashazID){
		DAOGet get = new DAOGet();
		Tarsashaz tarsashaz = get.getTarsashazByID(tarsashazID);
		TranzakcioT tranzakcio = get.getTranzakciokTByTranzakcioID(tranzakcioID);
		DAOUpdate daoUpdate = new DAOUpdate();
		int egyfore=tranzakcio.getOsszeg()/tarsashaz.getLakasszam();
		tarsashaz.setTartozas(tarsashaz.getTartozas()+tranzakcio.getOsszeg());
		daoUpdate.updateTarsashaz(tarsashaz);
		for(Lakas lakas:tarsashaz.getLakasok()){
			lakas.setTartozas(lakas.getTartozas()+egyfore);
			daoUpdate.updateLakas(lakas);
		}
		
	}
	
	public void elosztL(TranzakcioL tranzakcio, Lakas lakas){
		DAOUpdate daoUpdate = new DAOUpdate();
		lakas.setTartozas(lakas.getTartozas()-tranzakcio.getOsszeg());
		daoUpdate.updateLakas(lakas);
	}
}
