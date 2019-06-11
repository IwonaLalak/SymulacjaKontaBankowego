package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import kontoTypes.E_KontoType;
import system.BankomatFacade;
import system.Operacja;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;


public class Controller {

    private BankomatFacade bankomatFacade = new BankomatFacade();

    /*osobiste*/

    @FXML private Label saldoOsobiste;
    @FXML private TextField inputOsobistePrzelewPrzychodzacy;
    @FXML private TextField inputOsobisteWyplata;

    @FXML public TableView<Operacja> tableOsobiste;
    @FXML public TableColumn<Operacja,String> colOsobisteData;
    @FXML public TableColumn<Operacja,String> colOsobisteTyp;
    @FXML public TableColumn<Operacja,String> colOsobisteNadawca;
    @FXML public TableColumn<Operacja,Double> colOsobisteKwota;
    @FXML public TableColumn<Operacja,String> colOsobisteOpis;


    public void odswiezSaldoKonta(E_KontoType konto){
        if(konto.equals(E_KontoType.OSOBISTE_KONTO)){
            //DecimalFormat decimalFormat = new DecimalFormat("0.##");
            saldoOsobiste.setText(Double.toString(bankomatFacade.zwrocSaldo(E_KontoType.OSOBISTE_KONTO))+" zł");
        }
    }

    public void odswiezOperacje(E_KontoType konto){
        if(konto.equals(E_KontoType.OSOBISTE_KONTO)){

            final ObservableList<Operacja> data = FXCollections.observableArrayList();

            ArrayList<Operacja> operacje = bankomatFacade.zwrocListeOperacji(konto);
            data.addAll(operacje);

            colOsobisteData.setCellValueFactory(new PropertyValueFactory<Operacja,String>("data"));
            colOsobisteTyp.setCellValueFactory(new PropertyValueFactory<Operacja,String>("typ"));
            colOsobisteNadawca.setCellValueFactory(new PropertyValueFactory<Operacja,String>("nadawca"));
            colOsobisteOpis.setCellValueFactory(new PropertyValueFactory<Operacja,String>("opis"));
            colOsobisteKwota.setCellValueFactory(new PropertyValueFactory<Operacja,Double>("kwota"));

            tableOsobiste.setItems(data);
        }
    }

    public void onClickPrzelejNaOsobiste(){

        double kwota = Double.parseDouble(inputOsobistePrzelewPrzychodzacy.getText().replace(",","."));

        if(kwota >0){
            bankomatFacade.wplac(E_KontoType.OSOBISTE_KONTO, kwota);
            this.odswiezSaldoKonta(E_KontoType.OSOBISTE_KONTO);
            this.odswiezOperacje(E_KontoType.OSOBISTE_KONTO);
        }
    }


    public void onClickWplacZOsobistego(){
        double kwota = Double.parseDouble(inputOsobisteWyplata.getText().replace(",","."));
        if(kwota>0){
            bankomatFacade.wyplac(E_KontoType.OSOBISTE_KONTO,kwota);
            this.odswiezSaldoKonta(E_KontoType.OSOBISTE_KONTO);
            this.odswiezOperacje(E_KontoType.OSOBISTE_KONTO);
        }
    }


}
