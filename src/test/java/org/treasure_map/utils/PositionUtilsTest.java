package org.treasure_map.utils;

import org.treasure_map.model.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionUtilsTest {

    @Test
    public void isPositionInBound() {
        assertTrue(PositionUtils.isPositionInBound(new Position(1, 1), 3, 4));
    }

    @Test
    public void isPositionOutOfBoundByX() {
        try {
            PositionUtils.isPositionInBound(new Position(3, 1), 2, 3);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Position (x=3, y=1) is out of bounds", e.getMessage());
        }
    }

    @Test
    public void isPositionOutOfBoundByY() {
        try {
            PositionUtils.isPositionInBound(new Position(2, 4), 2, 3);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Position (x=2, y=4) is out of bounds", e.getMessage());
        }
    }
}
