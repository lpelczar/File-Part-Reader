package com.codecool.filewordanalyzer;

import com.codecool.filepartreader.FilePartReader;
import org.junit.Before;
import org.junit.Test;

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
}
