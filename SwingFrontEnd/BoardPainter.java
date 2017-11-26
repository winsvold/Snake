package Snake.SwingFrontEnd;

import Snake.Logic.Apple;
import Snake.Logic.Piece;
import Snake.Logic.Worm;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BoardPainter extends JPanel{
    private List<Apple> apples;
    private Worm worm;
    private int height;
    private int width;
    private int pixelPerPoint;

    public BoardPainter(Worm worm, List<Apple> apples, int pixelPerPoint, int height, int width) {
        super.setBackground(Color.orange);
        this.height = height;
        this.width = width;
        this.apples = apples;
        this.worm = worm;
        this.pixelPerPoint = pixelPerPoint;
    }

    private void paintCells(Graphics g){
        int offset = pixelPerPoint;

        Color myColor = new Color(250,250,0,150);
        g.setColor(myColor);
        worm.getPieces().forEach( (Piece piece) -> {
            g.fillRect(piece.getX()*offset,piece.getY()*offset,(int)(offset*0.9),(int)(offset*0.9));
        });

        apples.forEach((Apple apple) -> {
            final Color appleColor;
            if(apple.getTimeLeft()>20){
                appleColor = new Color(250,0,0,250);
            } else {
                appleColor = new Color(200,200,0,250);
            }
            g.setColor(appleColor);
            g.fillOval(apple.getX()*offset,apple.getY()*offset,(int)(offset*0.9),(int)(offset*0.9));
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.setBackground(new Color(60,60,120,160));
        super.paintComponent(g);
        this.paintCells(g);

        g.setColor(new Color(255,255,255,150));
        g.setFont(new Font("Arial", Font.BOLD,4*pixelPerPoint));
        g.drawString((worm.getLength() - 3) + "", 8,height*pixelPerPoint);
    }
}
