package mx.unam.fciencias.myp;

import java.awt.*;
import java.util.HashMap;

/**
 * A Demo that draws and shows an image that emulates the one shown in the
 * practice's second exercise.
 */
class DemoTwo extends Demo {
    /**
     * The amount of lines used for each of the drawing's sections.
     */
    private int lines;

    /**
     * Because this demo uses lines to create the impression of curves, this
     * constructor provides a way to set the amount of lines that should
     * constitute each of the drawing's sections.
     *
     * @param lines The amount of lines used for each of the drawing's
     *              sections.
     */
    DemoTwo(int lines) {
        super();
        this.lines = lines;
        this.title = "Drawing curves with lines 2";
    }

    @Override
    protected ImmutablePoint2D getOrigin() {
        return getCenter();
    }

    @Override
    public void paintComponent(Graphics g) {
        // Keep content within panel
        int min = Integer.min(getWidth(), getHeight());
        setSize(min, min);
        // Retrieve origin and factor
        ImmutablePoint2D origin = getOrigin();
        double factor = 0.7;
        // Calculate delta
        int delta = (int) origin.getX() / lines;
        // set initial points
        ImmutablePoint2D start = new ImmutablePoint2D(origin.getX(), origin.getY());
        ImmutablePoint2D end = new ImmutablePoint2D(origin.getX(), 0);
        ImmutablePoint2D p1, p2, p3, p4, quadrant_center;
        // create color hash map that maps angles to colors
        HashMap<Integer, Color> colorHashMap = new HashMap<>();
        colorHashMap.put(90, new Color(143, 12, 28));
        colorHashMap.put(270, new Color(200, 100, 100, 100));
        // for every quadrant rotation by 45 degrees
        for (int theta = 45 / 2; theta < 360 + 45 / 2; theta += 45) {
            // calculate the quadrant's center
            quadrant_center = origin
                    .translate(
                            origin.getX() / 2,
                            -origin.getY() / 2)
                    .rotate(theta, origin);
            // draw `lines` lines
            for (int i = 0; i <= lines; i++) {
                // calculate shift
                int dif = delta * i;
                // set basic endpoints
                p1 = start.translate(dif, 0).rotate(theta, origin);
                p2 = end.translate(0, dif).rotate(theta, origin);
                // set remaining angles
                int[] angles = {90, 270};
                // for the two remaining rotations
                for (int j : angles) {
                    g.setColor(colorHashMap.get(j));
                    p3 = p1.rotate(j, quadrant_center).scale(factor, getCenter());
                    p4 = p2.rotate(j, quadrant_center).scale(factor, getCenter());
                    g.drawLine(
                            (int) p3.getX(), (int) p3.getY(),
                            (int) p4.getX(), (int) p4.getY());
                }
            }
        }
    }
}

