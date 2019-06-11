package system;

import kontoTypes.E_KontoType;

import java.util.ArrayList;

interface I_AbstractKonto {
    public abstract E_KontoType getTypKonta();
    public abstract double getStanKonta();
    public abstract String getNazwaKonta();
    public abstract void wplac(double kwota);
    public abstract void wybierz(double kwota);
    public abstract void zrobPrzelew(double kwota, String data, String odbiorca, String opis);
    public abstract ArrayList<Operacja> getListaOperacji();



}
