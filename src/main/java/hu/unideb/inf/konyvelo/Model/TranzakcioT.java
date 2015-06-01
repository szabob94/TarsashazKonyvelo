/**
 * 
 */
package hu.unideb.inf.konyvelo.Model;

import org.joda.time.DateTime;

/**
 * @author Bence
 *
 */
public class TranzakcioT {

	/**
	 * A társasház tranzakció azonosítója.
	 */
	private int tranzakcioTID;
	
	/**
	 * A társasház azonosítója.
	 */
	private int tarsashazID;
	
	/**
	 * A társasház tranzakció összege.
	 */
	private int osszeg;
	
	/**
	 * A társasház tranzakció dátuma.
	 */
	private DateTime datum;
	
	/**
	 * A társasház tranzakció leírása.
	 */
	private String leiras;
	
	/**
	 * A társasház tranzakció kiírója.
	 */
	private String kiiro;
	
	/**
	 * Bő konstruktor társasház tranzakció létrehozásához.
	 * 
	 * @param tranzakcioTID a társasház tranzakció azonosítója
	 * @param tarsashazID a társasház azonosítója
	 * @param osszeg a társasház tranzakció összege
	 * @param datum a társasház tranzakció dátuma
	 * @param leiras a társasház tranzakció leírása
	 * @param kiiro a társasház tranzakió kiírója
	 */
	public TranzakcioT(int tranzakcioTID, int tarsashazID, int osszeg,
			DateTime datum, String leiras, String kiiro) {
		super();
		this.tranzakcioTID = tranzakcioTID;
		this.tarsashazID = tarsashazID;
		this.osszeg = osszeg;
		this.datum = datum;
		this.leiras = leiras;
		this.kiiro = kiiro;
	}

	/**
	 * Üres konstruntok társasház tranzakció létrehozásához.
	 */
	public TranzakcioT() {
	}

	/**
	 * A társasház tranzakció azonosítóját adja vissza.
	 * 
	 * @return A társasház tranzakció azonosítója
	 */
	public int getTranzakcioTID() {
		return tranzakcioTID;
	}

	/**
	 * A társasház tranzakció azonosítóját állítja be.
	 * 
	 * @param tranzakcioTID a társasház tranzakció azonosítója
	 */
	public void setTranzakcioTID(int tranzakcioTID) {
		this.tranzakcioTID = tranzakcioTID;
	}

	/**
	 * A társasház azonosítóját adja vissza.
	 * 
	 * @return a társasház azonosítója
	 */
	public int getTarsashazID() {
		return tarsashazID;
	}

	/**
	 * A társasház azonosítóját állítja be.
	 * 
	 * @param tarsashazID a társasház azonosítója
	 */
	public void setTarsashazID(int tarsashazID) {
		this.tarsashazID = tarsashazID;
	}

	/**
	 * A társasház tranzakció összegét adja vissza.
	 * 
	 * @return a társasház tranzakció összege
	 */
	public int getOsszeg() {
		return osszeg;
	}

	/**
	 * A társasház tranzakció összegét állítja be.
	 * 
	 * @param osszeg a társasház tranzakció összege
	 */
	public void setOsszeg(int osszeg) {
		this.osszeg = osszeg;
	}

	/**
	 * A társasház tranzakció dátumát adja vissza.
	 * 
	 * @return a társasház tranzakció dátuma
	 */
	public DateTime getDatum() {
		return datum;
	}

	/**
	 * A társasház tranzakció dátumát állítja be.
	 * 
	 * @param datum a társasház tranzakció dátuma
	 */
	public void setDatum(DateTime datum) {
		this.datum = datum;
	}

	/**
	 * A társasház tranzakció leírását adja vissza.
	 * 
	 * @return a társasház tranzakció leírása
	 */
	public String getLeiras() {
		return leiras;
	}

	/**
	 * A társasház tranzakció leírását állítja be.
	 * 
	 * @param leiras a társasház tranzakció leírása
	 */
	public void setLeiras(String leiras) {
		this.leiras = leiras;
	}

	/**
	 * A társasház tranzakció kiíróját adja vissza.
	 * 
	 * @return a társasház tranzakció kiírója
	 */
	public String getKiiro() {
		return kiiro;
	}

	/**
	 * A társasház tranzakció kiíróját állítja be.
	 * 
	 * @param kiiro a társasház tranzakció kiírója
	 */
	public void setKiiro(String kiiro) {
		this.kiiro = kiiro;
	}
	
	@Override
	public String toString(){
		return tranzakcioTID+"";
	}

	public String toString2() {
		return "Tranzakció T azon=" + tranzakcioTID + ", társasház id="
				+ tarsashazID + ", összeg=" + osszeg + ", dátum=" + datum
				+ ", leírás=" + leiras + ", kiíró=" + kiiro;
	}
	
}
