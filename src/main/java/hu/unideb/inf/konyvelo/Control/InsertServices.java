/**
 * 
 */
package hu.unideb.inf.konyvelo.Control;

import java.util.ArrayList;
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
public class InsertServices {

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
	}

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
	}

	public void insertLakas(Lakas lakas) {
		DAOGet daoGet = new DAOGet();
		List<Lakas> lakasok = daoGet.getLakasok();
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
	}
	
	public void insertTarsashaz(Tarsashaz tarsashaz) {
		DAOGet daoGet = new DAOGet();
		List<Tarsashaz> tarsashazak = daoGet.getTarsashazak();
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
	}

}