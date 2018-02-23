package com.codecool.filepartreader;

public class FilePartReader {

    private String filePath;
    private int fromLine;

    public FilePartReader() {
        this.filePath = "test_data.txt";
        this.fromLine = 2;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getFromLine() {
        return fromLine;
    }
}
