package com.rentalcars;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rentalcars.models.Car;
import com.rentalcars.models.VehiclesResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

/**
 * The console application get's and displays all the tasks in the technical test to a console
 */
public class ConsoleApplication {

    private final static String TARGET_WEBSITE_PATH = "http://www.rentalcars.com/js/vehicles.json";

    /**
     * The main method that runs
     * @param args
     * @throws IOException if any of the streams have issues
     */
    public static void main(String[] args) throws IOException {

        // The website url to get the data from
        URL websiteUrl = new URL(TARGET_WEBSITE_PATH);
        BufferedReader in = new BufferedReader(new InputStreamReader(websiteUrl.openStream()));

        // Get's the response
        ObjectMapper mapper = new ObjectMapper();

        List<Car> vehicleList = mapper.readValue(in, VehiclesResponse.class).Search.VehicleList;

        CarInfo carInfo = new CarInfo();

        System.out.println("Part 1 Task 1: ");
        System.out.println(carInfo.formatPriceOrder(vehicleList));

        System.out.println("Part 1 Task 2: ");
        System.out.println(carInfo.formatCarSummary(vehicleList));

        System.out.println("Part 1 Task 3: ");
        System.out.println(carInfo.formatCarTypeRatingOrder(vehicleList));

        System.out.println("Part 1 Task 4: ");
        System.out.println(carInfo.formatCarScoreOrder(vehicleList));
    }
}
