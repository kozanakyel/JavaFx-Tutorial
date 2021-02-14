package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Pane2 extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        /**
         * AnchorPane manages its children according to configured anchor points, even when
         * a container resizes. You specify an offset from the pane’s edge for a component.
         * */
        AnchorPane anchorPane = new AnchorPane();
        Label label = new Label("My Label");

        anchorPane.getChildren().add(label);
        AnchorPane.setLeftAnchor(label, 10.0);
        AnchorPane.setBottomAnchor(label,10.0);

        /**
         * to column 0 and row 0. The second label goes into the cell corresponding to column
         * 1 and row 0, and it spans two columns (the second and third columns).
         * */
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Label1"), 0,0);
        gridPane.add(new Label("Label2 isverylong"), 1,0,2,1);

        /**
         * BorderPane is convenient for desktop applications with discreet sections, including a
         * top toolbar (Top), a bottom status bar (Bottom), a center work area (Center), and two
         * side areas (Right and Left). Any of the five sections can be empty.
         *
         * Note that BorderPane uses a center alignment by default for the center area and a
         * left alignment for the top.
         * */
        BorderPane borderPane = new BorderPane();
        Label colorLabel = new Label("Color: LightBlue");
        colorLabel.setFont(new Font("Verdana", 18));
        borderPane.setTop(colorLabel);
        Rectangle rectangle = new Rectangle(100,50, Color.LIGHTBLUE);
        borderPane.setCenter(rectangle);
        BorderPane.setAlignment(colorLabel, Pos.CENTER);
        BorderPane.setMargin(colorLabel, new Insets(20,10,5,10)); //top,right,bottom,left

        /**
         * The HBox and VBox layout controls provide single horizontal or vertical placements for
         * child nodes.
         * */



        Scene scene = new Scene(borderPane, 350, 230, Color.LIGHTYELLOW);
        stage.setTitle("panes");
        stage.setScene(scene);
        stage.show();
    }
}
