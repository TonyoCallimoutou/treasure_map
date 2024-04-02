package org.treasure_map;

import org.treasure_map.file.FileManager;
import org.treasure_map.model.TreasureMap;

public class Main {
    public static void main(String[] args) {

        String[] fileAndResult = FileManager.getFileFromArgs(args);
        String file = fileAndResult[0];
        String result = fileAndResult[1];

        TreasureMap treasureMap = FileManager.createTreasureMapReadFileFromTxt(file);

        treasureMap.doAction();

        FileManager.writeFileForSaveResult(treasureMap, result);
    }
}