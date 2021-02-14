package sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.beans.binding.When;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    /**
     * The controller class implements Initializable and overrides method
     * initialize(), which is invoked for you at runtime. Importantly, the private
     * class fields stackPane and text2 are annotated with @FXML. The @FXML annotation
     * associates variable names in the controller class to the objects described in the FXML
     * file. There is no code in the controller class that creates these objects because the
     * FXMLLoader does that for you.
     * */
    @FXML
    private StackPane stackPane;
    @FXML
    private Text text2;
    private RotateTransition rotate;

    /**
     * The initialize() method does three things here. First, it creates and configures the
     * RotateTransition and applies it to the stackPane node. Second, it adds a change listener
     * to the transition’s status property. And third, a bind expression for the text2 stroke
     * property specifies its color based on the rotate transition’s status.
     * The @FXML annotation with handleMouseClick() indicates that the FXML file
     * configures the event handler. This mouse click event handler starts and stops the rotate
     * transition’s animation.
     * */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rotate = new RotateTransition(Duration.millis(2500), stackPane);
        rotate.setToAngle(360);
        rotate.setFromAngle(0);
        rotate.setInterpolator(Interpolator.LINEAR);

        rotate.statusProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    text2.setText("Was " + oldValue + ", Now " + newValue);
                }
        );

        text2.strokeProperty().bind(new When(rotate.statusProperty()
                .isEqualTo(Animation.Status.RUNNING))
                .then(Color.GREEN).otherwise(Color.RED));
        //text2.getStyleClass().add("mytext");
    }

    @FXML
    private void handleMouseClick(MouseEvent mouseEvent){
        if (rotate.getStatus().equals(Animation.Status.RUNNING)){
            rotate.pause();
        }else{
            rotate.play();
        }
    }

}
