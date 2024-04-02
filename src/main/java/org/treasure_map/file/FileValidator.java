package org.treasure_map.file;

import org.treasure_map.constants.FileConst;
import org.treasure_map.enums.Movement;
import org.treasure_map.enums.Orientation;

public class FileValidator {

    public static boolean isFormatCorrectForTreasureMap(String line) {
        String[] split = line.split(FileConst.SEPARATOR);
        if (split.length == 3) {
            try {
                Integer.parseInt(split[FileConst.INDEX_MAP_LIMIT_X]);
                Integer.parseInt(split[FileConst.INDEX_MAP_LIMIT_Y]);
                if (Integer.parseInt(split[FileConst.INDEX_MAP_LIMIT_X]) > 0 && Integer.parseInt(split[FileConst.INDEX_MAP_LIMIT_Y]) > 0) {
                    return true;
                }
            }
            catch (NumberFormatException e) {
                throw new RuntimeException("Format incorrect for treasure map");
            }
        }
        throw new RuntimeException("Format incorrect for treasure map");

    }

    public static boolean isFormatCorrectForMountain(String line) {
        String[] split = line.split(FileConst.SEPARATOR);
        if (split.length == 3) {
            try {
                Integer.parseInt(split[FileConst.INDEX_MOUNTAIN_POSITION_X]);
                Integer.parseInt(split[FileConst.INDEX_MOUNTAIN_POSITION_Y]);
                return true;
            }
            catch (NumberFormatException e) {
                throw new RuntimeException("Format incorrect for mountain");
            }
        }
        throw new RuntimeException("Format incorrect for mountain");
    }

    public static boolean isFormatCorrectForTreasure(String line) {
        String[] split = line.split(FileConst.SEPARATOR);
        if (split.length == 4) {
            try {
                Integer.parseInt(split[FileConst.INDEX_TREASURE_POSITION_X]);
                Integer.parseInt(split[FileConst.INDEX_TREASURE_POSITION_Y]);
                Integer.parseInt(split[FileConst.INDEX_TREASURE_QUANTITY]);
                return true;
            }
            catch (NumberFormatException e) {
                throw new RuntimeException("Format incorrect for treasure");
            }
        }
        throw new RuntimeException("Format incorrect for treasure");
    }

    public static boolean isFormatCorrectForAdventurer(String line) {
        String[] split = line.split(FileConst.SEPARATOR);
        if (split.length == 6) {
            try {
                Integer.parseInt(split[FileConst.INDEX_ADVENTURER_POSITION_X]);
                Integer.parseInt(split[FileConst.INDEX_ADVENTURER_POSITION_Y]);
                if (split[FileConst.INDEX_ADVENTURER_ORIENTATION].length() == 1) {
                    Orientation.fromLetter(split[FileConst.INDEX_ADVENTURER_ORIENTATION].charAt(0));
                    Movement.fromString(split[FileConst.INDEX_ADVENTURER_MOVEMENTS]);
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
