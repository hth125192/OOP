import java.util.ArrayList;
import java.util.List;

public class Ex2Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(7, 0, 1, 4, 0, 2, 1, 7));
        //Context context = new Context(new BubbleSort());
        Context context = new Context(new SelectionSort());
        context.sortStrategy(list);
        System.out.println(list);
    }
}
