package com.APIKey.AUTH;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIAuthKEy {

	//https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
	@Test
	public void Test_Method()
	{
		RequestSpecification requestSpecific = RestAssured.given();
		requestSpecific.baseUri("https://api.openweathermap.org");
		requestSpecific.basePath("/data/2.5/weather");
		
		requestSpecific.queryParam("q", "delhi").queryParam("appid", "4cb029a43d82d82a5d9c833c47d947a9");
		Response response = requestSpecific.get();
		
		System.out.println(response.getBody().asString());
		
	}
}
