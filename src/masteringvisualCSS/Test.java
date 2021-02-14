package masteringvisualCSS;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application {

    private final Label label = new Label("stylized label");

    private final TextField widthField = new TextField("500"){
        @Override
        public void replaceText(int start, int end, String text){
            if (text.matches("[0-9]*")){
                super.replaceText(start,end,text);
            }
        }
        @Override
        public void replaceSelection(String replacement) {
            if (replacement.matches("[0-9]*")) {
                super.replaceSelection(replacement);
            }
        }

    };

    private void updateLabelStyle(){
        label.setStyle(
                "-fx-background-color: black;"+
                        "-fx-text-fill: white;" +
                        "-fx-padding: 10;" +
                        "-fx-pref-width: " + widthField.getText() + "px;"

        );
    }

    @Override
    public void start(Stage stage) throws Exception {

        updateLabelStyle();
        widthField.setOnAction(e -> updateLabelStyle());
        VBox root = new VBox(10, label, widthField);
        root.setStyle(
                "-fx-background-color: lightblue;" +
                        "-fx-padding: 20px;"
        );

        Scene scene = new Scene(root, 400,400);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Mastering visual");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
