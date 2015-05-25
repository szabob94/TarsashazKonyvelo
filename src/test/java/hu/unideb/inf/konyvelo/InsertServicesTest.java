/**
 * 
 */
package hu.unideb.inf.konyvelo;

import java.util.ArrayList;
import java.util.List;

import hu.unideb.inf.konyvelo.Control.InsertServices;
import hu.unideb.inf.konyvelo.DAO.DAODelete;
import hu.unideb.inf.konyvelo.DAO.DAOGet;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;
import hu.unideb.inf.konyvelo.Model.TranzakcioL;
import hu.unideb.inf.konyvelo.Model.TranzakcioT;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Bence
 *
 */
public class InsertServicesTest {
	
	@Test
	public void testInsertTranzakcioL(){
		InsertServices inS = new InsertServices();
		TranzakcioL ures = new TranzakcioL();
		assertNotNull("Üres", ures);
		DAOGet get = new DAOGet();
		List<TranzakcioL> tranzakciok = get.getTranzakciokL();
		int size=tranzakciok.size();
		TranzakcioL tranzakcio = new TranzakcioL(1594, 4, 1000, new DateTime(2015,9,15,14,40), "valami", "valaki");
		inS.insertTranzakcioL(tranzakcio);
		tranzakciok=get.getTranzakciokL();
		
		assertEquals("Nem egyenlőek", size+1, tranzakciok.size());
		
		TranzakcioL tranzakcio2 = new TranzakcioL(1595, 4, 3540, new DateTime(2015,9,15,14,40), "valami", "valaki");
		inS.insertTranzakcioL(tranzakcio2);
		tranzakciok=get.getTranzakciokL();
		
		assertEquals("Nem egyenlőek", size+2, tranzakciok.size());
		
		DAODelete delete = new DAODelete();
		delete.deleteTranzakcioL(tranzakcio);
		delete.deleteTranzakcioL(tranzakcio2);
	}
	
	@Test
	public void testInsertTranzakcioT(){
		InsertServices inS = new InsertServices();
		TranzakcioT ures = new TranzakcioT();
		assertNotNull("Üres", ures);
		DAOGet get = new DAOGet();
		List<TranzakcioT> tranzakciok = get.getTranzakciokT();
		int size=tranzakciok.size();
		TranzakcioT tranzakcio = new TranzakcioT(1594, 4, 1000, new DateTime(2015,9,15,14,40), "valami", "valaki");
		inS.insertTranzakcioT(tranzakcio);
		tranzakciok=get.getTranzakciokT();
		
		assertEquals("Nem egyenlőek", size+1, tranzakciok.size());
		
		TranzakcioT tranzakcio2 = new TranzakcioT(1595, 4, 3540, new DateTime(2015,9,15,14,40), "valami", "valaki");
		inS.insertTranzakcioT(tranzakcio2);
		tranzakciok=get.getTranzakciokT();
		
		assertEquals("Nem egyenlőek", size+2, tranzakciok.size());
		
		DAODelete delete = new DAODelete();
		delete.deleteTranzakcioT(tranzakcio);
		delete.deleteTranzakcioT(tranzakcio2);
	}
	
	@Test
	public void testInsertLakas(){
		InsertServices inS = new InsertServices();
		Lakas ures = new Lakas();
		assertNotNull("Üres", ures);
		ures.setAjto(5);
		assertEquals("5-nek kéne hogy legyen", 5, ures.getAjto());
		ures.setEmelet(4);
		assertEquals("4-nek kéne hogy legyen", 4, ures.getEmelet());
		ures.setTulajdonos("valaki");
		assertEquals("valaki", ures.getTulajdonos());
		ures.setId(5);
		assertEquals("5-nek kéne hogy legyen", 5, ures.getId());
		
		DAOGet get = new DAOGet();
		List<Lakas> lakasok = get.getLakasokEgyszeru();
		int size=lakasok.size();
		Lakas lakas = new Lakas(21231,"Mekk Elek",25535,1,1,0,new ArrayList<TranzakcioL>());
		inS.insertLakas(lakas);
		lakasok=get.getLakasokEgyszeru();
		
		assertEquals("Nem egyenlőek", size+1, lakasok.size());
		
		Lakas lakas2 = new Lakas(21232,"Adat bá",25535,1,2,40000,new ArrayList<TranzakcioL>());
		inS.insertLakas(lakas2);
		lakasok=get.getLakasokEgyszeru();
		
		assertEquals("Nem egyenlőek", size+2, lakasok.size());
		
		DAODelete delete = new DAODelete();
		delete.deleteLakas(lakas);
		delete.deleteLakas(lakas2);
	}
	
	@Test
	public void testInsertTarsashaz(){
		InsertServices inS = new InsertServices();
		Tarsashaz ures = new Tarsashaz();
		assertNotNull("Üres", ures);
		DAOGet get = new DAOGet();
		List<Tarsashaz> tarsashazak = get.getTarsashazakEgyszeru();
		int size=tarsashazak.size();
		Tarsashaz tarsashaz = new Tarsashaz(25535,"A cim",8,16,0,new ArrayList<Lakas>(),new ArrayList<TranzakcioT>());
		inS.insertTarsashaz(tarsashaz);
		tarsashazak=get.getTarsashazakEgyszeru();
		
		assertEquals("Nem egyenlőek", size+1, tarsashazak.size());
		
		Tarsashaz tarsashaz2 = new Tarsashaz(25536,"Masik cim",3,4,21500,new ArrayList<Lakas>(),new ArrayList<TranzakcioT>());
		inS.insertTarsashaz(tarsashaz2);
		tarsashazak=get.getTarsashazakEgyszeru();
		
		assertEquals("Nem egyenlőek", size+2, tarsashazak.size());
		
		DAODelete delete = new DAODelete();
		delete.deleteTarsashaz(tarsashaz);
		delete.deleteTarsashaz(tarsashaz2);
	}

}
