import javax.swing.*;
import java.awt.*;

public class BoardComponent extends JComponent {

    public BoardComponent(){
        BoardMouseListener listener = new BoardMouseListener(this);
        this.addMouseListener(listener);
    }
    public void paintComponent(Graphics g){

        Color color1 = new Color(233,174,95);
        Color color2 = new Color(177,113,24);
        int tileSize = 50;
        int x = 0;
        int y = 0;
        int count2 = 8;
        for (int j = 0; j < 8; j++){
            for (int i = 0; i < count2; i++) {
                if (i % 2 == j % 2) {
                    g.setColor(color1);
                } else {
                    g.setColor(color2);
                }
                g.fillRect(x, y, 50, 50);

                x+=50;
            }
            x = 0;
            y+=50;
        }
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                int b = i * tileSize;
                int a = j * tileSize;

                if (Chess.position[j][i] != null) {
                    Chess.position[j][i].drawPiece(g, b, a);
                }
            }
        }
    }
}
