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
 * @author Bence
 *
 */
public class StatisztikaServices {
	
	private static Logger	logger = LoggerFactory.getLogger(StatisztikaServices.class);
	
	public int tarsashazakSzama(List<Tarsashaz> tarsashazak){
		logger.debug("Társasházak száma kiszámítva");
		return tarsashazak.size();
	}
	
	public int lakasokSzama(List<Lakas> lakasok){
		logger.debug("Lakások száma kiszámítva");
		return lakasok.size();
	}
	
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
	
	public int maxTartozas(List<Tarsashaz> tarsashazak){
		int tartozas=0;
		for(Tarsashaz tarsashaz:tarsashazak){
			if(tarsashaz.getTartozas()>tartozas)
				tartozas=tarsashaz.getTartozas();
		}
		logger.debug("Maximum társasház tartozás kiszámolva");
		return tartozas;
	}
	
	public int maxTartozasLakas(List<Lakas> lakasok){
		int tartozas=0;
		for(Lakas lakas:lakasok){
			if(lakas.getTartozas()>tartozas)
				tartozas=lakas.getTartozas();
		}
		logger.debug("Maximum lakás tartozás kiszámolva");
		return tartozas;
	}
	
	public int osszTartozas(List<Tarsashaz> tarsashazak){
		int tartozas=0;
		for(Tarsashaz tarsashaz:tarsashazak){
			tartozas+=tarsashaz.getTartozas();
		}
		logger.debug("Társasházak összes tartozása kiszámolva");
		return tartozas;
	}
	
	public int osszTartozasLakas(List<Lakas> lakasok){
		int tartozas=0;
		for(Lakas lakas:lakasok){
			tartozas+=lakas.getTartozas();
		}
		logger.debug("Lakások összes tartozása kiszámolva");
		return tartozas;
	}
	
	public double rezsiElott(int osszeg){
		logger.debug("Rezsicsökkentés előtti érték kiszámolva");
		return osszeg+(osszeg*0.1);
	}
	
	public double rezsiMegtakarit(double elotte, int utana){
		logger.debug("Megtakarítás kiszámolva");
		return elotte-utana;
	}
	
}
