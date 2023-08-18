package com.IgnoreFieldFromPOJOClassFromSerializationAndDeserialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IgnoreFieldFromPOJOClassFromSerializationAndDeserialization {

	@Test
	public void Test_Method01() throws JsonProcessingException {
		
		EmployeeForIgnoringFieldFromPOJOClass empJSON = new EmployeeForIgnoringFieldFromPOJOClass();
		empJSON.setFirstName("Amar");
		empJSON.setLastName("Singh");
		empJSON.setGender("Male");
		empJSON.setAge(26);
		empJSON.setSalary(1000);
		empJSON.setFullName("Amar Singh");
		
		ObjectMapper onjMapper = new ObjectMapper();
		String str = onjMapper.writerWithDefaultPrettyPrinter().writeValueAsString(empJSON);
		
		System.out.println(str);
		
		String str1="{\r\n"
				+ "  \"firstName\" : \"Amar\",\r\n"
				+ "  \"lastName\" : \"Singh\",\r\n"
				+ "  \"gender\" : \"Male\",\r\n"
				+ "  \"age\" : 26,\r\n"
				+ "  \"salary\" : 1000.0,\r\n"
				+ "  \"fullName\" : \"Amar Singh\"\r\n"
				+ "}" ;
	EmployeeForIgnoringFieldFromPOJOClass empPOJO	= onjMapper.readValue(str1, EmployeeForIgnoringFieldFromPOJOClass.class);
	System.out.println("Printing after the Deserialization");
	System.out.println("first Name : "+empPOJO.getFirstName());
	System.out.println("last Name : "+empPOJO.getLastName());
	System.out.println("Gender : "+empPOJO.getGender());
	System.out.println("Salary : "+empPOJO.getSalary());
	System.out.println("full name  : "+empPOJO.getFullName());
	
	}
}
