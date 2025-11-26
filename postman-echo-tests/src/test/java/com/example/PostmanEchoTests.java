package com.example;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostmanEchoTests {

    private final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testGetMethod() {
        Response response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get(BASE_URL + "/get")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JSONObject expectedArgs = new JSONObject();
        expectedArgs.put("foo1", "bar1");
        expectedArgs.put("foo2", "bar2");

        JSONObject actual = new JSONObject(response.asString());
        assertEquals(expectedArgs.toString(), actual.getJSONObject("args").toString());
    }

    @Test
    public void testPostMethod() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "John");
        requestBody.put("age", 30);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .when()
                .post(BASE_URL + "/post")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JSONObject actual = new JSONObject(response.asString());
        assertEquals(requestBody.toString(), actual.getJSONObject("data").toString());
    }

    @Test
    public void testPutMethod() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("city", "London");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .when()
                .put(BASE_URL + "/put")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JSONObject actual = new JSONObject(response.asString());
        assertEquals(requestBody.toString(), actual.getJSONObject("data").toString());
    }

    @Test
    public void testPatchMethod() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("field", "value");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .when()
                .patch(BASE_URL + "/patch")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JSONObject actual = new JSONObject(response.asString());
        assertEquals(requestBody.toString(), actual.getJSONObject("data").toString());
    }

    @Test
    public void testDeleteMethod() {
        Response response = given()
                .when()
                .delete(BASE_URL + "/delete")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JSONObject actual = new JSONObject(response.asString());
        assertEquals("{}", actual.getJSONObject("data").toString());
    }

    @Test
    public void testHeadMethod() {
        given()
                .when()
                .head(BASE_URL + "/get")
                .then()
                .statusCode(200);
    }

    @Test
    public void testOptionsMethod() {
        given()
                .when()
                .options(BASE_URL + "/get")
                .then()
                .statusCode(200);
    }
}