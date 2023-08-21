package com.FileUpload.RestAssured;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FileUploadinRestAssured {

	@Test
	public void Test_Method01() {
		File fileRestAssured = new File("C:\\Users\\bhumi\\OneDrive\\Desktop\\FileUpload.txt");
		
//		https://petstore.swagger.io/v2/pet/2/uploadImage

		
		RequestSpecification requestSpecific = RestAssured.given();
		requestSpecific.baseUri("https://petstore.swagger.io/v2/pet/2/uploadImage");
		
		requestSpecific.multiPart("file",fileRestAssured);
		Response response =requestSpecific.post();
		
		response.prettyPrint();
		
		
		
	}
}
