/**
 * 
 */
package hu.unideb.inf.konyvelo.Control;

import java.util.List;

import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;

/**
 * @author Bence
 *
 */
public class StatisztikaServices {
	
	public int tarsashazakSzama(List<Tarsashaz> tarsashazak){
		return tarsashazak.size();
	}
	
	public int lakasokSzama(List<Lakas> lakasok){
		return lakasok.size();
	}
	
	public double atlagTartozas(List<Tarsashaz> tarsashazak){
		int darab=0;
		int tartozas=0;
		for(Tarsashaz tarsashaz:tarsashazak){
			darab++;
			tartozas+=tarsashaz.getTartozas();
		}
		return tartozas/darab;
	}
	
	public double atlagTartozasLakasok(List<Lakas> lakasok){
		int darab=0;
		int tartozas=0;
		for(Lakas lakas:lakasok){
			darab++;
			tartozas+=lakas.getTartozas();
		}
		return tartozas/darab;
	}
	
	public int maxTartozas(List<Tarsashaz> tarsashazak){
		int tartozas=0;
		for(Tarsashaz tarsashaz:tarsashazak){
			if(tarsashaz.getTartozas()>tartozas)
				tartozas=tarsashaz.getTartozas();
		}
		return tartozas;
	}
	
	public int maxTartozasLakas(List<Lakas> lakasok){
		int tartozas=0;
		for(Lakas lakas:lakasok){
			if(lakas.getTartozas()>tartozas)
				tartozas=lakas.getTartozas();
		}
		return tartozas;
	}
	
	public int osszTartozas(List<Tarsashaz> tarsashazak){
		int tartozas=0;
		for(Tarsashaz tarsashaz:tarsashazak){
			tartozas+=tarsashaz.getTartozas();
		}
		return tartozas;
	}
	
	public int osszTartozasLakas(List<Lakas> lakasok){
		int tartozas=0;
		for(Lakas lakas:lakasok){
			tartozas+=lakas.getTartozas();
		}
		return tartozas;
	}
	
	public double rezsiElott(int osszeg){
		return osszeg+(osszeg*0.1);
	}
	
	public double rezsiMegtakarit(double elotte, int utana){
		return elotte-utana;
	}
	
}
