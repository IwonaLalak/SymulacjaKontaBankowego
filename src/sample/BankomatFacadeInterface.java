package sample;


import kontoTypes.E_KontoType;
import system.Operacja;

import java.util.ArrayList;

public interface BankomatFacadeInterface {

    void wplac(E_KontoType typKonta, double kwota);

    void wyplac(E_KontoType typKonta, double kwota);

    void zrobPrzelew(E_KontoType typKonto, double kwota, String data, String odbiorca, String opis);

    void wyswietlInformacje(E_KontoType typKonta);

    double zwrocSaldo(E_KontoType typkonta);

    ArrayList<Operacja> zwrocListeOperacji(E_KontoType typkonta);

}
