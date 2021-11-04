import java.util.ArrayList;
import java.util.List;

public class TestInterface {
    public static void main(String[] args) {
        List<GeometricObject> shapes = new ArrayList<>();
        ShapeUtil shapeUtil = new ShapeUtil();
        GeometricObject c1 = new Circle(new Point(1, 2), 3);
        Circle c2 = new Circle(new Point(5, 6), 2);
        GeometricObject t1 = new Triangle(new Point(1, 2), new Point(2, 3), new Point(3, 0));
        Triangle t2 = new Triangle(new Point(-1, -3), new Point(-5, 3), new Point(0, 0));
        //GeometricObject t3 = new Triangle(new Point(-1, -3), new Point(0, 0), new Point(0, 0));
        //Triangle t4 = new Triangle(new Point(-1, -3), new Point(-2, -6), new Point(0, 0));
        shapes.add(t1);
        shapes.add(t2);
        shapes.add(c1);
        shapes.add(c2);
        System.out.println(shapeUtil.printInfo(shapes));
        shapes.remove(3);
        shapes.remove(2);
        System.out.println(shapeUtil.printInfo(shapes));
    }
}
