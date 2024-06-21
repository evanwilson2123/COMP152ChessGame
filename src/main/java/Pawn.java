import javax.swing.*;

public class Pawn extends Piece{

    public Pawn(boolean isWhite){
        super(null, isWhite);
        if (isWhite){
            this.image = new ImageIcon("src/chessimages/wpawn.gif");
        } else {
            this.image = new ImageIcon("src/chessimages/bpawn.gif");
        }

    }
    // DONE
//    public boolean canMove(int startx, int starty, int endx, int endy) {
//        int direction;
//        if (isWhite) {
//            direction = -1;
//        } else {
//            direction = 1;
//        }
//
//        // Normal move
//        if (starty == endy) {
//            if (startx + direction == endx) {
//                if (Chess.position[endx][endy] == null){
//                    return true;
//                } else if (getColor() == Chess.position[endx][endy].getColor()) {
//                    return false;
//                } else if (getColor() != Chess.position[endx][endy].getColor()){
//                    return true;
//                }
//                return false;
//            }
//            // First move can be two steps
//            if (getMoveCount() == 0 && startx + 2 * direction == endx &&
//                    Chess.position[endx][endy] == null && Chess.position[endx][starty + direction] == null) {
//                if (Chess.position[endx][endy] == null){
//                    return true;
//                } else if (getColor() == Chess.position[endx][endy].getColor()) {
//                    return false;
//                } else if (getColor() != Chess.position[endx][endy].getColor()){
//                    return true;
//                }
//                return false;
//            }
//        }
//
//        // Capture move
//        if (Math.abs(starty - endy) == 1 && startx + direction == endx &&
//                Chess.position[endx][endy] != null && Chess.position[endx][endy].isWhite != isWhite) {
//            if (Chess.position[endx][endy] == null){
//                return true;
//            } else if (getColor() == Chess.position[endx][endy].getColor()) {
//                return false;
//            } else if (getColor() != Chess.position[endx][endy].getColor()){
//                return true;
//            }
//            return false;
//        }
//
//        return false;
//    }
    // DONE
    public boolean canMove(int startx, int starty, int endx, int endy) {
        int direction;
        if (isWhite) {
            direction = -1;
        } else {
            direction = 1;
        }

        // Ensure the move is within the board boundaries
        if (endx < 0 || endx > 7 || endy < 0 || endy > 7) {
            return false;
        }

        // Normal move
        if (starty == endy) {
            if (startx + direction == endx) {
                if (Chess.position[endx][endy] == null){
                    return true;
                }
                return false;
            }
            // First move can be two steps
            if (getMoveCount() == 0 && startx + 2 * direction == endx &&
                    Chess.position[endx][endy] == null && Chess.position[startx + direction][starty] == null) {
                return true;
            }
        }

        // Capture move
        if (Math.abs(starty - endy) == 1 && startx + direction == endx &&
                Chess.position[endx][endy] != null && Chess.position[endx][endy].isWhite != isWhite) {
            return true;
        }

        return false;
    }
}
