package com.QueryRequest.Specification;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.mapper.factory.JsonbObjectMapperFactory;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class QueryRequestSpecification {

	@Test
	public void Test_Method01() {
		
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("name", "morpheus");
//		jsonObject.put("job", "leader");
		
		RequestSpecification reqSpecific = RestAssured.given();
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "morpheus");
		jsonObject.put("job", "leader");
		
		
		reqSpecific.basePath("https://reqres.in/");
		reqSpecific.baseUri("/api/users");
		
		reqSpecific.contentType(ContentType.JSON).body(jsonObject.toJSONString());
		
	QueryableRequestSpecification	QrequestSpecific = SpecificationQuerier.query(reqSpecific);
	
	
	String str = QrequestSpecific.getBasePath();
	System.out.println(" Base Path : " + str);
	
	String str1 = QrequestSpecific.getBaseUri();
	System.out.println(" Base URI : " + str1);
	
	String str2 = QrequestSpecific.getBody();
	System.out.println(" Get Body  : " + str2);
	
	Headers headersValue =QrequestSpecific.getHeaders();
	
	for(Header h :headersValue ) {
		System.out.println("Header name  : " + h.getName()+ " And " + " Header Value :  " +h.getValue());
	}
	}
}
