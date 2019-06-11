package system;

import kontoTypes.E_KontoType;

class KontoCreator implements I_KontoCreator {

    private static KontoCreator Instance;

    private KontoCreator(){}

    static synchronized KontoCreator getInstance() {
        if(Instance == null){
            Instance = new KontoCreator();
        }
        return Instance;
    }

    @Override
    public I_AbstractKonto create(E_KontoType kontoType) {

        I_AbstractKonto konto;

        switch(kontoType){

            case OSOBISTE_KONTO :
                OsobisteKonto osobisteKonto = new OsobisteKonto();
                osobisteKonto.setStanKonta(20.5);
                konto = osobisteKonto;
                break;

            case FIRMOWE_KONTO:
                FirmoweKonto firmoweKonto = new FirmoweKonto();
                firmoweKonto.setStanKonta(0);
                konto = firmoweKonto;
                break;

            case OSZCZEDNOSCIOWE_KONTO:
                OszczednoscioweKonto oszczednoscioweKonto = new OszczednoscioweKonto();
                oszczednoscioweKonto.setStanKonta(1.0);
                konto = oszczednoscioweKonto;
                break;
            default:
                konto = null;
                break;
        }

        return konto;
    }
}
