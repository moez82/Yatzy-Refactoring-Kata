package kata.yatzy;

import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    @Test
    public void getCategoryByCode() {
        assertEquals(Category.Chance, Category.getCategoryByCode(1));
    }

    @Test
    public void score() {
        assertEquals(15, Category.Chance.score(new Roll(1, 2, 3, 4, 5)));
    }
}