package Snake.Logic;

import java.util.Random;

public class Apple extends Piece {

    private int timeLeft;

    public Apple(int x, int y){
        super(x,y);
        timeLeft = new Random().nextInt(100) + 30;
    }

    public void grow(){
        timeLeft--;
    }

    public boolean isRotten(){
        if(timeLeft <= 0){
            return true;
        }
        return false;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

}
