/**
 * 
 */
package hu.unideb.inf.konyvelo.Model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.joda.time.DateTime;

/**
 * @author Bence
 *
 */
public class TranzakcioL {

	private int tranzakcioLID;
	private int lakasID;
	private int osszeg;
	private DateTime datum;
	private String leiras;
	private String befizeto;
	
	/**
	 * @param tranzakcioLID
	 * @param lakasID
	 * @param osszeg
	 * @param datum
	 * @param leiras
	 * @param befizeto
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
	 * 
	 */
	public TranzakcioL() {
	}



	/**
	 * @return the tranzakcioLID
	 */
	public int getTranzakcioLID() {
		return tranzakcioLID;
	}

	/**
	 * @param tranzakcioLID the tranzakcioLID to set
	 */
	public void setTranzakcioLID(int tranzakcioLID) {
		this.tranzakcioLID = tranzakcioLID;
	}

	/**
	 * @return the lakasID
	 */
	public int getLakasID() {
		return lakasID;
	}

	/**
	 * @param lakasID the lakasID to set
	 */
	public void setLakasID(int lakasID) {
		this.lakasID = lakasID;
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
	 * @return the befizeto
	 */
	public String getBefizeto() {
		return befizeto;
	}

	/**
	 * @param befizeto the befizeto to set
	 */
	public void setBefizeto(String befizeto) {
		this.befizeto = befizeto;
	}

	@Override
	public String toString() {
		return "TranzakcioL [tranzakcioLID=" + tranzakcioLID + ", lakasID="
				+ lakasID + ", osszeg=" + osszeg + ", datum=" + datum
				+ ", leiras=" + leiras + ", befizeto=" + befizeto + "]";
	}
	
	
}
