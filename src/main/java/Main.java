package main.java;

import main.java.file.FileManager;
import main.java.model.TreasureMap;

public class Main {
    public static void main(String[] args) {
        TreasureMap treasureMap = FileManager.createTreasureMapReadFileFromTxt("input.txt");

        // TODO

        FileManager.writeFileForSaveResult(treasureMap);
    }
}