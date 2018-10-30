package com.developers.thought.endpoint.tests;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import java.util.logging.Logger;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndpointTest {

	final static String API_URL = "http://localhost:8080";
	private static Logger log = Logger.getLogger("EndpointTest");

	@Test
	public void endpointTest() {

		// Add Account Test
		Response response = given().contentType(ContentType.JSON).body("{\"name\": \"Sagar Jadhav\"}").when()
				.post(API_URL + "/account");

		log.info("Response & Status of Add Account Test : " + response.asString() + "," + response.statusCode());
		response.then().body("name", Matchers.is("Sagar Jadhav"));
		response.then().statusCode(201);
		int id = response.getBody().path("id");

		// Get Account Test
		response = get(API_URL + "/account/" + id);
		log.info("Response & Status of Get Account Test : " + response.asString() + "," + response.statusCode());
		response.then().body("name", Matchers.is("Sagar Jadhav"));
		response.then().statusCode(200);

		// Get Accounts Test
		response = get(API_URL + "/accounts");
		log.info("Response & Status of Get Accounts Test : " + response.asString() + "," + response.statusCode());
		response.then().body("name", Matchers.hasItem("Sagar Jadhav"));
		response.then().statusCode(200);

		// Update Account Test
		response = given().contentType(ContentType.JSON).body("{\"name\": \"Anish\"}").when()
				.put(API_URL + "/account/" + id);

		log.info("Response & Status of Update Account Test : " + response.asString() + "," + response.statusCode());
		response.then().body("name", Matchers.is("Anish"));
		response.then().statusCode(200);

		// Delete Account Test
		response = delete(API_URL + "/account/" + id);
		log.info("Response & Status of Delete Account Test : " + response.asString() + "," + response.statusCode());

		// check if deleted
		response = get(API_URL + "/account/" + id);
		response.then().statusCode(404);
	}
}
