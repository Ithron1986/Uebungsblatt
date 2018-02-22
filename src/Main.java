import datenbank.Datenbank;
import datenbank.UserSpeicher;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import model.AddressBuilder;
import model.Adresse;
import model.User;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {


        UserSpeicher userSpeicher = new UserSpeicher();
        Datenbank datenbank = new Datenbank(userSpeicher);


        //datenbank.UserSpeicher speicher1 = new datenbank.UserSpeicher(datenbank);
        User user = new User("hans", "wurscht", "hans@wurscht.com", "wer", 1992,
                new Adresse(43245));

        User user2 = new User("manni", "Mannheim", "mannheim@gmail.com", "asdfadf", 1986);
        user2.postHinzufügen("Hallo");
        user2.postHinzufügen("Miau");


        datenbank.register(user);
        datenbank.register(user2);
        new App(primaryStage, datenbank);


    }
}




