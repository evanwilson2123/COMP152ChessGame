import javax.swing.*;
import java.awt.*;

public abstract class Piece {

    ImageIcon image;
    boolean isWhite;

    int moveCount = 0;

    public Piece(ImageIcon image, boolean isWhite) {
        this.image = image;
        this.isWhite = isWhite;
    }

    public void drawPiece(Graphics g, int x, int y){
        if (image != null) {
            g.drawImage(image.getImage(), x, y, null);
        } else {
            System.out.println("Image is null for piece at: " + x + ", " + y);
        }
    }

    public boolean getColor() {
        return this.isWhite;
    }

    public abstract boolean canMove(int startx, int starty, int endx, int endy);

    public void addMove(){
        this.moveCount++;
    }
    public int getMoveCount(){
        return this.moveCount;
    }
}
