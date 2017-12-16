package mx.unam.fciencias.myp;

import java.awt.geom.AffineTransform;

class ImmutablePoint {
    private int x;
    private int y;

    ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    ImmutablePoint rotate(double degrees, ImmutablePoint origin) {
        double theta = Math.toRadians(degrees);
        double[] point = {this.x, this.y};
        AffineTransform.getRotateInstance(theta, origin.x, origin.y)
                .transform(point, 0, point, 0, 1);
        return new ImmutablePoint((int) point[0], (int) point[1]);
    }

    ImmutablePoint translate(int dx, int dy) {
        return new ImmutablePoint(this.x + dx, this.y + dy);
    }

    ImmutablePoint scale(double factor, ImmutablePoint origin) {
        return new ImmutablePoint(
                (int)(origin.x + this.x * factor),
                (int)(origin.y + this.y * factor)
        );
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }
}
