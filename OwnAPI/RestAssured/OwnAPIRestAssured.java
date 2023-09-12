package com.OwnAPI.RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OwnAPIRestAssured {

	@Test
	public void GetUserFromOwnAPI() {
		RequestSpecification requestSpecific = RestAssured.given();
		requestSpecific.baseUri("http://localhost:3000");
		requestSpecific.basePath("/users");
		
		Response response = requestSpecific.get();
		response.prettyPrint();
	}
	
	@Test(enabled = false)
	public void CreateUserFromOwnAPI() {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Himani");
		jsonObject.put("age", 27);
		
		RequestSpecification requestSpecific = RestAssured.given();
		requestSpecific.baseUri("http://localhost:3000");
		requestSpecific.basePath("/users");
		
		Response response = requestSpecific.contentType(ContentType.JSON)
		.body(jsonObject).post();
		
		response.prettyPrint();
	}
	
	@Test(enabled = false)
	public void UpdateUserFromOwnAPI() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Himani");
		jsonObject.put("age", "58");
		
		RequestSpecification requestSpecific = RestAssured.given();
		requestSpecific.baseUri("http://localhost:3000");
		requestSpecific.basePath("/users");
		
		Response response = requestSpecific.contentType(ContentType.JSON)
				            .body(jsonObject).put("/3");
		
		response.prettyPrint();
		
	}
	
	@Test
	public void DeleteUserFromOwnAPI() {
		RequestSpecification requestSpecific = RestAssured.given();
		requestSpecific.baseUri("http://localhost:3000");
		requestSpecific.basePath("/users");
		
		Response response = requestSpecific.delete("/4");
	}
}
