import java.util.List;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void sortStrategy(List<Integer> list) {
        strategy.sort(list);
    }
}
