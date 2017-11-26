package Snake.SwingFrontEnd;

import Snake.Logic.Apple;
import Snake.Logic.TurnPlayer;
import Snake.Logic.Worm;
import Snake.SwingFrontEnd.Listener.KeyBoardListener;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InitializeSimulator implements Runnable {

    private List<Apple> apples;
    private int height;
    private int width;
    private JFrame frame;
    private JPanel boardPainter;
    private Worm worm;
    private int pixelPerPoint;
    private double millisecondsPrRound;
    private ScheduledExecutorService updater;
    private TurnPlayer turnPlayer;

    public InitializeSimulator(Worm worm, List<Apple> apples, TurnPlayer turnPlayer, int pixelPerPoint, double hertz, int boardHeight, int boardWidth){
        this.turnPlayer = turnPlayer;
        this.apples = apples;
        this.height = boardHeight;
        this.width = boardWidth;
        this.worm = worm;
        this.millisecondsPrRound = (int)(1000/hertz);
        this.pixelPerPoint = pixelPerPoint;
        this.boardPainter = new BoardPainter(worm,apples,pixelPerPoint,height,width);
        updater = Executors.newScheduledThreadPool(1);
    }

    private void setNextUpdate (){
        updater.schedule(()->{
            turnPlayer.playTurn();
            if(!turnPlayer.isGameover()){
                setNextUpdate();
            }
            boardPainter.repaint();
            },(int)millisecondsPrRound,TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        frame = new JFrame("Snake");
        frame.setPreferredSize(new Dimension((int)((width)* pixelPerPoint + 27) ,(height) * pixelPerPoint + 50));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(boardPainter);
        frame.addKeyListener(new KeyBoardListener(worm));

        frame.pack();
        frame.setVisible(true);

        setNextUpdate();
    }
}
