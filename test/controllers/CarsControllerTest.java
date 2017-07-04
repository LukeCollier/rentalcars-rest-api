package controllers;/*
    Project: rentalcars-rest-api
    Created by: Joker
    Created date: 03/07/2017
*/

import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Result;
import play.test.WithApplication;

import java.io.IOException;

import static javax.security.auth.callback.ConfirmationCallback.OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.test.Helpers.contentAsString;

public class CarsControllerTest extends WithApplication {

//    @Override
//    protected Application provideApplication() {
//        return new GuiceApplicationBuilder()
//                .configure("play.http.router", "javaguide.tests.Routes")
//                .build();
//    }
//
//    @Test
//    public void testIndex() throws IOException {
//        Result result = new CarsController().getSortScore();
//        assertEquals(OK, result.status());
//        assertTrue(contentAsString(result).contains("Ford Focus"));
//    }

}