package mx.unam.fciencias.myp;

import javax.swing.*;
import java.awt.*;

/**
 * A JPanel with persistent sizing and custom drawings that use
 * {@link ImmutablePoint2D}s to locate important points within the panel.
 */
public abstract class Demo extends JPanel {
    /**
     * This demo's title.
     */
    protected String title;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(
                (int) getCenter().getX() * 2,
                (int) getCenter().getY() * 2);
    }

    /**
     * Returns an ImmutablePoint2D that correspond's to the demo's center.
     *
     * @return an ImmutablePoint2D that correspond's to the demo's center.
     */
    ImmutablePoint2D getCenter() {
        return new ImmutablePoint2D(getWidth() / 2, getHeight() / 2);
    }

    /**
     * This method returns an ImmutablePoint2D that corresponds to the
     * demo's coordinate system's origin.
     *
     * @return an ImmutablePoint2D that corresponds to the demo's coordinate
     * system's origin.
     */
    protected abstract ImmutablePoint2D getOrigin();
}
