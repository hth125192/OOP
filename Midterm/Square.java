public class Square extends Rectangle {
    public Square() {

    }

    public Square(double side) {
        super(side, side);
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
    public void draw() {
        System.out.println("Ve hinh vuong");
    }
}