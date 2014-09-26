package org.luyue.examples.java.io;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InputStreamConverterTest {

    InputStream in;
    String expectedString = "hello world\n" + "testing convert inputstream to string\n";

    @Before
    public void setUp() throws Exception {
        in = InputStreamConverter.class.getResourceAsStream("sample.txt");
    }

    @After
    public void tearDown() throws IOException {
        if (in != null) {
            in.close();
        }
    }

    @Test
    public void testToStringBufferedReader() throws IOException {
        String actual = InputStreamConverter.toStringBufferedReader(in);
        assertThat(actual, is(expectedString));
    }

    @Test
    public void testToStringScanner() throws IOException {
        String actual = InputStreamConverter.toStringBufferedReader(in);
        assertThat(actual, is(expectedString));
    }

    @Test
    public void testToStringGuava() throws IOException {
        String actual = InputStreamConverter.toStringBufferedReader(in);
        assertThat(actual, is(expectedString));
    }

    @Test
    public void testToStringApacheIO() throws IOException {
        String actual = InputStreamConverter.toStringBufferedReader(in);
        assertThat(actual, is(expectedString));
    }

}
