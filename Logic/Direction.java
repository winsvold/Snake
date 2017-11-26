package Snake.Logic;

public enum Direction {
    UP(new int[] {0,-1}),
    RIGHT(new int[] {1,0}),
    DOWN(new int[] {0,1}),
    LEFT(new int[] {-1,0});

    private int[] direction;

    private Direction (int[] dir){
        this.direction = dir;
    }

    public int[] getDirection(){
        return this.direction;
    }
}
