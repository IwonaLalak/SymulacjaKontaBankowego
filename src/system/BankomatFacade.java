package system;

import kontoTypes.E_KontoType;
import sample.BankomatFacadeInterface;

import java.util.ArrayList;
import java.util.Iterator;

public class BankomatFacade implements BankomatFacadeInterface {


    private KontoCreator kontoCreator;
    private I_AbstractKonto kontoOsobiste;
    private I_AbstractKonto kontoFirmowe;
    private I_AbstractKonto kontoOszczednosciowe;

    public BankomatFacade() {
        this.kontoCreator = KontoCreator.getInstance();
        this.kontoOsobiste = kontoCreator.create(E_KontoType.OSOBISTE_KONTO);
        this.kontoFirmowe = kontoCreator.create(E_KontoType.FIRMOWE_KONTO);
        this.kontoOszczednosciowe = kontoCreator.create(E_KontoType.OSZCZEDNOSCIOWE_KONTO);
    }


    @Override
    public void wplac(E_KontoType typKonta, double kwota) {
        if(typKonta == E_KontoType.OSOBISTE_KONTO){
            kontoOsobiste.wplac(kwota);
        }
        else if(typKonta == E_KontoType.FIRMOWE_KONTO){
            kontoFirmowe.wplac(kwota);
        }
        else{
            kontoOszczednosciowe.wplac(kwota);
        }
    }

    @Override
    public void wyplac(E_KontoType typKonta, double kwota) {
        if(typKonta == E_KontoType.OSOBISTE_KONTO){
            kontoOsobiste.wybierz(kwota);
        }
        else if(typKonta == E_KontoType.FIRMOWE_KONTO){
            kontoFirmowe.wybierz(kwota);
        }
        else{
            kontoOszczednosciowe.wybierz(kwota);
        }
    }

    @Override
    public void zrobPrzelew(E_KontoType typKonta, double kwota, String data, String odbiorca, String opis) {
        if(typKonta == E_KontoType.OSOBISTE_KONTO){
            kontoOsobiste.zrobPrzelew(kwota,data,odbiorca,opis);
        }
        else if(typKonta == E_KontoType.FIRMOWE_KONTO){
            kontoFirmowe.zrobPrzelew(kwota,data,odbiorca,opis);
        }
        else{
            kontoOszczednosciowe.zrobPrzelew(kwota,data,odbiorca,opis);
        }
    }

    @Override
    public void wyswietlInformacje(E_KontoType typKonta) {

        ArrayList<Operacja> operacje;

        if(typKonta == E_KontoType.OSOBISTE_KONTO){
            operacje = kontoOsobiste.getListaOperacji();
        }
        else if(typKonta == E_KontoType.FIRMOWE_KONTO){
            operacje = kontoFirmowe.getListaOperacji();
        }
        else{
            operacje = kontoOszczednosciowe.getListaOperacji();
        }


        if (operacje.size() == 0) {
            System.out.println("Brak operacji na osobistym koncie");
        } else {

            Iterator<Operacja> i = operacje.listIterator();

            while(i.hasNext()){
                Operacja op = i.next();
                System.out.println(op.getData()+" "+op.getTyp()+" "+op.getOpis()+" "+op.getKwota());
            }

            /*for (Operacja operacja : operacje) {
                System.out.println(operacja.getData() + " " + operacja.getTyp() + " " + operacja.getOpis() + " " + operacja.getKwota());
            }*/
        }
    }

    @Override
    public double zwrocSaldo(E_KontoType typKonta) {
        if(typKonta == E_KontoType.OSOBISTE_KONTO){
           return kontoOsobiste.getStanKonta();
        }
        else if(typKonta == E_KontoType.FIRMOWE_KONTO){
           return kontoFirmowe.getStanKonta();
        }
        else{
           return kontoOszczednosciowe.getStanKonta();
        }
    }

    @Override
    public ArrayList<Operacja> zwrocListeOperacji(E_KontoType typKonta) {

        ArrayList<Operacja> operacje;

        if(typKonta == E_KontoType.OSOBISTE_KONTO){
            operacje = kontoOsobiste.getListaOperacji();
        }
        else if(typKonta == E_KontoType.FIRMOWE_KONTO){
            operacje = kontoFirmowe.getListaOperacji();
        }
        else{
            operacje = kontoOszczednosciowe.getListaOperacji();
        }

        return operacje;
    }
}
