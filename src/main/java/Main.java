package main.java;

import main.java.file.FileManager;
import main.java.model.TreasureMap;

public class Main {
    public static void main(String[] args) {
        String file = "src/main/resources/input.txt";
        String result = "src/main/resources/result.txt";

        TreasureMap treasureMap = FileManager.createTreasureMapReadFileFromTxt(file);

        treasureMap.doAction();

        FileManager.writeFileForSaveResult(treasureMap, result);
    }
}