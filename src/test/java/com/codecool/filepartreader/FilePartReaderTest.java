package com.codecool.filepartreader;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FilePartReaderTest {

    private FilePartReader filePartReader;

    @Before
    public void before() {
        filePartReader = new FilePartReader();
    }

    @Test
    public void whenFilePartReaderInstantiatedThenFilePathIsSet() {
        assertEquals("test_data.txt", filePartReader.getFilePath());
    }

    @Test
    public void whenFilePartReaderInstantiatedThenFromLineIsSet() {
        assertEquals(2, filePartReader.getFromLine());
    }

    @Test
    public void whenFilePartReaderInstantiatedThenToLineIsSet() {
        assertEquals(4, filePartReader.getToLine());
    }
}
