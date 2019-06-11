package system;

import kontoTypes.E_KontoType;

import java.util.ArrayList;

abstract class AbstractKonto implements I_AbstractKonto{
   protected E_KontoType kontoType;
   protected double stanKonta;
   protected String nazwaKonta;
   protected ArrayList<Operacja> listaOperacji;


   @Override
   public E_KontoType getTypKonta() {
       return kontoType;
   }

   @Override
   public double getStanKonta() {
       return stanKonta;
   }

   @Override
   public String getNazwaKonta() {
       return nazwaKonta;
   }

   @Override
   public void wplac(double kwota){
       this.stanKonta = this.stanKonta + kwota;
       this.dodajOperacje(kwota, "PRZYCHÓD","Przykładowa firma 3421 0340 0000 3842", "Wpłata na konto","2019-06-01");
   }

   @Override
   public void wybierz(double kwota){
       if(this.stanKonta - kwota <0){
           System.out.println("Nie można wykonać operacji - brak wystarczających środków na koncie");
       }
       else{
           this.stanKonta = this.stanKonta - kwota;
           this.dodajOperacje(kwota, "OBCIĄŻENIE","-", "Wypłata z system", "2019-06-01");
       }
   }

   @Override
   public void zrobPrzelew(double kwota, String data, String odbiorca, String opis){
       if(this.stanKonta - kwota <0){
           System.out.println("Nie można wykonać operacji - brak wystarczających środków na koncie");
       }
       else{
           this.stanKonta = this.stanKonta - kwota;
           this.dodajOperacje(kwota, "OBCIĄŻENIE",odbiorca, opis, data);
       }
   }

   @Override
   public ArrayList<Operacja> getListaOperacji(){
       return listaOperacji;
   }

   void dodajOperacje(double kwota, String typ, String nadawca,String opis, String data){
       Operacja operacja = new Operacja(data,typ,nadawca,opis,kwota);
       this.listaOperacji.add(operacja);
   }

}
