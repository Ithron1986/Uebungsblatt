import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.image.*;


public class LayoutMethods {

    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new javafx.geometry.Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        VBox vbox = new VBox();

        Label label1 = new Label("Welcome at Social Network");
        label1.setFont(Font.font("Willkommen", FontWeight.BOLD, 20));
        Label label2 = new Label("Your network to get together with other people");

        vbox.getChildren().addAll(label1, label2);
        hbox.getChildren().add(vbox);

        return hbox;
    }

    public VBox addVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new javafx.geometry.Insets(10));
        vbox.setSpacing(8);
        vbox.setStyle("-fx-background-color: #00bfff;");
        Text title = new Text("Startseite");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        Hyperlink options[] = new Hyperlink[]{
                new Hyperlink("Login"),
                new Hyperlink("Register"),
                new Hyperlink("Contact"),
                new Hyperlink("Info")};


        for (int i = 0; i < 4; i++) {
            VBox.setMargin(options[i], new javafx.geometry.Insets(0, 0, 0, 8));
            vbox.getChildren().add(options[i]);
        }
        return vbox;
    }

    public void addStackPane(HBox hb) {
        StackPane stack = new StackPane();
        Rectangle helpIcon = new Rectangle(30.0, 25.0);
        helpIcon.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#4977A3")),
                new Stop(0.5, Color.web("#B0C6DA")),
                new Stop(1, Color.web("#9CB6CF"))));
        helpIcon.setStroke(Color.web("#D0E6FA"));
        helpIcon.setArcHeight(3.5);
        helpIcon.setArcWidth(3.5);

        Text helpText = new Text("?");
        helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        helpText.setFill(Color.WHITE);
        helpText.setStroke(Color.web("#7080A0"));

        stack.getChildren().addAll(helpIcon, helpText);
        stack.setAlignment(Pos.CENTER_RIGHT);     // Right-justify nodes in stack
        StackPane.setMargin(helpText, new Insets(0, 10, 0, 0)); // Center "?"

        hb.getChildren().add(stack);            // Add to HBox from Example 1-2
        HBox.setHgrow(stack, Priority.ALWAYS);    // Give stack any extra space
    }


    public GridPane addGridSecondPane() {
        return addGridSecondPane();
    }


}


