package com.restAssured.QueryParameter;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QueryParameter {

	@Test
	public void Method01() {
		RequestSpecification requestSpecific = RestAssured.given();
		
		requestSpecific.baseUri("https://reqres.in");
		requestSpecific.basePath("/api/users");
		requestSpecific.queryParam("page",2).queryParam("id",7);
		
		Response response = requestSpecific.get();
		String str = response.getBody().asString();
		
		System.out.println(str);
		
		 JsonPath jsonPathView = response.jsonPath();
		 String str1= jsonPathView.get("data.first_name");
		 Assert.assertEquals(str1 , "Michael");
		 
		
	}
}


//{"data":{"id":7,"email":"michael.lawson@reqres.in","first_name":"Michael","last_name":"Lawson","avatar":"https://reqres.in/img/faces/7-image.jpg"},"support":{"url":"https://reqres.in/#support-heading","text":"To keep ReqRes free, contributions towards server costs are appreciated!"}}