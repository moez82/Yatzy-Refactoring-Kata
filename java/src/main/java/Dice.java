public class Dice {

    private final int[] dice;

    public Dice(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[]{d1, d2, d3, d4, d5};
    }

    public int[] dice() {
        return dice;
    }

}
