package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rentalcars.CarInfo;
import play.mvc.Controller;
import play.mvc.Result;
import com.rentalcars.models.VehiclesResponse;

import java.io.*;
import java.net.URL;

public class CarsController extends Controller {

    private final static String TARGET_WEBSITE_PATH = "http://www.rentalcars.com/js/vehicles.json";

    public Result getSortPrice() throws IOException {
        CarInfo carInfo = new CarInfo();
        return ok(carInfo.formatPriceOrder(getRentalCarsVehiclesResponse().Search.VehicleList));

    }

    public Result getCarSummary() throws IOException {
        CarInfo carInfo = new CarInfo();
        return ok(carInfo.formatCarSummary(getRentalCarsVehiclesResponse().Search.VehicleList));
    }

    public Result getSortCarRating() throws IOException {
        CarInfo carInfo = new CarInfo();
        return ok(carInfo.formatCarTypeRatingOrder(getRentalCarsVehiclesResponse().Search.VehicleList));
    }

    public Result getSortScore() throws IOException {
        CarInfo carInfo = new CarInfo();
        return ok(carInfo.formatCarScoreOrder(getRentalCarsVehiclesResponse().Search.VehicleList));
    }


    /**
     * The rental cars vehicle response
     * @return a object of rental cars
     * @throws IOException
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
