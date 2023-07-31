package com.rest_assured.project;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UsingDelete_Method {

	@Test
	public void Test_Method01() {
		RestAssured.baseURI="https://reqres.in/api/users/875";
		RestAssured.given().when().delete().then().log().all();
	}
}
