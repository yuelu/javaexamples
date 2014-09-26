package org.luyue.examples.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import com.google.common.io.CharStreams;

public class InputStreamConverter {

    public static String toStringBufferedReader(InputStream in) throws IOException {

        StringBuilder convertedString = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String line = "";

        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8.name()));) {
            while ((line = reader.readLine()) != null) {
                convertedString.append(line);
                convertedString.append(newLine);
            }
        }

        return convertedString.toString();
    }

    public static String toStringScanner(InputStream in) {

        String convertedString = "";
        try (final Scanner scanner = new Scanner(in, StandardCharsets.UTF_8.name())) {
            convertedString = scanner.useDelimiter("\\A").next();
        }

        return convertedString;
    }

    public static String toStringGuava(InputStream in) throws IOException {

        String convertedString = "";
        try (final Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8.name())) {
            convertedString = CharStreams.toString(reader);
        }

        return convertedString;
    }

    public static String toStringApacheIO(InputStream in) throws IOException {
        return IOUtils.toString(in, StandardCharsets.UTF_8.name());
    }
}
