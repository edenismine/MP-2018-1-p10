package mx.unam.fciencias.myp;

import java.awt.*;
import java.util.HashMap;

/**
 * A Demo that draws and shows an image that emulates the one shown in the
 * practice's first exercise.
 */
class DemoOne extends Demo {
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
    DemoOne(int lines) {
        super();
        this.lines = lines;
        this.title = "Drawing curves with lines 1";
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
        // Retrieve origin
        ImmutablePoint2D origin = getOrigin();
        // Calculate delta
        int delta = (int) origin.getX() / lines;
        // set initial points
        ImmutablePoint2D start = new ImmutablePoint2D(origin.getX(), origin.getY());
        ImmutablePoint2D end = new ImmutablePoint2D(origin.getX(), 0);
        ImmutablePoint2D p1, p2, quadrant_center;
        // create color hash map that maps angles to colors
        HashMap<Integer, Color> colorHashMap = new HashMap<>();
        colorHashMap.put(0, Color.RED);
        colorHashMap.put(90, new Color(200, 100, 100, 185));
        colorHashMap.put(180, new Color(255, 195, 55, 185));
        colorHashMap.put(270, new Color(81, 129, 255, 185));
        // for every quadrant
        for (int theta = 0; theta < 360; theta += 90) {
            // calculate the quadrant's center
            quadrant_center = origin
                    .translate(origin.getX() / 2, -origin.getY() / 2)
                    .rotate(theta, origin);
            // draw `lines` lines
            for (int i = 0; i <= lines; i++) {
                // calculate shift
                int dif = delta * i;
                // get base end points translated by delta
                p1 = start.translate(dif, 0).rotate(theta, origin);
                p2 = end.translate(0, dif).rotate(theta, origin);
                // for the quadrant's remaining orientations
                for (int j = 0; j < 360; j += 90) {
                    // draw corresponding rotations of the base line around
                    // the quadrant's center
                    g.setColor(colorHashMap.get(j));
                    p1 = p1.rotate(j, quadrant_center);
                    p2 = p2.rotate(j, quadrant_center);
                    g.drawLine(
                            (int) p1.getX(), (int) p1.getY(),
                            (int) p2.getX(), (int) p2.getY());
                }
            }
        }
    }
}

