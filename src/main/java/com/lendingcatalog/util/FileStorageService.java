package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileNotFoundException {
        File fileLog = new File(filename);
        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(fileLog, appendFile))){
            logWriter.println(contents);

        } catch (FileNotFoundException e) {
            System.out.println("Writing file failed" + filename);
        }
    }

    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
        List<String> dataLines = new ArrayList<>();
        File dataFile = new File(filename);

        try (Scanner dataInput = new Scanner(dataFile)) {
            while (dataInput.hasNextLine()) {
                String lineOfInput = dataInput.nextLine();
                dataLines.add(lineOfInput);
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found" + filename);
        }
        return dataLines;
    }
}
