package task8.files.properties;

import java.util.Properties;
import exceptions.taskexception.TaskException;

import utility.TaskUtility;

public class PropertiesTask {
	
	public Properties getPropertiesInstance() {
		return new Properties();
	}
	
	public Object setProperties(Properties propObj,String key,String value) throws TaskException{
		TaskUtility.validateNullValue(propObj);
		TaskUtility.validateNullValue(key);
		TaskUtility.validateNullValue(value);
		return propObj.setProperty(key, value);
	}
}
