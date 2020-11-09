package com.atmecs.apiTesting.utility;

import org.testng.annotations.DataProvider;

import com.atmecs.apiTesting.constant.Constants;

public class UsersDataProvider 
{
	@DataProvider(name = "createUser")
	public static Object[][] createUserData()
	{
		JsonFileReader jsonReader = new JsonFileReader(Constants.JSON_DATA_FILE);
		
		Object object = jsonReader.parse();
		
		Object[][] data = new Object[1][1];
		
		data[0][0] = object;
		
		return data;
		
	}
}
