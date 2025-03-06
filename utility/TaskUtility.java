package utility;

import exceptions.taskexception.TaskException;
import exceptions.nullexception.NullValueException;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import task3.stringexception.StringException;
import exceptions.indexexception.IndexBoundException;
import exceptions.minimumcharexception.MinimumCharException;


public class TaskUtility{
	
	public static Scanner scan = new Scanner(System.in);
	private static boolean logConfig = false; 
	
	public static void validateNullValue(Object input) throws TaskException {
        if (input == null) {
			throw new NullValueException("Invalid Input: Null value is given.");
        }
    }

    public static void validateEmptyValue(int length) throws TaskException {
        if (length == 0) {
            throw new StringException("Invalid String: Empty value is given.");
        }
    }

    public static void validateIndexInBounds(int index, int length) throws TaskException {
		validateEmptyValue(length);
        if (index< 0 || index>length-1) {
            throw new IndexBoundException("Invalid index: Exceeds input length or out of bounds.");
        }
    }
	
	public static void validateMinimumChars(int limit,String input) throws TaskException{
		validateNullValue(input);
		validateEmptyValue(limit);
		int len = getLength(input);
		if(len<limit){
			throw new MinimumCharException("Invalid Input: Minimum of "+limit+" characters to be given");
		}
	}
	
	public static int getLength(CharSequence input) throws TaskException {
			validateNullValue(input);
			return input.length();
    }
	
	public static String getStringInput() {
        return scan.nextLine();
    }

    public static int getIntInput() {
		int input = scan.nextInt();
		scan.nextLine();
        return input;
    }

    public static char getCharInput() {
        char character = scan.next().charAt(0);
		scan.nextLine();
		return character;
    }

    public static boolean getBoolInput() {
        boolean bool = scan.nextBoolean();
		scan.nextLine();
		return bool;
    }
	
	public static float getFloatInput() {
		float input = scan.nextFloat();
		scan.nextLine();
        return input;
    }
	
	public static long getLongInput() {
		long input = scan.nextLong();
		scan.nextLine();
        return input;
    }
	
	public static StringBuilder appendString(StringBuilder strBuilder, String str) throws TaskException{
		validateNullValue(strBuilder);
		validateNullValue(str);
		return strBuilder.append(str);
	}
	
	public static String convertToString(StringBuilder strBuilder) throws TaskException{
		validateNullValue(strBuilder);
		return strBuilder.toString();
	}
	
	public static void setupLogger(Logger LOG) throws TaskException{
		
		if(logConfig) return;
		
		System.out.println("Enter the directory path in which the LOG files should be stored: ");
		String directoryPath = TaskUtility.getStringInput();
		System.out.println("Enter the file name to save the \"INFO\" LOG files: ");
		String infoFile = TaskUtility.getStringInput();
		System.out.println("Enter the file name to save the \"SEVERE\" LOG files: ");
		String severeFile = TaskUtility.getStringInput();
		
		File directory = new File(directoryPath);
	    if (!directory.exists()) { 
	    	if (directory.mkdirs()) { 
	            System.out.println("Directory created successfully: " + directoryPath);
	        }
	    	else {
	            throw new TaskException("Failed to create directory: " + directoryPath);
	        }
	    }
	    
		try {
			TaskUtility.createInfoFileHandler(LOG,directoryPath+File.separator+infoFile);
			TaskUtility.createSevereFileHandler(LOG,directoryPath+File.separator+severeFile);
			logConfig=true;
		} 
		catch (SecurityException | TaskException | IOException e) {
			LOG.severe("Exception in creating info/severe handler");
		}

	}
	
	public static void createInfoFileHandler(Logger LOG,String filePath) throws TaskException, SecurityException, IOException{
		validateNullValue(filePath);
		FileHandler infoHandler = new FileHandler(filePath,true);
		infoHandler.setFormatter(new SimpleFormatter());
		infoHandler.setFilter(record -> record.getLevel() == Level.INFO);
		LOG.addHandler(infoHandler);
		LOG.setUseParentHandlers(false);	
        LOG.setLevel(Level.ALL);
	}
	
	public static void createSevereFileHandler(Logger LOG,String filePath) throws TaskException, SecurityException, IOException{
		validateNullValue(filePath);
		FileHandler severeHandler = new FileHandler(filePath,true);
        severeHandler.setFormatter(new SimpleFormatter());
        severeHandler.setFilter(record -> record.getLevel() == Level.SEVERE);
        LOG.addHandler(severeHandler);
        LOG.setUseParentHandlers(false);
        LOG.setLevel(Level.ALL);
	}
	
	public static Logger createLogger(String className){
		return Logger.getLogger(className);
	}
	
	public static void getThreadDump(Logger LOG) {
		ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfos = threadBean.dumpAllThreads(true, true);
		LOG.info("\n===== Thread Dump =====\n");
        for (ThreadInfo info : threadInfos) {
           LOG.info(info+"");
        }
	}
	
	public static void getAllThreadDump(Logger LOG) {
		for(Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
			LOG.info(entry.getKey()+" "+entry.getKey().getState());
			for(StackTraceElement element : entry.getValue()) {
				LOG.info("\tat "+element+"\n");
			}
		}
	}
}