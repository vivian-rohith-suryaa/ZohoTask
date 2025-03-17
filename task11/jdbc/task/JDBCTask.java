package task11.jdbc.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exceptions.taskexception.TaskException;
import utility.TaskUtility;	

public class JDBCTask {
	
	private String query;
	private String tableName;
	public String sort = "ASC";
	private static final String DBURL = "jdbc:mysql://localhost:3306/incubationDB";
	private static final String DBUSER = "vvn";
	private static final String DBPASS = "root";
	
	private Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(DBURL,DBUSER,DBPASS);
	}
	
	private Statement getStatement(Connection conn) throws SQLException, TaskException {
		TaskUtility.validateNullValue(conn);		
		return conn.createStatement();
	}
	
	private PreparedStatement getPreparedStatement(Connection conn,String query) throws SQLException, TaskException {
		TaskUtility.validateNullValue(conn);
		TaskUtility.validateNullValue(query);
		return conn.prepareStatement(query);
	}
	
	private ResultSet getResultSet(PreparedStatement stmt) throws TaskException, SQLException {
		TaskUtility.validateNullValue(stmt);
		return stmt.executeQuery();
	}
	
	public int createEmployeeTable(String tableName) throws TaskException{
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
			throw new TaskException("Exception caught in createEmployeeTable task.\n",e);
		}
	}
	
	public void addEmployee(List<Employee> employees) throws TaskException {
		TaskUtility.validateEmptyValue(employees.size());
		
		query = "INSERT INTO Employee(NAME,MOBILE,EMAIL,DEPARTMENT) VALUES(?,?,?,?)";
		
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn,query)){
			for(Employee employee : employees) {
				stmt.setString(1, employee.getEmployeeName());
				stmt.setString(2, employee.getEmployeeMobile());
				stmt.setString(3, employee.getEmployeeEmail());
				stmt.setString(4, employee.getEmployeeDept());
				stmt.addBatch();
			}
			stmt.executeBatch();
		}
		catch(SQLException e) {
			throw new TaskException("Exception caught in addEmployee task.\n",e);
		}
	}
	
	public List<Employee> getEmployeeInfo(String param) throws TaskException {
		
		TaskUtility.validateNullValue(param);
		
		String query = "SELECT * FROM Employee WHERE NAME=?";
		
		List<Employee> employee = new ArrayList<Employee>();
		
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn, query)){
			stmt.setString(1, param);
			
			try(ResultSet rst = getResultSet(stmt)){
				
				while(rst.next()) {
					Employee emp =new Employee();
					emp.setEmployeeId(rst.getInt("EMPLOYEE_ID"));
					emp.setEmployeeName(rst.getString("NAME"));
					emp.setEmployeeMobile(rst.getString("MOBILE"));
					emp.setEmployeeEmail(rst.getString("EMAIL"));
					emp.setEmployeeDept(rst.getString("DEPARTMENT"));
					employee.add(emp);
				}
				return employee;
			}
			
		}
		catch(SQLException e) {
			throw new TaskException("Exception caught in getEmployeeInfo task.\n",e);
		}
	}

	public int updateEmployee(String field, String newValue, int employeeId) throws TaskException {
		TaskUtility.validateNullValue(field);
		TaskUtility.validateNullValue(newValue);
		TaskUtility.validateNullValue(employeeId);
		
		field=field.toUpperCase();
		tableName = "Employee";
		
		List<String> validFields = getColumns(tableName);
		if (!validFields.contains(field)) {
			throw new TaskException("Invalid field name: " + field);
		}
		
		String query = "UPDATE Employee SET "+field+" =? WHERE EMPLOYEE_ID = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn, query)){
			
			stmt.setString(1, newValue);
			stmt.setInt(2, employeeId);
			
			return stmt.executeUpdate();
			
		}
		catch (SQLException e) {
			throw new TaskException("Exception caught in updateEmployee task.\n",e);
		}
	}
	
	public List<Employee> viewEmployees() throws TaskException{
		
		List<Employee> employee = new ArrayList<Employee>();
		String query ="SELECT * FROM Employee";
		
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn, query);
			ResultSet rst = getResultSet(stmt)){
			while(rst.next()) {
				Employee emp =new Employee();
				emp.setEmployeeId(rst.getInt("EMPOYEE_ID"));
				emp.setEmployeeName(rst.getString("NAME"));
				emp.setEmployeeMobile(rst.getString("MOBILE"));
				emp.setEmployeeEmail(rst.getString("EMAIL"));
				emp.setEmployeeDept(rst.getString("DEPARTMENT"));
				
				employee.add(emp);
			}
			return employee;
		}
		catch (SQLException e) {
			throw new TaskException("Exception caught in viewEmployees task.\n",e);
		}

	}
	
	public List<Employee> sortEmployees(String field, boolean sortType) throws TaskException{
		
		TaskUtility.validateNullValue(field);
		TaskUtility.validateNullValue(sortType);
		
		field=field.toUpperCase();
		
		tableName = "Employee";
		
		List<String> validFields = getColumns(tableName);
		if (!validFields.contains(field)) {
			throw new TaskException("Invalid field name: " + field);
		}
		
		if(sortType) {
			sort="DESC";
		}
		
		String query ="SELECT * FROM Employee ORDER BY "+field+" "+sort;
		
		List<Employee> employee = new ArrayList<Employee>();
		
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn, query);
			ResultSet rst = getResultSet(stmt)){
			while(rst.next()) {
				Employee emp =new Employee();
				emp.setEmployeeId(rst.getInt("EMPLOYEE_ID"));
				emp.setEmployeeName(rst.getString("NAME"));
				emp.setEmployeeMobile(rst.getString("MOBILE"));
				emp.setEmployeeEmail(rst.getString("EMAIL"));
				emp.setEmployeeDept(rst.getString("DEPARTMENT"));
				
				employee.add(emp);
			}
			return employee;
		}
		catch (SQLException e) {
			throw new TaskException("Exception caught in sortEmployees task.\n",e);
		}
		
	}
	
	public int deleteEmployee(int employeeId) throws TaskException {
		TaskUtility.validateNullValue(employeeId);
		
		String query = "DELETE FROM Employee WHERE EMPLOYEE_ID = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn, query)){
				
			stmt.setInt(1, employeeId);
			
			return stmt.executeUpdate();
			
		}
		catch (SQLException e) {
			throw new TaskException("Exception caught in deleteEmployee task.\n",e);
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
			throw new TaskException("Exception caught in createDependentTable task.\n",e);
		}
	}
	
	public void addDependents(List<Dependent> prsnList) throws TaskException {
		TaskUtility.validateEmptyValue(prsnList.size());
		
		String query = "INSERT INTO Dependent(EMPLOYEE_ID,PERSON_NAME,AGE,RELATIONSHIP) VALUES(?,?,?,?)";
		
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn,query)){
			for(Dependent prsn : prsnList) {
				stmt.setInt(1, prsn.getEmployeeId());
				stmt.setString(2, prsn.getPersonName());
				stmt.setInt(3, prsn.getAge());
				stmt.setString(4, prsn.getRelation());
				stmt.addBatch();
			}
			stmt.executeBatch();
		}
		
		catch(SQLException e) {
			throw new TaskException("Exception caught in addDependents task.\n",e);
		}
	}
	
	public List<Dependent> getDependentInfo(int employeeId) throws TaskException{
		TaskUtility.validateNullValue(employeeId);
		
		List<Dependent> prsnList = new ArrayList<Dependent>();
		String query = "SELECT ep.PERSON_ID, e.EMPLOYEE_ID,e.NAME as EMPLOYEE_NAME, ep.PERSON_NAME,ep.AGE, ep.RELATIONSHIP"
					+ " FROM Dependent ep"
					+ " JOIN Employee e ON ep.EMPLOYEE_ID = e.EMPLOYEE_ID WHERE ep.EMPLOYEE_ID = ?";
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn,query)){
			stmt.setInt(1, employeeId);
			
			try(ResultSet rst = getResultSet(stmt)){
				while(rst.next()) {
					Dependent prsn = new Dependent();
					
					prsn.setPersonId(rst.getInt("PERSON_ID"));
					prsn.setEmployeeId(rst.getInt("EMPLOYEE_ID"));
					prsn.setEmployeeName(rst.getString("EMPLOYEE_NAME"));
					prsn.setPersonName(rst.getString("PERSON_NAME"));
					prsn.setAge(rst.getInt("AGE"));
					prsn.setRelation(rst.getString("RELATIONSHIP"));
					
					prsnList.add(prsn);
				}
			}
			
			return prsnList;
				
		}
		catch (SQLException e) {
			throw new TaskException("Exception caught in getDependentInfo task.\n",e);
		}
		
	}
	
	public List<Dependent> viewDependents() throws TaskException{
		
		List<Dependent> prsnList = new ArrayList<Dependent>();
		String query ="SELECT ep.*,e.NAME as EMPLOYEE_NAME FROM Dependent ep "
					+"JOIN Employee e ON ep.EMPLOYEE_ID = e.EMPLOYEE_ID";
		
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn, query);
			ResultSet rst = getResultSet(stmt)){
			while(rst.next()) {
				Dependent prsn =new Dependent();
				prsn.setPersonId(rst.getInt("PERSON_ID"));
				prsn.setEmployeeId(rst.getInt("EMPLOYEE_ID"));
				prsn.setEmployeeName(rst.getString("EMPLOYEE_NAME"));
				prsn.setPersonName(rst.getString("PERSON_NAME"));
				prsn.setAge(rst.getInt("AGE"));
				prsn.setRelation(rst.getString("RELATIONSHIP"));
				
				prsnList.add(prsn);
			}
			return prsnList;
		}
		catch (SQLException e) {
			throw new TaskException("Exception caught in viewDependents task.\n",e);
		}

	}
	
	public List<Dependent> sortDependents(String field, boolean sortType) throws TaskException{
		
		TaskUtility.validateNullValue(field);
		TaskUtility.validateNullValue(sortType);
		
		field=field.toUpperCase();

		tableName = "Dependent";
		
		List<String> validFields = getColumns(tableName);
		if (!validFields.contains(field)) {
			throw new TaskException("Invalid field name: " + field);
		}
		
		if(sortType) {sort="DESC";}
		
		String query ="SELECT ep.*,e.NAME as EMPLOYEE_NAME FROM Dependent ep JOIN Employee e ON ep.EMPLOYEE_ID = e.EMPLOYEE_ID ORDER BY "+field+" "+sort;
		
		List<Dependent> prsnList = new ArrayList<Dependent>();
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn, query);
			ResultSet rst = getResultSet(stmt)){
			while(rst.next()) {
				Dependent prsn =new Dependent();
				prsn.setPersonId(rst.getInt("PERSON_ID"));
				prsn.setEmployeeId(rst.getInt("EMPLOYEE_ID"));
				prsn.setEmployeeName(rst.getString("EMPLOYEE_NAME"));
				prsn.setPersonName(rst.getString("PERSON_NAME"));
				prsn.setAge(rst.getInt("AGE"));
				prsn.setRelation(rst.getString("RELATIONSHIP"));
				
				prsnList.add(prsn);
			}
			return prsnList;
		}
		catch (SQLException e) {
			throw new TaskException("Exception caught in sortDependents task.\n",e);
		}
		
	}
	
	public List<String> getColumns(String tableName) throws TaskException{
		
		String query = "SELECT * FROM "+tableName;
		
		List<String> columnNames = new ArrayList<String>();
		
		try(Connection conn = getConnection();
			PreparedStatement stmt = getPreparedStatement(conn, query);
			ResultSet rst = getResultSet(stmt)){
			
			ResultSetMetaData rsMetaData = rst.getMetaData();
			
			for(int i=1;i<rsMetaData.getColumnCount();i++) {
				columnNames.add(rsMetaData.getColumnName(i));
			}
			return columnNames;
		}
		
		catch(SQLException e) {
			throw new TaskException("Cannot fetch the table's column name.",e);
		}
	}
	
}
