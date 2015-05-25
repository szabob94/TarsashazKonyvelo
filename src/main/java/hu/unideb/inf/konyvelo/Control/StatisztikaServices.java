/**
 * 
 */
package hu.unideb.inf.konyvelo.Control;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.unideb.inf.konyvelo.MainMenu;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;

/**
 * Osztály, amely a statisztikákhoz szükséges adatokat számolja.
 */
public class StatisztikaServices {
	
	private static Logger	logger = LoggerFactory.getLogger(StatisztikaServices.class);
	
	/**
	 * Visszaadja a paraméterül kapott listában lévő társasházak számát.
	 * 
	 * @param tarsashazak a társasházak listája
	 * @return a listában lévő társasházak száma
	 */
	public int tarsashazakSzama(List<Tarsashaz> tarsashazak){
		logger.debug("Társasházak száma kiszámítva");
		return tarsashazak.size();
	}
	
	/**
	 * Visszaadja a paraméterül kapott listában lévő lakások számát.
	 * 
	 * @param lakasok a lakások listája
	 * @return a listában lévő lakások száma
	 */
	public int lakasokSzama(List<Lakas> lakasok){
		logger.debug("Lakások száma kiszámítva");
		return lakasok.size();
	}
	
	/**
	 * Visszaadja a paraméterül kapott listában lévő társasházak tartozásainak átlag tartozását.
	 * 
	 * @param tarsashazak a társasházak listája
	 * @return a listában lévő társasházak tartozásainak átlaga
	 */
	public double atlagTartozas(List<Tarsashaz> tarsashazak){
		int darab=0;
		int tartozas=0;
		for(Tarsashaz tarsashaz:tarsashazak){
			darab++;
			tartozas+=tarsashaz.getTartozas();
		}
		logger.debug("Társasházak átlaga kiszámolva");
		return tartozas/darab;
	}
	
	/**
	 * Visszaadja a paraméterül kapott listában lévő lakások tartozásainak átlag tartozását.
	 * 
	 * @param lakasok a lakások listája
	 * @return a listában lévő lakások tartozásainak átlaga
	 */
	public double atlagTartozasLakasok(List<Lakas> lakasok){
		int darab=0;
		int tartozas=0;
		for(Lakas lakas:lakasok){
			darab++;
			tartozas+=lakas.getTartozas();
		}
		logger.debug("Lakások átlaga kiszámolva");
		return tartozas/darab;
	}
	
	/**
	 * Visszaadja a paraméterül kapott listában lévő társasházak tartozásai közül a legnagyobbat.
	 * 
	 * @param tarsashazak a társasházak listája
	 * @return a listában lévő társasházak legnagyobb tartozása
	 */
	public int maxTartozas(List<Tarsashaz> tarsashazak){
		int tartozas=0;
		for(Tarsashaz tarsashaz:tarsashazak){
			if(tarsashaz.getTartozas()>tartozas)
				tartozas=tarsashaz.getTartozas();
		}
		logger.debug("Maximum társasház tartozás kiszámolva");
		return tartozas;
	}
	
	/**
	 * Visszaadja a paraméterül kapott listában lévő lakások tartozásai közül a legnagyobbat.
	 * 
	 * @param lakasok a lakások listája
	 * @return a listában lévő lakások legnagyobb tartozása
	 */
	public int maxTartozasLakas(List<Lakas> lakasok){
		int tartozas=0;
		for(Lakas lakas:lakasok){
			if(lakas.getTartozas()>tartozas)
				tartozas=lakas.getTartozas();
		}
		logger.debug("Maximum lakás tartozás kiszámolva");
		return tartozas;
	}
	
	/**
	 * Visszaadja a paraméterül kapott listában lévő társasházak összes tartozását.
	 * 
	 * @param tarsashazak a társasházak listája
	 * @return a listában lévő társasházak összes tartozása
	 */
	public int osszTartozas(List<Tarsashaz> tarsashazak){
		int tartozas=0;
		for(Tarsashaz tarsashaz:tarsashazak){
			tartozas+=tarsashaz.getTartozas();
		}
		logger.debug("Társasházak összes tartozása kiszámolva");
		return tartozas;
	}
	
	/**
	 * Visszaadja a paraméterül kapott listában lévő lakások összes tartozását.
	 * 
	 * @param lakasok a lakások listája
	 * @return a listában lévő lakások összes tartozása
	 */
	public int osszTartozasLakas(List<Lakas> lakasok){
		int tartozas=0;
		for(Lakas lakas:lakasok){
			tartozas+=lakas.getTartozas();
		}
		logger.debug("Lakások összes tartozása kiszámolva");
		return tartozas;
	}
	
	/**
	 * Visszaadja a paraméterül kapott érték rezsicsökkentés előtti értékét.
	 * 
	 * @param osszeg a rezsicsökkentés utáni érték
	 * @return a rezsicsökkentés előtti érték
	 */
	public double rezsiElott(int osszeg){
		logger.debug("Rezsicsökkentés előtti érték kiszámolva");
		return osszeg+(osszeg*0.1);
	}
	
	/**
	 * Visszaadja a megtakarítás értékét rezsicsökkentés után.
	 * 
	 * @param elotte a rezsicsökkentés előtti tartozás
	 * @param utana a rezsicsökkentés utáni tartozás
	 * @return a megtakarítás értéke.
	 */
	public double rezsiMegtakarit(double elotte, int utana){
		logger.debug("Megtakarítás kiszámolva");
		return elotte-utana;
	}
	
}
