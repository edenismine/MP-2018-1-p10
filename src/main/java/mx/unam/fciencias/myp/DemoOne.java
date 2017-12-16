package mx.unam.fciencias.myp;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.HashMap;

class DemoOne extends JPanel {
    private int lines;

    DemoOne(int lines) {
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
        // Calculate delta
        int delta = origin.getX() / lines;
        ImmutablePoint start = new ImmutablePoint(origin.getX(), origin.getY());
        ImmutablePoint end = new ImmutablePoint(origin.getX(), 0);
        ImmutablePoint p1, p2, quadrant_origin;
        HashMap<Integer, Color> colorHashMap = new HashMap<>();
        colorHashMap.put(90, new Color(200, 100, 100, 185));
        colorHashMap.put(180, new Color(255, 195, 55, 185));
        colorHashMap.put(270, new Color(81, 129, 255, 185));
        for (int theta = 0; theta <= 360; theta += 90) {
            quadrant_origin = origin.translate(origin.getX() / 2, -origin.getY() / 2).rotate(theta, origin);
            for (int i = 1; i < lines; i++) {
                int dif = delta * i;
                // Inner
                g.setColor(Color.RED);
                p1 = start.translate(dif, 0).rotate(theta, origin);
                p2 = end.translate(0, dif).rotate(theta, origin);
                g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
                // Outer
                for (int j = 90; j < 360; j += 90) {
                    g.setColor(colorHashMap.get(j));
                    p1 = p1.rotate(j, quadrant_origin);
                    p2 = p2.rotate(j, quadrant_origin);
                    g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
                }
            }
        }
    }
}

