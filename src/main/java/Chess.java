import javax.swing.*;

public class Chess {

    public static Piece[][] position = new Piece[8][8];
    public static void main(String[] args){
        System.out.println("Starting chess...");
        initializeBoard();
        JFrame window = new JFrame("CHESS");
        window.setSize(400, 428);
        BoardComponent board = new BoardComponent();
        BoardMouseListener mouseListener = new BoardMouseListener(board);
        board.addMouseListener(mouseListener);
        window.add(board);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    private static void initializeBoard(){
        // Initialize black pieces
        position[0][0] = new Rook(false);
        position[0][1] = new Knight(false);
        position[0][2] = new Bishop(false);
        position[0][3] = new Queen(false);
        position[0][4] = new King(false);
        position[0][5] = new Bishop(false);
        position[0][6] = new Knight(false);
        position[0][7] = new Rook(false);
        for (int i = 0; i < 8; i++) {
            position[1][i] = new Pawn(false);
        }

        // Initialize white pieces
        position[7][0] = new Rook(true);
        position[7][1] = new Knight(true);
        position[7][2] = new Bishop(true);
        position[7][3] = new Queen(true);
        position[7][4] = new King(true);
        position[7][5] = new Bishop(true);
        position[7][6] = new Knight(true);
        position[7][7] = new Rook(true);
        for (int i = 0; i < 8; i++) {
            position[6][i] = new Pawn(true);
        }
    }
}
