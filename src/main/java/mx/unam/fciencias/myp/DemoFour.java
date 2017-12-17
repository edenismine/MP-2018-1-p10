package mx.unam.fciencias.myp;

import java.awt.*;
import java.util.Random;

public class DemoFour extends Demo {
    DemoFour() {
        super();
        this.title = "Caterpillar";
    }

    @Override
    protected ImmutablePoint getOrigin() {
        return new ImmutablePoint(0, 0);
    }

    @Override
    protected void draw(Graphics g) {
        ImmutablePoint head, eye1, eye2;
        ImmutablePoint corner = getOrigin();
        Random random = new Random();
        int dx = 0;
        int dy = 0;
        int side = 50;
        int step = 30;
        int[] options = {0, step};
        while (corner.getX() + side < getWidth() && corner.getY() + side < getHeight()) {
            g.setColor(Color.GREEN.darker());
            g.fillOval(corner.getX(), corner.getY(), side, side);
            dx = options[random.nextInt(options.length)];
            dy = options[random.nextInt(options.length)];
            corner = corner.translate(dx, dy);
        }
        head = corner.translate(-dx, -dy);
        eye1 = head.translate(10, 10);
        eye2 = head.translate(30, 10);
        int eyeSide = 10;
        g.setColor(Color.GREEN.darker().darker());
        g.fillOval(head.getX(), head.getY(), side, side);
        g.setColor(Color.WHITE);
        g.fillOval(eye1.getX(), eye1.getY(), eyeSide, eyeSide);
        g.fillOval(eye2.getX(), eye2.getY(), eyeSide, eyeSide);
        g.setColor(Color.BLACK);
        int pupil = eyeSide / 2;
        g.fillOval(
                eye1.translate(pupil, pupil).getX(),
                eye1.translate(pupil, pupil).getY(),
                pupil, pupil);
        g.fillOval(
                eye2.translate(pupil, pupil).getX(),
                eye2.translate(pupil, pupil).getY(),
                pupil, pupil);
    }
}
