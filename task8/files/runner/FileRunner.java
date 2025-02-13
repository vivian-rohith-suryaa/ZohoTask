package task8.files.runner;

import exceptions.custom.CustomException;
import exceptions.taskexception.TaskException;
import utility.TaskUtility;
import task8.files.task.FileTask;
import java.io.File;
import java.io.IOException;
import task8.files.properties.PropertiesTask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;
import task6.custom.Custom;
import task8.files.example.Example;
import task8.files.singletons.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import task8.files.enumerator.Colors;
import task8.files.time.TimeTask;

public class FileRunner {
	
	FileTask filetaskObj = new FileTask();
	PropertiesTask propObj = new PropertiesTask();
	TimeTask timeObj = new TimeTask();
	
	private static final Logger fileLogger  = TaskUtility.getLogger();
	
	static {
		showTasks();
		try {
			TaskUtility.setupLogger();
		} catch (TaskException e) {
			fileLogger.severe("Exception in creating a Logger");
		}
			
	}
	public static void main(String[] args) {
		
		FileRunner runnerObj = new FileRunner();
		boolean loop = true;

		
		while(loop){
			System.out.println("Enter the sequence number for the exercise (1 -11, or 0 to exit):");
			int sequenceNumber = TaskUtility.getIntInput();		
			if(sequenceNumber==0){
				fileLogger.info("Exiting program!!!");
				loop = false;
			}
			
			else{
				try{
					switch(sequenceNumber){
						case 1:
							runnerObj.runCaseOne(System.getProperty("user.dir"));
							break;
							
						case 2:
							runnerObj.runCaseTwo(System.getProperty("user.dir"));
							break;
							
						case 3:
							runnerObj.runCaseThree(System.getProperty("user.dir"));
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
							
						default:
							System.out.println("Please choose the number between 1 to 11");
							break;
					}
				}
				catch(Exception e){
					fileLogger.log(Level.SEVERE,"Exception Occured:",e);

				}
			}
		}
	
	}
	
	public static void showTasks(){
		System.out.println("1. Create a file programatically and write contents in it.");
		System.out.println("2. Create a Properties class and store keys and values and write it in a text.");
		System.out.println("3. Load the keys and values in the text file to a properties object.");
		System.out.println("4. Repeat steps 1 to 3 and store the values in the directory given by the user.");
		System.out.println("5. Creating an overloaded constructor in a class with a string and calling only the object to print the string.");
		System.out.println("6. Creating a POJO class with getters and setters and giving values to the class's overloaded constructor and printing the object.");
		System.out.println("7. Creating a normal object and calling the getter and setter methods and printing the value.");
		System.out.println("8. Calling the constructors from Example Class without creating the instance.");
		System.out.println("9. Creating an Enum with Rainbow colors and colorcodes.");
		System.out.println("10. Create and explore about different types of Singleton class patterns.");
		System.out.println("11. Tasks for Time Class.");
		
	}
	
	public void runCaseOne(String path) throws TaskException,IOException{
		
		fileLogger.info("Creating a file.");

		System.out.println("Enter the file name: ");
		String fileName = TaskUtility.getStringInput();

		String pathName = path+File.separator+fileName;
		
		System.out.println("Enter the number of lines to write in the file: ");
		int number = TaskUtility.getIntInput();
		filetaskObj.writeInFile(pathName,number);
		fileLogger.info("Writing in file completed!!!. Go and Check it.");

	}
	
	public void runCaseTwo(String path) throws TaskException,IOException{
		
		Properties propStore = propObj.getPropertiesInstance();
		
		System.out.println("Enter the file name: ");
		String fileName = TaskUtility.getStringInput();
		
		System.out.println("Enter the number of keys and values:");
		int number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter String Value "+(i+1)+" : ");
			String strValue = TaskUtility.getStringInput();
			propObj.setProperties(propStore, strKey, strValue);
		}

		String pathName = path+File.separator+fileName;

		System.out.println("Enter the comments to write in properties file: ");
		String comment = TaskUtility.getStringInput();
		filetaskObj.storeProperties(propStore,pathName,comment);
		fileLogger.info("Property file created!!!. Go and Check it.");
		
	}
	
	public void runCaseThree(String path) throws TaskException,IOException{
		
		Properties propLoad = propObj.getPropertiesInstance();
		
		System.out.println("Enter the file name: ");
		String fileName = TaskUtility.getStringInput();
		
		String pathName = path+File.separator+fileName;

		filetaskObj.loadProperties(propLoad, pathName);
			
		for(String key : filetaskObj.getPropertyKeys(propLoad)) {
			fileLogger.info(key+" = "+filetaskObj.getPropertyValues(propLoad,key));
		}
	}
	
	public void runCaseFour() throws TaskException,IOException{
		
		System.out.println("Enter the file path: ");
		String filePath = TaskUtility.getStringInput();
		runCaseOne(filePath);
		runCaseTwo(filePath);
		runCaseThree(filePath);
	}
	
	public void runCaseFive(){
		
		System.out.println("Enter the String to pass to the instance: ");
		String str = TaskUtility.getStringInput();
		Custom cusObj = new Custom(str);
		fileLogger.info(cusObj+("\n"));
		
	}
	
	public void runCaseSix(){
		
		System.out.println("Enter the String to pass to the instance: ");
		String str = TaskUtility.getStringInput();
		System.out.println("Enter the Integer to pass to the instance: ");
		int number= TaskUtility.getIntInput();
		Example exObj = new Example(str,number);
		fileLogger.info(exObj+("\n"));
	}
	
	public void runCaseSeven() {
		
		Example exObj = new Example();
		System.out.println("Enter the integer value: ");
		int value = TaskUtility.getIntInput();
		exObj.setIntValue(value);
		System.out.println("Enter the string value: ");
		String str= TaskUtility.getStringInput();
		exObj.setStrValue(str);
		fileLogger.info("String: "+exObj.getStrValue()+" Integer: "+exObj.getIntValue());
		
	}
	
	public void runCaseEight() throws CustomException{
		
		try {
			Class<?> exClass = Class.forName("task8.files.example.Example");
			
			Constructor<?> overloadCons = exClass.getConstructor(String.class,int.class);
			Constructor<?> defCons = exClass.getConstructor();
			
			Object overloadObj = overloadCons.newInstance("Vivian",21);
			Object defObj = defCons.newInstance();
			
			Method method1 = exClass.getMethod("setStrValue",String.class);
			method1.invoke(defObj,"Vivian");
			
			Method method2 = exClass.getMethod("getStrValue");
			
			fileLogger.info("Overloaded Constructor- "+overloadObj);
			fileLogger.info("Default Constructor - String: "+method2.invoke(defObj));
		}
		catch(ClassNotFoundException|SecurityException|NoSuchMethodException|InstantiationException|IllegalAccessException|IllegalArgumentException|InvocationTargetException e) {
			throw new CustomException("Exception Occured in runCaseEight()");
		}
		
	}
	
	public void runCaseNine() throws TaskException{
		
		for(Colors color : Colors.values()) {
			fileLogger.info("Index "+color.ordinal()+" - Color: "+color+" - Colorcode: "+color.getValues());
			
		}
	}
	
	public void runCaseTen() throws TaskException{
		fileLogger.info("Singleton Class- Lazy Initialization: "+LazySingleton.getInstance());
		fileLogger.info("Singleton Class- Early/Eager Initialization: "+EarlySingleton.getInstance());
		fileLogger.info("Singleton Class- Static Initialization: "+StaticSingleton.getInstance());
		fileLogger.info("Singleton Class- Thread Safe Initialization: "+StaticSingleton.getInstance());
		fileLogger.info("Singleton Class- Double check Locked Initialization: "+StaticSingleton.getInstance());
		fileLogger.info("Singleton Class- Inner Class Initialization: "+InnerClassSingleton.getInstance());
		fileLogger.info("Singleton Class- Enum Singleton: "+EnumSingleton.getInstance());
	}
	
	public void runCaseEleven() throws TaskException{
		
		fileLogger.info("\n1. Return currentTime with Date,seconds ,etc\n");
		
		System.out.println("Date and Time Formatters:\n1. yyyy-MM-dd\n2. dd-MM-yyyy\n3. MM/dd/yyyy (US Format)\n4. yyyyMMdd (Compact Format)\n5. EEEE, MMM dd, yyyy (Full weekday name, short month name)\n6. yyyy-MM-dd HH:mm:ss (Date and time (24-hour format))\n7. yyyy-MM-dd hh:mm:ss a (Date and time (12-hour format with AM/PM))\n8. yyyy-MM-dd HH:mm:ss.SSS (Date, time with milliseconds)\n9. yyyy-MM-dd HH:mm:ss Z (Date, time with time zone offset)\n10. yyyy-MM-dd'T'HH:mm:ss'Z' (	ISO 8601 UTC format)");
		
		System.out.println("Enter the number by which the date and time should be printed: ");
		int format = TaskUtility.getIntInput();
		ZonedDateTime zdt = TimeTask.getZoneDateTime(ZoneId.systemDefault());
		
		fileLogger.info("Date and Time: "+timeObj.getDateTimePattern(zdt, format));
		fileLogger.info("The Day of the Week is: "+timeObj.getDayOfWeek(zdt)+"\nThe Day of the Month is: "+timeObj.getDayOfMonth(zdt)+"\nThe Day of the Year is: "+timeObj.getDayOfYear(zdt));
		fileLogger.info("Month: "+timeObj.getMonthName(zdt));
		fileLogger.info("Local Zone Id: "+timeObj.getZoneId(zdt));
		fileLogger.info("The Current Time in Nanoseconds: "+timeObj.getTimeInNanos());
		
		fileLogger.info("\n2. Return currentTime in milliseconds\n");
		fileLogger.info("The Current time in Milliseconds(Using Instant): "+timeObj.getMillisByInstant());
		fileLogger.info("The Current time in Milliseconds(Using System): "+timeObj.getMillisBySystem());
		
		
		fileLogger.info("\n3. Return currentTime of Zone Ids\n");
		
		List<String> zones = new ArrayList<String>(ZoneId.getAvailableZoneIds());
		Collections.sort(zones);
		for(String zone : zones) {
			fileLogger.info(zone+"\n");
		}
		
		System.out.println("\nEnter the Zone ID to get the Date and Time of that Zone: ");
		String zoneId = TaskUtility.getStringInput();
		fileLogger.info(zoneId+" Date and Time: "+TimeTask.getZoneDateTime(ZoneId.of(zoneId)));
		
		fileLogger.info("\n4.Return the week day, month name and year for the currentTime in millis or any given time in millis\n");
		System.out.println("Enter the time in milliseconds to find out the Weekday, Month and Year of: ");
		long millis = TaskUtility.getLongInput();
		
		System.out.println("Enter the Time Zone: ");
		String timeZone = TaskUtility.getStringInput();
		
		ZonedDateTime userZDt = timeObj.convertMillisToZonedDateTime(millis, timeZone);
		
		fileLogger.info("The Day of the Week is:"+timeObj.getDayOfWeek(userZDt));
		fileLogger.info("The Month Name is: "+timeObj.getMonthName(userZDt));
		fileLogger.info("The Year is:"+timeObj.getYear(userZDt));
		
		System.out.println("Enter the Time Zone to find Daylight Save Time: ");
		String dstZone = TaskUtility.getStringInput();
		System.out.println("Enter the Date (dd-MM-yyyy) for which the Daylight saving time offset should be shown in milliseconds: ");
		String dstDate = TaskUtility.getStringInput();
		ZoneOffset  zo= timeObj.getZoneOffset(ZoneId.of(dstZone), dstDate);
		fileLogger.info("Offset: "+zo+" Offset in Milliseconds: "+zo.getTotalSeconds()*1000);
	}

	
}