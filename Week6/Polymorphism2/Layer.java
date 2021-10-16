import java.util.ArrayList;
import java.util.List;

public class Layer {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /** getInfo. */
    public String getInfo() {
        String s = "Layer of crazy shapes:\n";
        for (int i = 0; i < shapes.size(); i++) {
            s = s + shapes.get(i).toString() + "\n";
        }
        return s;
    }

    /** removeCircles. */
    public void removeCircles() {
        for (int i = shapes.size() - 1; i >= 0; i--) {
            if (shapes.get(i) instanceof Circle) {
                shapes.remove(i);
            }
        }
    }

    /** removeDuplicates. */
    public void removeDuplicates() {
        for (int i = 0; i < shapes.size(); i++) {
            Shape newShape = shapes.get(i);
            for (int j = 0; j < shapes.size(); j++) {
                if (shapes.get(j).equals(newShape)) {
                    shapes.remove(j);
                }
            }
            shapes.add(i, newShape);
        }
    }

}
