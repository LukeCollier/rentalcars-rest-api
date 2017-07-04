package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rentalcars.CarInfo;
import play.mvc.Controller;
import play.mvc.Result;
import com.rentalcars.models.VehiclesResponse;

import java.io.*;
import java.net.URL;

/**
 * Cars controller used by play framework to serve requests
 */
public class CarsController extends Controller {

    private final static String TARGET_WEBSITE_PATH = "http://www.rentalcars.com/js/vehicles.json";

    /**
     * Serves a list of vehicles when requested sorted by price
     * @return a string list of vehicles
     * @throws IOException thrown if something goes wrong with rentalcars response
     */
    public Result getSortPrice() throws IOException {
        CarInfo carInfo = new CarInfo();
        return ok(carInfo.formatPriceOrder(getRentalCarsVehiclesResponse().Search.VehicleList));

    }

    /**
     * Serves a list of vehicles when requested with summary information shown
     * @return a string list of vehicles
     * @throws IOException thrown if something goes wrong with rentalcars response
     */
    public Result getCarSummary() throws IOException {
        CarInfo carInfo = new CarInfo();
        return ok(carInfo.formatCarSummary(getRentalCarsVehiclesResponse().Search.VehicleList));
    }

    /**
     * Serves a list of vehicles when requested sorted by rating and car type
     * @return a string list of vehicles
     * @throws IOException thrown if something goes wrong with rentalcars response
     */
    public Result getSortCarRating() throws IOException {
        CarInfo carInfo = new CarInfo();
        return ok(carInfo.formatCarTypeRatingOrder(getRentalCarsVehiclesResponse().Search.VehicleList));
    }

    /**
     * Serves a list of vehicles when requested sorted by score
     * @return a string list of vehicles
     * @throws IOException thrown if something goes wrong with rentalcars response
     */
    public Result getSortScore() throws IOException {
        CarInfo carInfo = new CarInfo();
        return ok(carInfo.formatCarScoreOrder(getRentalCarsVehiclesResponse().Search.VehicleList));
    }


    /**
     * The rental cars vehicle response mapped into an object
     * @return an list of cars
     * @throws IOException thrown if an issue occurs with getting the json file
     */
    private static VehiclesResponse getRentalCarsVehiclesResponse() throws IOException {
        // The website url to get the data from
        URL websiteUrl = new URL(TARGET_WEBSITE_PATH);
        BufferedReader in = new BufferedReader(new InputStreamReader(websiteUrl.openStream()));

        // Get's the response
        ObjectMapper mapper = new ObjectMapper();

        return(mapper.readValue(in, VehiclesResponse.class));
    }
}
