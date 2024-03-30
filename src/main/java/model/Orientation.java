package main.java.model;

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
}
