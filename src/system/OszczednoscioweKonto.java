package system;

import kontoTypes.E_KontoType;

import java.util.ArrayList;

class OszczednoscioweKonto extends AbstractKonto {
    OszczednoscioweKonto() {
        this.kontoType = E_KontoType.OSZCZEDNOSCIOWE_KONTO;
        this.stanKonta = 0;
        this.nazwaKonta = "Konto oszczędnościowe";
        this.listaOperacji = new ArrayList<>();
    }

    void setStanKonta(double stan){
        this.stanKonta = stan;
    }
}
