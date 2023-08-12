package com.deserialize.JSONData;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class JSONdataSerialize {

	@Test
	public void Test_Method01() {
		RequestSpecification requestSpecific = RestAssured.given();
		requestSpecific.baseUri("https://reqres.in/");
		requestSpecific.basePath("/api/users");
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Amar Singh");
		jsonObject.put("job", "leader");
		
		Response response =  requestSpecific.contentType(ContentType.JSON)
		.body(jsonObject.toJSONString())
		.post();
		
		ResponseBody responseBody = response.getBody() ;
		
		JSONSerializeClass resSerialize   = responseBody.as(JSONSerializeClass.class);
		
		Assert.assertEquals(resSerialize.name, "Amar Singh");
		Assert.assertEquals(resSerialize.job, "leader");

	}
}
