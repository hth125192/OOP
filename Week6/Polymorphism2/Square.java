public class Square extends Rectangle {
    public Square() {

    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public Square(Point topLeft, double side, String color, boolean filled) {
        super(topLeft, side, side, color, filled);
    }

    public double getSide() {
        return width;
    }

    public void setSide(double side) {
        this.width = side;
        this.length = side;
    }

    @Override
    public void setWidth(double side) {
        this.width = side;
        this.length = side;
    }

    @Override
    public void setLength(double side) {
        this.width = side;
        this.length = side;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    /** toString. */
    public String toString() {
        return "Square[topLeft=" + topLeft.toString()
                + ",side=" + (double) Math.round(getWidth() * 10) / 10
                + ",color=" + getColor() + ",filled=" + isFilled() + "]";
    }
}
