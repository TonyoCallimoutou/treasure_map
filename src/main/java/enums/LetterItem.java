package main.java.enums;

public enum LetterItem {
    COMMENT('#'),
    MAP('C'),
    MOUNTAIN('M'),
    TREASURE('T'),
    ADVENTURER('A');

    private final char letter;

    LetterItem(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    /**
     * Converts a letter to a LetterItem
     * @param letter
     * @return
     */
    public static LetterItem fromLetter(char letter) {
        for (LetterItem movement : values()) {
            if (movement.getLetter() == letter) {
                return movement;
            }
        }
        throw new IllegalArgumentException("No item found for letter: " + letter);
    }

}
