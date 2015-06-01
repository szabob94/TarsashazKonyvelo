/**
 * 
 */
package hu.unideb.inf.konyvelo.Model;

import java.util.List;

/**
 * Osztály, amely a társasházakat reprezentálja.
 */
public class Tarsashaz {

	/**
	 * A társasház azonosítója.
	 */
	private int id;
	
	/**
	 * A társasház címe.
	 */
	private String cim;
	
	/**
	 * A társasház emeleteinek száma.
	 */
	private int emeletszam;
	
	/**
	 * A társasház lakásainak száma.
	 */
	private int lakasszam;
	
	/**
	 * A társasház tartozása.
	 */
	private int tartozas;
	
	/**
	 * A társasházhoz tartozó lakások listája.
	 */
	private List<Lakas> lakasok;
	
	/**
	 * A társasházhoz tartozó társasház tranzakciók listája.
	 */
	private List<TranzakcioT> tranzakcioTk;

	/**
	 * Bő konstruktor, amely minden adattagot felhasznál.
	 * 
	 * @param id a társasház azonosítója
	 * @param cim a társasház címe
	 * @param emeletszam a társasház emeleteinek száma
	 * @param lakasszam a társasház lakásainak száma
	 * @param tartozas a társasház tartozása
	 * @param lakasok a társasházhoz tartozó lakások listája
	 * @param tranzakcioTk a társasháthoz tartozó társasház tranzakciók listája
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

	/**
	 * Üres konstruktor, amely társasházat hoz létre.
	 */
	public Tarsashaz() {
	}

	/**
	 * A társasház azonosítóját adja vissza.
	 * 
	 * @return a társasház azonosítója
	 */
	public int getId() {
		return id;
	}

	/**
	 * A társasház azonosítóját állítja be.
	 * 
	 * @param id a társasház azonosítója
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * A társasház címét adja vissza.
	 * 
	 * @return a társasház címe
	 */
	public String getCim() {
		return cim;
	}

	/**
	 * A társasház címét állítja be.
	 * 
	 * @param cim a társasház címe
	 */
	public void setCim(String cim) {
		this.cim = cim;
	}

	/**
	 * A társasház tartozását adja vissza.
	 * 
	 * @return a társasház tartozása
	 */
	public int getTartozas() {
		return tartozas;
	}

	/**
	 * A társasház tartozását állítja be.
	 * 
	 * @param tartozas a társasház tartozása
	 */
	public void setTartozas(int tartozas) {
		this.tartozas = tartozas;
	}

	/**
	 * A társasház lakásainak listáját adja vissza.
	 * 
	 * @return a társasház lakásainak listája
	 */
	public List<Lakas> getLakasok() {
		return lakasok;
	}

	/**
	 * A társasház lakásainak listáját állítja be.
	 * 
	 * @param lakasok a társasház lakásainak listája
	 */
	public void setLakasok(List<Lakas> lakasok) {
		this.lakasok = lakasok;
	}

	/**
	 * A társasház tranzakcióinak listáját adja vissza.
	 * 
	 * @return a társasház tranzakcióinak listája
	 */
	public List<TranzakcioT> getTranzakcioTk() {
		return tranzakcioTk;
	}

	/**
	 * A társashát tranzakcióinak listáját állítja be.
	 * 
	 * @param tranzakcioTk a társasház tranzakciók listája
	 */
	public void setTranzakcioTk(List<TranzakcioT> tranzakcioTk) {
		this.tranzakcioTk = tranzakcioTk;
	}

	/**
	 * A társasház emeleteinek számát adja vissza.
	 * 
	 * @return a társasház emeleteinek száma
	 */
	public int getEmeletszam() {
		return emeletszam;
	}

	/**
	 * A társasház emeleteinek számát állítja be.
	 * 
	 * @param emeletszam a társasház emeleteinek száma
	 */
	public void setEmeletszam(int emeletszam) {
		this.emeletszam = emeletszam;
	}

	/**
	 * A társasház lakásainak számát adja vissza.
	 * 
	 * @return a társasház lakásainak száma
	 */
	public int getLakasszam() {
		return lakasszam;
	}

	/**
	 * A társasház lakásainak számát állítja be.
	 * 
	 * @param lakasszam a társasház lakásainak száma
	 */
	public void setLakasszam(int lakasszam) {
		this.lakasszam = lakasszam;
	}

	@Override
	public String toString() {
		return id+"";
	}
	
	public String toString2() {
		return "Társasház azon=" + id + ", cim=" + cim + ", emeletszám="
				+ emeletszam + ", lakásszám=" + lakasszam + ", tartozás="
				+ tartozas;
	}
	
}
