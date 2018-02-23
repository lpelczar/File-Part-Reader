package com.codecool.filepartreader;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
        this.filePath = "test_data.txt";
        this.fromLine = 2;
        this.toLine = 4;
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
}
