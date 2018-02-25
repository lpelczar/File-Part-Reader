package com.codecool.filewordanalyzer;

import com.codecool.filepartreader.FilePartReader;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

public class FileWordAnalyzerTest {

    private FileWordAnalyzer fileWordAnalyzer;

    @Before
    public void before() {
        fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader());
        fileWordAnalyzer.getFilePartReader().setFilePath("test_data.txt");
        fileWordAnalyzer.getFilePartReader().setFromLine(1);
        fileWordAnalyzer.getFilePartReader().setToLine(7);
    }

    @Test
    public void whenInstantiatedThenFilePartReaderIsSet() {
        assertNotNull(fileWordAnalyzer.getFilePartReader());
    }

    @Test
    public void whenWordsByABCThenReturnWordsOrderedAlphabeticallyAsArrayList() throws FileNotFoundException {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1a1", "2a", "2b", "3a", "3b", "3c",
                "4a", "4bb4", "4cr", "4d", "5ax", "5b", "5c", "5d", "5e", "6a", "6bb", "6ca", "6d",
                "6ea", "6f", "7ea", "7f", "7g"));
        ArrayList<String> result = fileWordAnalyzer.wordsByABC();
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void givenSubStringWhenWordsContainingSubStringCalledThenReturnWordsContainingThatSubString()
    throws FileNotFoundException {
        String subString = "ea";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("6ea", "7ea"));
        ArrayList<String> result = fileWordAnalyzer.wordsContainingSubString(subString);
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void whenWordArePalindromeCalledThenReturnWordsWhichArePalindromes() throws FileNotFoundException {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1a1", "4bb4"));
        ArrayList<String> result = fileWordAnalyzer.wordsArePalindrome();
        assertArrayEquals(expected.toArray(), result.toArray());
    }
}
