package main.java.file;

import main.java.model.*;

import static main.java.file.FileValidator.*;
import static main.java.file.FileValidator.isFormatCorrectForAdventurer;

public class FileCreateMap {

    public static void createTreasureMap(String line, TreasureMap treasureMap) throws RuntimeException {
        String[] lineSplit = line.split(" - ");
        char firstCharacter = line.charAt(0);
        switch (firstCharacter) {
            case '#':
                break;
            case 'C':
                if (!isFormatCorrectForTreasureMap(line)) {
                    throw new RuntimeException("Format incorrect for treasure map");
                }
                initializeTreasureMap(lineSplit, treasureMap);
                break;
            case 'M':
                if (!isFormatCorrectForMountain(line)) {
                    throw new RuntimeException("Format incorrect for mountain");
                }
                addMountain(lineSplit, treasureMap);
                break;
            case 'T':
                if (!isFormatCorrectForTreasure(line)) {
                    throw new RuntimeException("Format incorrect for treasure");
                }
                addTreasure(lineSplit, treasureMap);
                break;
            case 'A':
                if (!isFormatCorrectForAdventurer(line)) {
                    throw new RuntimeException("Format incorrect for adventurer");
                }
                addAdventurer(lineSplit, treasureMap);
                break;
            default:
                throw new RuntimeException("Format incorrect of first charactere : " + firstCharacter);
        }
    }

    private static void initializeTreasureMap(String[] lineSplit, TreasureMap treasureMap) {
        treasureMap.setLimitX(Integer.parseInt(lineSplit[1]));
        treasureMap.setLimitY(Integer.parseInt(lineSplit[2]));
    }

    private static void addMountain(String[] lineSplit, TreasureMap treasureMap) {
        Position positionMountain = new Position(Integer.parseInt(lineSplit[1]), Integer.parseInt(lineSplit[2]));

        treasureMap.addItemTreasureMap(new Mountain(positionMountain));
    }

    private static void addTreasure(String[] lineSplit, TreasureMap treasureMap) {
        Position positionTreasure = new Position(Integer.parseInt(lineSplit[1]), Integer.parseInt(lineSplit[2]));
        Integer quantity = Integer.parseInt(lineSplit[3]);

        treasureMap.addItemTreasureMap(new Treasure(positionTreasure, quantity));
    }

    private static void addAdventurer(String[] lineSplit, TreasureMap treasureMap) {
        String nameAdventurer = lineSplit[1];
        Position positionAdventurer = new Position(Integer.parseInt(lineSplit[2]), Integer.parseInt(lineSplit[3]));
        String orientation = lineSplit[4];
        String movements = lineSplit[5];

        treasureMap.addAdventurer(new Adventurer(nameAdventurer, positionAdventurer, orientation, movements));
    }
}
