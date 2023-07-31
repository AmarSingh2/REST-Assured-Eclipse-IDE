package com.rest_assured.project;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UsingPut_Method {

	@Test
	public void TestMethod01() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Name","Sonam Singh");
		jsonObject.put("Job","Dot Net Developer");
		
		RestAssured.baseURI="https://reqres.in/api/users/581";
		RestAssured.given().header("content-type","Application/JSON").contentType(ContentType.JSON).body(jsonObject.toJSONString())
		.when().put()
		.then().statusCode(200).log().all();

	}
}
