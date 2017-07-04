package com.rentalcars;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests the letter to value class using the car-types.json
 */
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

    /**
     * Test that checks that the entire json object is correctly mapped
     * @throws IOException
     */
    @Test
    public void testGetValueFromLetter() throws IOException {
        try(InputStream inputStreamCarTypes = getClass().getResourceAsStream(CAR_TYPES_PATH)) {
            LetterToValue letterToValue = LetterToValue.readSpecification(inputStreamCarTypes);
            assertEquals(letterToValue.getValueFromLetter('M'), "Mini");
            assertEquals(letterToValue.getValueFromLetter('E'), "Economy");
            assertEquals(letterToValue.getValueFromLetter('C'), "Compact");
            assertEquals(letterToValue.getValueFromLetter('I'), "Intermediate");
            assertEquals(letterToValue.getValueFromLetter('S'), "Standard");
            assertEquals(letterToValue.getValueFromLetter('F'), "Full size");
            assertEquals(letterToValue.getValueFromLetter('P'), "Premium");
            assertEquals(letterToValue.getValueFromLetter('L'), "Luxury");
            assertEquals(letterToValue.getValueFromLetter('X'), "Special");
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
