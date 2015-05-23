package hu.unideb.inf.konyvelo;

import java.util.List;

import org.joda.time.DateTime;

import hu.unideb.inf.konyvelo.DAO.DAODelete;
import hu.unideb.inf.konyvelo.DAO.DAOGet;
import hu.unideb.inf.konyvelo.DAO.DAOInsert;
import hu.unideb.inf.konyvelo.DAO.DAOUpdate;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;
import hu.unideb.inf.konyvelo.Model.TranzakcioL;
import hu.unideb.inf.konyvelo.Model.TranzakcioT;

/**
 * Hello world!
 *
 */
public class Main {
	public static void main(String[] args) {
		DAOGet daoGet = new DAOGet();
		List<Tarsashaz> tarsashazak = daoGet.getTarsashazak();
		List<Lakas> lakasok = daoGet.getLakasok();
		List<TranzakcioL> tranzakciokL = daoGet.getTranzakciokL();
		List<TranzakcioT> tranzakciokT = daoGet.getTranzakciokT();

		System.out.println("Társasházak: ");
		for (Tarsashaz tarsashaz : tarsashazak) {
			System.out.println(tarsashaz);
		}

		System.out.println("Lakások: ");
		for (Lakas lakas : lakasok) {
			System.out.println(lakas);
		}

		System.out.println("TranzakciokL: ");
		for (TranzakcioL tranzakcioL : tranzakciokL) {
			System.out.println(tranzakcioL);
		}

		System.out.println("TranzakciokT: ");
		for (TranzakcioT tranzakcioT : tranzakciokT) {
			System.out.println(tranzakcioT);
		}

		DAOUpdate daoUpdate = new DAOUpdate();
		daoUpdate.updateTarsashaz(new Tarsashaz(1, "Nyíregyháza, Mező u. 25",
				180000,null,null));
		tarsashazak = daoGet.getTarsashazak();
		System.out.println("Társasházak: ");
		for (Tarsashaz tarsashaz : tarsashazak) {
			System.out.println(tarsashaz);
		}

		daoUpdate.updateLakas(new Lakas(1, "Kiss Alexandra", 1, 1, 1, 20000,null));
		lakasok = daoGet.getLakasok();
		System.out.println("Lakások: ");
		for (Lakas lakas : lakasok) {
			System.out.println(lakas);
		}

		daoUpdate.updateTranzakcioL(new TranzakcioL(1, 1, 30000, new DateTime(
				2015, 5, 8, 13, 40), "Rongálás", "Kiss Csilla"));
		tranzakciokL = daoGet.getTranzakciokL();
		System.out.println("TranzakciokL: ");
		for (TranzakcioL tranzakcioL : tranzakciokL) {
			System.out.println(tranzakcioL);
		}

		daoUpdate.updateTranzakcioT(new TranzakcioT(1, 1, 140000, new DateTime(
				2015, 5, 8, 14, 00), "Gáz", "Gáz szolgáltató kft."));
		tranzakciokT = daoGet.getTranzakciokT();
		System.out.println("TranzakciokT: ");
		for (TranzakcioT tranzakcioT : tranzakciokT) {
			System.out.println(tranzakcioT);
		}

		DAOInsert daoInsert = new DAOInsert();
		daoInsert.insertTarsashaz(new Tarsashaz(3,
				"Nyíregyháza, Arany János u. 25", 0,null,null));
		daoInsert.insertLakas(new Lakas(46, "Szabó Bence", 3, 1, 1, 0,null));
		daoInsert.insertTranzakcioL(new TranzakcioL(2, 3, 4000, new DateTime(
				2015, 5, 8, 15, 00), "valami", "Szabó Bence"));
		daoInsert.insertTranzakcioT(new TranzakcioT(2, 3, 50000, new DateTime(
				2015, 5, 8, 16, 00), "Áram", "Áram szolgáltató"));

		tarsashazak = daoGet.getTarsashazak();
		lakasok = daoGet.getLakasok();
		tranzakciokL = daoGet.getTranzakciokL();
		tranzakciokT = daoGet.getTranzakciokT();

		System.out.println("Társasházak: ");
		for (Tarsashaz tarsashaz : tarsashazak) {
			System.out.println(tarsashaz);
		}

		System.out.println("Lakások: ");
		for (Lakas lakas : lakasok) {
			System.out.println(lakas);
		}

		System.out.println("TranzakciokL: ");
		for (TranzakcioL tranzakcioL : tranzakciokL) {
			System.out.println(tranzakcioL);
		}

		System.out.println("TranzakciokT: ");
		for (TranzakcioT tranzakcioT : tranzakciokT) {
			System.out.println(tranzakcioT);
		}
		
		DAODelete daoDelete = new DAODelete();
		TranzakcioL valami=new TranzakcioL();
		valami.setTranzakcioLID(5);
		daoDelete.deleteTranzakcioL(valami);

	}
}
