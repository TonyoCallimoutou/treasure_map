package test.java.model;

import main.java.model.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void isEqual() {
        assertEquals(new Position(2, 3), new Position(2, 3));
    }

    @Test
    public void isNotEqual() {
        assertNotEquals(new Position(3, 2), new Position(2, 3));
    }
}
