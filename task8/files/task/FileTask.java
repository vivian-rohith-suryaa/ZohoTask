package task8.files.task;

import exceptions.taskexception.TaskException;
import utility.TaskUtility;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.io.BufferedWriter;

public class FileTask {
	
	public void writeInFile(String pathName, int number) throws TaskException,IOException{
		TaskUtility.validateNullValue(pathName);
		TaskUtility.validateNullValue(number);
		List<String> arrList = new ArrayList<String>(number);
		for(int i=0;i<number;i++) {
			String userValue = TaskUtility.getStringInput();
			arrList.add(userValue);
		}
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathName))){
			for(String line : arrList) {
				bw.write(line);
				bw.newLine();
			}
		}
		catch(IOException ex) {
			throw new IOException("IOException Occured");
		}
	}
		
	public void storeProperties(Properties prop, String pathName, String comment) throws TaskException,IOException{
		TaskUtility.validateNullValue(prop);
		TaskUtility.validateNullValue(pathName);
		TaskUtility.validateNullValue(comment);
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathName))){
			prop.store(bw,comment);
		}
		catch(IOException ex) {
			throw new IOException("IOException Occured");
		}
	}
	
	public void loadProperties(Properties prop, String pathName)throws TaskException,IOException{
		TaskUtility.validateNullValue(prop);
		TaskUtility.validateNullValue(pathName);
		try(BufferedReader bd = new BufferedReader(new FileReader(pathName))){
			prop.load(bd);
		}
		catch(IOException ex) {
			throw new IOException("IOException Occured");
		}
		
	}
	
	public Set<String> getPropertyKeys(Properties prop) throws TaskException{
		TaskUtility.validateNullValue(prop);
		return prop.stringPropertyNames();
	}
	
	public String getPropertyValues(Properties prop,String key) throws TaskException{
		TaskUtility.validateNullValue(prop);
		TaskUtility.validateNullValue(key);
		return prop.getProperty(key);
	}
	
	


}
