package mx.unam.fciencias.myp;

import java.awt.geom.AffineTransform;

/**
 * This class represents an immutable point in 2 dimensions.
 * It implements non-destructive operations that return new objects.
 */
class ImmutablePoint2D {
    private double x;
    private double y;

    /**
     * As this is a two-dimensional point, in order to create a new object,
     * we only need to provide its x-y cartesian
     * coordinates.
     *
     * @param x x coordinate.
     * @param y y coordinate.
     */
    ImmutablePoint2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This method returns a new point that corresponds to this point's
     * position if the plane was rotated <code>degrees</code> degrees around
     * the provided point.
     *
     * @param degrees The angle of rotation in degrees.
     * @param origin  The point relative to which the rotation is performed.
     * @return a rotated point.
     */
    ImmutablePoint2D rotate(double degrees, ImmutablePoint2D origin) {
        double theta = Math.toRadians(degrees);
        double[] point = {this.x, this.y};
        AffineTransform.getRotateInstance(theta, origin.x, origin.y)
                .transform(point, 0, point, 0, 1);
        return new ImmutablePoint2D(point[0], point[1]);
    }

    /**
     * This method returns a new point that corresponds to this point's
     * position if the plane was translated <code>dx</code> units on the
     * x-axis and <code>dy</code> units on the y-axis.
     *
     * @param dx Displacement on the x-axis.
     * @param dy Displacement on the y-axis.
     * @return a translated point.
     */
    ImmutablePoint2D translate(double dx, double dy) {
        return new ImmutablePoint2D(this.x + dx, this.y + dy);
    }

    /**
     * This method returns a new point that corresponds to this point's
     * position if the plane was scaled by the provided factor around the
     * provided point.
     *
     * @param factor The angle of rotation in degrees.
     * @param origin The point relative to which the rotation is performed.
     * @return a rotated point.
     */
    ImmutablePoint2D scale(double factor, ImmutablePoint2D origin) {
        return new ImmutablePoint2D(
                origin.x + this.x * factor - factor * origin.getX(),
                origin.y + this.y * factor - factor * origin.getY()
        );
    }

    /**
     * Retrieves this point's x-coordinate.
     *
     * @return This point's x-coordinate.
     */
    double getX() {
        return this.x;
    }

    /**
     * Retrieves this point's y-coordinate.
     *
     * @return This point's y-coordinate.
     */
    double getY() {
        return this.y;
    }
}
