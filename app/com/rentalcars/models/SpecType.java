package com.rentalcars.models;

/**
 * A specification type used to be mapped to against the resources json types
 */
public class SpecType {
    private Character letter;
    private String value;
    private int score = 0;

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
