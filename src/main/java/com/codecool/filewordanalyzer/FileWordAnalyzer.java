package com.codecool.filewordanalyzer;

import com.codecool.filepartreader.FilePartReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public FilePartReader getFilePartReader() {
        return filePartReader;
    }

    public ArrayList<String> wordsByABC() throws FileNotFoundException {
        String[] words = filePartReader.readLines().split("\\W+");
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));
        wordsList.sort(String::compareTo);
        return wordsList;
    }
}
