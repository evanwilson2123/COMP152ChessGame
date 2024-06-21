import javax.swing.*;

public class Bishop extends Piece{

    public Bishop(boolean isWhite){
        super(null, isWhite);
        if (isWhite){
            this.image = new ImageIcon("src/chessimages/wbishop.gif");
        } else {
            this.image = new ImageIcon("src/chessimages/bbishop.gif");
        }
    }

    // DONE
    public boolean canMove(int startx, int starty, int endx, int endy){
        int dx = Math.abs(startx - endx);
        int dy = Math.abs(starty - endy);

        if (dx != dy) {
            return false;
        }

        int xDirection = (endx - startx) > 0 ? 1: -1;
        int yDirection = (endy - starty) > 0 ? 1: -1;

        int x = startx + xDirection;
        int y = starty + yDirection;

        while (x != endx && y != endy) {
            if (Chess.position[x][y] != null) {
                return false;
            }
            x += xDirection;
            y += yDirection;
        }

        if (Chess.position[endx][endy] == null) {
            return true;
        } else if (getColor() != Chess.position[endx][endy].getColor()) {
            return true;
        } else {
            return false;
        }
    }
}
