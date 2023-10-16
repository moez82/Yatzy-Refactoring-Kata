package kata.yatzy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RulesTest {

    @Test
    public void chance() {
        assertEquals(15, Rules.chance(new Roll(2, 3, 4, 5, 1)));
        assertEquals(16, Rules.chance(new Roll(3, 3, 4, 5, 1)));
    }

    @Test
    public void yatzy() {
        assertEquals(0, Rules.yatzy(new Roll(6, 6, 6, 6, 3)));
        assertEquals(50, Rules.yatzy(new Roll(4, 4, 4, 4, 4)));
        assertEquals(50, Rules.yatzy(new Roll(6, 6, 6, 6, 6)));
    }

    @Test
    public void ones() {
        assertEquals(0, Rules.ones(new Roll(6, 2, 2, 4, 5)));
        assertEquals(1, Rules.ones(new Roll(1, 2, 3, 4, 5)));
        assertEquals(2, Rules.ones(new Roll(1, 2, 1, 4, 5)));
        assertEquals(4, Rules.ones(new Roll(1, 2, 1, 1, 1)));
    }

    @Test
    public void twos() {
        assertEquals(4, Rules.twos(new Roll(1, 2, 3, 2, 6)));
        assertEquals(10, Rules.twos(new Roll(2, 2, 2, 2, 2)));
    }

    @Test
    public void threes() {
        assertEquals(6, Rules.threes(new Roll(1, 2, 3, 2, 3)));
        assertEquals(12, Rules.threes(new Roll(2, 3, 3, 3, 3)));
    }

    @Test
    public void fours() {
        assertEquals(4, Rules.fours(new Roll(4, 5, 5, 5, 5)));
        assertEquals(8, Rules.fours(new Roll(4, 4, 5, 5, 5)));
        assertEquals(12, Rules.fours(new Roll(4, 4, 4, 5, 5)));
    }

    @Test
    public void fives() {
        assertEquals(10, Rules.fives(new Roll(4, 4, 4, 5, 5)));
        assertEquals(15, Rules.fives(new Roll(4, 4, 5, 5, 5)));
        assertEquals(20, Rules.fives(new Roll(4, 5, 5, 5, 5)));
    }

    @Test
    public void sixes() {
        assertEquals(0, Rules.sixes(new Roll(4, 4, 4, 5, 5)));
        assertEquals(6, Rules.sixes(new Roll(4, 4, 6, 5, 5)));
        assertEquals(18, Rules.sixes(new Roll(6, 5, 6, 6, 5)));
    }

    @Test
    public void onePair() {
        assertEquals(6, Rules.pair(new Roll(3, 4, 3, 5, 6)));
        assertEquals(10, Rules.pair(new Roll(5, 3, 3, 3, 5)));
        assertEquals(12, Rules.pair(new Roll(5, 3, 6, 6, 5)));
    }

    @Test
    public void twoPairs() {
        assertEquals(16, Rules.twoPairs(new Roll(3, 3, 5, 4, 5)));
        assertEquals(16, Rules.twoPairs(new Roll(3, 3, 5, 5, 5)));
    }

    @Test
    public void threeOfAKind() {
        assertEquals(0, Rules.threeOfAKind(new Roll(3, 3, 1, 4, 5)));
        assertEquals(9, Rules.threeOfAKind(new Roll(3, 3, 3, 4, 5)));
        assertEquals(9, Rules.threeOfAKind(new Roll(3, 3, 3, 3, 5)));
        assertEquals(9, Rules.threeOfAKind(new Roll(3, 3, 3, 3, 3)));
        assertEquals(15, Rules.threeOfAKind(new Roll(5, 3, 5, 4, 5)));
    }

    @Test
    public void fourOfAKind() {
        assertEquals(0, Rules.fourOfAKind(new Roll(3, 3, 1, 4, 5)));
        assertEquals(12, Rules.fourOfAKind(new Roll(3, 3, 3, 3, 5)));
        assertEquals(20, Rules.fourOfAKind(new Roll(5, 5, 5, 4, 5)));
    }

    @Test
    public void smallStraight() {
        assertEquals(0, Rules.smallStraight(new Roll(1, 2, 2, 4, 5)));
        assertEquals(15, Rules.smallStraight(new Roll(1, 2, 3, 4, 5)));
        assertEquals(15, Rules.smallStraight(new Roll(2, 3, 4, 5, 1)));
    }

    @Test
    public void largeStraight() {
        assertEquals(0, Rules.largeStraight(new Roll(1, 2, 2, 4, 5)));
        assertEquals(20, Rules.largeStraight(new Roll(6, 2, 3, 4, 5)));
        assertEquals(20, Rules.largeStraight(new Roll(2, 3, 4, 5, 6)));
    }

    @Test
    public void fullHouse() {
        assertEquals(0, Rules.fullHouse(new Roll(2, 3, 4, 5, 6)));
        assertEquals(18, Rules.fullHouse(new Roll(6, 2, 2, 2, 6)));
    }
}
