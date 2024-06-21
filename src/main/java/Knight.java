import javax.swing.*;

public class Knight extends Piece{

    public Knight(boolean isWhite){
        super(null, isWhite);
        if (isWhite){
            this.image = new ImageIcon("src/chessimages/wknight.gif");
        } else {
            this.image = new ImageIcon("src/chessimages/bknight.gif");
        }
    }
    public boolean canMove(int startx, int starty, int endx, int endy){
        int dx = Math.abs(startx - endx);
        int dy = Math.abs(starty - endy);
        if ((dx == 1 && dy == 2) || (dx == 2 && dy == 1)) {
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
