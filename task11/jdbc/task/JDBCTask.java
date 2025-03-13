package task11.jdbc.task;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exceptions.taskexception.TaskException;
import utility.TaskUtility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;	

public class JDBCTask {
	
	private static final String DBURL = "jdbc:mysql://localhost:3306/incubationDB";
	private static final String DBUSER = "vvn";
	private static final String DBPASS = "root";
	
	String query;
	
	public Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(DBURL,DBUSER,DBPASS);
	}
	
	public Statement getStatement(Connection conn) throws SQLException, TaskException {
		TaskUtility.validateNullValue(conn);		
		return conn.createStatement();
	}
	
	public PreparedStatement getPreparedStatement(Connection conn,String query) throws SQLException, TaskException {
		TaskUtility.validateNullValue(conn);
		TaskUtility.validateNullValue(query);
		return conn.prepareStatement(query);
	}
	
	public ResultSet getResultSet(PreparedStatement stmt) throws TaskException, SQLException {
		TaskUtility.validateNullValue(stmt);
		return stmt.executeQuery();
	}
	
	public int createTable(String tableName) throws TaskException{
		TaskUtility.validateNullValue(tableName);
		
		try(Connection conn = getConnection();
			Statement stmt = getStatement(conn)){
			
			query = "CREATE TABLE IF NOT EXISTS "+tableName+" ("
					+"EMPLOYEE_ID INT PRIMARY KEY AUTO_INCREMENT,"
					+"NAME VARCHAR(50) NOT NULL,"
					+"MOBILE VARCHAR(10) NOT NULL UNIQUE,"
					+"EMAIL VARCHAR(40) NOT NULL UNIQUE,"
					+"DEPARTMENT VARCHAR(50) NOT NULL)"; 
			return stmt.executeUpdate(query);
			}
		catch(SQLException e) {
			throw new TaskException("Exception caught in createTable task.\n"+e.getMessage());
		}
	}
	
	public void insertValueIntoTable(Employee employee) throws TaskException {
		TaskUtility.validateNullValue(employee);
		
		query = "INSERT INTO Employee(NAME,MOBILE,EMAIL,DEPARTMENT) VALUES(?,?,?,?)";
		
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn,query)){
			stmt.setString(1, employee.getEmpName());
			stmt.setString(2, employee.getEmpMobile());
			stmt.setString(3, employee.getEmpEmail());
			stmt.setString(4, employee.getEmpDept());
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			throw new TaskException("Exception caught in insertValueIntoTable task.\n"+e.getMessage());
		}
	}
	
	public List<Employee> retrieveRowFromTable(String param) throws TaskException {
		
		TaskUtility.validateNullValue(param);
		
		String query = "SELECT * FROM Employee WHERE NAME=?";
		
		List<Employee> employee = new ArrayList<Employee>();
		
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn, query)){
			stmt.setString(1, param);
			
			try(ResultSet rst = getResultSet(stmt)){
				
				while(rst.next()) {
					Employee emp =new Employee();
					emp.setEmpId(rst.getInt("EMPLOYEE_ID"));
					emp.setEmpName(rst.getString("NAME"));
					emp.setEmpMobile(rst.getString("MOBILE"));
					emp.setEmpEmail(rst.getString("EMAIL"));
					emp.setEmpDept(rst.getString("DEPARTMENT"));
					
					employee.add(emp);
				}
				return employee;
			}
			
		}
		catch(SQLException e) {
			throw new TaskException("Exception caught in retrieveRowFromTable task.\n"+e.getMessage());
		}
	}

	public int updateTable(String field, String newValue, int empId) throws TaskException {
		TaskUtility.validateNullValue(field);
		TaskUtility.validateNullValue(newValue);
		TaskUtility.validateNullValue(empId);
		
		field=field.toUpperCase();
		List<String> validFields = Arrays.asList("NAME", "MOBILE", "EMAIL", "DEPARTMENT");
		if (!validFields.contains(field)) {
			throw new TaskException("Invalid field name: " + field);
		}
		
		String query = "UPDATE Employee SET "+field+" =? WHERE EMPLOYEE_ID = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn, query)){
			
			stmt.setString(1, newValue);
			stmt.setInt(2, empId);
			
			return stmt.executeUpdate();
			
		}
		catch (SQLException e) {
			throw new TaskException("Exception caught in updateTable task.\n"+e.getMessage());
		}
	}
	
	public List<Employee> viewTable() throws TaskException{
		
		List<Employee> employee = new ArrayList<Employee>();
		String query ="SELECT * FROM Employee";
		
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn, query);
			ResultSet rst = getResultSet(stmt)){
			while(rst.next()) {
				Employee emp =new Employee();
				emp.setEmpId(rst.getInt("EMPLOYEE_ID"));
				emp.setEmpName(rst.getString("NAME"));
				emp.setEmpMobile(rst.getString("MOBILE"));
				emp.setEmpEmail(rst.getString("EMAIL"));
				emp.setEmpDept(rst.getString("DEPARTMENT"));
				
				employee.add(emp);
			}
			return employee;
		}
		catch (SQLException e) {
			throw new TaskException("Exception caught in viewTable task.\n"+e.getMessage());
		}

	}
	
	public List<Employee> sortTable(String field, boolean sortType) throws TaskException{
		
		TaskUtility.validateNullValue(field);
		TaskUtility.validateNullValue(sortType);
		
		field=field.toUpperCase();
		String sort="";

		List<String> validFields = Arrays.asList("NAME", "MOBILE", "EMAIL", "DEPARTMENT");
		if (!validFields.contains(field)) {
			throw new TaskException("Invalid field name: " + field);
		}
		
		if(sortType) {sort="DESC";}
		
		String query ="SELECT * FROM Employee ORDER BY "+field+" "+sort;
		
		List<Employee> employee = new ArrayList<Employee>();
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn, query);
			ResultSet rst = getResultSet(stmt)){
			while(rst.next()) {
				Employee emp =new Employee();
				emp.setEmpId(rst.getInt("EMPLOYEE_ID"));
				emp.setEmpName(rst.getString("NAME"));
				emp.setEmpMobile(rst.getString("MOBILE"));
				emp.setEmpEmail(rst.getString("EMAIL"));
				emp.setEmpDept(rst.getString("DEPARTMENT"));
				
				employee.add(emp);
			}
			return employee;
		}
		catch (SQLException e) {
			throw new TaskException("Exception caught in sortTable task.\n"+e.getMessage());
		}
		
	}
	
	public int deleteRecordInTable(int empId) throws TaskException {
		TaskUtility.validateNullValue(empId);
		
		String query = "DELETE FROM Employee WHERE EMPLOYEE_ID = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn, query)){
				
			stmt.setInt(1, empId);
			
			return stmt.executeUpdate();
			
		}
		catch (SQLException e) {
			throw new TaskException("Exception caught in deleteRecordInTable task.\n"+e.getMessage());
		}
	}
	
	public int createDependentTable(String tableName) throws TaskException{
		TaskUtility.validateNullValue(tableName);
		
		try(Connection conn = getConnection();
			Statement stmt = getStatement(conn)){
			
			query = "CREATE TABLE IF NOT EXISTS "+tableName+" ("
					+"PERSON_ID INT PRIMARY KEY AUTO_INCREMENT,"
					+"EMPLOYEE_ID INT,"
					+"EMPLOYEE_NAME VARCHAR(50),"
					+"PERSON_NAME VARCHAR(50) NOT NULL,"
					+"AGE INT(3) NOT NULL,"
					+"RELATIONSHIP VARCHAR(50) NOT NULL,"
					+"FOREIGN KEY (EMPLOYEE_ID) REFERENCES Employee(EMPLOYEE_ID) ON DELETE CASCADE)";
			return stmt.executeUpdate(query);
			}
		catch(SQLException e) {
			throw new TaskException("Exception caught in createDependentTable task.\n"+e.getMessage());
		}
	}
	
	public void insertValuesToDependentTable(Employee_Personal prsnl) throws TaskException {
		TaskUtility.validateNullValue(prsnl);
		
		String query = "INSERT INTO Employee_Personal(EMPLOYEE_ID,PERSON_NAME,AGE,RELATIONSHIP) VALUES(?,?,?,?)";
		
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn,query)){
			stmt.setInt(1, prsnl.getEmpId());
			stmt.setString(2, prsnl.getPersonName());
			stmt.setInt(3, prsnl.getAge());
			stmt.setString(4, prsnl.getRelation());
			stmt.executeUpdate();
		}
		
		catch(SQLException e) {
			throw new TaskException("Exception caught in insertValuesToDependentTable task.\n"+e.getMessage());
		}
	}
	
	public List<Employee_Personal> getDetailsFromEmpPersonal(int empId) throws TaskException{
		TaskUtility.validateNullValue(empId);
		
		List<Employee_Personal> empPerList = new ArrayList<Employee_Personal>();
		String query = "SELECT ep.PERSON_ID, e.EMPLOYEE_ID,e.NAME as EMPLOYEE_NAME, ep.PERSON_NAME,ep.AGE, ep.RELATIONSHIP"
					+ " FROM Employee_Personal ep"
					+ " JOIN Employee e ON ep.EMPLOYEE_ID = e.EMPLOYEE_ID WHERE ep.EMPLOYEE_ID = ?";
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn,query)){
			stmt.setInt(1, empId);
			
			try(ResultSet rst = getResultSet(stmt)){
				while(rst.next()) {
					Employee_Personal empPer = new Employee_Personal();
					
					empPer.setPerId(rst.getInt("PERSON_ID"));
					empPer.setEmpId(rst.getInt("EMPLOYEE_ID"));
					empPer.setEmpName(rst.getString("EMPLOYEE_NAME"));
					empPer.setPersonName(rst.getString("PERSON_NAME"));
					empPer.setAge(rst.getInt("AGE"));
					empPer.setRelation(rst.getString("RELATIONSHIP"));
					
					empPerList.add(empPer);
				}
			}
			
			return empPerList;
				
		}
		catch (SQLException e) {
			throw new TaskException("Exception caught in getDetailsFromEmpPersonal task.\n"+e.getMessage());
		}
		
	}
	
	public List<Employee_Personal> viewDependentTable() throws TaskException{
		
		List<Employee_Personal> empPerList = new ArrayList<Employee_Personal>();
		String query ="SELECT ep.*,e.NAME as EMPLOYEE_NAME FROM Employee_Personal ep "
					+"JOIN Employee e ON ep.EMPLOYEE_ID = e.EMPLOYEE_ID";
		
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn, query);
			ResultSet rst = getResultSet(stmt)){
			while(rst.next()) {
				Employee_Personal empPer =new Employee_Personal();
				empPer.setPerId(rst.getInt("PERSON_ID"));
				empPer.setEmpId(rst.getInt("EMPLOYEE_ID"));
				empPer.setEmpName(rst.getString("EMPLOYEE_NAME"));
				empPer.setPersonName(rst.getString("PERSON_NAME"));
				empPer.setAge(rst.getInt("AGE"));
				empPer.setRelation(rst.getString("RELATIONSHIP"));
				
				empPerList.add(empPer);
			}
			return empPerList;
		}
		catch (SQLException e) {
			throw new TaskException("Exception caught in viewTable task.\n"+e.getMessage());
		}

	}
	
public List<Employee_Personal> sortDependentTable(String field, boolean sortType) throws TaskException{
		
		TaskUtility.validateNullValue(field);
		TaskUtility.validateNullValue(sortType);
		
		field=field.toUpperCase();
		String sort="";

		List<String> validFields = Arrays.asList("EMPLOYEE_ID", "EMPLOYEE_NAME", "PERSON_NAME", "AGE", "RELATIONSHIP");
		if (!validFields.contains(field)) {
			throw new TaskException("Invalid field name: " + field);
		}
		
		if(sortType) {sort="DESC";}
		
		String query ="SELECT ep.*,e.NAME as EMPLOYEE_NAME FROM Employee_Personal ep JOIN Employee e ON ep.EMPLOYEE_ID = e.EMPLOYEE_ID ORDER BY "+field+" "+sort;
		
		List<Employee_Personal> empPerList = new ArrayList<Employee_Personal>();
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn, query);
			ResultSet rst = getResultSet(stmt)){
			while(rst.next()) {
				Employee_Personal empPer =new Employee_Personal();
				empPer.setPerId(rst.getInt("PERSON_ID"));
				empPer.setEmpId(rst.getInt("EMPLOYEE_ID"));
				empPer.setEmpName(rst.getString("EMPLOYEE_NAME"));
				empPer.setPersonName(rst.getString("PERSON_NAME"));
				empPer.setAge(rst.getInt("AGE"));
				empPer.setRelation(rst.getString("RELATIONSHIP"));
				
				empPerList.add(empPer);
			}
			return empPerList;
		}
		catch (SQLException e) {
			throw new TaskException("Exception caught in sortTable task.\n"+e.getMessage());
		}
		
	}
	
}
