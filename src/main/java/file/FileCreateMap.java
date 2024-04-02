package main.java.file;

import main.java.constants.FileConst;
import main.java.enums.LetterItem;
import main.java.enums.Movement;
import main.java.enums.Orientation;
import main.java.model.*;

import java.util.List;

import static main.java.file.FileValidator.*;
import static main.java.file.FileValidator.isFormatCorrectForAdventurer;

public class FileCreateMap {

    /**
     * Update the treasure map according to the line
     * @param line
     * @param treasureMap
     * @throws RuntimeException
     */
    public static void createTreasureMap(String line, TreasureMap treasureMap) throws RuntimeException {
        String[] lineSplit = line.split(FileConst.SEPARATOR);
        LetterItem item = LetterItem.fromLetter(line.charAt(0));
        switch (item) {
            case COMMENT:
                break;
            case MAP:
                if (isFormatCorrectForTreasureMap(line)) {
                    initializeTreasureMap(lineSplit, treasureMap);
                }
                break;
            case MOUNTAIN:
                if (isFormatCorrectForMountain(line)) {
                    addMountain(lineSplit, treasureMap);
                }
                break;
            case TREASURE:
                if (isFormatCorrectForTreasure(line)) {
                    addTreasure(lineSplit, treasureMap);
                }
                break;
            case ADVENTURER:
                if (isFormatCorrectForAdventurer(line)) {
                    addAdventurer(lineSplit, treasureMap);
                }
                break;
        }
    }

    private static void initializeTreasureMap(String[] lineSplit, TreasureMap treasureMap) {
        treasureMap.setLimitX(Integer.parseInt(lineSplit[FileConst.INDEX_MAP_LIMIT_X]));
        treasureMap.setLimitY(Integer.parseInt(lineSplit[FileConst.INDEX_MAP_LIMIT_Y]));
    }

    private static void addMountain(String[] lineSplit, TreasureMap treasureMap) {
        Position positionMountain = new Position(Integer.parseInt(lineSplit[FileConst.INDEX_MOUNTAIN_POSITION_X]), Integer.parseInt(lineSplit[FileConst.INDEX_MOUNTAIN_POSITION_Y]));

        treasureMap.addItemTreasureMap(new Mountain(positionMountain));
    }

    private static void addTreasure(String[] lineSplit, TreasureMap treasureMap) {
        Position positionTreasure = new Position(Integer.parseInt(lineSplit[FileConst.INDEX_TREASURE_POSITION_X]), Integer.parseInt(lineSplit[FileConst.INDEX_TREASURE_POSITION_Y]));
        int quantity = Integer.parseInt(lineSplit[3]);

        treasureMap.addItemTreasureMap(new Treasure(positionTreasure, quantity));
    }

    private static void addAdventurer(String[] lineSplit, TreasureMap treasureMap) {
        String nameAdventurer = lineSplit[FileConst.INDEX_ADVENTURER_NAME];
        Position positionAdventurer = new Position(Integer.parseInt(lineSplit[FileConst.INDEX_ADVENTURER_POSITION_X]), Integer.parseInt(lineSplit[FileConst.INDEX_ADVENTURER_POSITION_Y]));
        Orientation orientation = Orientation.fromLetter(lineSplit[FileConst.INDEX_ADVENTURER_ORIENTATION].charAt(0));
        List<Movement> movements = Movement.fromString(lineSplit[FileConst.INDEX_ADVENTURER_MOVEMENTS]);

        treasureMap.setNbrOfTurns(movements.size());
        treasureMap.addItemTreasureMap(new Adventurer(nameAdventurer, positionAdventurer, orientation, movements));
    }
}
