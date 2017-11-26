package Snake.SwingFrontEnd.Listener;

import Snake.Logic.Direction;
import Snake.Logic.Worm;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardListener implements KeyListener {

    private Worm worm;

    public KeyBoardListener(Worm worm){
        this.worm = worm;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN && worm.getDirection() != Direction.UP){
            worm.setDirection(Direction.DOWN);
        }
        if(e.getKeyCode() == KeyEvent.VK_UP && worm.getDirection() != Direction.DOWN){
            worm.setDirection(Direction.UP);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT && worm.getDirection() != Direction.RIGHT){
            worm.setDirection(Direction.LEFT);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && worm.getDirection() != Direction.LEFT){
            worm.setDirection(Direction.RIGHT);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
