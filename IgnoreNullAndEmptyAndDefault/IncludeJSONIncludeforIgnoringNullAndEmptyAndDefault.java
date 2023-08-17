package com.IgnoreNullAndEmptyAndDefault;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class IncludeJSONIncludeforIgnoringNullAndEmptyAndDefault {

	@Test
	public void Test_Method01() throws JsonProcessingException {
		EmployeeForIncludeJSON empJSON = new EmployeeForIncludeJSON();
		empJSON.setFirstName("Amar");
//		empJSON.setLastName("Singh");
		empJSON.setGender("Male");
		empJSON.setAge(26);
		empJSON.setSalary(1000);
		empJSON.setMarried(false);
		
		ObjectMapper objMapper = new ObjectMapper();
		String str = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(empJSON);
		System.out.println(str);
		
	}
	
}
