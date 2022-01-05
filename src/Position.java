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
        setX(this.x + dx);
        setY(this.y + dy);
    }

    public void movePosition(double[] vector) {
        if (vector.length != 2) return;
        setX(getX() + vector[0]);
        setY(getY() + vector[1]);
    }

    public double[] getPosition() {
        return new double[]{x, y};
    }

    public double distance(Position p) {
        return Math.hypot(p.getX() - x, p.getY() - y);
    }

}
