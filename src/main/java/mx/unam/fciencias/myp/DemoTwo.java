package mx.unam.fciencias.myp;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

class DemoTwo extends JPanel {
    private int lines;

    DemoTwo(int lines) {
        super();
        this.lines = lines;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(getOrigin().getX() * 2, getOrigin().getY() * 2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawQuadrant(g, getOrigin());
    }

    private ImmutablePoint getOrigin() {
        return new ImmutablePoint(getWidth() / 2, getHeight() / 2);
    }

    private void drawQuadrant(Graphics g, ImmutablePoint origin) {
        double factor = 0.7;
        g.setColor(Color.MAGENTA);
        // Calculate delta
        int delta = origin.getX() / lines;
        ImmutablePoint start = new ImmutablePoint(origin.getX(), origin.getY());
        ImmutablePoint end = new ImmutablePoint(origin.getX(), 0);
        ImmutablePoint p1, p2, p3, p4, quadrant_origin;
        HashMap<Integer, Color> colorHashMap = new HashMap<>();
        colorHashMap.put(90, new Color(143, 12, 28));
        colorHashMap.put(270, new Color(200, 100, 100, 100));
        for (int theta = 45/2; theta <= 360+45/2; theta += 45) {
            quadrant_origin = origin.translate(origin.getX() / 2, -origin.getY() / 2).rotate(theta, origin);
            for (int i = 1; i < lines; i++) {
                int dif = delta * i;
                // Inner
                g.setColor(Color.RED);
                p1 = start.translate(dif, 0).rotate(theta, origin);
                p2 = end.translate(0, dif).rotate(theta, origin);
                // Outer
                int[] angles = {90, 270};
                for (int j : angles) {
                    g.setColor(colorHashMap.get(j));
                    p3 = p1.rotate(j, quadrant_origin).scale(factor, getOrigin()).translate((int) (-factor * getOrigin().getX()), (int) (-factor * getOrigin().getY()));
                    p4 = p2.rotate(j, quadrant_origin).scale(factor, getOrigin()).translate((int) (-factor * getOrigin().getX()), (int) (-factor * getOrigin().getY()));
                    g.drawLine(
                            p3.getX(), p3.getY(),
                            p4.getX(), p4.getY()
                    );
                }
            }
        }
    }
}

