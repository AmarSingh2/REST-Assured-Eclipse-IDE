package POJOClassofNestedJSONObject;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class POJOClassofNestedJSOnObject {

	@Test
	public void Test_Method01() throws JsonProcessingException {
		
		EmployeeofNestedJSON emp = new EmployeeofNestedJSON();
		emp.setFirstName("Amar");
		emp.setLastName("Singh");
		emp.setGender("Male");
		emp.setSalary(10000.56);
		
		EmployeeAddress emp1 = new EmployeeAddress();
		emp1.setStreet("Bhilai Town");
		emp1.setCity("Bhilai");
		emp1.setState("Chhattisgarh");
		emp1.setPincode(530012);
		
		emp.setAddress(emp1);
		
		ObjectMapper objMapper = new ObjectMapper();
		String str = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		System.out.println(str);
	}
}
