package kata.yatzy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Roll {

    private final int[] dice;

    public Roll(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[]{d1, d2, d3, d4, d5};
    }

    public Roll(int[] array) {
        dice = array;
    }

    public int[] dice() {
        return dice;
    }

    public int occurenceOf(int number) {
        return (int) Arrays.stream(dice()).filter(i -> i == number).count();
    }

    public Map<Integer, Long> sidesFrequency() {
        return Arrays.stream(dice()).boxed().collect(
            Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public boolean hasTwoPairs() {
        return sidesFrequency().entrySet().stream()
            .filter(e -> e.getValue() >= 2)
            .count() == 2;
    }

}
