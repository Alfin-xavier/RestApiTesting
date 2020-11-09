package com.atmecs.rest.apiTesting.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.apiTesting.utility.UsersDataProvider;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutUser 
{
	@Test(dataProvider = "createUser", dataProviderClass = UsersDataProvider.class )
	public void updateUser(Object requestBody) throws MalformedURLException
	{
		String url = "https://reqres.in/api/users";

		Map<String, Object> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");

		RequestSpecification request = RestAssured.given().headers(headers);

		Response response = request.when().body(requestBody.toString()).put(new URL(url)).then().extract().response();

		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();

		System.out.println("Status Code:" + statusCode);
		System.out.println("Response Body:" + responseBody);

		Assert.assertEquals(statusCode, 200);

		JsonPath jsonPath = response.jsonPath();

		String name = jsonPath.getString("name");
		System.out.println("Name:" + name);

		String updatedAt = jsonPath.getString("updatedAt");
		System.out.println("CreatedAt:" + updatedAt);

	}
}
