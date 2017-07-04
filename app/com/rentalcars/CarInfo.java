package com.rentalcars;

import com.rentalcars.models.Car;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Get's car list information as a list of strings
 */
public class CarInfo {
    // Handy variables with the path's to the relevant resource files
    private final static String CAR_TYPES_PATH = "/car-types.json";
    private final static String DOOR_TYPES_PATH = "/door-types.json";
    private final static String TRANSMISSION_PATH = "/transmission-types.json";
    private final static String FUEL_AIR_CON_PATH = "/fuel-air-con-types.json";

    // List of positions for
    private final static int CARS_POS = 0;
    private final static int DOORS_POS = 1;
    private final static int TRANS_POS = 2;
    private final static int FUEL_POS = 3;

    private final LetterToValue carTypes;
    private final LetterToValue doorTypes;
    private final LetterToValue transmissionTypes;
    private final LetterToValue fuelAirConTypes;

    /**
     * Initializes the different LetterToValue types by using try-with-resources that will automatically close the
     * stream
     * @throws IOException Throws an exception if anything goes wrong with input stream of resources
     */
    public CarInfo() throws IOException {
        try(InputStream inputStreamCarTypes = getClass().getResourceAsStream(CAR_TYPES_PATH)){
            carTypes = LetterToValue.readSpecification(inputStreamCarTypes);
        }

        try(InputStream inputStreamDoorTypes = getClass().getResourceAsStream(DOOR_TYPES_PATH))
        {
            doorTypes = LetterToValue.readSpecification(inputStreamDoorTypes);
        }

        try(InputStream inputStreamTransmissionTypes = getClass().getResourceAsStream(TRANSMISSION_PATH)){
            transmissionTypes = LetterToValue.readSpecification(inputStreamTransmissionTypes);
        }

        try(InputStream inputStreamFuelAirCon = getClass().getResourceAsStream(FUEL_AIR_CON_PATH))
        {
            fuelAirConTypes = LetterToValue.readSpecification(inputStreamFuelAirCon);
        }
    }

    /**
     * Task one of the technical test, get's the name and price ordered by the price in ascending order.
     * @param carList the car list to order and get the string of
     * @return a string list of cars
     */
    public String formatPriceOrder(List<Car> carList) {
        return carList.stream()
                .sorted(Comparator.comparing(Car::getPrice))
                .map(car -> String.format("{%s} - {%s}",
                        car.getName(),car.getPrice().setScale(2, BigDecimal.ROUND_CEILING)))
                .collect(Collectors.joining("\n"));
    }

    /**
     * Task two of the technical test, get's the name, sipp code, sipp code meanings output in the order it was received
     * @param carList the car list to get the string of
     * @return a string list of cars
     */
    public String formatCarSummary(List<Car> carList) {
        return carList.stream()
                .map(car -> String.format("{%s} - {%s} - {%s} - {%s} - {%s} - {%s} - {%s}",
                        car.getName(),
                        car.getSipp(),
                        carTypes.getValueFromLetter(car.getSipp().charAt(CARS_POS)),
                        doorTypes.getValueFromLetter(car.getSipp().charAt(DOORS_POS)),
                        transmissionTypes.getValueFromLetter(car.getSipp().charAt(TRANS_POS)),
                        fuelAirConTypes.getValueFromLetter(car.getSipp().charAt(FUEL_POS)).split("/")[0],
                        fuelAirConTypes.getValueFromLetter(car.getSipp().charAt(FUEL_POS)).split("/")[1]
                ))
                .collect(Collectors.joining("\n"));
    }

    /**
     * Formats the list of cars by rating and car type order
     * @param carList the car list to format and sorted
     * @return a string list of cars
     */
    public String formatCarTypeRatingOrder(List<Car> carList) {
        return carList.stream()
                .sorted((car1, car2) -> {
                    Float rating1 = car1.getRating();
                    Float rating2 = car2.getRating();
                    return rating2.compareTo(rating1);
                })
                .sorted((car1, car2) -> {
                    String carType1 = carTypes.getValueFromLetter(car1.getSipp().charAt(CARS_POS));
                    String carType2 = carTypes.getValueFromLetter(car2.getSipp().charAt(DOORS_POS));
                    return carType1.compareTo(carType2);
                })
                .map(car -> String.format("{%s} - {%s} - {%s} - {%s}",
                        car.getName(),
                        carTypes.getValueFromLetter(car.getSipp().charAt(0)),
                        car.getSupplier(),
                        car.getRating()))
                .collect(Collectors.joining("\n"));
    }

    /**
     * Formats the list sorted by a score value
     * @param carList the car list to format and sort
     * @return a string list of cars
     */
    public String formatCarScoreOrder(List<Car> carList) {
        return carList.stream()
                .sorted((car1, car2) -> {
                    Float score1 = car1.getRating() + getScoreFromSipp(car1.getSipp());
                    Float score2 = car2.getRating() + getScoreFromSipp(car2.getSipp());
                    return score2.compareTo(score1);
                })
                .map((Car car) -> {
                    int score = getScoreFromSipp(car.getSipp());
                    return String.format("{%s} - {%d} - {%.1f} - {%.1f}",
                                car.getName(), score,car.getRating(),car.getRating()+score);

                })
                .collect(Collectors.joining("\n"));
    }

    /**
     * Takes the last two characters of the SIPP and finds their combined score
     * @param sipp a string that is the SiPP code to use
     * @return an integer value representing the total score of the SiPP
     */
    private int getScoreFromSipp(String sipp) {
        return transmissionTypes.getScoreFromLetter(sipp.charAt(TRANS_POS))
                + fuelAirConTypes.getScoreFromLetter(sipp.charAt(FUEL_POS));

    }
}
