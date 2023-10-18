package kata.yatzy;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public class Rules {

    public static final int TOTAL_DICE_NUMBER = 5;
    public static final int SMALL_STRAIGHT_SCORE = 15;
    public static final int LARGE_STRAIGHT_SCORE = 20;
    public static final int YATZY_SCORE = 50;

    public static int chance(Roll roll) {
        return roll.dice().stream().mapToInt(Integer::intValue).sum();
    }

    public static int yatzy(Roll roll) {
        Map<Integer, Long> map = roll.sidesFrequency();

        return map.values().stream().anyMatch(i -> i == 5) ? YATZY_SCORE : 0;
    }

    private static int sameSideRule(Roll roll, int sideNumber) {
        return roll.occurenceOf(sideNumber) * sideNumber;
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

    public static int fullHouse(Roll roll) {
        if (hasTwoAndThreeOfAKind(roll)) {
            return roll.sidesFrequency().entrySet().stream().mapToInt(e -> (int) (e.getKey() * e.getValue())).sum();
        }
        return 0;
    }

    private static boolean hasTwoAndThreeOfAKind(Roll roll) {
        if (roll.sidesFrequency().entrySet().size() == 2) {
            Optional<Integer> value = roll.sidesFrequency().keySet().stream().findAny();
            return value.get() == 2 || value.get() == 3;
        }
        return false;
    }
}



