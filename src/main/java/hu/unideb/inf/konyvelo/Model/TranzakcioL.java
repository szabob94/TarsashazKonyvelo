/**
 * 
 */
package hu.unideb.inf.konyvelo.Model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.joda.time.DateTime;

/**
 * Osztály, amely egy lakás tranzakciót reprezentál.
 */
public class TranzakcioL {

	/**
	 * A tranzakció azonosítója.
	 */
	private int tranzakcioLID;
	
	/**
	 * A tranzakció lakás azonosítója.
	 */
	private int lakasID;
	
	/**
	 * A tranzakció összege.
	 */
	private int osszeg;
	
	/**
	 * A tranzakció létrejöttének dátuma.
	 */
	private DateTime datum;
	
	/**
	 * A tranzakció leírása.
	 */
	private String leiras;
	
	/**
	 * A tranzakció kezdeményezője.
	 */
	private String befizeto;
	
	/**
	 * 
	 * Bő konstruktor lakás tranzakció létrehozásához, minden adattaggal.
	 * 
	 * @param tranzakcioLID a tranzakció azonosítója
	 * @param lakasID a tranzakció lakás azonosítója
	 * @param osszeg a tranzakció összege
	 * @param datum a tranzakció létrejöttének dátuma
	 * @param leiras a tranzakció leírása
	 * @param befizeto a tranzakció kezdeményezője
	 */
	public TranzakcioL(int tranzakcioLID, int lakasID, int osszeg,
			DateTime datum, String leiras, String befizeto) {
		this.tranzakcioLID = tranzakcioLID;
		this.lakasID = lakasID;
		this.osszeg = osszeg;
		this.datum = datum;
		this.leiras = leiras;
		this.befizeto = befizeto;
	}
	
	

	/**
	 * Üres konstruktor, amely lakás tranzakciót hoz létre.
	 */
	public TranzakcioL() {
	}



	/**
	 * A lakás tranzakció azonosítóját adja vissza.
	 * 
	 * @return a lakás tranzakció azonosítója
	 */
	public int getTranzakcioLID() {
		return tranzakcioLID;
	}

	/**
	 * A lakás tranzakció azonosítóját állítja be.
	 * 
	 * @param tranzakcioLID a lakás tranzakció azonosítója
	 */
	public void setTranzakcioLID(int tranzakcioLID) {
		this.tranzakcioLID = tranzakcioLID;
	}

	/**
	 * A lakás azonosítóját adja vissza.
	 * 
	 * @return a lakás azonosítója
	 */
	public int getLakasID() {
		return lakasID;
	}

	/**
	 * A lakás azonosítóját állítja be.
	 * 
	 * @param lakasID a lakás azonosítója
	 */
	public void setLakasID(int lakasID) {
		this.lakasID = lakasID;
	}

	/**
	 * A lakás tranzakció összegét adja vissza.
	 * 
	 * @return a lakás tranzakció összege
	 */
	public int getOsszeg() {
		return osszeg;
	}

	/**
	 * A lakás tranzakció összegét állítja be.
	 * 
	 * @param osszeg a lakás tranzakció összege
	 */
	public void setOsszeg(int osszeg) {
		this.osszeg = osszeg;
	}

	/**
	 * A lakás tranzakció dátumát adja vissza.
	 * 
	 * @return a lakástranzakció dátuma
	 */
	public DateTime getDatum() {
		return datum;
	}

	/**
	 * A lakás tranzakció dátumát állítja be.
	 * 
	 * @param datum a lakás tranzakció dátuma
	 */
	public void setDatum(DateTime datum) {
		this.datum = datum;
	}

	/**
	 * A lakás tranzakció leírását adja vissza.
	 * 
	 * @return a lakás tranzakció leírása
	 */
	public String getLeiras() {
		return leiras;
	}

	/**
	 * A lakás tranzakció leírását állítja be.
	 * 
	 * @param leiras a lakás tranzakció leírása
	 */
	public void setLeiras(String leiras) {
		this.leiras = leiras;
	}

	/**
	 * A lakás tranzakció befizetőjét adja vissza.
	 * 
	 * @return a lakás tranzakció befizetője
	 */
	public String getBefizeto() {
		return befizeto;
	}

	/**
	 * A lakás tranzakció befizetőjét állítja be.
	 * 
	 * @param befizeto a lakás tranzakció befizetője
	 */
	public void setBefizeto(String befizeto) {
		this.befizeto = befizeto;
	}

	@Override
	public String toString() {
		return "Tranzakció L azon=" + tranzakcioLID + ", lakás azon="
				+ lakasID + ", összeg=" + osszeg + ", dátum=" + datum
				+ ", leírás=" + leiras + ", befizető=" + befizeto + "]";
	}
	
	
}
