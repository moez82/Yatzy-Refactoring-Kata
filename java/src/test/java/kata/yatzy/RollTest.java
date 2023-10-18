package kata.yatzy;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class RollTest {

    @Test
    public void dice() {
        assertNotNull(new Roll(1, 1, 2, 2, 3).dice());
        assertNotNull(new Roll(new int[] {1, 1, 2, 2, 3}).dice());
    }

    @Test
    public void occurenceOf() {
        assertEquals(2, new Roll(1, 1, 2, 2, 3).occurenceOf(1));
        assertEquals(0, new Roll(1, 1, 2, 2, 3).occurenceOf(5));
    }

    @Test
    public void sidesFrequency() {
        Map<Integer, Long> stats = new Roll(1, 1, 2, 2, 3).sidesFrequency();
        assertEquals(3, stats.size());
        assertEquals(2, (long) stats.get(1));
        assertEquals(1, (long) stats.get(3));
    }

    @Test
    public void hasTwoPairs() {
        assertTrue(new Roll(1, 1, 2, 2, 3).hasTwoPairs());
        assertTrue(new Roll(1, 1, 2, 2, 2).hasTwoPairs());
        assertFalse(new Roll(1, 1, 2, 5, 3).hasTwoPairs());
    }

}