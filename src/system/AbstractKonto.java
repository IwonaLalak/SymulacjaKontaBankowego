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
       this.dodajOperacje(kwota, "PRZYCHÓD", "Wpłata na konto");
   }

   @Override
   public void wybierz(double kwota){
       if(this.stanKonta - kwota <0){
           System.out.println("Nie można wykonać operacji - brak wystarczających środków na koncie");
       }
       else{
           this.stanKonta = this.stanKonta - kwota;
           this.dodajOperacje(kwota, "OBCIĄŻENIE", "Wypłata z system");
       }
   }

   @Override
   public ArrayList<Operacja> getListaOperacji(){
       return listaOperacji;
   }

   void dodajOperacje(double kwota, String typ, String opis){
       Operacja operacja = new Operacja("2019-05-01",typ,opis,kwota);
       this.listaOperacji.add(operacja);
   }

}
