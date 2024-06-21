import javax.swing.*;

public class King extends Piece{

    public King(boolean isWhite){
        super(null, isWhite);
        if (isWhite){
            this.image = new ImageIcon("src/chessimages/wking.gif");
        } else {
            this.image = new ImageIcon("src/chessimages/bking.gif");
        }
    }

    // DONE
    public boolean canMove(int startx, int starty, int endx, int endy){
        if (
            (Math.abs(startx - endx) == 1 && Math.abs(starty - endy) == 0)
            || (Math.abs(startx - endx) == 0 && Math.abs(starty - endy) == 1)
            || (Math.abs(startx - endx) == 1 && Math.abs(starty - endy) == 1)) {
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
