import datenbank.Datenbank;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;
import model.AddressBuilder;
import model.Adresse;
import model.Statusmeldung;
import model.User;
import ui.Formbuilder;

import java.time.LocalDateTime;

public class App {
    Datenbank datenbank;
    BorderPane mainLayout;
    Scene scene;
    Stage stage;

    private int maxNumberCR = 100;


    public App(Stage stage, Datenbank datenbank) {
        this.datenbank = datenbank;
        this.mainLayout = new BorderPane();
        this.stage = stage;
        LayoutMethods layoutStartingpage = new LayoutMethods();

        this.mainLayout.setTop(layoutStartingpage.addHBox());
        this.mainLayout.setLeft(layoutStartingpage.addVBox());
        layoutStartingpage.addStackPane(layoutStartingpage.addHBox());
        // this.signinScreen();

        this.mainPageUser(datenbank.getUser("mannheim@gmail.com"));

        this.scene = new Scene(this.mainLayout, 1600, 900);
        this.stage.setScene(scene);
        this.stage.setTitle("Social Network");
        this.stage.show();
    }

    public void registerUser() {

        Formbuilder formBuilder = new Formbuilder(7, 11);

        GridPane registrationForm = formBuilder.addHeader("Registration")
                .addTextInputField("Firstname")
                .addTextInputField("Lastname")
                .addTextInputField("E-mail")
                .addTextInputField("Pasword")
                .addTextInputField("Year of Birth")
                .addTextInputField("Post Code")
                .addTextInputField("Place of Residence")
                .addTextInputField("Street Name")
                .addTextInputField("House Number")
                .build((e -> {
                    String firstname = formBuilder.getControls().get("Firstname").getText();
                    String lastname = formBuilder.getControls().get("Lastname").getText();
                    String eMail = formBuilder.getControls().get("E-mail").getText();
                    String pasword = formBuilder.getControls().get("Pasword").getText();
                    String yearOfBirth = formBuilder.getControls().get("Year of Birth").getText();
                    String postCode = formBuilder.getControls().get("Post Code").getText();
                    String placeOfResidence = formBuilder.getControls().get("Place of Residence").getText();
                    String streetName = formBuilder.getControls().get("Street Name").getText();
                    String houseNumber = formBuilder.getControls().get("House Number").getText();

                    int yearOfBirthInt = Integer.valueOf(yearOfBirth);
                    int houseNumberInt = Integer.valueOf(houseNumber);
                    int postCodeInt = Integer.valueOf(postCode);

                    AddressBuilder addressBuilder = new AddressBuilder();
                    Adresse newUserAddress = addressBuilder.withHausnummer(houseNumberInt)
                            .withPostleitzahl(postCodeInt)
                            .withStraße(streetName)
                            .withWohnort(placeOfResidence)
                            .build();
                    User user = new User(firstname
                            , lastname
                            , eMail
                            , pasword
                            , yearOfBirthInt
                            , newUserAddress);
                    datenbank.register(user);
                    signinScreen();
                }), "Confirm");

        this.mainLayout.setCenter(registrationForm);
    }
public void changeUserDataPage (){
    Formbuilder formBuilderChange = new Formbuilder(7, 11);

    GridPane registrationFormChange = formBuilderChange.addHeader("Registration")
            .addTextInputField("Firstname")
            .addTextInputField("Lastname")
            .addTextInputField("E-mail")
            .addTextInputField("Pasword")
            .addTextInputField("Year of Birth")
            .addTextInputField("Post Code")
            .addTextInputField("Place of Residence")
            .addTextInputField("Street Name")
            .addTextInputField("House Number")
            .build((e -> {
                String firstname = formBuilderChange.getControls().get("Firstname").getText();
                String lastname = formBuilderChange.getControls().get("Lastname").getText();
                String eMail = formBuilderChange.getControls().get("E-mail").getText();
                String pasword = formBuilderChange.getControls().get("Pasword").getText();
                String yearOfBirth = formBuilderChange.getControls().get("Year of Birth").getText();
                String postCode = formBuilderChange.getControls().get("Post Code").getText();
                String placeOfResidence = formBuilderChange.getControls().get("Place of Residence").getText();
                String streetName = formBuilderChange.getControls().get("Street Name").getText();
                String houseNumber = formBuilderChange.getControls().get("House Number").getText();

                int yearOfBirthInt = Integer.valueOf(yearOfBirth);
                int houseNumberInt = Integer.valueOf(houseNumber);
                int postCodeInt = Integer.valueOf(postCode);

                AddressBuilder addressBuilder = new AddressBuilder();
                Adresse newUserAddress = addressBuilder.withHausnummer(houseNumberInt)
                        .withPostleitzahl(postCodeInt)
                        .withStraße(streetName)
                        .withWohnort(placeOfResidence)
                        .build();
                User user = new User(firstname
                        , lastname
                        , eMail
                        , pasword
                        , yearOfBirthInt
                        , newUserAddress);
                datenbank.register(user);
                signinScreen();
            }), "Confirm");

    this.mainLayout.setCenter(registrationFormChange);

}


    private void mainPageUser(User user) {

        int spaltenZahl = 1;
        int zeilenzahl = 9;


        TableView<Statusmeldung> table = new TableView<>();
        TableColumn<Statusmeldung, String> statusmeldungTextColumn = new TableColumn<>("Status Message");
        statusmeldungTextColumn.setCellValueFactory(new PropertyValueFactory<>("text"));
        statusmeldungTextColumn.setMinWidth(600);
        statusmeldungTextColumn.setResizable(true);

        TableColumn<Statusmeldung, String> dateStatusmeldungColumn = new TableColumn<>("Date");
        dateStatusmeldungColumn.setCellValueFactory((row) -> {
            LocalDateTime datum = row.getValue().getDatum();
            String schoenesDatum = datum.getHour() +
                    ":" + datum.getMinute() +
                    "  " + datum.getDayOfMonth() +
                    "." + datum.getMonth().getValue() +
                    "." + datum.getYear();
            return new SimpleStringProperty(schoenesDatum);
        });
        dateStatusmeldungColumn.setMinWidth(200);
        dateStatusmeldungColumn.setPrefWidth(400);

        TableColumn<Statusmeldung, String> nutzerkennungColumn = new TableColumn<>("Sender");
        nutzerkennungColumn.setMinWidth(200);
        nutzerkennungColumn.setPrefWidth(400);
        /*
        0 Statusmeldung { text: "...", datum: "...", absender: User{ vorname: ".."}}
        1 Statusmeldung { text: "...", datum: "...", absender: User{ vorname: ".."}}
         */
        nutzerkennungColumn.setCellValueFactory((row) -> {
            User currentUser = row.getValue().getAbsender();
            String firstname = currentUser.getVorname();
            //String lastname = currentUser.getNachname();
            return new SimpleStringProperty(firstname);
        });
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        table.getColumns().addAll(statusmeldungTextColumn, nutzerkennungColumn, dateStatusmeldungColumn);
        table.setItems(user.getPosts());


        //Erstellen der Boxen für die Nutzerseite
        VBox centerVBox = new VBox();
        HBox topHBox = new HBox();
        GridPane newGridPane = creatingGrid(7, 8);
        ScrollPane scrollingTable = new ScrollPane();
        scrollingTable.setContent(table);

        scrollingTable.setFitToWidth(true);
        centerVBox.getChildren().addAll(topHBox, scrollingTable, newGridPane);


        //Textfeld der schreibbox
        TextField schreibBox = new TextField("Write a Message...");
        schreibBox.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 14));
        newGridPane.add(schreibBox, 1, 1, 4, 1);


        //Button der Schreibbox
        Button sendButton = new Button("Send Message");
        sendButton.setOnAction(e -> {
            String post = schreibBox.getText();
            user.postHinzufügen(post);
        });
        newGridPane.add(sendButton, 5, 1, 1, 1);


        //Top Hbox mit Begrüßung
        Text title = new Text("Willkommen " + user.getVorname() + " " + user.getNachname());
        topHBox.setAlignment(Pos.CENTER);
        title.setTextAlignment(TextAlignment.CENTER);
        title.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        topHBox.getChildren().add(title);
        newGridPane.setGridLinesVisible(true);

        // Vbox auf der linken Seite
        VBox vboxLeft = new VBox();
        vboxLeft.setPadding(new javafx.geometry.Insets(10));
        vboxLeft.setSpacing(8);
        vboxLeft.setStyle("-fx-background-color: #00bfff;");
        Text benutzernameUndNachname = new Text("Willkommen\r\n" + user.getVorname() + " " + user.getNachname() + "\r\n");
        vboxLeft.getChildren().add(benutzernameUndNachname);
        Text titleVBoxLeft = new Text("User account");
        titleVBoxLeft.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vboxLeft.getChildren().add(titleVBoxLeft);

        Button buttonChangeUserData = new Button("Change useder data");
        //buttonChangeUserData.setOnAction(e->);
        buttonChangeUserData.setStyle("-fx-background-color: #00bfff;");
        vboxLeft.getChildren().add(buttonChangeUserData);
        Hyperlink optionsLeft[] = new Hyperlink[]{
                new Hyperlink("Change user data"),
                new Hyperlink("Help")
        };


        for (int j = 0; j < 2; j++) {
            VBox.setMargin(optionsLeft[j], new javafx.geometry.Insets(0, 8, 0, 0));
            vboxLeft.getChildren().add(optionsLeft[j]);
        }


        VBox vBoxRight = new VBox();
        vBoxRight.setPadding(new javafx.geometry.Insets(8));
        vBoxRight.setSpacing(8);
        vBoxRight.setStyle("-fx-background-color: #00bfff;");
        Text titleVBoxRight = new Text("Ich überlege mir was");
        titleVBoxRight.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vBoxRight.getChildren().add(titleVBoxRight);

        Hyperlink options[] = new Hyperlink[]{
                new Hyperlink("Muhh"),
                new Hyperlink("Mähh"),
                new Hyperlink("Ahh"),
                new Hyperlink("Bähh")};


        for (int i = 0; i < 4; i++) {
            VBox.setMargin(options[i], new javafx.geometry.Insets(0, 8, 0, 0));
            vBoxRight.getChildren().add(options[i]);
        }


        //implementierung in das MainLayout
        this.mainLayout.setLeft(vboxLeft);
        this.mainLayout.setRight(vBoxRight);
        this.mainLayout.setCenter(centerVBox);


    }


    private GridPane creatingGrid(int maxNumberColumn, int maxNumberRows) {
        GridPane newGrid = new GridPane();

        for (int i = 0; i < maxNumberColumn; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(maxNumberCR / maxNumberColumn);
            newGrid.getColumnConstraints().add(col);
        }
        for (int i = 0; i < maxNumberRows; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(8);
            newGrid.getRowConstraints().add(row);
        }
        newGrid.setHgap(10);
        newGrid.setVgap(10);
        newGrid.setPadding(new Insets(0, 10, 0, 10));
        return newGrid;
    }


    public void signinScreen() {
        GridPane grid = creatingGrid(7, 11);
        grid.setGridLinesVisible(true);


        Text titleSignin = new Text("Welcome");
        grid.add(titleSignin, 1, 2, 4, 2);
        GridPane.setHalignment(titleSignin, HPos.CENTER);
        titleSignin.setFont(Font.font("Arial", FontWeight.BOLD, 25));

        TextField emailTextfield = new TextField();
        emailTextfield.setStyle("-fx-stroke: black"); // ich will nen schwarzen rahmen
        grid.add(emailTextfield, 3, 4);

        //Textlabel der Emailadresse
        Text labelEmail = new Text("E-Mail-Address");
        labelEmail.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        //GridPane.setHalignment(labelEmail, HPos.LEFT);
        grid.add(labelEmail, 2, 4);

        TextField passwordTextfield = new TextField();
        grid.add(passwordTextfield, 3, 5);

        // Textlabel des Passworts
        Text labelPassword = new Text("Password");
        labelPassword.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        grid.add(labelPassword, 2, 5);


        //Sign in Button
        Button signInButton = new Button("Sign in");
        grid.add(signInButton, 4, 5);
        signInButton.setOnAction(e -> {
            String eingabePasswort = passwordTextfield.getText();
            String eingabeEmail = emailTextfield.getText();
            if (datenbank.istNutzervorhanden(eingabeEmail, eingabePasswort)) {
                mainPageUser(datenbank.getUser(eingabeEmail));
            } else {
                Text errorText = new Text("No match found for given Login information");
                errorText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
                errorText.setFill(Color.RED);
                GridPane.setHalignment(errorText, HPos.CENTER);
                grid.add(errorText, 1, 7, 4, 2);
            }
        });

        //Register Feld
        Hyperlink registerHyperlink = new Hyperlink("Register");
        grid.add(registerHyperlink, 3, 6);
        registerHyperlink.setOnAction(e -> {
            this.registerUser();
            //this.registerScreen();
        });

        this.mainLayout.setCenter(grid);

    }


}
