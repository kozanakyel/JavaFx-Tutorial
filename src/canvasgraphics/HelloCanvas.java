package canvasgraphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class HelloCanvas extends Application {

    private static final String MSG = "JavaFX Rocks!";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0,0, WIDTH,HEIGHT);
        gc.setFill(Color.DARKBLUE);
        gc.fillRoundRect(100,200,WIDTH-200,180,90,90);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font(60));
        gc.setFill(Color.LIGHTBLUE);
        gc.fillText(MSG,WIDTH/2,HEIGHT/2);
        gc.setStroke(Color.BLUE);
        gc.strokeText(MSG,WIDTH/2,HEIGHT/2);

        Canvas canvas1 = new Canvas(WIDTH,HEIGHT);
        GraphicsContext gc1 = canvas1.getGraphicsContext2D();
        gc1.setFont(Font.font(12));
        gc1.setFill(Color.BLACK);
        gc1.fillRect(0,0,WIDTH,HEIGHT);
        gc1.setStroke(Color.LIGHTCYAN);
        for (int i = 0; i < WIDTH; i+= 100){
            for (int k = 0; k < HEIGHT; k += 100){
                gc1.strokeRect(i,k,100,100);
                gc1.setFill(Color.WHITE);
                gc1.fillText("x="+i+",y="+k, i+2, k+12);
                gc1.setFill(Color.RED);
                gc1.fillOval(i-4,k-4,8,8);
            }
        }

        Canvas canvas2 = new Canvas(800,600);
        GraphicsContext ctx = canvas2.getGraphicsContext2D();
        ctx.setLineWidth(10);
        canvas2.setOnMousePressed(e -> ctx.beginPath());
        canvas2.setOnMouseDragged(e -> {
            ctx.lineTo(e.getX(), e.getY());
            ctx.stroke();
        });
        canvas2.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.SECONDARY){
                clear(ctx);
            }
        });

        Canvas canvas3 = new Canvas(WIDTH,HEIGHT);
        GraphicsContext ctx1 = canvas3.getGraphicsContext2D();
        for (int i = 0; i < canvas3.getWidth(); i++){
            for (int j = 0; j < canvas3.getHeight(); j++){
                ctx1.getPixelWriter().setColor(i,j,Color.color(Math.random(),
                        Math.random(),Math.random()));
            }
        }

        stage.setScene(new Scene(new StackPane(canvas3), WIDTH, HEIGHT));
        stage.setTitle("Hello Canvas...");
        stage.show();
        clear(ctx);

    }

    public void clear(GraphicsContext ctx){
        ctx.setFill(Color.DARKBLUE);
        ctx.fillRect(0,0,WIDTH,HEIGHT);
        ctx.setStroke(Color.ALICEBLUE);
    }
}
