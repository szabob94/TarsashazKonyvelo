/**
 * 
 */
package hu.unideb.inf.konyvelo.Control;

import java.util.List;

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
		
	}
	
	public void elosztL(int tranzakcioID){
		DAOGet get = new DAOGet();
		TranzakcioL tranzakcio = get.getTranzakciokLByTranzakcioID(tranzakcioID);
		Lakas lakas = get.getLakasokById(tranzakcio.getLakasID());
		DAOUpdate daoUpdate = new DAOUpdate();
		lakas.setTartozas(lakas.getTartozas()-tranzakcio.getOsszeg());
		daoUpdate.updateLakas(lakas);
	}
}
