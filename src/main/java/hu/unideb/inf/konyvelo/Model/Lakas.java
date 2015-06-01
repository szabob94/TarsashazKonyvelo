/**
 * 
 */
package hu.unideb.inf.konyvelo.Model;

import java.util.List;

/**
 * Osztály, megy egy lakást reprezentál.
 *
 */
public class Lakas {

	/**
	 * A lakás azonosítója.
	 */
	private int id;
	
	/**
	 * A lakás tulajdonosa.
	 */
	private String Tulajdonos;
	
	/**
	 * A lakás társasház azonosítója.
	 */
	private int TarsashazID;
	
	/**
	 * A lakás emeletének száma.
	 */
	private int emelet;
	
	/**
	 * A lakás ajtajának száma.
	 */
	private int ajto;
	
	/**
	 * A lakás tartozása.
	 */
	private int tartozas;
	
	/**
	 * A lakáshoz tartozó tranzakciók listája.
	 */
	private List<TranzakcioL> tranzakciok;
	
	/**
	 * A lakás bő kostruktora, minden adattaghoz.
	 * 
	 * @param id a lakás azonosítója
	 * @param tulajdonos a lakás tulajdonosa
	 * @param tarsashazID a lakás társasház azonosítója
	 * @param emelet a lakás emeletének száma
	 * @param ajto a lakás ajtajának száma
	 * @param tartozas a lakás tartozása
	 * @param tranzakciok a lakás tranzakcióinak listája
	 */
	public Lakas(int id, String tulajdonos, int tarsashazID, int emelet,
			int ajto, int tartozas, List<TranzakcioL> tranzakciok) {
		this.id = id;
		Tulajdonos = tulajdonos;
		TarsashazID = tarsashazID;
		this.emelet = emelet;
		this.ajto = ajto;
		this.tartozas = tartozas;
		this.tranzakciok=tranzakciok;
	}

	/**
	 * Üres konstruktor, mely egy lakást hoz létre.
	 */
	public Lakas() {
	}

	/**
	 * A lakás azonosítóját adja vissza.
	 * 
	 * @return a lakás azonosítója
	 */
	public int getId() {
		return id;
	}

	/**
	 * A lakás azonosítóját állítja be.
	 * 
	 * @param id a lakás azonosítója
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * A lakás tulajdonosát adja vissza.
	 * 
	 * @return a lakás tulajdonosa
	 */
	public String getTulajdonos() {
		return Tulajdonos;
	}

	/**
	 * A lakás tulajdonosát állítja be.
	 * 
	 * @param tulajdonos a lakát tulajdonosa
	 */
	public void setTulajdonos(String tulajdonos) {
		Tulajdonos = tulajdonos;
	}

	/**
	 * A lakát társasház azonosítóját adja vissza.
	 * 
	 * @return a lakás társasház azonosítója
	 */
	public int getTarsashazID() {
		return TarsashazID;
	}

	/**
	 * A lakás társasház azonosítóját állítja be.
	 * 
	 * @param tarsashazID a lakás társasház azonosítója
	 */
	public void setTarsashazID(int tarsashazID) {
		TarsashazID = tarsashazID;
	}

	/**
	 * A lakás emeletének számát adja vissza.
	 * 
	 * @return a lakás emeletének száma
	 */
	public int getEmelet() {
		return emelet;
	}

	/**
	 * A lakás emeletének számát állítja be.
	 * 
	 * @param emelet a lakás emeletének száma
	 */
	public void setEmelet(int emelet) {
		this.emelet = emelet;
	}

	/**
	 * A lakás ajtajának számát adja vissza.
	 * 
	 * @return A lakás ajtajának száma
	 */
	public int getAjto() {
		return ajto;
	}

	/**
	 * A lakás ajtajának számát állítja be.
	 * 
	 * @param ajto a lakás ajtajának száma
	 */
	public void setAjto(int ajto) {
		this.ajto = ajto;
	}

	/**
	 * A lakás tartozását adja vissza.
	 * 
	 * @return a lakás tartozása
	 */
	public int getTartozas() {
		return tartozas;
	}

	/**
	 * A lakás tartozását állítja be.
	 * 
	 * @param tartozas a lakás tartozása
	 */
	public void setTartozas(int tartozas) {
		this.tartozas = tartozas;
	}

	/**
	 * A lakás tranzakcióinak listáját adja vissza.
	 * 
	 * @return a lakás tranzakcióinak listája
	 */
	public List<TranzakcioL> getTranzakciok() {
		return tranzakciok;
	}

	/**
	 * A lakás tranzakcióinak listáját állítja be.
	 * 
	 * @param tranzakciok a lakás tranzakcióinak listája
	 */
	public void setTranzakciok(List<TranzakcioL> tranzakciok) {
		this.tranzakciok = tranzakciok;
	}

	@Override
	public String toString() {
		return id+"";
	}
	
	public String toString2() {
		return "Lakás azon=" + id + ", Tulajdonos=" + Tulajdonos
				+ ", társasház azon=" + TarsashazID + ", emelet=" + emelet
				+ ", ajtó=" + ajto + ", tartozás=" + tartozas;
	}

	
	
}
