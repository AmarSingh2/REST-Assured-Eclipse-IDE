package POJOClassofJSONArray;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJOClassOfJSONData.Employee;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class POJOClassofJSONArraySerializationAndDeserialization {

	@Test
	public void Test_Method() throws JsonProcessingException {
		Employee emp1 = new Employee();
		 emp1.setFirstName("Amar");
		 emp1.setLastName("Singh");
		 emp1.setAge(27);
		 emp1.setGender("Male");
		 emp1.setSalary(10000.0f);
		 
		Employee emp2 = new Employee();
		 emp2.setFirstName("Amar");
		 emp2.setLastName("Singh");
		 emp2.setAge(27);
		 emp2.setGender("Male");
		 emp2.setSalary(10000.0f);
		 
		 List<Employee> list = new ArrayList<Employee>();
		 list.add(emp1);
		 list.add(emp2);
		 
		 ObjectMapper objMapper = new ObjectMapper();
		 String str = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
		 
		 System.out.println(str);
		 
		RequestSpecification requestSpecific = RestAssured.given();
		
		System.out.println("--------------------------------Printing the statemnet after reqres API Post method----------------------------------");
		requestSpecific.baseUri("https://reqres.in");
		requestSpecific.basePath("/api/users");
		Response resonse = requestSpecific.contentType(ContentType.JSON).body(str).post();
		
		resonse.prettyPrint();
		System.out.println(resonse.statusCode());
		ResponseBody responseBody	= resonse.getBody();
		
		JsonPath jsonPathView = responseBody.jsonPath();
		List<Employee> employeeList = jsonPathView.getList("json", Employee.class);
		
		for(Employee emp : employeeList) {
			System.out.println(emp.getFirstName());
		}
		 
		 
	}
	
		
		
		
	
}
