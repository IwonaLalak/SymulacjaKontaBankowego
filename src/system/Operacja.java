package system;

public class Operacja {
    protected String data;
    protected String typ;
    protected String opis;
    protected String nadawca;
    protected double kwota;

    public Operacja(String data, String typ, String nadawca,String opis, double kwota) {
        this.data = data;
        this.typ = typ;
        this.nadawca = nadawca;
        this.opis = opis;
        this.kwota = kwota;
    }

    public String getData() {
        return data;
    }

    public String getTyp() {
        return typ;
    }

    public String getNadawca(){return nadawca;}

    public String getOpis() {
        return opis;
    }

    public double getKwota() {
        return kwota;
    }

}
