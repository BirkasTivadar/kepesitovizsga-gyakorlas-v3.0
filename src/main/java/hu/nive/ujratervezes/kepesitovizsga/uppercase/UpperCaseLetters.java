package hu.nive.ujratervezes.kepesitovizsga.uppercase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpperCaseLetters {


    public int getNumberOfUpperCase(String fileName) {
        int counter = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                UpperCaseLetters.class.getResourceAsStream("/" + fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                counter += countUpperInLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return counter;
    }

    private int countUpperInLine(String line) {
        int counter = 0;
        for (char c : line.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                counter++;
            }
        }
        return counter;
    }
}
