package com.atmecs.rest.apiTesting.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.apiTesting.utility.UsersDataProvider;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUser 
{
	@Test(dataProvider = "createUser", dataProviderClass = UsersDataProvider.class )
	public void createUser(Object requestBody) throws MalformedURLException
	{
		String url ="https://reqres.in/api/users";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.when().body(requestBody.toString())
							.post(new URL(url)).then().extract().response();
		
		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();
		
		System.out.println("Status Code:"+ statusCode);
		System.out.println("Response Body:"+ responseBody);
		
		
		  Assert.assertEquals(statusCode, 201);
		  
		  JsonPath jsonPath = response.jsonPath();

		  String id = jsonPath.getString("id"); 
		  System.out.println("Id:"+id);
		  
		  String createdAt = jsonPath.getString("createdAt"); 
		  System.out.println("CreatedAt:"+createdAt);
		  		  
	}
}
