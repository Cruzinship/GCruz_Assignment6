/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: Customer Class to record Customer data
 * Due: 04/29/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Gianpaulo Cruz
*/
package Power;

public class Customer {
	
	private String name;
	private int age;

	Customer(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	Customer(Customer c){
		this.name = c.getName();
		this.age = c.getAge();
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", Age: " + age;
	}
}
