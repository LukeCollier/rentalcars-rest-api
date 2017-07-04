package com.rentalcars;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rentalcars.models.SpecType;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Specifications are a map of characters to an string
 */
public class LetterToValue {
    private final Map<Character, SpecificationWrapper> specificationData;

    /**
     * Static constructor
     * @param data set the data to equal this
     */
    private LetterToValue(Map<Character, SpecificationWrapper> data) {
        specificationData = data;
    }

    /**
     * Read a specification from input stream
     * @param inputStream the input stream to read the information from
     * @return an LetterToValue object with information from the input stream
     * @throws IOException thrown if an error occurs with the input stream
     */
    public static LetterToValue readSpecification(InputStream inputStream) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<SpecType> dataSpecList = mapper.readValue(inputStream, new TypeReference<List<SpecType>>(){});

        final Map<Character, SpecificationWrapper> specData = new HashMap<>();

        dataSpecList.forEach(specType -> specData.put(specType.getLetter(),new SpecificationWrapper(specType)));

        return new LetterToValue(specData);
    }

    /**
     * Get's the corresponding value from a character
     * @param letter the character to get the corresponding string value from
     * @return a string representation of the characters code
     */
    public String getValueFromLetter(char letter) {
        if (specificationData.containsKey(letter)) {
            return specificationData.get(letter).getValue();
        } else {
            return "not found";
        }
    }

    /**
     * Get's the score representation from the character
     * @param letter the character code to check against
     * @return the score of the characters code
     */
    public int getScoreFromLetter(char letter) {
        if (!specificationData.containsKey(letter)) {
            return 0;
        } else {
            return specificationData.get(letter).getScore();
        }
    }

    /**
     * A data wrapper for the SpecType taken from the json file
     */
    static class SpecificationWrapper {
        private String value;
        private int score = 0;

        /**
         * A default constructor that converts a SpecType into SpecificationWrapper
         * @param type the specification type
         */
        SpecificationWrapper(SpecType type) {
            this.value = type.getValue();
            this.score = type.getScore();
        }

        /**
         * Get's the value of the spec data
         * @return an string representing the value
         */
        String getValue() {
            return value;
        }

        /**
         * Get's the score for the spec data
         * @return an integer representing the score
         */
        int getScore() {
            return score;
        }
    }

}
