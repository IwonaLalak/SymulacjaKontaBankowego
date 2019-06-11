package system;

import kontoTypes.E_KontoType;

import java.util.ArrayList;

class FirmoweKonto extends AbstractKonto {
    FirmoweKonto() {
        this.kontoType = E_KontoType.OSZCZEDNOSCIOWE_KONTO;
        this.stanKonta = 0;
        this.nazwaKonta = "Konto firmowe";
        this.listaOperacji = new ArrayList<>();
    }

    void setStanKonta(double stan){
        this.stanKonta = stan;
    }
}
