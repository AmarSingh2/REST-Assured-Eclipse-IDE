package com.OAuth.VersionTwoPointZero;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OAuthVersionTwo {
	
	static String Access_Token;

	@Test
	public void GetAccess_Token01(){

		
	 String ClientID =	"AbsnzrLW8iR3J6lXOoOLHwgSQNwdhhmMQymR8LskuUzw11DWTKgEwaRdz3V1ezj_f_v3YVwYs2GWKVBN" ;
	 String SecretKey = "EH6nRTJCHhrrfh_u0o7y0BF_QD0kEAsU60Dj_1mLwmJsh09Ge31cIsR9oV009du7KwXGgYnjvmH96JXB" ;
	
	 RequestSpecification requestSpecific = RestAssured.given();
	 
	 requestSpecific.baseUri("https://api-m.sandbox.paypal.com");
	 requestSpecific.basePath("/v1/oauth2/token");
	 
	Response response = requestSpecific.auth().preemptive().basic(ClientID, SecretKey).param("grant_type" , "client_credentials").post();
	response.prettyPrint();
	
	System.out.println("Response StatusCode : " +response.statusCode());
	System.out.println("Response StatusLine : " +response.statusLine());
		
	 Access_Token = response.getBody().path("access_token");
	System.out.println("Access_token : " + Access_Token);

	}
	
	@Test(dependsOnMethods = "GetAccess_Token01")
	public void ListToken01() {
		Response res = RestAssured.given().auth().oauth2(Access_Token)
		.queryParam("page", "3")
		.queryParam("page_size" ,"4")
		.queryParam("total_count_required", "true")
		.get(" https://api-m.sandbox.paypal.com/v1/invoicing/invoices");
		
		System.out.println("----------------List Invoice ----------------------");
		
		res.prettyPrint();
		
		System.out.println("Status code : " +res.statusCode());
		System.out.println("Status line : " +res.statusLine());
	}
}
