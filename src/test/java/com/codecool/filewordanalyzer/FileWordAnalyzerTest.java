package com.codecool.filewordanalyzer;

import com.codecool.filepartreader.FilePartReader;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class FileWordAnalyzerTest {

    private FileWordAnalyzer fileWordAnalyzer;

    @Before
    public void before() {
        fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader());
    }

    @Test
    public void whenInstantiatedThenFilePartReaderIsSet() {
        assertThat(fileWordAnalyzer.getFilePartReader(), instanceOf(FilePartReader.class));
    }
}
