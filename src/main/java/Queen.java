import javax.swing.*;

public class Queen extends Piece{

    public Queen(boolean isWhite){
        super(null, isWhite);
        if (isWhite){
            this.image = new ImageIcon("src/chessimages/wqueen.gif");
        } else {
            this.image = new ImageIcon("src/chessimages/bqueen.gif");
        }
    }

    // DONE
    public boolean canMove(int startx, int starty, int endx, int endy){
        int dx = Math.abs(startx - endx);
        int dy = Math.abs(starty - endy);

        if (dx == dy || startx == endx || starty == endy){
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
            if (Chess.position[endx][endy] == null){
                return true;
            } else if (getColor() != Chess.position[endx][endy].getColor()) {
                return false;
            } else {
                return false;
            }
        }
        return false;
    }
}
