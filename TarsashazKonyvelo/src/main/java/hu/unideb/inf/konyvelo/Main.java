package hu.unideb.inf.konyvelo;

import java.util.List;

import hu.unideb.inf.konyvelo.DAO.DAO;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;
import hu.unideb.inf.konyvelo.Model.TranzakcioL;
import hu.unideb.inf.konyvelo.Model.TranzakcioT;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        DAO dao = new DAO();
        List<Tarsashaz> tarsashazak=dao.getTarsashazak();
        List<Lakas> lakasok=dao.getLakasok();
        List<TranzakcioL> tranzakciokL = dao.getTranzakcioL();
        List<TranzakcioT> tranzakciokT = dao.getTranzakcioT();
        
        System.out.println("Társasházak: ");
        for (Tarsashaz tarsashaz:tarsashazak){
        	System.out.println(tarsashaz);
        }
        
        System.out.println("Lakások: ");
        for (Lakas lakas:lakasok){
        	System.out.println(lakas);
        }
        
        System.out.println("TranzakciokL: ");
        for (TranzakcioL tranzakcioL:tranzakciokL){
        	System.out.println(tranzakcioL);
        }
        
        System.out.println("TranzakciokT: ");
        for (TranzakcioT tranzakcioT:tranzakciokT){
        	System.out.println(tranzakcioT);
        }
    }
}
