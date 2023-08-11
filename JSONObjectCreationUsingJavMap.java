package com.JSONObject.UsingJavaMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JSONObjectCreationUsingJavMap {

	@Test
	public void test_Method01() {
		Map<String,Object> obj1= new HashMap<String, Object>();
		obj1.put("firstName","Amod");
		obj1.put("lastName","Mahajan");
		obj1.put("Age",28);
		obj1.put("Salary",10000.56);
		obj1.put("IsMarried",true);
		
		ArrayList<String> obj2 = new ArrayList<String>();
		obj2.add("Music");	obj2.add("Computer");	obj2.add("Games");
		
		obj1.put("Hobbies", obj2);
		
		Map<String, String> obj3=new HashMap<String, String>();
		obj3.put("Programming language", "Java");
		obj3.put("Web Automation", "Selenium");
		obj3.put("API Testing", "Rest Assured");
		
		obj1.put("TechSkills", obj3);
		
		Response response=RestAssured.given().baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		.body(obj1).post();
		
		response.prettyPrint();
		
		




	}
}
