package com.rest_assured.project;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UsingGet_Method {
	@Test
	public void TestMethod01() { // GET Method 
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("Header : "+response.getHeader("content-type") );
		System.out.println("Status Code : "+response.getStatusCode() );
		System.out.println("Response Time : "+response.getTime());
		System.out.println("Response body : "+response.getBody() );	
		
		int ExpectedStatusCode = 200;
		int ActualStatusCode = response.getStatusCode();
		
		Assert.assertEquals(ActualStatusCode, ExpectedStatusCode);
	}
	 
	@Test
	public void TestMethod02() { // BDD format for GET Request
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given().queryParam("users", "2")
		.when().get()
		.then().statusCode(200);
	}
	
}
