package org.example;

import dtos.Location;
import dtos.Network;
import dtos.Root;
import io.restassured.RestAssured.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import com.google.gson.JsonObject;

import io.restassured.matcher.RestAssuredMatchers.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    // Scenario: 01 Can get all networks http://api.citybik.es/v2/networks/
    // Scenario: 02 Can get network by id http://api.citybik.es/v2/networks/<network_id>//
    // Scenario: 03 All networks have the correct fields - company, id, location, href, name
    /* Scenario: 04 Can filter by fields:
         - id
         - location
         - href
         - name
         - company
    *
    *
    * */

    @Test
    public void CityFrankFurtIsInGermanyAndCanReturnLatAndLong() {

        Response res = get("https://api.citybik.es/v2/networks?fields=location");
        String jsonResult = res.asString();

        ObjectMapper om = new ObjectMapper();
        Root root = new Root();
        try {
            root = om.readValue(jsonResult, Root.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Network network : root.networks) {
            if (network.location.city == "Frankfurt") {
                assertTrue(network.location.country == "DE");
                System.out.println(network.location.latitude);
                System.out.println(network.location.longitude);
                break;
            }
        }


    }


}

