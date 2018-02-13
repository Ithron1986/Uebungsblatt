import datenbank.Datenbank;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.AddressBuilder;
import model.Adresse;
import model.User;
import ui.Formbuilder;

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
        this.signinScreen();


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


        Text title = new Text("Welcome");
        grid.add(title, 1, 2, 4, 2);
        GridPane.setHalignment(title, HPos.CENTER);
        title.setFont(Font.font("Arial", FontWeight.BOLD, 25));

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
                /*startingpageUser();*/
            } else {
                Text errorText = new Text("login wrong");
                grid.add(errorText, 2, 6);
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

    public void registerScreen() {
        Label header1 = new Label();
        Label header2 = new Label();
        header1.setText("Welcome at Social Network");
        header2.setText("Please insert your user data and apply with the \"Submit\"-button ");
        TextField emailField = new TextField();
        Button submitButton = new Button();
        submitButton.setText("Submit");
        submitButton.setOnAction(e -> {
            signinScreen();
        });

        Pane layout = new Pane();
        submitButton.setLayoutX(512);
        submitButton.setLayoutY(800);
        submitButton.setPrefSize(200, 50);
        layout.getChildren().addAll(submitButton);
        this.mainLayout.setCenter(layout);
    }


}
