package com.rest_assured.project;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstRest_AssuredCode {
	
	@Test
	public void TestCase01() {
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(res.asString()); // for printing the whole data so we use asString method to print in console
		System.out.println("Status code : " + res.getStatusCode());
		
	}

}
