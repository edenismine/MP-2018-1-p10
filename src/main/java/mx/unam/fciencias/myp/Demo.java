package mx.unam.fciencias.myp;

import javax.swing.*;
import java.awt.*;

public abstract class Demo extends JPanel {
    protected String title;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(getOrigin().getX() * 2, getOrigin().getY() * 2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g, getOrigin());
    }

    ImmutablePoint getOrigin() {
        return new ImmutablePoint(getWidth() / 2, getHeight() / 2);
    }

    protected abstract void draw(Graphics g, ImmutablePoint origin);
}
