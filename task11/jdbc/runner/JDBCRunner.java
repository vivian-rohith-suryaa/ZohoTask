package task11.jdbc.runner;

import java.util.List;
import exceptions.taskexception.TaskException;
import task11.jdbc.task.Employee;
import task11.jdbc.task.Employee_Personal;
import task11.jdbc.task.JDBCTask;
import utility.TaskUtility;

public class JDBCRunner {
	
	JDBCTask taskObj = new JDBCTask();
	
	static {
		showTasks();
	}
	
	public static void main(String[] agrs) {
		
		JDBCRunner runnerObj = new JDBCRunner();
		boolean loop = true;
		
		while(loop) {
			System.out.println("Enter the sequence number for the exercise (1-11, or 0 to exit):");
			int sequenceNumber = TaskUtility.getIntInput();
			if(sequenceNumber==0) {
				System.out.println("Exiting the program!!!!");
				loop = false;
			}
			else {
				try {
					switch(sequenceNumber) {
						
						case 1:
							runnerObj.runCaseOne();
							break;
							
						case 2:
							runnerObj.runCaseTwo();
							break;
							
						case 3:
							runnerObj.runCaseThree();
							break;
							
						case 4:
							runnerObj.runCaseFour();
							break;
							
						case 5:
							runnerObj.runCaseFive();
							break;
							
						case 6: 
							runnerObj.runCaseSix();
							break;
							
						case 7: 
							runnerObj.runCaseSeven();
							break;
							
						case 8: 
							runnerObj.runCaseEight();
							break;
							
						case 9: 
							runnerObj.runCaseNine();
							break;
							
						case 10: 
							runnerObj.runCaseTen();
							break;
							
						case 11: 
							runnerObj.runCaseEleven();
							break;
							
						case 12:
							runnerObj.viewDependentTable();
							break;
							
						default:
							System.out.println("Please choose between numbers 1 to 11.");
							break;
					}
				}
				catch(Exception e) {
					System.out.println("Exception caught in main method: "+e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void showTasks() {
		System.out.println("1. Creating an Employee Table programatically with columns EMPLOYEE_ID, NAME, MOBILE, EMAIL, DEPARTMENT by connecting to the incubationDB");
		System.out.println("2. Insert some records in to the table.");
		System.out.println("3. Retrieve record from table based on condition.");
		System.out.println("4. Modify the record in table.");
		System.out.println("5. View Table Records.");
		System.out.println("6. Sort Table Records.");
		System.out.println("7. Delete Record from the table.");
		System.out.println("8. Create a table dependent on the Employee Table.");
		System.out.println("9. Insert some records into the dependent table.");
		System.out.println("10. Retrieve record from table based on condition.");
		System.out.println("11. Sort Dependent Table Records.");
		System.out.println("12. View Dependent Table.");
		
	}
	
	public void runCaseOne() throws TaskException {
		System.out.println("Enter the table name:");
		String tableName = TaskUtility.getStringInput();
		if(taskObj.createTable(tableName)==0) {
			System.out.println("Table Created Successfully");
		}
		runCaseFive();
	}
	
	public void runCaseTwo() throws TaskException {
		System.out.println("Enter the number of Records to be added in the table:");
		int recordCount = TaskUtility.getIntInput();
		
		for (int i=1;i<=recordCount;i++) {
			System.out.println("Enter the Name for "+i+" record to insert in table Employee:");
			String name = TaskUtility.getStringInput();
			System.out.println("Enter the Mobile for "+i+" record to insert in table Employee:");
			String mobile = TaskUtility.getStringInput();
			System.out.println("Enter the E-Mail for "+i+" record to insert in table Employee:");
			String email = TaskUtility.getStringInput();
			System.out.println("Enter the Department for "+i+" record to insert in table Employee:");
			String dept = TaskUtility.getStringInput();
			
			Employee employee = new Employee();
			employee.setEmpName(name);
			employee.setEmpMobile(mobile);
			employee.setEmpEmail(email);
			employee.setEmpDept(dept);
			taskObj.insertValueIntoTable(employee);
		}
		
		System.out.println("Values are inserted into the table successfully.");
		runCaseFive();
	}
	
	public void runCaseThree() throws TaskException {
		System.out.println("Enter the Employee Name to fetch out the details in the table: ");
		String param = TaskUtility.getStringInput();
		
		List<Employee> empList = taskObj.retrieveRowFromTable(param);
		
		displayEmployeeTable(empList);
	}
	
	public void runCaseFour() throws TaskException {
		System.out.println("Enter the Employee ID for which you would like to update the value:");
		int empId = TaskUtility.getIntInput();
		
		System.out.println("Enter the field which you would like to update:(Name, Mobile, Email, Department)");
		String field = TaskUtility.getStringInput();
		
		System.out.println("Enter the value to update in the table:");
		String newValue = TaskUtility.getStringInput();
		
		System.out.println(taskObj.updateTable(field, newValue,empId)>0 ? "Updated Successfully" : "Update Failed");
		runCaseFive();

	}
	
	public void runCaseFive() throws TaskException {
		List<Employee> empList = taskObj.viewTable();
		
		displayEmployeeTable(empList);
	}
	
	public void runCaseSix() throws TaskException{
		System.out.println("Enter the field which you would like to sort:(Name, Mobile, Email, Department)");
		String field = TaskUtility.getStringInput();
		
		System.out.println("Whether to be sorted by Descending order: (True/False)");
		boolean sortType = TaskUtility.getBoolInput(); 
		
		List<Employee> empList = taskObj.sortTable(field,sortType);
		
		displayEmployeeTable(empList);
	}

	public void runCaseSeven() throws TaskException{
		System.out.println("Enter the Employee ID for which you would like to delete the record:");
		int empId = TaskUtility.getIntInput();
		
		System.out.println(taskObj.deleteRecordInTable(empId) > 0 ? "Deleted Successfully" : "Deletion Failed");
		runCaseFive();
	}

	public void runCaseEight() throws TaskException {
		
		System.out.println("Enter the table name:");
		String tableName = TaskUtility.getStringInput();
		if(taskObj.createDependentTable(tableName)==0) {
			System.out.println("Table Created Successfully");
		}
		viewDependentTable();
	}
	
	public void runCaseNine() throws TaskException {
		System.out.println("Enter the number of Records to be added in the table:");
		int recordCount = TaskUtility.getIntInput();
		
		for(int i=1;i<=recordCount;i++) {
			System.out.println("Enter the number of Info to be entered for "+i+" individual:");
			int indivCount = TaskUtility.getIntInput();
			for(int j = 1;j<=indivCount;j++) {
				System.out.println("Enter the EmployeeID for "+j+" record to insert in table Employee_Personal for "+i+" individual:");
				int empId = TaskUtility.getIntInput();
				System.out.println("Enter the Name of the Person for "+j+" record to insert in table Employee_Personal for "+i+" individual:");
				String personName = TaskUtility.getStringInput();
				System.out.println("Enter the Age of the Person for "+j+" record to insert in table Employee_Personal for "+i+" individual:");
				int age = TaskUtility.getIntInput();
				System.out.println("Enter the Relationship of the Person with Employee for "+j+" record to insert in table Employee_Personal for "+i+" individual:");
				String relation = TaskUtility.getStringInput();
				
				Employee_Personal prsnl = new Employee_Personal();
				prsnl.setEmpId(empId);
				prsnl.setPersonName(personName);
				prsnl.setAge(age);
				prsnl.setRelation(relation);
				
				taskObj.insertValuesToDependentTable(prsnl);
			}
		}
		System.out.println("Values are inserted into the table successfully.");
		viewDependentTable();
	}
	
	public void runCaseTen() throws TaskException {
		System.out.println("Enter the EmployeeID of the Employee to fetch the details from Employee_Personal Table:");
		int empId = TaskUtility.getIntInput();
		
		List<Employee_Personal> empPerList = taskObj.getDetailsFromEmpPersonal(empId);
		displayeEmployeePersonalTable(empPerList);
	}
	
	public void runCaseEleven() throws TaskException {
		System.out.println("Enter the field which you would like to sort:(Employee_ID,Person_Name,Age,Relationship)");
		String field = TaskUtility.getStringInput();
		
		System.out.println("Whether to be sorted by Descending order: (True/False)");
		boolean sortType = TaskUtility.getBoolInput(); 
		
		List<Employee_Personal> empPerList = taskObj.sortDependentTable(field, sortType);
		displayeEmployeePersonalTable(empPerList);
	}
	
	public void viewDependentTable() throws TaskException {
		List<Employee_Personal> empPerList=taskObj.viewDependentTable();
		displayeEmployeePersonalTable(empPerList);
	}
	
	public void displayEmployeeTable(List<Employee> empList) {
		int idWidth = 12, nameWidth = 15, mobileWidth = 15, emailWidth = 25, deptWidth = 15;

	    System.out.printf("%-" + idWidth + "s%-" + nameWidth + "s%-" + mobileWidth + "s%-" + emailWidth + "s%-" + deptWidth + "s%n",
	                      "EMPLOYEE_ID", "NAME", "MOBILE", "EMAIL", "DEPARTMENT");

	    for (Employee emp : empList) {
	        System.out.printf("%-" + idWidth + "d%-" + nameWidth + "s%-" + mobileWidth + "s%-" + emailWidth + "s%-" + deptWidth + "s%n",
	                          emp.getEmpId(), emp.getEmpName(), emp.getEmpMobile(), emp.getEmpEmail(), emp.getEmpDept());
	    }
	}
	
	public void displayeEmployeePersonalTable(List<Employee_Personal> empPerList) {
		
		int idWidth = 12, empIdWidth = 12,empNameWidth = 15, nameWidth = 15, ageWidth = 15, relationWidth = 25;
		
		System.out.printf("%-" + idWidth +"s%-" + empIdWidth +"s%-" + empNameWidth + "s%-" + nameWidth + "s%-" + ageWidth + "s%-" + relationWidth + "s%n","PERSON_ID","EMPLOYEE_ID", "EMPLOYEE_NAME", "NAME", "AGE", "RELATIONSHIP");
		
		for(Employee_Personal empPer : empPerList) {
			System.out.printf("%-" + idWidth +"d%-" + empIdWidth +"s%-" + empNameWidth + "s%-" + nameWidth + "s%-" + ageWidth + "s%-" + relationWidth + "s%n",empPer.getPerId(),empPer.getEmpId(),empPer.getEmpName(),empPer.getPersonName(),empPer.getAge(),empPer.getRelation());
		}
	}
	
}
