package deepDiveUI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class deepDive extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();
        Button btn = new Button("click me!");
        btn.getStyleClass().add("padder");
        Insets sets = new Insets(10,10,10,10);
        btn.setOnAction(event -> System.out.println("button was clicked"));
        //root.getChildren().add(btn);
        root.getChildren().add(btn);
        CheckBox cb = new CheckBox("enable power plant");
        cb.setIndeterminate(false);
        cb.getStyleClass().add("padder");
        cb.setOnAction(e -> System.out.println("action event fired"));
        cb.selectedProperty().addListener(i -> System.out.println("selected state change to " + cb.isSelected()));
        //root.getChildren().add(cb);
        root.getChildren().add(cb);

        ToggleButton tb1 = new ToggleButton("ben one");
        ToggleButton tb2 = new ToggleButton("bentwo");
        ToggleButton tb3 = new ToggleButton("ben3");
        tb1.getStyleClass().add("padder");
        tb2.getStyleClass().add("padder");
        tb3.getStyleClass().add("padder");
        root.getStyleClass().add("padder");

        ToggleGroup grup = new ToggleGroup();
        grup.getToggles().addAll(tb1, tb2, tb3);

        RadioButton rb1 = new RadioButton("ben one");
        RadioButton rb2 = new RadioButton("bentwo");
        RadioButton rb3 = new RadioButton("ben3");

        ToggleGroup grupRadio = new ToggleGroup();
        grup.getToggles().addAll(rb1, rb2, rb3);

        tb1.setOnAction(e -> System.out.println("t 1 clicked"));

        grup.selectedToggleProperty().addListener(i ->
                System.out.println("selected toggle is " + grup.getSelectedToggle()));



        VBox radio = new VBox(rb1,rb2,rb3);
        //root.getChildren().add(radio);
        StackPane.setAlignment(radio, Pos.BASELINE_RIGHT);

        TextField tf = new TextField();
        tf.setPromptText("enter your name");

        tf.setOnAction(e -> System.out.println("entered text is: " + tf.getText()));
        tf.textProperty().addListener((o, oldValue, newValue) ->
                System.out.println("current text is: " + newValue));
        tf.setStyle("-fx-background-color:red");
        tf.getStyleClass().add("padder");
        //root.getChildren().add(tf);

        VBox togg = new VBox(10,tb1,tb2,tb3,rb1,rb2,rb3,tf);
        StackPane.setAlignment(togg, Pos.CENTER);
        root.getChildren().add(togg);

        Scene scene = new Scene(root,250,200);
        stage.setTitle("deep dive");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
