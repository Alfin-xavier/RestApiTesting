package com.atmecs.rest.apiTesting.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.testng.annotations.Test;
import com.atmecs.apiTesting.constant.Constants;
import com.atmecs.apiTesting.utility.PropertyReader;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUserList 
{
	Properties property = PropertyReader.readProperties(Constants.DATA_PROVIDER_FILE);
	@Test()
	public void getUserList() throws MalformedURLException 
	{
		String requestUrl = "https://reqres.in/api/users/2" ;
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get(new URL(requestUrl));
		
		int statusCode = response.getStatusCode();
		
		String body = response.getBody().asString();
		
		JsonPath jsonPath = response.jsonPath();
		
		System.out.println(body);
		
		/**
		 * Getting inputs by hard coded.
		 */
		/*
		 * String firstName = jsonPath.get("data.first_name"); String lastName =
		 * jsonPath.get("data.last_name"); String email = jsonPath.get("data.email");
		 * 
		 * Assert.assertEquals("Janet", firstName); Assert.assertEquals("Weaver",
		 * lastName); Assert.assertEquals("janet.weaver@reqres.in", email);
		 * 
		 * System.out.println("FirstName: " + firstName);
		 * System.out.println("LastName: " + lastName); System.out.println("Email Id: "
		 * + email); System.out.println("Response Body: " + body);
		 * System.out.println("Status Code: " + statusCode);
		 */
		 
		 /**
		  * Getting inputs from properties file.
		  */
		String actualFirstName = jsonPath.get("data.first_name");
		String actualLastName = jsonPath.get("data.last_name"); 
		String actualEmail = jsonPath.get("data.email");
		
		/*
		 * String expectedFirstName = property.getProperty("firstname"); String
		 * expectedLastName = property.getProperty("lastname"); String expectedEmail =
		 * property.getProperty("email");
		 */
		/*
		 * Assert.assertEquals(expectedFirstName, actualFirstName);
		 * Assert.assertEquals(expectedLastName,actualLastName);
		 * Assert.assertEquals(expectedEmail, actualEmail);
		 */
		
		System.out.println("FirstName: " + actualFirstName);
		System.out.println("LastName: " + actualLastName);
		System.out.println("Email Id: " + actualEmail);
		System.out.println("Response Body: " + body);
		System.out.println("Status Code: " + statusCode);
		
	}
}
