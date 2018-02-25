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

    public void setFromLine(int fromLine) {
        this.fromLine = fromLine;
    }

    public void setup(String filePath, int fromLine, int toLine) {
        if (fromLine < 1) throw new IllegalArgumentException("'fromLine' cannot be less than 1");
        if (toLine < fromLine) throw new IllegalArgumentException("'toLine' cannot be less than 'fromLine'");
    }

    public void setToLine(int toLine) {
        this.toLine = toLine;
    }
}
