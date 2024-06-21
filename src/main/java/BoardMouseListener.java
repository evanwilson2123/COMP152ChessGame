import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Timer;

public class BoardMouseListener implements MouseListener {
    int startx, starty, endx, endy;
    BoardComponent boardComponent;
    public BoardMouseListener(BoardComponent boardComponent){
        this.boardComponent = boardComponent;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        startx = e.getY()/50;
        starty = e.getX()/50;
        System.out.println("Pressed! x: " + startx + " y: " + starty);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endx = e.getY()/50;
        endy = e.getX()/50;

        System.out.println("Moved to: " + endx + ", " + endy);

        // Ensure the move is within bounds
        if (startx < 0 || startx > 7 || starty < 0 || starty > 7 ||
            endx < 0 || endx > 7 || endy < 0 || endy > 7) {
                System.out.println("Move out of bounds, ignoring.");
        }

        // Check if there is a piece to move
        if (
            Chess.position[startx][starty] != null
            && Chess.position[startx][starty].getColor()
            && Chess.position[startx][starty].canMove(startx, starty, endx, endy)) {
                // add move to move count
                Chess.position[startx][starty].addMove();
                System.out.println(Chess.position[startx][starty].getMoveCount());
                // Move the piece
                Chess.position[endx][endy] = Chess.position[startx][starty];
                Chess.position[startx][starty] = null;
                System.out.println("Piece moved from " + startx + ", " + starty + " to " + endx + ", " + endy);
                boardComponent.repaint();
                makeRandomMove();
        } else {
            System.out.println("No piece at starting position.");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }
    public void makeRandomMove(){
        while (true) {
            Random random = new Random();
            int startx = random.nextInt(0, 8);
            int starty = random.nextInt(0, 8);
            int endx = random.nextInt(0,8);
            int endy = random.nextInt(0, 8);
            if (endx > 7 || endy > 7 || endx < 0 || endy < 0){
                continue;
            }
            else if (Chess.position[startx][starty] == null || Chess.position[startx][starty].getColor()) {
                continue;
            } else if (startx == endx && starty == endy) {
                continue;
            } else if (!Chess.position[startx][starty].canMove(startx, starty, endx, endy)){
                continue;
            }
            Chess.position[endx][endy] = Chess.position[startx][starty];
            Chess.position[startx][starty] = null;
            break;
        }
        boardComponent.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

