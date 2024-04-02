package org.treasure_map.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PositionTest {

    @Test
    public void isEqual() {
        assertEquals(new Position(2, 3), new Position(2, 3));
    }

    @Test
    public void isNotEqual() {
        assertNotEquals(new Position(3, 2), new Position(2, 3));
    }

    @Test
    public void isNotEqualNotPosition() {
        Object object = new Object() {
            final int x = 2;
            final int y = 3;
        };
        assertNotEquals(new Position(2, 3), object);
    }
}
