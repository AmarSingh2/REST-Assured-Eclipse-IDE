package com.basicAuthAndDigestAuth.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAndDigestAuth {

	@Test
	public void Test_Method01() {
		
		RequestSpecification requestSpecific = RestAssured.given();
		
		requestSpecific.baseUri("https://github.com");
		requestSpecific.basePath("/AmarSingh2?tab=repositories");
		
		//pre-emptive basic auth
		Response response = requestSpecific.get();
//		 Response response = requestSpecific.auth().preemptive().basic("amar","singh").get();
		 String str=response.statusLine();
		 String str1=response.getBody().asString();
		 System.out.println(str);
		 System.out.println(str1);	 
	}

	@Test
	public void Test_Method02() {
		RequestSpecification requestSpecific = RestAssured.given();
		
		requestSpecific.baseUri("https://github.com");
		requestSpecific.basePath("/AmarSingh2?tab=repositories");
		
		Response response = requestSpecific.get();
//		Response response = requestSpecific.auth().digest("amar", "singh").get();
		
		 int statusCode = response.statusCode();
		 
		 Assert.assertEquals(statusCode, 200);
		 
	}
}







