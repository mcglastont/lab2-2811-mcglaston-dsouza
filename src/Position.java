/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Garden - Extended
 * Author:     Sean D'Souza
 * Date:       1/5/2022
 */

/**
 * This class represents a position within the garden.
 * Positions on both axes go from 0 to 1, to make it easier to scale and to work with.
 */
public class Position {

    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void movePosition(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public void movePosition(double[] vector) {
        if (vector.length != 2) return;
        x += vector[0];
        y += vector[1];
    }

    public double[] getPosition() {
        return new double[]{x, y};
    }

    public double distance(Position p) {
        return Math.hypot(p.getX() - x, p.getY() - y);
    }

}
