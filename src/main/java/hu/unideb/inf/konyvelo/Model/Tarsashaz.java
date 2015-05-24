/**
 * 
 */
package hu.unideb.inf.konyvelo.Model;

import java.util.List;

/**
 * @author Bence
 *
 */
public class Tarsashaz {

	private int id;
	private String cim;
	private int emeletszam;
	private int lakasszam;
	private int tartozas;
	private List<Lakas> lakasok;
	private List<TranzakcioT> tranzakcioTk;

	/**
	 * @param id
	 * @param cim
	 * @param emeletszam
	 * @param lakasszam
	 * @param tartozas
	 * @param lakasok
	 * @param tranzakcioTk
	 */
	public Tarsashaz(int id, String cim, int emeletszam, int lakasszam,
			int tartozas, List<Lakas> lakasok, List<TranzakcioT> tranzakcioTk) {
		super();
		this.id = id;
		this.cim = cim;
		this.emeletszam = emeletszam;
		this.lakasszam = lakasszam;
		this.tartozas = tartozas;
		this.lakasok = lakasok;
		this.tranzakcioTk = tranzakcioTk;
	}

	public Tarsashaz() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the cim
	 */
	public String getCim() {
		return cim;
	}

	/**
	 * @param cim the cim to set
	 */
	public void setCim(String cim) {
		this.cim = cim;
	}

	/**
	 * @return the tartozas
	 */
	public int getTartozas() {
		return tartozas;
	}

	/**
	 * @param tartozas the tartozas to set
	 */
	public void setTartozas(int tartozas) {
		this.tartozas = tartozas;
	}

	/**
	 * @return the lakasok
	 */
	public List<Lakas> getLakasok() {
		return lakasok;
	}

	/**
	 * @param lakasok the lakasok to set
	 */
	public void setLakasok(List<Lakas> lakasok) {
		this.lakasok = lakasok;
	}

	/**
	 * @return the tranzakcioTk
	 */
	public List<TranzakcioT> getTranzakcioTk() {
		return tranzakcioTk;
	}

	/**
	 * @param tranzakcioTk the tranzakcioTk to set
	 */
	public void setTranzakcioTk(List<TranzakcioT> tranzakcioTk) {
		this.tranzakcioTk = tranzakcioTk;
	}

	public int getEmeletszam() {
		return emeletszam;
	}

	public void setEmeletszam(int emeletszam) {
		this.emeletszam = emeletszam;
	}

	public int getLakasszam() {
		return lakasszam;
	}

	public void setLakasszam(int lakasszam) {
		this.lakasszam = lakasszam;
	}

	@Override
	public String toString() {
		return "Tarsashaz [id=" + id + ", cim=" + cim + ", emeletszam="
				+ emeletszam + ", lakasszam=" + lakasszam + ", tartozas="
				+ tartozas + ", lakasok=" + lakasok + ", tranzakcioTk="
				+ tranzakcioTk + "]";
	}
	
}
