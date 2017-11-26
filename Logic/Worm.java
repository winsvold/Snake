package Snake.Logic;

import java.util.ArrayList;
import java.util.List;

public class Worm {
    private Direction direction = Direction.DOWN;
    private List<Piece> worm = new ArrayList<>();
    private int maxSize = 3;
    private int height;
    private int width;

    public Worm(int originalX,int originalY,Direction originalDirection,int height,int width){
        this.direction = originalDirection;
        worm.add(new Piece(originalX,originalY));
        this.height = height;
        this.width = width;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction newDirection){
        this.direction = newDirection;
    }

    public int getLength(){
        return worm.size();
    }

    public List<Piece> getPieces(){
        return worm;
    }

    public void move() throws Exception{

        int newX = getPosition().getX() + direction.getDirection()[0];
        int newY = getPosition().getY() + direction.getDirection()[1];
        if(newX > width){
            newX = 0;
        } else if (newX < 0){
            newX = width;
        }
        if (newY > height){
            newY = 0;
        } else if(newY < 0){
            newY = height;
        }

        worm.add(new Piece(newX,newY));

        while(worm.size()> maxSize){
            worm.remove(0);
        }

        if(runsIntoItself()){
            throw new Exception("Worm ran into itself");
        }
    }

    public Piece getPosition(){
        return worm.get(worm.size() - 1);
    }

    public void grow(){
        this.maxSize++;
    }

    public boolean runsInto(Piece piece){
        return piece.runsIntoPiece(getPosition());
    }

    public boolean runsIntoItself(){
        for (int i = 0; i < worm.size() - 1; i++) {
            if(getPosition().runsIntoPiece(worm.get(i))){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return getPieces().toString();
    }
}