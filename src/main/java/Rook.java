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
        if (startx - endx == 0 || starty - endy == 0) {
            if (startx > endx) {
                for (int i = startx-1; i > endx; i--) {
                    if (Chess.position[i][starty] != null) {
                        return false;
                    }
                }
            } else if (startx < endx) {
                for (int i = startx+1; i < endx; i++) {
                    if (Chess.position[i][starty] != null) {
                        return false;
                    }
                }
            } else if (starty > endy) {
                for (int i = starty-1; i > endy; i--) {
                    if (Chess.position[startx][i] != null) {
                        return false;
                    }
                }
            } else {
                for (int i = starty+1; i < endy; i++) {
                    if (Chess.position[startx][i] != null) {
                        return false;
                    }
                }
            }
            if (Chess.position[endx][endy] == null){
                return true;
            } else if (getColor() == Chess.position[endx][endy].getColor()) {
                return false;
            } else if (getColor() != Chess.position[endx][endy].getColor()){
                return true;
            }
            return false;
        }
        return false;
    }
}
