package com.XML.Validate.Payload;

import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

	
	public class ValidateXMLRequest {
		
		@Test
		public void Test_Method01() {
			
			String JSONBody = "{\r\n"
					+ "  \"id\": 0,\r\n"
					+ "  \"category\": {\r\n"
					+ "    \"id\": 0,\r\n"
					+ "    \"name\": \"string\"\r\n"
					+ "  },\r\n"
					+ "  \"name\": \"doggie\",\r\n"
					+ "  \"photoUrls\": [\r\n"
					+ "    \"string\"\r\n"
					+ "  ],\r\n"
					+ "  \"tags\": [\r\n"
					+ "    {\r\n"
					+ "      \"id\": 0,\r\n"
					+ "      \"name\": \"string\"\r\n"
					+ "    }\r\n"
					+ "  ],\r\n"
					+ "  \"status\": \"available\"\r\n"
					+ "}";
			
			String XMLBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
					+ "<Pet>\r\n"
					+ "	<id>0</id>\r\n"
					+ "	<Category>\r\n"
					+ "		<id>0</id>\r\n"
					+ "		<name>string</name>\r\n"
					+ "	</Category>\r\n"
					+ "	<name>doggie</name>\r\n"
					+ "	<photoUrls>\r\n"
					+ "		<photoUrl>string</photoUrl>\r\n"
					+ "	</photoUrls>\r\n"
					+ "	<tags>\r\n"
					+ "		<Tag>\r\n"
					+ "			<id>0</id>\r\n"
					+ "			<name>string</name>\r\n"
					+ "		</Tag>\r\n"
					+ "	</tags>\r\n"
					+ "	<status>available</status>\r\n"
					+ "</Pet>";
			
//			JSONObject jsonObject = new JSONObject();
			
			RequestSpecification reqSpecification = RestAssured.given();
			reqSpecification.baseUri("https://petstore.swagger.io");
			reqSpecification.basePath("/v2/pet");
			
			reqSpecification.header("accept","application/json");
			reqSpecification.header("Content-Type","application/json");
			reqSpecification.body(JSONBody);
			
			Response resppnse = reqSpecification.post();
			resppnse.prettyPrint();
			
			
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
		}
			
//		System.out.println("-----------------------------------------------------------------------------------------------");
		
		
		
		@Test
		public void Test_Method02() {
			
			String XMLBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
					+ "<Pet>\r\n"
					+ "	<id>0</id>\r\n"
					+ "	<Category>\r\n"
					+ "		<id>0</id>\r\n"
					+ "		<name>string</name>\r\n"
					+ "	</Category>\r\n"
					+ "	<name>doggie</name>\r\n"
					+ "	<photoUrls>\r\n"
					+ "		<photoUrl>string</photoUrl>\r\n"
					+ "	</photoUrls>\r\n"
					+ "	<tags>\r\n"
					+ "		<Tag>\r\n"
					+ "			<id>0</id>\r\n"
					+ "			<name>string</name>\r\n"
					+ "		</Tag>\r\n"
					+ "	</tags>\r\n"
					+ "	<status>available</status>\r\n"
					+ "</Pet>";
			
			RequestSpecification reqSpecific = RestAssured.given();
			reqSpecific.baseUri("https://petstore.swagger.io");
			reqSpecific.basePath("/v2/pet");
			
			reqSpecific.header("accept","application/xml");
			reqSpecific.header("Content-Type","application/xml");
			reqSpecific.body(XMLBody);
			
			Response response = reqSpecific.post();
			response.prettyPrint();
			
			
			response.then().body("Pet.name", Matchers.equalTo("doggie"));
			
			System.out.println("----------------------------------------------------------------------------------------------------------");
			
			
		}
		
		@Test
		public void Test_Method03() {
			
//			http://restapi.adequateshop.com/api/Traveler
			
			RequestSpecification reqSpecific = RestAssured.given();
			reqSpecific.baseUri("http://restapi.adequateshop.com");
			reqSpecific.basePath("/api/Traveler");
			
			reqSpecific.header("Accept","application/xml");
			Response response = reqSpecific.get();
			response.prettyPrint();
			
			response.then().body("TravelerinformationResponse.travelers.Travelerinformation[2].name", Matchers.equalTo("vano"));
			
			
			XmlPath objXmlPath = new XmlPath(response.asString());
			
			List<String> objectList = objXmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
			
			boolean found = false;
			for( String travelers : objectList ) {
				System.out.println(travelers);
				
//				boolean found = false;
				if(travelers.equals("vano"))
				{
					found= true;
					break;
				}
			}
			
//			boolean found = false;
//			if(objectList.equals("vano")){
//				found= true;
//			}
			
			Assert.assertEquals(found, true);
			
		}
	}