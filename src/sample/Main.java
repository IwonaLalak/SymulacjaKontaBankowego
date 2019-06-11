package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("symulacjaBanku.fxml"));
        primaryStage.setTitle("Symulacja konta bankowego");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    static public String returnTodayDate(){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(Calendar.getInstance().getTime());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
