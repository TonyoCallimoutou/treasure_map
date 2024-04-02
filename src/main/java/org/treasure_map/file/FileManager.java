package org.treasure_map.file;

import org.treasure_map.model.TreasureMap;

import java.io.*;

public class FileManager {
    public static TreasureMap createTreasureMapReadFileFromTxt(String file) {

        try {
            FileReader fileReader = new FileReader(file);

            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();

            TreasureMap treasureMap = new TreasureMap();

            while (line != null) {
                FileCreateMap.createTreasureMap(line, treasureMap);
                line = reader.readLine();
            }
            reader.close();
            return treasureMap;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFileForSaveResult(TreasureMap treasureMap, String file) {

        try {
            FileWriter fileWriter = new FileWriter(file, false);

            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (String line : treasureMap.toListOfString()) {
                writer.write(line);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}