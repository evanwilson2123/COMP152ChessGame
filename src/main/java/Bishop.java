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
        if (dx == dy) {
            if (endx-startx > 0 && endy-starty > 0) {
                int x = startx;
                int y = starty;
                for (int i = startx; i < endx; i++) {
                    x++;
                    y++;
                    if (Chess.position[x][y] != null && Chess.position[x][y].getColor() != Chess.position[startx][starty].getColor()) {
                        continue;
                    }
                    else if (Chess.position[x][y] != null) {
                        return false;
                    }
                }
            } else if (endx-startx > 0 && endy-starty < 0) {
                int x = startx;
                int y = starty;
                for (int i = startx; i < endx; i++) {
                    x++;
                    y--;
                    if (Chess.position[x][y] != null && Chess.position[x][y].getColor() != Chess.position[startx][starty].getColor()) {
                        continue;
                    }
                    else if (Chess.position[x][y] != null) {
                        return false;
                    }
                }
            } else if (endx-startx < 0 && endy-starty > 0) {
                int x = startx;
                int y = starty;
                for (int i = startx; i < endx; i++) {
                    x--;
                    y++;
                    if (Chess.position[x][y] != null && Chess.position[x][y].getColor() != Chess.position[startx][starty].getColor()) {
                        continue;
                    } else if (Chess.position[x][y] != null) {
                        return false;
                    }
                }
            } else if (endx-startx < 0 && endy-starty < 0) {
                int x = startx-1;
                int y = starty-1;
                for (int i = startx; i < endx; i++) {
                    if (Chess.position[x][y] != null) {
                        return false;
                    } else if (Chess.position[x][y] != null && Chess.position[x][y].getColor() != Chess.position[startx][starty].getColor()) {
                        continue;
                    }
                    x--;
                    y--;
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
