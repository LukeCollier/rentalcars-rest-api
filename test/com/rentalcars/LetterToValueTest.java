package com.rentalcars;

import org.junit.Test;
import com.rentalcars.LetterToValue;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LetterToValueTest {
    // Handy variables with the path's to the relevant resource files
    private final static String CAR_TYPES_PATH = "/car-types.json";

    @Test
    public void testReadSpecificationFromFile() throws IOException {
        try(InputStream inputStreamCarTypes = getClass().getResourceAsStream(CAR_TYPES_PATH)) {
            LetterToValue letterToValue = LetterToValue.readSpecification(inputStreamCarTypes);
            assertNotNull(letterToValue);
        }
    }

    @Test
    public void testGetValueFromLetter() throws IOException {
        try(InputStream inputStreamCarTypes = getClass().getResourceAsStream(CAR_TYPES_PATH)) {
            LetterToValue letterToValue = LetterToValue.readSpecification(inputStreamCarTypes);
            assertEquals(letterToValue.getValueFromLetter('M'), "Mini");
        }
    }

    @Test
    public void testGetScoreFromLetter() throws IOException {
        try(InputStream inputStreamCarTypes = getClass().getResourceAsStream(CAR_TYPES_PATH)) {
            LetterToValue letterToValue = LetterToValue.readSpecification(inputStreamCarTypes);
            assertEquals(letterToValue.getScoreFromLetter('M'), 0);
        }
    }
}
