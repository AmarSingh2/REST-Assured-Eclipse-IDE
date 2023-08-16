package POJOClassofNestedJSONObject;

public class EmployeeofNestedJSON {

	private String firstName;
	
	private String lastName;
	
	private String gender;
	
	private double salary;
	
	private EmployeeAddress Address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public EmployeeAddress getAddress() {
		return Address;
	}

	public void setAddress(EmployeeAddress address) {
		Address = address;
	}
	
	
	
	
}
