package com.codecool.filewordanalyzer;

import com.codecool.filepartreader.FilePartReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public ArrayList<String> wordsContainingSubString(String subString) throws FileNotFoundException {
        String[] words = filePartReader.readLines().split("\\W+");
        List<String> wordsList = new ArrayList<>(Arrays.asList(words));
        return wordsList.stream()
                .filter(x -> x.toUpperCase().contains(subString.toUpperCase()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
