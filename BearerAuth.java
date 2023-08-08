package com.BearerAuth.RestAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerAuth {

	@Test
	public void Test_Method01() {
			
		RequestSpecification requestSpecific = RestAssured.given();
		requestSpecific.baseUri("https://gorest.co.in/");
		requestSpecific.basePath("/public/v2/users");
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Amar Singh");
		jsonObject.put("email", "amar877057@gmial.com");
		jsonObject.put("gender", "male");
		jsonObject.put("status", "active");
		
		String authToken="Bearer ecc74fbae413bde6ae355a8a9007cbd346b988e279a76b6afca1329748d36e76";
		
		requestSpecific.headers("Authorization", authToken).contentType(ContentType.JSON).body(jsonObject.toJSONString());
		
		 Response response =    requestSpecific.post();
		 
		 System.out.println(response.getBody().asString());
	}	
}
