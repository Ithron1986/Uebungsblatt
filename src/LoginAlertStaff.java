import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class LoginAlertStaff {
    public static void display(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Staff Login");
        window.setMinWidth(250);

        Label label = new Label();
        label.setText("Please insert your staff-e-mail address\n\rand password");
        Button submitButton = new Button("Log in");
        submitButton.setOnAction(e->window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,submitButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}
