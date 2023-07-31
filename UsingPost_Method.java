package com.rest_assured.project;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UsingPost_Method {

		@Test
		public void TestMethod01() {
			
			JSONObject jsonObject= new JSONObject();
			jsonObject.put("Name", "Amar Singh");
			jsonObject.put("Job", "QA Automation");
			
			RestAssured.baseURI="https://reqres.in/api/users";
			RestAssured.given().header("content-type","Application/JSON")
			.contentType(ContentType.JSON)
			.body(jsonObject.toJSONString())
			.when().post()
			.then().statusCode(201).log().all() ;
		}
}


//https://reqres.in/api/users/581