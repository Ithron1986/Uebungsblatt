package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;

public class Formbuilder {


    private GridPane result;

    private int maxNumberCR = 100;

    private int currentRowIndex = 0;
    private int currentColIndex = 0;

    private Map<String, TextInputControl> controls = new HashMap<>();

    // header
    // rows, cols
    // inputs

    public Formbuilder(int rows, int cols) {
        this.result = creatingGrid(rows, cols);
        this.result.setGridLinesVisible(false);

    }

    public Formbuilder addHeader(String header) {
        Label label = new Label(header);
        label.setFont(Font.font("Arial",FontWeight.BOLD, 25));
        this.result.add(label,currentColIndex,currentRowIndex,6,1);
        currentRowIndex++;
        return this;

    }

    public Formbuilder addTextInputField(String name) {
        Label label = new Label(name);
        TextField textField = new TextField();
        this.controls.put(name, textField);
        this.result.add(label, currentColIndex, currentRowIndex);
        this.result.add(textField, currentColIndex + 1, currentRowIndex,2,1);
        currentRowIndex++;
        return this;
    }
    public Formbuilder addTextInputField(String name,String userdata) {
        Label label = new Label(name);
        TextField textField = new TextField(userdata);
        this.controls.put(name, textField);
        this.result.add(label, currentColIndex, currentRowIndex);
        this.result.add(textField, currentColIndex + 1, currentRowIndex,2,1);
        currentRowIndex++;
        return this;
    }

    public Formbuilder addPasswortField(String name) {
        return this;
    }

    public Formbuilder addDateField(String name) {
        return this;
    }

    public Map<String, TextInputControl> getControls() {
        return this.controls;
    }

    public GridPane build(EventHandler<ActionEvent> handler,String buttonLabel) {
        Button button = new Button(buttonLabel);
        button.setOnAction(handler);
        this.result.add(button, currentColIndex +1, currentRowIndex+1);
        return this.result;
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
        newGrid.setPadding(new Insets(20, 20, 20, 30));
        return newGrid;
    }
}
