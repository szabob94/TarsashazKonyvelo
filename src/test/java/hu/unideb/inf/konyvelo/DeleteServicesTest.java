/**
 * 
 */
package hu.unideb.inf.konyvelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import hu.unideb.inf.konyvelo.DAO.DAODelete;
import hu.unideb.inf.konyvelo.DAO.DAOGet;
import hu.unideb.inf.konyvelo.DAO.DAOInsert;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;
import hu.unideb.inf.konyvelo.Model.TranzakcioL;
import hu.unideb.inf.konyvelo.Model.TranzakcioT;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * @author Bence
 *
 */
public class DeleteServicesTest {

	@Test
	public void testDeleteTarsashaz() {
		DAOInsert insert = new DAOInsert();
		Tarsashaz th =new Tarsashaz(29987,"A cim",8,16,0,new ArrayList<Lakas>(),new ArrayList<TranzakcioT>());
		insert.insertTarsashaz(th);
		DAOGet get = new DAOGet();
		List<Tarsashaz> tarsashazak = get.getTarsashazakEgyszeru();
		int size=tarsashazak.size();
		DAODelete delete = new DAODelete();
		delete.deleteTarsashaz(th);
		tarsashazak = get.getTarsashazakEgyszeru();
		
		assertEquals("Nem egyenlőek", size-1, tarsashazak.size());
		
		Tarsashaz th1 =new Tarsashaz(29987,"A cim",8,16,0,new ArrayList<Lakas>(),new ArrayList<TranzakcioT>());
		insert.insertTarsashaz(th1);
		Tarsashaz th2 =new Tarsashaz(29967,"A cim",8,16,0,new ArrayList<Lakas>(),new ArrayList<TranzakcioT>());
		insert.insertTarsashaz(th2);
		tarsashazak = get.getTarsashazakEgyszeru();
		size=tarsashazak.size();
		delete=new DAODelete();
		delete.deleteTarsashaz(th1);
		delete.deleteTarsashaz(th2);
		tarsashazak = get.getTarsashazakEgyszeru();
		
		assertEquals("Nem egyenlőek", size-2, tarsashazak.size());
	}
	
	@Test
	public void testDeleteLakas() {
		DAOInsert insert = new DAOInsert();
		Lakas th =new Lakas(21231,"Mekk Elek",25535,1,1,0,new ArrayList<TranzakcioL>());;
		insert.insertLakas(th);
		DAOGet get = new DAOGet();
		List<Lakas> lakasok = get.getLakasokEgyszeru();
		int size=lakasok.size();
		DAODelete delete = new DAODelete();
		delete.deleteLakas(th);
		lakasok = get.getLakasokEgyszeru();
		
		assertEquals("Nem egyenlőek", size-1, lakasok.size());
		
		Lakas th1 =new Lakas(21231,"Mekk Elek",25535,1,1,0,new ArrayList<TranzakcioL>());
		insert.insertLakas(th1);
		Lakas th2 =new Lakas(21232,"Mekk Elek",25535,1,1,0,new ArrayList<TranzakcioL>());;
		insert.insertLakas(th2);
		lakasok = get.getLakasokEgyszeru();
		size=lakasok.size();
		delete=new DAODelete();
		delete.deleteLakas(th1);
		delete.deleteLakas(th2);
		lakasok = get.getLakasokEgyszeru();
		
		assertEquals("Nem egyenlőek", size-2, lakasok.size());
	}

	@Test
	public void testDeleteTranzakcioT() {
		DAOInsert insert = new DAOInsert();
		TranzakcioT th =new TranzakcioT(1594, 4, 1000, new DateTime(2015,9,15,14,40), "valami", "valaki");
		insert.insertTranzakcioT(th);
		DAOGet get = new DAOGet();
		List<TranzakcioT> tranzakciok = get.getTranzakciokT();
		int size=tranzakciok.size();
		DAODelete delete = new DAODelete();
		delete.deleteTranzakcioT(th);
		tranzakciok = get.getTranzakciokT();
		
		assertEquals("Nem egyenlőek", size-1, tranzakciok.size());
		
		TranzakcioT th1 =new TranzakcioT(1594, 4, 1000, new DateTime(2015,9,15,14,40), "valami", "valaki");
		insert.insertTranzakcioT(th1);
		TranzakcioT th2 =new TranzakcioT(1595, 4, 1000, new DateTime(2015,9,15,14,40), "valami", "valaki");
		insert.insertTranzakcioT(th2);
		tranzakciok = get.getTranzakciokT();
		size=tranzakciok.size();
		delete=new DAODelete();
		delete.deleteTranzakcioT(th1);
		delete.deleteTranzakcioT(th2);
		tranzakciok = get.getTranzakciokT();
		
		assertEquals("Nem egyenlőek", size-2, tranzakciok.size());
	}
	
	@Test
	public void testDeleteTranzakcioL() {
		DAOInsert insert = new DAOInsert();
		TranzakcioL th =new TranzakcioL(1594, 4, 1000, new DateTime(2015,9,15,14,40), "valami", "valaki");
		insert.insertTranzakcioL(th);
		DAOGet get = new DAOGet();
		List<TranzakcioL> tranzakciok = get.getTranzakciokL();
		int size=tranzakciok.size();
		DAODelete delete = new DAODelete();
		delete.deleteTranzakcioL(th);
		tranzakciok = get.getTranzakciokL();
		
		assertEquals("Nem egyenlőek", size-1, tranzakciok.size());
		
		TranzakcioL th1 =new TranzakcioL(1594, 4, 1000, new DateTime(2015,9,15,14,40), "valami", "valaki");
		insert.insertTranzakcioL(th1);
		TranzakcioL th2 =new TranzakcioL(1595, 4, 1000, new DateTime(2015,9,15,14,40), "valami", "valaki");
		insert.insertTranzakcioL(th2);
		tranzakciok = get.getTranzakciokL();
		size=tranzakciok.size();
		delete=new DAODelete();
		delete.deleteTranzakcioL(th1);
		delete.deleteTranzakcioL(th2);
		tranzakciok = get.getTranzakciokL();
		
		assertEquals("Nem egyenlőek", size-2, tranzakciok.size());
	}
}
