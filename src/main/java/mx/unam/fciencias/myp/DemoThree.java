package mx.unam.fciencias.myp;

import java.awt.*;

public class DemoThree extends Demo {
    DemoThree() {
        super();
        this.title = "Chessboard";
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g, new ImmutablePoint(0, 0));
    }

    @Override
    protected void draw(Graphics g, ImmutablePoint origin) {
        Color[] colors = {Color.WHITE, Color.BLACK};
        int side = Integer.min(getWidth(), getHeight()) / 8;
        ImmutablePoint corner;
        for (int row = 0; row < 8; row++) {
            boolean evenRow = row % 2 == 0;
            for (int col = 0; col < 8; col++) {
                boolean evenCol = col % 2 == 0;
                if (evenRow) {
                    g.setColor(evenCol ? colors[0] : colors[1]);
                } else {
                    g.setColor(evenCol ? colors[1] : colors[0]);
                }
                corner = new ImmutablePoint(row * side, col * side);
                g.fillRect(corner.getX(), corner.getY(), side, side);
            }
        }
    }
}
