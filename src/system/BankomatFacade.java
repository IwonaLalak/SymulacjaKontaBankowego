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
    public void wplac(String typKonta, double kwota) {
        if(typKonta == "OSOBISTE"){
            kontoOsobiste.wplac(kwota);
        }
        else if(typKonta == "FIRMOWE"){
            kontoFirmowe.wplac(kwota);
        }
        else{
            kontoOszczednosciowe.wplac(kwota);
        }
    }

    @Override
    public void wyswietlInformacje(String typKonta) {

        ArrayList<Operacja> operacje;

        if(typKonta == "OSOBISTE"){
            operacje = kontoOsobiste.getListaOperacji();
        }
        else if(typKonta == "FIRMOWE"){
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
}
