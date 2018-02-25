package com.codecool.filepartreader;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
        assertEquals("", filePartReader.getFilePath());
    }

    @Test
    public void whenFilePartReaderInstantiatedThenFromLineIsSet() {
        assertEquals(0, filePartReader.getFromLine());
    }

    @Test
    public void whenFilePartReaderInstantiatedThenToLineIsSet() {
        assertEquals(0, filePartReader.getToLine());
    }

    @Test
    public void whenSetupMethodCalledWithFromLineLowerThan1ThenIllegalArgumentException() {
        filePartReader.setFromLine(-1);
        exception.expect(IllegalArgumentException.class);
        filePartReader.setup(filePartReader.getFilePath(), filePartReader.getFromLine(), filePartReader.getToLine());
    }

    @Test
    public void whenSetupMethodCalledWithToLineLowerThanFromLineThenIllegalArgumentException() {
        filePartReader.setFromLine(2);
        filePartReader.setToLine(1);
        exception.expect(IllegalArgumentException.class);
        filePartReader.setup(filePartReader.getFilePath(), filePartReader.getFromLine(), filePartReader.getToLine());
    }

    @Test
    public void whenReadLinesCalledBeforeSetupThenFileNotFoundException() throws FileNotFoundException {
        exception.expect(FileNotFoundException.class);
        filePartReader.readLines();
    }

    @Test
    public void whenReadLinesCalledWithFromLine1AndToLine2ThenReturnsFirstTwoLines() throws FileNotFoundException {
        filePartReader.setFromLine(1);
        filePartReader.setToLine(2);
        filePartReader.setFilePath("test_data.txt");
        String result = filePartReader.readLines();
        assertEquals("1a1\n2b 2a", result);
    }

    @Test
    public void whenReadLinesCalledWithFromLine2AndToLine4ThenReturnsAppropriateLines() throws FileNotFoundException {
        filePartReader.setFromLine(2);
        filePartReader.setToLine(4);
        filePartReader.setFilePath("test_data.txt");
        String result = filePartReader.readLines();
        assertEquals("2b 2a\n3c 3b 3a\n4d 4cr 4bb4 4a", result);
    }
}
