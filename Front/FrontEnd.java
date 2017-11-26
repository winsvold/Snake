package Snake.Front;

import Snake.Logic.Apple;
import Snake.Logic.Direction;
import Snake.Logic.TurnPlayer;
import Snake.Logic.Worm;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FrontEnd extends Application {

    private int boardHeight = 10;
    private int boardWidth = 10;
    private Worm worm = new Worm(new Random().nextInt(boardWidth),new Random().nextInt(boardHeight), Direction.RIGHT, boardHeight, boardWidth);
    private List<Apple> apples = new ArrayList<>();
    private TurnPlayer turnPlayer = new TurnPlayer(worm,apples,boardHeight,boardWidth);


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root,400,300, Color.BLACK);
        primaryStage.setTitle("Snake");
        primaryStage.setScene(scene);

        final long startNanoTime = System.nanoTime();

        new AnimationTimer(){
            public void handle(long currentNanoTime){
                // Code here
            }
        }.start();

        primaryStage.show();
    }
}
