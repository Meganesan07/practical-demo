package com.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

// This single annotation replaces the 4 old ones! It tells Spring to start up the app on a random port for testing.
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalcEndpointTest {

    // Modern way to grab the random port Spring just started
    @LocalServerPort
    int port;

    ObjectMapper objectMapper = new ObjectMapper(new MessagePackFactory());

    // @Before is now @BeforeEach in JUnit 5
    @BeforeEach
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    // @Test now comes from the org.junit.jupiter.api package
    @Test
    public void testCalc() throws Exception {
        byte[] response = given()
                .accept("application/x-msgpack") // <-- ADD THIS LINE HERE
                .param("left", 100)
                .param("right", 200)
                .log().all()
                .get("/calc")
                .then()
                .log().all()
                .extract()
                .asByteArray();

        CalcEndpoint.Result result = objectMapper.readValue(response, CalcEndpoint.Result.class);
        
        assertEquals(300L, result.getAnswer());
        assertEquals(100, result.getLeft());
        assertEquals(200, result.getRight());
    }
}