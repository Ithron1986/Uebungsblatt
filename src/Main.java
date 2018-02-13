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

    Stage window;

    Button buttonStaffLogin;

    public static void main(String[] args) {
        launch(args);
        AddressBuilder builder = new AddressBuilder();
        Datenbank datenbank = new Datenbank();
        UserSpeicher speicher1 = new UserSpeicher(datenbank);

        Adresse adresse = builder.withHausnummer(5)
                .withPostleitzahl(91757)
                .withWohnort("Treuchtlingen")
                .build();

        User user = new User("hans", "wurscht", "hans@wurscht.com", "wer", 1992,
                new Adresse(43245));

        User user2 = new User("manni", "Mannheim", "mannheim@gmail.com", "asdfadf", 1986);

        speicher1.saveUser(user);
        speicher1.saveUser(user2);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

      /*  window = primaryStage;

        buttonStaffLogin = new Button("Staff Login");
        Button loginButton = new Button();
        Button registerButton = new Button();
        Button buttonAuswahl = new Button();


        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Sign in", "Register", "");
        choiceBox.setValue("Sign in");
        //Listen for selection changes

       /* choiceBox.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) ->
                {
                    String neuerWert = newValue;
                    if (neuerWert.equals("Sign in")) {
                        LoginAlertUser.display();
                    }
                    if (neuerWert.equals("Register")){window.setScene(registrationUser);
                    }
                });
        buttonStaffLogin.setOnAction(event -> LoginAlertStaff.display());*/
        //buttonAuswahl.setOnAction(e -> getChoice(choiceBox));
/*
        TextField textField2 = new TextField();
        Label labelTextfield2 = new Label("E-mail");
//        registerButton.setOnAction(event -> );

        // loginButton.setOnAction(e->);

//Layout1
        BorderPane border = new BorderPane();
        LayoutMethods layoutStartingpage = new LayoutMethods();
        layoutStartingpage.addHBox();
        layoutStartingpage.addVBox();

        border.setTop(layoutStartingpage.addHBox());
        border.setLeft(layoutStartingpage.addVBox());
        layoutStartingpage.addStackPane(layoutStartingpage.addHBox());
        border.setCenter(layoutStartingpage.addGridPane(border,));

//Layout2
        BorderPane border2 = new BorderPane();
        layoutStartingpage.addHBox();
        layoutStartingpage.addVBox();

        border.setTop(layoutStartingpage.addHBox());
        border.setLeft(layoutStartingpage.addVBox());
        layoutStartingpage.addStackPane(layoutStartingpage.addHBox());
        border.setCenter(layoutStartingpage.addGridPane());



        Scene scene = new Scene(border, 1024, 860);
        Scene sceneGrid = new Scene(border2, 1024, 860);
        window.setScene(scene);
        window.setTitle("Social Network");
        window.show();*/
        Datenbank datenbank = new Datenbank();
        //datenbank.UserSpeicher speicher1 = new datenbank.UserSpeicher(datenbank);
        User user = new User("hans", "wurscht", "hans@wurscht.com", "wer", 1992,
                new Adresse(43245));

        User user2 = new User("manni", "Mannheim", "mannheim@gmail.com", "asdfadf", 1986);

        datenbank.register(user);
        datenbank.register(user2);
        new App(primaryStage,datenbank);


    }


//        choiceBox.setLayoutX(412);
//        choiceBox.setLayoutY(380);
//        choiceBox.setPrefSize(200, 100);
//        buttonAuswahl.setLayoutX(512);
//        buttonAuswahl.setLayoutY(500);
//        buttonStaffLogin.setLayoutX(512);
//        buttonStaffLogin.setLayoutY(800);
//        label1.setLayoutX(0);
//        label1.setLayoutY(0);
//        layout.getChildren().addAll(label1,label2, choiceBox, buttonStaffLogin);
//
    //Scene startseite = new Scene(layout, 1024, 860);

//        window.setScene(startseite);
//        window.setTitle("Social Network");
//        window.show();
}

   /* private void getChoice(ChoiceBox<String> choiceBox) {
        String choiceLoginScreen = choiceBox.getValue();
        System.out.println(choiceLoginScreen);
    }
*/



