package org.treasure_map.enums;

import java.util.ArrayList;
import java.util.List;

public enum Movement {
    MOVE_FORWARD('A'),
    TURN_LEFT('G'),
    TURN_RIGHT('D');

    private final char letter;

    Movement(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    /**
     * Converts a string of letters to an array of movements
     * @param str
     * @return list of movements
     */
    public static List<Movement> fromString(String str) {
        List<Character> letters = str.chars()
                .mapToObj(e -> (char)e)
                .toList();

        List<Movement> movements = new ArrayList<>();
        for (int i = 0; i < letters.size(); i++) {
            movements.add(fromLetter(letters.get(i)));
        }

        return movements;
    }

    /**
     * Converts a letter to a movement
     * @param letter
     * @return
     */
    public static Movement fromLetter(char letter) {
        for (Movement movement : values()) {
            if (movement.getLetter() == letter) {
                return movement;
            }
        }
        throw new IllegalArgumentException("No movement found for letter: " + letter);
    }

}
