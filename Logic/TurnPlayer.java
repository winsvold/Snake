package Snake.Logic;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TurnPlayer {

    private boolean gameover = false;
    private Worm worm;
    private int height;
    private int width;
    private List<Apple> apples;

    public TurnPlayer(Worm worm, List<Apple> apples, int height, int width ){
        this.worm = worm;
        this.apples = apples;
        this.height = height;
        this.width = width;
    }

    public void makeApple(){
        int x;
        int y;
        while(true) {
            x = new Random().nextInt(height);
            y = new Random().nextInt(width);
            if(worm.getDirection() == Direction.RIGHT || worm.getDirection() == Direction.RIGHT){
                if(worm.getPosition().getY() == y){
                    continue;
                }
            } else {
                if(worm.getPosition().getX() == x){
                    continue;
                }
            }
            break;
        }
        apples.add(new Apple(x,y));
    }

    private boolean eatsApple(){
        Iterator<Apple> iterator = apples.iterator();
        while(iterator.hasNext()){
            Apple next = iterator.next();
            if ( worm.getPosition().runsIntoPiece(next) ){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    private void growApples(){
        Iterator<Apple> iterator = apples.iterator();
        while (iterator.hasNext()){
            Apple next = iterator.next();
            next.grow();
            if(next.isRotten()){
                iterator.remove();
            }
        }
    }

    public void playTurn(){
        if(new Random().nextDouble() < 0.6 / worm.getLength() + 0.02){
            makeApple();
        }
        try {
            worm.move();
        } catch (Exception e) {
            gameover = true;
        }
        if(eatsApple()){
            worm.grow();
        }
        growApples();
    }

    public boolean isGameover() {
        return gameover;
    }
}