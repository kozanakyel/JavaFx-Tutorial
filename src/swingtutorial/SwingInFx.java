package swingtutorial;

import java.awt.BorderLayout;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.embed.swing.SwingNode;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SwingInFx extends Application {
    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception{
        var borderPane = new BorderPane();
        var swingNode = new SwingNode();
        var scene = new Scene(borderPane, 200, 200);
        borderPane.setCenter(swingNode);
        borderPane.setBottom(new Label("javafx Bottom"));
        SwingUtilities.invokeLater(() -> {
            var panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add(new JLabel("Swing North"), BorderLayout.CENTER);
            swingNode.setContent(panel);
            borderPane.layout();
        });
        stage.setScene(scene);
        stage.show();
    }
}
