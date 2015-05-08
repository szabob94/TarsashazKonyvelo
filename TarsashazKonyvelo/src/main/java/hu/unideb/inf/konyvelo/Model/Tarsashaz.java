/**
 * 
 */
package hu.unideb.inf.konyvelo.Model;

/**
 * @author Bence
 *
 */
public class Tarsashaz {

	private int id;
	private String cim;
	private int tartozas;
	
	/**
	 * @param id
	 * @param cim
	 * @param tartozas
	 */
	public Tarsashaz(int id, String cim, int tartozas) {
		this.id = id;
		this.cim = cim;
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

	@Override
	public String toString() {
		return "Tarsashaz [id=" + id + ", cim=" + cim + ", tartozas="
				+ tartozas + "]";
	}
		
	
}
