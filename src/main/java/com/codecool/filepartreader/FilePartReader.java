package com.codecool.filepartreader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = 0;
        this.toLine = 0;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getFromLine() {
        return fromLine;
    }

    public int getToLine() {
        return toLine;
    }

    public void setFromLine(int fromLine) {
        this.fromLine = fromLine;
    }

    public void setToLine(int toLine) {
        this.toLine = toLine;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setup(String filePath, int fromLine, int toLine) {
        if (fromLine < 1) throw new IllegalArgumentException("'fromLine' cannot be less than 1");
        if (toLine < fromLine) throw new IllegalArgumentException("'toLine' cannot be less than 'fromLine'");
    }

    public String readLines() throws FileNotFoundException {
        String[] lines = read().split("\\r?\\n");
        if (toLine > lines.length) throw new IllegalArgumentException("'toLine' is past end of file");
        String[] resultLines = Arrays.copyOfRange(lines, fromLine - 1, toLine);
        return String.join("\n", resultLines);
    }

    private String read() throws FileNotFoundException {
        return new Scanner(new File(filePath)).useDelimiter("\\Z").next();
    }
}
