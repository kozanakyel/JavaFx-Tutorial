package swingtutorial;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javafx.application.Platform;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class BidiractionalFX {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            var frame = new JFrame("java11 bidirectional");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            var jfxPanel = new JFXPanel();
            var button = new Button("hello fx");
            var sc = new Scene(button);
            jfxPanel.setScene(sc);
            jfxPanel.setPreferredSize(new Dimension(200, 100));
            jfxPanel.setBorder(new EmptyBorder(5,5,5,5));
            var panel = new JPanel(new BorderLayout());
            panel.add(new JLabel("hello swing north"), BorderLayout.NORTH);
            var suthButton = new JButton("hello swiing south button");
            panel.add(suthButton, BorderLayout.SOUTH);

            button.setOnMousePressed(e -> SwingUtilities.invokeLater(() -> suthButton.setText("FX Button Pressed")));
            button.setOnMouseReleased(e -> SwingUtilities.invokeLater(() -> suthButton.setText("Hello Swing South")));

            suthButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    Platform.runLater(() -> button.setText("Swing Button Pressed"));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    Platform.runLater(() -> button.setText("Hello FX"));
                }

            });

            panel.add(jfxPanel, BorderLayout.CENTER);
            frame.setContentPane(panel);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
