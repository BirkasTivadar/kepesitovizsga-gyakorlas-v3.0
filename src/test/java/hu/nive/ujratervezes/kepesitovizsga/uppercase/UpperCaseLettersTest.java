package hu.nive.ujratervezes.kepesitovizsga.uppercase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpperCaseLettersTest {

    @Test
    void testGetNumberOfUpperCase() {
        assertEquals(8, new UpperCaseLetters().getNumberOfUpperCase("characters.txt"));
    }

}