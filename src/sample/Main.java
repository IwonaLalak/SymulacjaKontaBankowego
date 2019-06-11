package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import system.BankomatFacade;

public class Main extends Application {

    private BankomatFacade bankomatFacade = new BankomatFacade();
    private static Main bankomat = new Main();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("symulacjaBanku.fxml"));
        primaryStage.setTitle("Symulacja konta bankowego");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


        bankomatFacade.wyswietlInformacje("OSOBISTE");
        bankomatFacade.wplac("OSOBISTE",40);
        bankomatFacade.wyswietlInformacje("OSOBISTE");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
