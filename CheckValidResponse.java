package ValidatingHTTPStatus;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckValidResponse {
	
	@Test(enabled = false)
	public void Test_Method01() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
       // Get Request verification/specification from the Request
		RequestSpecification requestSpecify = RestAssured.given();
		
	   // call get method
		Response response = requestSpecify.get();
		
	  //	Validate Response
		ValidatableResponse validResponse = response.then();
		
	  //    Status code 	
		validResponse.statusCode(200);
		
	    System.out.println("Validating Success");
		validResponse.statusLine("HTTP/1.1 200 OK");
	}
	
	@Test
	public void Test_Method02BDDStyle() {
		RestAssured.given()
		.when().get("https://reqres.in/api/users/2")
		.then().statusCode(200).statusLine("HTTP/1.1 200 OK");
	}

}
