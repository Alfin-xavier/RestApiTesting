package com.atmecs.rest.apiTesting.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.apiTesting.constant.Constants;
import com.atmecs.apiTesting.utility.PropertyReader;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteUser 
{
	Properties property = PropertyReader.readProperties(Constants.DATA_PROVIDER_FILE);
	
	@Test
	public void deleteUser() throws MalformedURLException
	{
		String url = "https://reqres.in/api/users/2";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.delete(new URL(url)).then().extract().response();
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 204);
		
		System.out.println(statusCode);
		
	}
}
