public class TestPolymorphism2 {
    public static void main(String[] args) {
        Layer layer = new Layer();
        Square s1 = new Square(new Point(1.25, 1.92), 2.02, "GREEN", false);
        Square s2 = new Square(1, "GREEN", true);
        Circle c1 = new Circle(new Point(1.92, 1.25), 2.2, "RED", false);
        Circle c2 = new Circle(1, "RED", true);
        Rectangle r1 = new Rectangle(new Point(7, 7), 2, 1, "BLUE", true);
        Rectangle r2 = new Rectangle(1, 1, "BLUE", false);
        Rectangle r3 = new Rectangle(new Point(7, 7), 2, 1, "BLUE", true);
        layer.addShape(s1);
        layer.addShape(c1);
        layer.addShape(r1);
        layer.addShape(s2);
        layer.addShape(c2);
        layer.addShape(r2);
        layer.addShape(r3);
        System.out.println(layer.getInfo());
        layer.removeDuplicates();
        System.out.println(layer.getInfo());
        layer.removeCircles();
        System.out.println(layer.getInfo());
    }
}
