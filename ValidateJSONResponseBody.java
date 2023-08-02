package ValidateJSONResponseBody;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.mapping.JsonbMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateJSONResponseBody {

	@Test
	public void Test_Method01() {
	RequestSpecification requestSpecific = RestAssured.given();
	
	requestSpecific.baseUri("https://reqres.in/");
	requestSpecific.basePath("api/users?page=2");
	
	Response response = requestSpecific.get();
	
	ResponseBody responseBody = response.getBody();
	
	
	String str=responseBody.asString();
	System.out.println(str);
	
	JsonPath jsonPath=responseBody.jsonPath();
	String str1=jsonPath.get("data[0].first_name");
	Assert.assertEquals(str1, "George");
	
	
	
	
	
	}
}
