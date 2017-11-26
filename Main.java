package Snake;

import Snake.Front.FrontEnd;
import Snake.Logic.Apple;
import Snake.Logic.Direction;
import Snake.Logic.TurnPlayer;
import Snake.Logic.Worm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception{

        int boardHeight = 10;
        int boardWidth = 10;
        Worm worm = new Worm(new Random().nextInt(boardWidth),new Random().nextInt(boardHeight), Direction.RIGHT, boardHeight, boardWidth);
        List<Apple> apples = new ArrayList<>();
        TurnPlayer turnPlayer = new TurnPlayer(worm,apples,boardHeight,boardWidth);

    }
}