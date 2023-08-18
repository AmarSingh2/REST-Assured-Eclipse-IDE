package com.IgnoreFieldFromPOJOClassFromSerializationAndDeserialization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"firstName","gender"})
public class EmployeeForIgnoringFieldFromPOJOClass {

	private String firstName;
	
	private String lastName;
	
	private String gender;
	
	private int age;
	
//	{
//		  "firstName" : "Amar",
//		  "lastName" : "Singh",
//		  "gender" : "Male",
//		  "age" : 26,
//		  "fullName" : "Amar Singh"
//		}
	
//	@JsonIgnore
	private double salary;
	
	private String fullName;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
