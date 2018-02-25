package com.codecool.filepartreader;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class FilePartReaderTest {

    private FilePartReader filePartReader;

    @Rule
    public ExpectedException exception = ExpectedException.none();

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

    @Test
    public void whenSetupMethodCalledWithFromLineLowerThan1ThenIllegalArgumentException() {
        filePartReader.setFromLine(-1);
        exception.expect(IllegalArgumentException.class);
        filePartReader.setup(filePartReader.getFilePath(), filePartReader.getFromLine(), filePartReader.getToLine());
    }
}
