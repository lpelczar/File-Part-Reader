package com.codecool.filewordanalyzer;

import com.codecool.filepartreader.FilePartReader;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

public class FileWordAnalyzerTest {

    private FileWordAnalyzer fileWordAnalyzer;

    @Before
    public void before() {
        fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader());
    }

    @Test
    public void whenInstantiatedThenFilePartReaderIsSet() {
        assertNotNull(fileWordAnalyzer.getFilePartReader());
    }

    @Test
    public void whenWordsByABCThenReturnWordsOrderedAlphabeticallyAsArrayList() {
        fileWordAnalyzer.getFilePartReader().setFilePath("test_data.txt");
        fileWordAnalyzer.getFilePartReader().setFromLine(1);
        fileWordAnalyzer.getFilePartReader().setToLine(3);
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1a1", "2a", "2b", "3a", "3b", "3c"));
        ArrayList<String> result = fileWordAnalyzer.wordsByABC();
        assertArrayEquals(expected.toArray(), result.toArray());
    }
}
