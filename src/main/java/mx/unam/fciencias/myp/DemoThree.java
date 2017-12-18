package mx.unam.fciencias.myp;

import java.awt.*;

/**
 * A Demo that draws and shows an image that emulates the one shown in the
 * practice's third exercise: a chessboard.
 */
public class DemoThree extends Demo {
    /**
     * Creates the chessboard.
     */
    DemoThree() {
        super();
        this.title = "Chessboard";
    }

    @Override
    protected ImmutablePoint2D getOrigin() {
        return new ImmutablePoint2D(0, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        ImmutablePoint2D origin = getOrigin();
        Color[] colors = {Color.WHITE, Color.BLACK};
        int side = Integer.min(getWidth(), getHeight()) / 8;
        ImmutablePoint2D corner;
        for (int row = 0; row < 8; row++) {
            boolean evenRow = row % 2 == 0;
            for (int col = 0; col < 8; col++) {
                boolean evenCol = col % 2 == 0;
                if (evenRow) {
                    g.setColor(evenCol ? colors[0] : colors[1]);
                } else {
                    g.setColor(evenCol ? colors[1] : colors[0]);
                }
                corner = origin.translate(row * side, col * side);
                g.fillRect(
                        (int) corner.getX(), (int) corner.getY(),
                        side, side);
            }
        }
    }
}
