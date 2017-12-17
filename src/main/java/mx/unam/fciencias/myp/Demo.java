package mx.unam.fciencias.myp;

import javax.swing.*;
import java.awt.*;

public abstract class Demo extends JPanel {
    protected String title;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(getCenter().getX() * 2, getCenter().getY() * 2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    ImmutablePoint getCenter() {
        return new ImmutablePoint(getWidth() / 2, getHeight() / 2);
    }

    protected abstract ImmutablePoint getOrigin();

    protected abstract void draw(Graphics g);
}
