package org.treasure_map.file;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileValidatorTest {

    @Test
    public void testCorrectFormatForTreasureMap() {
        assertTrue(FileValidator.isFormatCorrectForTreasureMap("C - 3 - 4"));
    }

    @Test
    public void isIncorrectFormatForTreasureMapOne() {
        try {
            FileValidator.isFormatCorrectForTreasureMap("C - 3 - four");
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Format incorrect for treasure map", e.getMessage());
        }
    }

    @Test
    public void isIncorrectFormatForTreasureMapTwo() {
        try {
            FileValidator.isFormatCorrectForTreasureMap("C - 3");
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Format incorrect for treasure map", e.getMessage());
        }
    }

    @Test
    public void testCorrectFormatForMountain() {
        assertTrue(FileValidator.isFormatCorrectForMountain("M - 1 - 1"));
    }

    @Test
    public void isIncorrectFormatForMountainOne() {
        try {
            FileValidator.isFormatCorrectForMountain("M - one - 1");
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Format incorrect for mountain", e.getMessage());
        }
    }

    @Test
    public void isIncorrectFormatForMountainTwo() {
        try {
            FileValidator.isFormatCorrectForMountain("M - 1");
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Format incorrect for mountain", e.getMessage());
        }
    }

    @Test
    public void testCorrectFormatForTreasure() {
        assertTrue(FileValidator.isFormatCorrectForTreasure("T - 0 - 3 - 2"));
    }

    @Test
    public void isIncorrectFormatForTreasureOne() {
        try {
            FileValidator.isFormatCorrectForTreasure("T - 0 - 3 - two");
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Format incorrect for treasure", e.getMessage());
        }
    }

    @Test
    public void isIncorrectFormatForTreasureTwo() {
        try {
            FileValidator.isFormatCorrectForTreasure("T - 0 - 3");
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Format incorrect for treasure", e.getMessage());
        }
    }

    @Test
    public void testCorrectFormatForAdventurer() {
        assertTrue(FileValidator.isFormatCorrectForAdventurer("A - Indiana - 1 - 1 - S - AADADA"));
    }

    @Test
    public void isIncorrectFormatForAdventurerOne() {
        try {
            FileValidator.isFormatCorrectForAdventurer("A - Indiana - 1 - 1 - South - AADADA");
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Format incorrect for adventurer", e.getMessage());
        }
    }

    @Test
    public void isIncorrectFormatForAdventurerTwo() {
        try {
            FileValidator.isFormatCorrectForAdventurer("A - Indiana - 1 - 1 - Y - AADADA");
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("No orientation found for letter: Y", e.getMessage());
        }
    }

    @Test
    public void isIncorrectFormatForAdventurerThree() {
        try {
            FileValidator.isFormatCorrectForAdventurer("A - Indiana - 1 - 1 - S - ZZRFTG");
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("No movement found for letter: Z", e.getMessage());
        }
    }

    @Test
    public void isIncorrectFormatForAdventurerFour() {
        try {
            FileValidator.isFormatCorrectForAdventurer("A - Indiana - one - 1 - S - AADADA");
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Format incorrect for adventurer", e.getMessage());
        }
    }

    @Test
    public void isIncorrectFormatForAdventurerFive() {
        try {
            FileValidator.isFormatCorrectForAdventurer("A - Indiana - 1 - two - S - AADADA");
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Format incorrect for adventurer", e.getMessage());
        }
    }


    @Test
    public void isIncorrectFormatForAdventurerSix() {
        try {
            FileValidator.isFormatCorrectForAdventurer("A - Indiana - 1 - S - AADAD");
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Format incorrect for adventurer", e.getMessage());
        }
    }
}
