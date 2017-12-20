/**
 * <p>This package contains four Java Swing Demos that use
 * {@link java.awt.Graphics#drawLine(int, int, int, int)},
 * {@link java.awt.Graphics#fillRect(int, int, int, int)} and
 * {@link java.awt.Graphics#fillOval(int, int, int, int)} in order to draw
 * the figures described by the practice's specifications as requested. Each
 * demo corresponds to one of the practice's exercises.</p>
 *
 * <p>It uses some custom tools in order to make drawing using mathematical
 * transformations easier. All the demos inherit from an abstract subclass of
 * {@link javax.swing.JPanel} ({@link mx.unam.fciencias.myp.Demo}) which
 * implements a method ({@link mx.unam.fciencias.myp.Demo#getCenter()}) that
 * returns an {@link mx.unam.fciencias.myp.ImmutablePoint2D} object that
 * contains the coordinates of the center of the panel.</p>
 *
 * <p>That class also provides the specification of the method
 * {@link mx.unam.fciencias.myp.Demo#getOrigin()} which provides each demo a
 * way to customize the desired cartesian coordinate origin it should work
 * with.</p>
 *
 * @author Luis Daniel Arago Bermudez
 */
package mx.unam.fciencias.myp;
