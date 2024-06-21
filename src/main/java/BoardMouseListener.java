import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    public void makeRandomMove() {
        Random random = new Random();
        /* storage for all moves
           move will be an array of 4 ints:
                  0: startx
                  1: starty
                  2: endx
                  3: endy                      */
        List<int[]> capturingMoves = new ArrayList<>();
        List<int[]> regularMoves = new ArrayList<>();


        // loop through all x positions of each row
        for (int startx = 0; startx < 8; startx++) {
            // loop through all y positions on board
            for (int starty = 0; starty < 8; starty++) {
                // store position in piece
                Piece piece = Chess.position[startx][starty];
                // make sure the piece is a black piece
                if (piece != null && !piece.getColor()) {
                    // choose endx
                    for (int endx = 0; endx < 8; endx++) {
                        // choose endy
                        for (int endy = 0; endy < 8; endy++) {
                            // ensure the piece can move
                            if (piece.canMove(startx, starty, endx, endy)) {
                                // if the end position has a white piece, store (move) in capturing moves
                                if (Chess.position[endx][endy] != null && Chess.position[endx][endy].getColor()) {
                                    capturingMoves.add(new int[]{startx, starty, endx, endy});
                                // if not store move in regular moves
                                } else if (Chess.position[endx][endy] == null) {
                                    regularMoves.add(new int[]{startx, starty, endx, endy});
                                }
                            }
                        }
                    }
                }
            }
        }

        // initialize move
        int[] move = null;

        // prioritize capturing moves
        if (!capturingMoves.isEmpty()) {
            move = capturingMoves.get(random.nextInt(capturingMoves.size()));
        } else if (!regularMoves.isEmpty()) {
            move = regularMoves.get(random.nextInt(regularMoves.size()));
        }

        // execute the move if found
        if (move != null) {
            int startx = move[0];
            int starty = move[1];
            int endx = move[2];
            int endy = move[3];
            Chess.position[endx][endy] = Chess.position[startx][starty];
            Chess.position[startx][starty] = null;
            boardComponent.repaint();
        } else {
            System.out.println("No valid moves found for AI.");
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}