package Snake.SwingFrontEnd;

import Snake.Logic.Apple;
import Snake.Logic.Direction;
import Snake.Logic.TurnPlayer;
import Snake.Logic.Worm;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args){

        int boardHeight = 15;
        int boardWidth = 15;
        Worm worm = new Worm(new Random().nextInt(boardWidth),new Random().nextInt(boardHeight), Direction.RIGHT, boardHeight, boardWidth);
        List<Apple> apples = new ArrayList<>();
        TurnPlayer turnPlayer = new TurnPlayer(worm,apples,boardHeight,boardWidth);

        turnPlayer.makeApple();
        InitializeSimulator initializeSimulator = new InitializeSimulator(worm,apples,turnPlayer,45, 6, boardHeight,boardWidth);
        SwingUtilities.invokeLater(initializeSimulator);
    }
}
