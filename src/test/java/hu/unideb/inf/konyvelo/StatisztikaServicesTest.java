/**
 * 
 */
package hu.unideb.inf.konyvelo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;
import hu.unideb.inf.konyvelo.Control.StatisztikaServices;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;

/**
 * @author Bence
 *
 */
public class StatisztikaServicesTest {
	
	@Test
	public void testTarsashazakSzama(){
		List<Tarsashaz> tarsashazak = new ArrayList<Tarsashaz>();
		StatisztikaServices ss = new StatisztikaServices();
		assertEquals("0-nak kéne hogy legyen", 0, ss.tarsashazakSzama(tarsashazak));
		tarsashazak.add(new Tarsashaz());
		tarsashazak.add(new Tarsashaz());
		tarsashazak.add(new Tarsashaz());
		tarsashazak.add(new Tarsashaz());
		tarsashazak.add(new Tarsashaz());
		tarsashazak.add(new Tarsashaz());
		
		assertEquals("6-nak kéne hogy legyen", 6, ss.tarsashazakSzama(tarsashazak));
		tarsashazak.add(new Tarsashaz());
		tarsashazak.add(new Tarsashaz());
		assertEquals("8-nak kéne hogy legyen", 8, ss.tarsashazakSzama(tarsashazak));
	}

	@Test
	public void testLakasokSzama(){
		List<Lakas> lakasok = new ArrayList<Lakas>();
		StatisztikaServices ss = new StatisztikaServices();
		assertEquals("0-nak kéne hogy legyen", 0, ss.lakasokSzama(lakasok));
		lakasok.add(new Lakas());
		lakasok.add(new Lakas());
		lakasok.add(new Lakas());
		lakasok.add(new Lakas());
		lakasok.add(new Lakas());
		lakasok.add(new Lakas());
		
		assertEquals("6-nak kéne hogy legyen", 6, ss.lakasokSzama(lakasok));
		lakasok.add(new Lakas());
		lakasok.add(new Lakas());
		assertEquals("8-nak kéne hogy legyen", 8, ss.lakasokSzama(lakasok));
	}
	
	@Test
	public void testAtlagTartozas(){
		StatisztikaServices ss = new StatisztikaServices();
		List<Tarsashaz> tarsashazak = new ArrayList<Tarsashaz>();
		double kene=0;
		for(int i=1;i<=3;i++){
			Tarsashaz thaz=new Tarsashaz();
			thaz.setTartozas(i*3000);
			tarsashazak.add(thaz);
			kene+=i*3000;
		}

		assertEquals("Nem egyeznek", kene/3, ss.atlagTartozas(tarsashazak), 5);
		
		Tarsashaz thaz=new Tarsashaz();
		thaz.setTartozas(6000);
		tarsashazak.add(thaz);
		kene+=6000;
		assertEquals("Nem egyeznek", kene/4, ss.atlagTartozas(tarsashazak), 5);
	}
	
	@Test
	public void testAtlagTartozasLakasok(){
		StatisztikaServices ss = new StatisztikaServices();
		List<Lakas> lakasok = new ArrayList<Lakas>();
		double kene=0;
		for(int i=1;i<=3;i++){
			Lakas lakas=new Lakas();
			lakas.setTartozas(i*3000);
			lakasok.add(lakas);
			kene+=i*3000;
		}
		
		assertEquals("Nem egyeznek", kene/3, ss.atlagTartozasLakasok(lakasok), 5);
		
		Lakas lakas=new Lakas();
		lakas.setTartozas(6000);
		lakasok.add(lakas);
		kene+=6000;
		
		assertEquals("Nem egyeznek", kene/4, ss.atlagTartozasLakasok(lakasok), 5);
	}
	
	@Test
	public void testMaxTartozas(){
		StatisztikaServices ss = new StatisztikaServices();
		List<Tarsashaz> tarsashazak = new ArrayList<Tarsashaz>();
		Tarsashaz thaz = new Tarsashaz();
		thaz.setTartozas(5000);
		tarsashazak.add(thaz);
		thaz = new Tarsashaz();
		thaz.setTartozas(6000);
		tarsashazak.add(thaz);
		thaz = new Tarsashaz();
		thaz.setTartozas(4000);
		tarsashazak.add(thaz);
		
		assertEquals("6000 kéne hogy legyen", 6000, ss.maxTartozas(tarsashazak));
		
		thaz = new Tarsashaz();
		thaz.setTartozas(3000);
		tarsashazak.add(thaz);
		
		thaz = new Tarsashaz();
		thaz.setTartozas(8000);
		tarsashazak.add(thaz);
		
		assertEquals("8000 kéne hogy legyen", 8000, ss.maxTartozas(tarsashazak));
	}
	
	@Test
	public void testMaxTartozasLakas(){
		StatisztikaServices ss = new StatisztikaServices();
		List<Lakas> lakasok = new ArrayList<Lakas>();
		Lakas lakas = new Lakas();
		lakas.setTartozas(5000);
		lakasok.add(lakas);
		lakas = new Lakas();
		lakas.setTartozas(6000);
		lakasok.add(lakas);
		lakas = new Lakas();
		lakas.setTartozas(4000);
		lakasok.add(lakas);
		
		assertEquals("6000 kéne hogy legyen", 6000, ss.maxTartozasLakas(lakasok));
		
		lakas = new Lakas();
		lakas.setTartozas(3000);
		lakasok.add(lakas);
		
		lakas = new Lakas();
		lakas.setTartozas(8000);
		lakasok.add(lakas);
		
		assertEquals("8000 kéne hogy legyen", 8000, ss.maxTartozasLakas(lakasok));
	}
	
	@Test
	public void testOsszTartozas(){
		StatisztikaServices ss = new StatisztikaServices();
		List<Tarsashaz> tarsashazak = new ArrayList<Tarsashaz>();
		Tarsashaz thaz = new Tarsashaz();
		thaz.setTartozas(5000);
		tarsashazak.add(thaz);
		thaz = new Tarsashaz();
		thaz.setTartozas(6000);
		tarsashazak.add(thaz);
		thaz = new Tarsashaz();
		thaz.setTartozas(4000);
		tarsashazak.add(thaz);
		
		assertEquals("15000 kéne hogy legyen", 15000, ss.osszTartozas(tarsashazak));
		
		thaz = new Tarsashaz();
		thaz.setTartozas(2000);
		tarsashazak.add(thaz);
		thaz = new Tarsashaz();
		thaz.setTartozas(10000);
		tarsashazak.add(thaz);
		
		assertEquals("27000 kéne hogy legyen", 27000, ss.osszTartozas(tarsashazak));
		
	}
	
	@Test
	public void testOsszTartozasLakas(){
		StatisztikaServices ss = new StatisztikaServices();
		List<Lakas> lakasok = new ArrayList<Lakas>();
		Lakas lakas = new Lakas();
		lakas.setTartozas(5000);
		lakasok.add(lakas);
		lakas = new Lakas();
		lakas.setTartozas(6000);
		lakasok.add(lakas);
		lakas = new Lakas();
		lakas.setTartozas(4000);
		lakasok.add(lakas);
		
		assertEquals("15000 kéne hogy legyen", 15000, ss.osszTartozasLakas(lakasok));
		
		lakas = new Lakas();
		lakas.setTartozas(3000);
		lakasok.add(lakas);
		
		lakas = new Lakas();
		lakas.setTartozas(8000);
		lakasok.add(lakas);
		
		assertEquals("26000 kéne hogy legyen", 26000, ss.osszTartozasLakas(lakasok));
	}
	
	@Test
	public void testRezsiElott(){
		StatisztikaServices ss = new StatisztikaServices();
		assertEquals("22000 kéne hogy legyen", 22000, ss.rezsiElott(20000), 5);
		assertEquals("36300 kéne hogy legyen", 36300, ss.rezsiElott(33000), 5);
	}
	
	@Test
	public void testRezsiMegtakarit(){
		StatisztikaServices ss = new StatisztikaServices();
		assertEquals("20000 kéne hogy legyen", 20000, ss.rezsiMegtakarit(42000, 22000) ,5);
		assertEquals("2000 kéne hogy legyen", 2000, ss.rezsiMegtakarit(22000, 20000) ,5);
	}
}
