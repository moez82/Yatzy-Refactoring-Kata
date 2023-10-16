package kata.yatzy;

import java.util.function.Function;

public enum Category {

    Chance(1, Rules::chance),
    Yatzy(2, Rules::yatzy),
    Ones(3, Rules::ones),
    Twos(4, Rules::twos),
    Threes(5, Rules::threes),
    Fours(6, Rules::fours),
    Fives(6, Rules::fives),
    Sixes(7, Rules::sixes),
    Pair(8, Rules::pair),
    Two_pairs(9, Rules::twoPairs),
    Three_of_a_kind(10, Rules::threes),
    Four_of_a_kind(11, Rules::fourOfAKind),
    Small_straight(12, Rules::smallStraight),
    Large_straight(13, Rules::largeStraight),
    Full_house(14, Rules::fullHouse);

    private final int code;
    private final Function<Roll, Integer> function;

    Category(int code, Function<Roll, Integer> function) {
        this.code = code;
        this.function = function;
    }

    public int code() {
        return this.code;
    }

    public static Category getCategoryByCode(int code) {
        for (Category cat: values()) {
            if (cat.code == code) return cat;
        }

        System.err.println("Unknown category !");
        return null;
    }

    public int score(Roll roll) {
        return function.apply(roll);
    }

    public static void print() {
        for (Category category: values()) {
            System.out.println("code: " + category.code + " - name : " + category.name());
        }
    }
}
