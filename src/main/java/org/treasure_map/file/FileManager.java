package org.treasure_map.file;

import org.treasure_map.constants.ArgsConst;
import org.treasure_map.model.TreasureMap;

import java.io.*;

public class FileManager {

    /**
     * Get the input and output file from the args
     * @param args
     * @return String[] with the input file and output file
     */
    public static String[] getFileFromArgs(String[] args) {
        String inputFilePath = ArgsConst.DEFAULT_INPUT;
        String outputFilePath = ArgsConst.DEFAULT_OUTPUT;
        for (String arg : args) {
            if (arg.startsWith(ArgsConst.INPUT)) {
                inputFilePath = arg.substring(ArgsConst.INPUT.length());
            } else if (arg.startsWith(ArgsConst.OUTPUT)) {
                outputFilePath = arg.substring(ArgsConst.OUTPUT.length());
            }
        }

        return new String[] {inputFilePath, outputFilePath};
    }

    public static TreasureMap createTreasureMapReadFileFromTxt(String file) {

        try {
            FileReader fileReader = new FileReader(file);

            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();

            TreasureMap treasureMap = new TreasureMap();

            if (line == null) {
                throw new RuntimeException("The file is empty");
            }

            while (line != null) {
                if (!line.isEmpty()) {
                    FileCreateMap.createTreasureMap(line, treasureMap);
                }
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

            System.out.println("The result is saved in " + file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}