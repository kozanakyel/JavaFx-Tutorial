package sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.When;
import javafx.beans.value.ObservableObjectValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Pane1 extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        /**
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        */

        /**
         *         ellipse.setFill(Color.LIGHTBLUE);
         *         ellipse.setFill(Color.web("#ADD8E6"));
         *         ellipse.setFill(Color.rgb(173, 216, 230, .5));         *
         * */
        Ellipse ellipse = new Ellipse(110, 70);
        //ellipse.setFill(Color.LIGHTBLUE);
        ellipse.setFill(Color.web("#ADD8E6"));
        ellipse.setFill(Color.rgb(173, 216, 230, .5));

        Text text = new Text("My Shapes");
        text.setFont(new Font("Arial Bold", 24));

        /**
         * Group uses default alignment settings for its children and places everything at the
         * origin (0,0), For Text, the default placement is the
         * bottom-left edge of the text element.
         * */
        Group group = new Group(ellipse, text); // but we should configure figures coordinates
        ellipse.setCenterX(175);
        ellipse.setCenterY(115);
        text.setX(175-(text.getLayoutBounds().getWidth()/2)); //ideal olan layout nçünkü her resizewindowsda istenmeyen yerde olacak text
        text.setY(115+(text.getLayoutBounds().getHeight()/2));

        StackPane stackPane = new StackPane();
        //stackPane.setAlignment(Pos.BOTTOM_CENTER); // align all managed nodes
        stackPane.getChildren().addAll(ellipse, text);

        Stop[] stops = new Stop[]{ new Stop(0, Color.DODGERBLUE),
                new Stop(0.5, Color.LIGHTBLUE),
                new Stop(1.0, Color.LIGHTGREEN)};
        //startX, startY, endX, endY
        LinearGradient gradient = new LinearGradient(0,0,0,1,true, CycleMethod.NO_CYCLE, stops);

        ellipse.setEffect(new DropShadow(30,10,10,Color.GRAY));
        ellipse.setFill(gradient);

        Reflection r = new Reflection();
        r.setFraction(.8);
        r.setTopOffset(1.0);

        text.setOnMouseClicked(mouseEvent -> System.out.println(mouseEvent.getSource().getClass()
                + " clicked."));
        //ellipse.setOnMouseClicked(mouseEvent -> ellipse.setFill(Color.RED));
        text.setEffect(r);

        /**
         *Transitions begin with method play() or playFromStart(). Method play() starts
         * the transition at its current time; method playFromStart() always begins at time 0. Other
         * methods include stop() and pause(). You can query a transition’s status with getStatus(),
         * which returns one of the Animation.Status enum values: RUNNING, PAUSED, or STOPPED.
         * All transitions support the common properties duration, autoReverse, cycleCount,
         * onFinished, currentTime, and either node or shape (for Shape-specific transitions).
         * */
        RotateTransition rotate = new RotateTransition(
                Duration.millis(2500), ellipse
        );
        rotate.setToAngle(360);
        rotate.setFromAngle(0);
        rotate.setInterpolator(Interpolator.LINEAR);

        stackPane.setOnMouseClicked(mouseEvent -> {
            if (rotate.getStatus().equals(Animation.Status.RUNNING)){
                rotate.pause();
            }else{
                rotate.play();
            }
        });
        Text text2 = new Text("Animation status: ");
        stackPane.getChildren().add(text2);
        StackPane.setAlignment(text2, Pos.BOTTOM_CENTER);
        text2.setFont(new Font("Arial Bold", 36));
        rotate.statusProperty().addListener(observable -> text2.setText("Animation status: " +
                rotate.getStatus()));

        rotate.statusProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    text2.setText("Was " + oldValue + ", Now " + newValue);
                });
        text2.rotateProperty().bind(stackPane.rotateProperty());  //undirectioal binding
        text2.textProperty().bindBidirectional(text.textProperty());
        /**
         * text.textProperty() ->
         * StringProperty [bean: Text[text="My Shapes", x=112.310546875, y=128.40625, alignment=LEFT, origin=BASELINE,
         * boundsType=LOGICAL, font=Font[name=Arial Bold, family=Arial, style=Bold, size=24.0], fontSmoothingType=GRAY,
         * fill=0x000000ff], name: text, value: My Shapes]
         * */
        //System.out.println(text.textProperty());
        text2.strokeProperty().bind(new When(rotate.statusProperty()
                .isEqualTo(Animation.Status.RUNNING))
                .then(Color.GREEN).otherwise(Color.RED));

        Scene scene = new Scene(stackPane, 500, 230, Color.LIGHTYELLOW);
        stage.setTitle("Myshapes with javaFx");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }
}
