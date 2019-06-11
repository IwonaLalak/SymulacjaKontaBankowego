package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import kontoTypes.E_KontoType;
import system.BankomatFacade;
import system.Operacja;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;



public class Controller {

    private BankomatFacade bankomatFacade = new BankomatFacade();


    /*osobiste*/

    @FXML
    private Label saldoOsobiste;
    @FXML
    private TextField inputOsobistePrzelewPrzychodzacy;
    @FXML
    private TextField inputOsobisteWyplata;

    @FXML
    private DatePicker inputOsobistePrzelewData;
    @FXML
    private TextField inputOsobistePrzelewOdbiorca;
    @FXML
    private TextField inputOsobistePrzelewOpis;
    @FXML
    private TextField inputOsobistePrzelewKwota;

    @FXML
    public TableView<Operacja> tableOsobiste;
    @FXML
    public TableColumn<Operacja, String> colOsobisteData;
    @FXML
    public TableColumn<Operacja, String> colOsobisteTyp;
    @FXML
    public TableColumn<Operacja, String> colOsobisteNadawca;
    @FXML
    public TableColumn<Operacja, Double> colOsobisteKwota;
    @FXML
    public TableColumn<Operacja, String> colOsobisteOpis;


    /*Oszczednosciowe*/
    @FXML
    private Label saldoFirmowe;

    @FXML
    private TextField inputFirmowePrzelewOdbiorca;
    @FXML
    private DatePicker inputFirmowePrzelewData;
    @FXML
    private TextField inputFirmowePrzelewOpis;
    @FXML
    private TextField inputFirmowePrzelewKwota;

    @FXML
    private TextField inputFirmowePrzelewPrzychodzacy;
    @FXML
    private TextField inputFirmoweWyplata;

    @FXML
    public TableView<Operacja> tableFirmowe;
    @FXML
    public TableColumn<Operacja, String> colFirmoweData;
    @FXML
    public TableColumn<Operacja, String> colFirmoweTyp;
    @FXML
    public TableColumn<Operacja, String> colFirmoweNadawca;
    @FXML
    public TableColumn<Operacja, Double> colFirmoweKwota;
    @FXML
    public TableColumn<Operacja, String> colFirmoweOpis;

    /*oszczednosciowe*/

    @FXML
    private Label saldoOszczednosciowe;

    @FXML
    private TextField inputOszczednosciowePrzelewOdbiorca;
    @FXML
    private DatePicker inputOszczednosciowePrzelewData;
    @FXML
    private TextField inputOszczednosciowePrzelewOpis;
    @FXML
    private TextField inputOszczednosciowePrzelewKwota;

    @FXML
    private TextField inputOszczednosciowePrzelewPrzychodzacy;
    @FXML
    private TextField inputOszczednoscioweWyplata;

    @FXML
    public TableView<Operacja> tableOszczednosciowe;
    @FXML
    public TableColumn<Operacja, String> colOszczednoscioweData;
    @FXML
    public TableColumn<Operacja, String> colOszczednoscioweTyp;
    @FXML
    public TableColumn<Operacja, String> colOszczednoscioweNadawca;
    @FXML
    public TableColumn<Operacja, Double> colOszczednoscioweKwota;
    @FXML
    public TableColumn<Operacja, String> colOszczednoscioweOpis;



    public void odswiezSaldoKonta(E_KontoType konto) {
        if (konto.equals(E_KontoType.OSOBISTE_KONTO)) {
            saldoOsobiste.setText(Double.toString(bankomatFacade.zwrocSaldo(E_KontoType.OSOBISTE_KONTO)) + " zł");
        }
        else if(konto.equals(E_KontoType.FIRMOWE_KONTO)){
            saldoFirmowe.setText(Double.toString(bankomatFacade.zwrocSaldo(E_KontoType.FIRMOWE_KONTO)) + " zł");
        }
        else if(konto.equals(E_KontoType.OSZCZEDNOSCIOWE_KONTO)){
            saldoOszczednosciowe.setText(Double.toString(bankomatFacade.zwrocSaldo(E_KontoType.OSZCZEDNOSCIOWE_KONTO)) + " zł");
        }

    }

    public void odswiezOperacje(E_KontoType konto) {
        if (konto.equals(E_KontoType.OSOBISTE_KONTO)) {

            final ObservableList<Operacja> data = FXCollections.observableArrayList();

            ArrayList<Operacja> operacje = bankomatFacade.zwrocListeOperacji(konto);
            data.addAll(operacje);

            colOsobisteData.setCellValueFactory(new PropertyValueFactory<Operacja, String>("data"));
            colOsobisteTyp.setCellValueFactory(new PropertyValueFactory<Operacja, String>("typ"));
            colOsobisteNadawca.setCellValueFactory(new PropertyValueFactory<Operacja, String>("nadawca"));
            colOsobisteOpis.setCellValueFactory(new PropertyValueFactory<Operacja, String>("opis"));
            colOsobisteKwota.setCellValueFactory(new PropertyValueFactory<Operacja, Double>("kwota"));

            tableOsobiste.setItems(data);
        }
        else if (konto.equals(E_KontoType.FIRMOWE_KONTO)){
            final ObservableList<Operacja> data = FXCollections.observableArrayList();

            ArrayList<Operacja> operacje = bankomatFacade.zwrocListeOperacji(konto);
            data.addAll(operacje);

            colFirmoweData.setCellValueFactory(new PropertyValueFactory<Operacja, String>("data"));
            colFirmoweTyp.setCellValueFactory(new PropertyValueFactory<Operacja, String>("typ"));
            colFirmoweNadawca.setCellValueFactory(new PropertyValueFactory<Operacja, String>("nadawca"));
            colFirmoweOpis.setCellValueFactory(new PropertyValueFactory<Operacja, String>("opis"));
            colFirmoweKwota.setCellValueFactory(new PropertyValueFactory<Operacja, Double>("kwota"));

            tableFirmowe.setItems(data);
        }
        else if (konto.equals(E_KontoType.OSZCZEDNOSCIOWE_KONTO)){
            final ObservableList<Operacja> data = FXCollections.observableArrayList();

            ArrayList<Operacja> operacje = bankomatFacade.zwrocListeOperacji(konto);
            data.addAll(operacje);

            colOszczednoscioweData.setCellValueFactory(new PropertyValueFactory<Operacja, String>("data"));
            colOszczednoscioweTyp.setCellValueFactory(new PropertyValueFactory<Operacja, String>("typ"));
            colOszczednoscioweNadawca.setCellValueFactory(new PropertyValueFactory<Operacja, String>("nadawca"));
            colOszczednoscioweOpis.setCellValueFactory(new PropertyValueFactory<Operacja, String>("opis"));
            colOszczednoscioweKwota.setCellValueFactory(new PropertyValueFactory<Operacja, Double>("kwota"));

            tableOszczednosciowe.setItems(data);
        }
    }

    public void showAlertAboutInput(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Symulator konta bankowego");
        alert.setHeaderText("Proszę uzupełnić wymagane dane");
        alert.showAndWait();
    }

    /*osobiste*/

    public void onClickPrzelejNaOsobiste() {
        if (inputOsobistePrzelewPrzychodzacy.getText().length() > 0) {
            double kwota = Double.parseDouble(inputOsobistePrzelewPrzychodzacy.getText().replace(",", "."));

            if (kwota > 0) {
                bankomatFacade.wplac(E_KontoType.OSOBISTE_KONTO, kwota);
                this.odswiezSaldoKonta(E_KontoType.OSOBISTE_KONTO);
                this.odswiezOperacje(E_KontoType.OSOBISTE_KONTO);
            }
        } else this.showAlertAboutInput();
    }


    public void onClickWplacZOsobistego() {
        if (inputOsobisteWyplata.getText().length() > 0) {
            double kwota = Double.parseDouble(inputOsobisteWyplata.getText().replace(",", "."));
            if (kwota > 0) {
                bankomatFacade.wyplac(E_KontoType.OSOBISTE_KONTO, kwota);
                this.odswiezSaldoKonta(E_KontoType.OSOBISTE_KONTO);
                this.odswiezOperacje(E_KontoType.OSOBISTE_KONTO);
            }
        } else this.showAlertAboutInput();
    }

    public void onClickWykonajPrzelewZOsobistego() {
        if (inputOsobistePrzelewKwota.getText().length() > 0) {
            double kwota = Double.parseDouble(inputOsobistePrzelewKwota.getText().replace(",", "."));
            String odbiorca = inputOsobistePrzelewOdbiorca.getText();
            String opis = inputOsobistePrzelewOpis.getText();
            String data = "";

            if (kwota > 0 && odbiorca.length() > 0) {

                if(inputOsobistePrzelewData.getValue()!=null){
                    data = inputOsobistePrzelewData.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                }else{
                    data = Main.returnTodayDate();
                }

                bankomatFacade.zrobPrzelew(E_KontoType.OSOBISTE_KONTO, kwota, data, odbiorca, opis);
                this.odswiezSaldoKonta(E_KontoType.OSOBISTE_KONTO);
                this.odswiezOperacje(E_KontoType.OSOBISTE_KONTO);
            } else this.showAlertAboutInput();
        } else this.showAlertAboutInput();

    }

    /*firmowe*/

    public void onClickWykonajPrzelewZFirmowego(){
        if (inputFirmowePrzelewKwota.getText().length() > 0) {
            double kwota = Double.parseDouble(inputFirmowePrzelewKwota.getText().replace(",", "."));
            String odbiorca = inputFirmowePrzelewOdbiorca.getText();
            String opis = inputFirmowePrzelewOpis.getText();
            String data = "";

            if (kwota > 0 && odbiorca.length() > 0) {

                if(inputFirmowePrzelewData.getValue()!=null){
                    data = inputFirmowePrzelewData.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                }else{
                    data = Main.returnTodayDate();
                }

                bankomatFacade.zrobPrzelew(E_KontoType.FIRMOWE_KONTO, kwota, data, odbiorca, opis);
                this.odswiezSaldoKonta(E_KontoType.FIRMOWE_KONTO);
                this.odswiezOperacje(E_KontoType.FIRMOWE_KONTO);
            } else this.showAlertAboutInput();
        } else this.showAlertAboutInput();
    }

    public void onClickWplacZFirmowego(){
        if (inputFirmoweWyplata.getText().length() > 0) {
            double kwota = Double.parseDouble(inputFirmoweWyplata.getText().replace(",", "."));
            if (kwota > 0) {
                bankomatFacade.wyplac(E_KontoType.FIRMOWE_KONTO, kwota);
                this.odswiezSaldoKonta(E_KontoType.FIRMOWE_KONTO);
                this.odswiezOperacje(E_KontoType.FIRMOWE_KONTO);
            }
        } else this.showAlertAboutInput();
    }

    public void onClickPrzelejNaFirmowe(){
        if (inputFirmowePrzelewPrzychodzacy.getText().length() > 0) {
            double kwota = Double.parseDouble(inputFirmowePrzelewPrzychodzacy.getText().replace(",", "."));

            if (kwota > 0) {
                bankomatFacade.wplac(E_KontoType.FIRMOWE_KONTO, kwota);
                this.odswiezSaldoKonta(E_KontoType.FIRMOWE_KONTO);
                this.odswiezOperacje(E_KontoType.FIRMOWE_KONTO);
            }
        } else this.showAlertAboutInput();
    }

    /*oszczednosiowe*/

    public void onClickWykonajPrzelewZOszczednosciowego(){
        if (inputOszczednosciowePrzelewKwota.getText().length() > 0) {
            double kwota = Double.parseDouble(inputOszczednosciowePrzelewKwota.getText().replace(",", "."));
            String odbiorca = inputOszczednosciowePrzelewOdbiorca.getText();
            String opis = inputOszczednosciowePrzelewOpis.getText();
            String data = "";

            if (kwota > 0 && odbiorca.length() > 0) {

                if(inputOszczednosciowePrzelewData.getValue()!=null){
                    data = inputOszczednosciowePrzelewData.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                }else{
                    data = Main.returnTodayDate();
                }

                bankomatFacade.zrobPrzelew(E_KontoType.OSZCZEDNOSCIOWE_KONTO, kwota, data, odbiorca, opis);
                this.odswiezSaldoKonta(E_KontoType.OSZCZEDNOSCIOWE_KONTO);
                this.odswiezOperacje(E_KontoType.OSZCZEDNOSCIOWE_KONTO);
            } else this.showAlertAboutInput();
        } else this.showAlertAboutInput();
    }

    public void onClickWplacZOszczednosciowego(){
        if (inputOszczednoscioweWyplata.getText().length() > 0) {
            double kwota = Double.parseDouble(inputOszczednoscioweWyplata.getText().replace(",", "."));
            if (kwota > 0) {
                bankomatFacade.wyplac(E_KontoType.OSZCZEDNOSCIOWE_KONTO, kwota);
                this.odswiezSaldoKonta(E_KontoType.OSZCZEDNOSCIOWE_KONTO);
                this.odswiezOperacje(E_KontoType.OSZCZEDNOSCIOWE_KONTO);
            }
        } else this.showAlertAboutInput();
    }

    public void onClickPrzelejNaOszczednosciowe(){
        if (inputOszczednosciowePrzelewPrzychodzacy.getText().length() > 0) {
            double kwota = Double.parseDouble(inputOszczednosciowePrzelewPrzychodzacy.getText().replace(",", "."));

            if (kwota > 0) {
                bankomatFacade.wplac(E_KontoType.OSZCZEDNOSCIOWE_KONTO, kwota);
                this.odswiezSaldoKonta(E_KontoType.OSZCZEDNOSCIOWE_KONTO);
                this.odswiezOperacje(E_KontoType.OSZCZEDNOSCIOWE_KONTO);
            }
        } else this.showAlertAboutInput();
    }
}
