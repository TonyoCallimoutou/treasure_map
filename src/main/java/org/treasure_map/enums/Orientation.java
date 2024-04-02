package org.treasure_map.enums;

public enum Orientation {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private final char letter;

    Orientation(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    /**
     * Converts a letter to an orientation
     * @param letter
     * @return
     */
    public static Orientation fromLetter(char letter) {
        for (Orientation orientation : values()) {
            if (orientation.getLetter() == letter) {
                return orientation;
            }
        }
        throw new IllegalArgumentException("No orientation found for letter: " + letter);
    }

    public Orientation turnLeft() {
        return switch (this) {
            case NORTH -> WEST;
            case EAST -> NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
        };
    }

    public Orientation turnRight() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }
}
