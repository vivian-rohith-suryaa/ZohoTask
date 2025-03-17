package task11.jdbc.task;

public class Dependent {
	private int employeeId;
	private int personId;
	private String employeeName;
	private String personName;
	private int age;
	private String relation;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int empId) {
		this.employeeId = empId;
	}
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int perId) {
		this.personId = perId;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String empName) {
		this.employeeName = empName;
	}
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}

}
