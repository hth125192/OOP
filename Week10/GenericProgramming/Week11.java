import java.util.ArrayList;
import java.util.List;

public class Week11 {
    /** sortGeneric. */
    public static <T extends Comparable<T>> List<T> sortGeneric(List<T> list) {
        List<T> sortedList = new ArrayList<T>();
        while (!list.isEmpty()) {
            T itemMin = list.get(0);
            for (T item : list) {
                if (itemMin.compareTo(item) > 0) {
                    itemMin = item;
                }
            }
            list.remove(itemMin);
            sortedList.add(itemMin);
        }
        return sortedList;
    }

}