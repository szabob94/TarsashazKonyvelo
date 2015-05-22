/**
 * 
 */
package hu.unideb.inf.konyvelo.Model;

/**
 * @author Bence
 *
 */
public class Lakas {

	private int id;
	private String Tulajdonos;
	private int TarsashazID;
	private int emelet;
	private int ajto;
	private int tartozas;
	
	/**
	 * @param id
	 * @param tulajdonos
	 * @param tarsashazID
	 * @param emelet
	 * @param ajto
	 * @param tartozas
	 */
	public Lakas(int id, String tulajdonos, int tarsashazID, int emelet,
			int ajto, int tartozas) {
		this.id = id;
		Tulajdonos = tulajdonos;
		TarsashazID = tarsashazID;
		this.emelet = emelet;
		this.ajto = ajto;
		this.tartozas = tartozas;
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
	 * @return the tulajdonos
	 */
	public String getTulajdonos() {
		return Tulajdonos;
	}

	/**
	 * @param tulajdonos the tulajdonos to set
	 */
	public void setTulajdonos(String tulajdonos) {
		Tulajdonos = tulajdonos;
	}

	/**
	 * @return the tarsashazID
	 */
	public int getTarsashazID() {
		return TarsashazID;
	}

	/**
	 * @param tarsashazID the tarsashazID to set
	 */
	public void setTarsashazID(int tarsashazID) {
		TarsashazID = tarsashazID;
	}

	/**
	 * @return the emelet
	 */
	public int getEmelet() {
		return emelet;
	}

	/**
	 * @param emelet the emelet to set
	 */
	public void setEmelet(int emelet) {
		this.emelet = emelet;
	}

	/**
	 * @return the ajto
	 */
	public int getAjto() {
		return ajto;
	}

	/**
	 * @param ajto the ajto to set
	 */
	public void setAjto(int ajto) {
		this.ajto = ajto;
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

	@Override
	public String toString() {
		return "Lakas [id=" + id + ", Tulajdonos=" + Tulajdonos
				+ ", TarsashazID=" + TarsashazID + ", emelet=" + emelet
				+ ", ajto=" + ajto + ", tartozas=" + tartozas + "]";
	}
	
	
}
