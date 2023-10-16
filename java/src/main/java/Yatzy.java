import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class Yatzy {

    public static final int TOTAL_DICE_NUMBER = 5;
    public static final int SMALL_STRAIGHT_SCORE = 15;
    public static final int LARGE_STRAIGHT_SCORE = 20;

    public static int chance(Roll roll) {
        return Arrays.stream(roll.dice()).sum();
    }

    public static int yatzy(Roll roll) {
        Map<Integer, Long> map = roll.sidesFrequency();

        return map.values().stream().anyMatch(i -> i == 5) ? 50 : 0;
    }

    private static int sameSideRule(Roll roll, int i) {
        return roll.occurenceOf(i) * i;
    }

    public static int ones(Roll roll) {
        return sameSideRule(roll, 1);
    }

    public static int twos(Roll roll) {
        return sameSideRule(roll, 2);
    }

    public static int threes(Roll roll) {
        return sameSideRule(roll, 3);
    }

    public static int fours(Roll roll) {
        return sameSideRule(roll, 4);
    }

    public static int fives(Roll roll) {
        return sameSideRule(roll, 5);
    }

    public static int sixes(Roll roll) {
        return sameSideRule(roll, 6);
    }

    public static int pair(Roll roll) {

        Map<Integer, Long> frequency = roll.sidesFrequency();

        return frequency.entrySet().stream()
            .filter(e -> e.getValue() >= 2)
            .max(Comparator.comparingInt(Map.Entry::getKey))
            .map(e -> e.getKey() * 2).orElse(0);
    }

    public static int twoPairs(Roll roll) {

        Map<Integer, Long> frequency = roll.sidesFrequency();

        if (roll.hasTwoPairs()) {
            return frequency.entrySet().stream()
                .filter(e -> e.getValue() >= 2)
                .mapToInt(Map.Entry::getKey).sum() * 2;
        }

        return 0;

    }

    public static int threeOfAKind(Roll roll) {
        int sideNumber = 3;
        return scoreDiceOfAkindRule(roll, sideNumber);
    }

    public static int fourOfAKind(Roll roll) {
        int sideNumber = 4;
        return scoreDiceOfAkindRule(roll, sideNumber);
    }

    private static int scoreDiceOfAkindRule(Roll roll, int die) {
        return roll.sidesFrequency().entrySet().stream()
            .filter(e -> e.getValue() >= die)
            .map(Map.Entry::getKey)
            .mapToInt(i -> i * die)
            .sum();
    }

    public static int smallStraight(Roll roll) {
        if (roll.sidesFrequency().entrySet().size() == TOTAL_DICE_NUMBER &&
            roll.sidesFrequency().keySet().stream().mapToInt(v -> v).sum() == SMALL_STRAIGHT_SCORE) {
            return SMALL_STRAIGHT_SCORE;
        }
        return 0;
    }

    public static int largeStraight(Roll roll) {
        if (roll.sidesFrequency().entrySet().size() == TOTAL_DICE_NUMBER &&
            roll.sidesFrequency().keySet().stream().mapToInt(v -> v).sum() == LARGE_STRAIGHT_SCORE) {
            return LARGE_STRAIGHT_SCORE;
        }
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



