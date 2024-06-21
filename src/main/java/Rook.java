import javax.swing.*;
import java.awt.*;

public class Rook extends Piece{


    public Rook(boolean isWhite) {
        super(null, isWhite);
        if (isWhite){
            this.image = new ImageIcon("src/chessimages/wrook.gif");
        } else {
            this.image = new ImageIcon("src/chessimages/brook.gif");
        }
    }

    // DONE
    public boolean canMove(int startx, int starty, int endx, int endy){
        if (startx == endx || starty == endy) {
            int xDirection = Integer.compare(endx, startx);
            int yDirection = Integer.compare(endy, starty);

            int x = startx + xDirection;
            int y = starty + yDirection;

            while (x != endx || y != endy) {
                if (Chess.position[x][y] != null) {
                    return false;
                }
                x+=xDirection;
                y+=yDirection;
            }

            if (Chess.position[endx][endy] == null) {
                return true;
            } else if (getColor() != Chess.position[endx][endy].getColor()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
