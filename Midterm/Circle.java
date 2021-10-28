public class Circle extends Shape {
    protected double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Ve hinh tron");
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
