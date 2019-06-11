package sample;


import kontoTypes.E_KontoType;
import system.Operacja;

import java.util.ArrayList;

public interface BankomatFacadeInterface {

    void wplac(E_KontoType typKonta, double kwota);

    void wyswietlInformacje(E_KontoType typKonta);

    double zwrocSaldo(E_KontoType typkonta);

    ArrayList<Operacja> zwrocListeOperacji(E_KontoType typkonta);

}
