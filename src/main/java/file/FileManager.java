package main.java.file;

import main.java.model.*;

import java.io.*;

import static main.java.file.FileCreateMap.createTreasureMap;

public class FileManager {
    public static TreasureMap createTreasureMapReadFileFromTxt(String file) {

        try {
            FileReader fileReader = new FileReader("src/main/resources/" + file );

            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();

            TreasureMap treasureMap = new TreasureMap();

            while (line != null) {
                createTreasureMap(line, treasureMap);
                line = reader.readLine();
            }
            reader.close();
            return treasureMap;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFileForSaveResult(TreasureMap treasureMap) {
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/result.txt", false);

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