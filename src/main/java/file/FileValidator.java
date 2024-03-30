package main.java.file;

import main.java.model.Movement;
import main.java.model.Orientation;

public class FileValidator {

    public static boolean isFormatCorrectForTreasureMap(String line) {
        String[] split = line.split(" - ");
        if (split.length == 3) {
            try {
                Integer.parseInt(split[1]);
                Integer.parseInt(split[2]);
                return true;
            }
            catch (NumberFormatException e) {
                throw new RuntimeException("Format incorrect for treasure map");
            }
        }
        throw new RuntimeException("Format incorrect for treasure map");

    }

    public static boolean isFormatCorrectForMountain(String line) {
        String[] split = line.split(" - ");
        if (split.length == 3) {
            try {
                Integer.parseInt(split[1]);
                Integer.parseInt(split[2]);
                return true;
            }
            catch (NumberFormatException e) {
                throw new RuntimeException("Format incorrect for mountain");
            }
        }
        throw new RuntimeException("Format incorrect for mountain");
    }

    public static boolean isFormatCorrectForTreasure(String line) {
        String[] split = line.split(" - ");
        if (split.length == 4) {
            try {
                Integer.parseInt(split[1]);
                Integer.parseInt(split[2]);
                Integer.parseInt(split[3]);
                return true;
            }
            catch (NumberFormatException e) {
                throw new RuntimeException("Format incorrect for treasure");
            }
        }
        throw new RuntimeException("Format incorrect for treasure");
    }

    public static boolean isFormatCorrectForAdventurer(String line) {
        String[] split = line.split(" - ");
        if (split.length == 6) {
            try {
                Integer.parseInt(split[2]);
                Integer.parseInt(split[3]);
                if (split[4].length() == 1) {
                    Orientation.fromLetter(split[4].charAt(0));
                    Movement.fromString(split[5]);
                    return true;
                }

            }
            catch (NumberFormatException e) {
                throw new RuntimeException("Format incorrect for adventurer");
            }
        }
        throw new RuntimeException("Format incorrect for adventurer");
    }
}
