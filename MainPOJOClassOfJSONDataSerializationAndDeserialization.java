package POJOClassOfJSONData;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MainPOJOClassOfJSONDataSerializationAndDeserialization {

	@Test
	public void Test_Method01() throws JsonProcessingException {
		 Employee emp1 = new Employee();
		 emp1.setFirstName("Amar");
		 emp1.setLastName("Singh");
		 emp1.setAge(27);
		 emp1.setGender("Male");
		 emp1.setSalary(10000.0f);
		 
//		 Employee emp2 = new Employee();
//		 emp2.setFirstName("Sonam");
//		 emp2.setLastName("Singh");
//		 emp2.setAge(27);
//		 emp2.setGender("Female");
//		 emp2.setSalary(100000.0f);
		 
		 // both the instance emp1 and emp2 are stored in one list 
//		 List<Employee> list = new ArrayList<Employee>();
//		 list.add(emp1);
//		 list.add(emp2);
		 
		 // by using objectmapper we serialize the POJO class ( Conversion of )
		 ObjectMapper objectmapper = new ObjectMapper();
		 
		String str=objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		 System.out.println(str);
		 
		 RequestSpecification requestSpecific = RestAssured.given();
		 requestSpecific.baseUri("https://reqres.in/api/users");
		 Response response = requestSpecific.contentType(ContentType.JSON).body(objectmapper).post();
		 response.prettyPrint();
		 
		 System.out.println("---------------------------After Deserialization ----------------------------------------------------------");
		 Employee emp3 =objectmapper.readValue(str, Employee.class);
		 System.out.println("first Name : " +emp3.getFirstName());
		 System.out.println("Last Name : " +emp3.getLastName());
		 System.out.println("Gender : " +emp3.getGender());
		 System.out.println("Age : " +emp3.getAge());
		 System.out.println("Salary : " +emp3.getSalary());
	}
}
