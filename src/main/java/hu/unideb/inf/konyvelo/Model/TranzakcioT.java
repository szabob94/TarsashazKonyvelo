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

	private int tranzakcioTID;
	private int tarsashazID;
	private int osszeg;
	private DateTime datum;
	private String leiras;
	private String kiiro;
	
	/**
	 * @param tranzakcioTID
	 * @param tarsashazID
	 * @param osszeg
	 * @param datum
	 * @param leiras
	 * @param kiiro
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

	public TranzakcioT() {
	}

	/**
	 * @return the tranzakcioTID
	 */
	public int getTranzakcioTID() {
		return tranzakcioTID;
	}

	/**
	 * @param tranzakcioTID the tranzakcioTID to set
	 */
	public void setTranzakcioTID(int tranzakcioTID) {
		this.tranzakcioTID = tranzakcioTID;
	}

	/**
	 * @return the tarsashazID
	 */
	public int getTarsashazID() {
		return tarsashazID;
	}

	/**
	 * @param tarsashazID the tarsashazID to set
	 */
	public void setTarsashazID(int tarsashazID) {
		this.tarsashazID = tarsashazID;
	}

	/**
	 * @return the osszeg
	 */
	public int getOsszeg() {
		return osszeg;
	}

	/**
	 * @param osszeg the osszeg to set
	 */
	public void setOsszeg(int osszeg) {
		this.osszeg = osszeg;
	}

	/**
	 * @return the datum
	 */
	public DateTime getDatum() {
		return datum;
	}

	/**
	 * @param datum the datum to set
	 */
	public void setDatum(DateTime datum) {
		this.datum = datum;
	}

	/**
	 * @return the leiras
	 */
	public String getLeiras() {
		return leiras;
	}

	/**
	 * @param leiras the leiras to set
	 */
	public void setLeiras(String leiras) {
		this.leiras = leiras;
	}

	/**
	 * @return the kiiro
	 */
	public String getKiiro() {
		return kiiro;
	}

	/**
	 * @param kiiro the kiiro to set
	 */
	public void setKiiro(String kiiro) {
		this.kiiro = kiiro;
	}

	@Override
	public String toString() {
		return "TranzakcioT [tranzakcioTID=" + tranzakcioTID + ", tarsashazID="
				+ tarsashazID + ", osszeg=" + osszeg + ", datum=" + datum
				+ ", leiras=" + leiras + ", kiiro=" + kiiro + "]";
	}
	
}
