package Snake.Logic;

public class Piece {
    private int x;
    private int y;

    public Piece (int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean runsIntoPiece(Piece piece){
        return piece.getX() == this.x && piece.getY() == this.y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
