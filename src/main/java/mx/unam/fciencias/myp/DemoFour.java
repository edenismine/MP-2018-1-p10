package mx.unam.fciencias.myp;

import java.awt.*;
import java.util.Random;

/**
 * A Demo that draws and shows an image that emulates the one shown in the
 * practice's fourth exercise: a caterpillar.
 */
class DemoFour extends Demo {
    /**
     * Creates the dynamic caterpillar.
     */
    DemoFour() {
        super();
        this.title = "Caterpillar";
    }

    @Override
    protected ImmutablePoint2D getOrigin() {
        return new ImmutablePoint2D(0, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        ImmutablePoint2D head, eye1, eye2;
        ImmutablePoint2D corner = getOrigin();
        Random random = new Random();
        int dx = 0;
        int dy = 0;
        int side = 50;
        int step = 32;
        int[] options = {0, step};
        while (corner.getX() + side < getWidth() && corner.getY() + side < getHeight()) {
            g.setColor(Color.GREEN.darker());
            g.fillOval(
                    (int) corner.getX(), (int) corner.getY(),
                    side, side);
            dx = options[random.nextInt(options.length)];
            dy = options[random.nextInt(options.length)];
            corner = corner.translate(dx, dy);
        }
        head = corner.translate(-dx, -dy);
        eye1 = head.translate(10, 10);
        eye2 = head.translate(30, 10);
        int eyeSide = 10;
        g.setColor(Color.GREEN.darker().darker());
        g.fillOval((int) head.getX(), (int) head.getY(), side, side);
        g.setColor(Color.WHITE);
        g.fillOval((int) eye1.getX(), (int) eye1.getY(), eyeSide, eyeSide);
        g.fillOval((int) eye2.getX(), (int) eye2.getY(), eyeSide, eyeSide);
        g.setColor(Color.BLACK);
        int pupil = eyeSide / 2;
        g.fillOval(
                (int) eye1.translate(pupil, pupil).getX(),
                (int) eye1.translate(pupil, pupil).getY(),
                pupil, pupil);
        g.fillOval(
                (int) eye2.translate(pupil, pupil).getX(),
                (int) eye2.translate(pupil, pupil).getY(),
                pupil, pupil);
    }
}
