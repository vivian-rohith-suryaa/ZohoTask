package task10.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import exceptions.custom.CustomException;
import exceptions.taskexception.TaskException;
import utility.TaskUtility;

public class RegexRunner {
	
	private static final Logger LOG = RegexLogger.createLogger();
	public String message;
	static {
		showTasks();
		try {
			TaskUtility.setupLogger(LOG);
		}
		catch (TaskException e) {
			LOG.severe("Exception in creating a Logger");
		}
	}
	RegexTask taskObj = new RegexTask();
	
	public static void main(String[] args) {
		RegexRunner runnerObj = new RegexRunner();
		boolean loop = true;
		
		while(loop) {
			System.out.println("Enter the sequence number for the exercise (1-8, or 0 to exit):");
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
							
						default:
							LOG.info("Please choose between numbers 1 to 8.");
							break;
					}
				}
				catch(Exception e) {
					LOG.severe("Exception caught in main method: "+e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void showTasks() {
		System.out.println("1. Method for Mobile Number Validation.");
		System.out.println("2. Method for AlphaNumeric Validation.");
		System.out.println("3. Method for checking of an input value with a reference value.\n\ti.Check the given string starts with the matching string\n"+"\tii.Check the given string contains the matching string\n"+"\tiii.Check the given string ends with the matching string\n"+"\tiv.Check the given string is an exact match");
		System.out.println("4. Method to check the strings in a list with the reference(Case Insensitive).");
		System.out.println("5. Method for Email Validation.");
		System.out.println("6. Method to check whether each string is within the given range. ");
		System.out.println("7. Method to map the values in two different list of strings with the matching word as key and the index as value.");
		System.out.println("8. Method to print only the html tags.");
	}
	
	public void runCaseOne() throws TaskException {
		System.out.println("Enter the mobile number: ");
		String mobile = TaskUtility.getStringInput();
		
		if(taskObj.validateMobileNumber(mobile)) {
			LOG.info("Valid Mobile Number.");
		}
		else {
			message = "The given mobile number does not match with the format.\n(Should have 10 numbers. First digit should start with 7 or 8 or 9 only.)";
			LOG.severe(message);
			throw new CustomException(message);
		}
	}
	
	public void runCaseTwo() throws TaskException {
		System.out.println("Enter the input with alphanumeric characters: ");
		String input = TaskUtility.getStringInput();
		
		if(taskObj.validateAlphaNumeric(input)) {
			LOG.info("Valid Input.");
		}
		else {
			message="The given input does not match the format.\n(Should contain only alphanumeric characters.)";
			LOG.severe(message);
			throw new CustomException(message);
		}
	}
	
	public void runCaseThree() throws TaskException {
		System.out.println("Enter the option to check for the input: ");
		int option = TaskUtility.getIntInput();
		if(option <= 0 || option > 4) {
	        System.out.println("Please select from the given options.");
	        return;
	    }
		System.out.println("Enter the reference input: ");
		String reference = TaskUtility.getStringInput();
		System.out.println("Enter the input to check with reference: ");
		String input = TaskUtility.getStringInput();		
		if(taskObj.checkInputWithReference(input,reference, option)) {
			LOG.info("The input value matches with the reference value.");
		}
		else {
			System.out.println("Please select from the given options.");
		}
	}

	public void runCaseFour() throws TaskException{
		
		List<String> strList = new ArrayList<String>();
		
		System.out.println("Enter the number of elements in the list: ");
		int size = TaskUtility.getIntInput();
		for(int i=1;i<=size;i++) {
			System.out.println("Enter the "+i+" string: ");
			String element = TaskUtility.getStringInput();
			strList.add(element);
		}
		
		System.out.println("Enter the reference String: ");
		String reference=TaskUtility.getStringInput();
		
		List<Boolean> result= taskObj.matchCaseInsensitiveString(strList, reference);
		
		for(int i=0;i<size;i++) {
			LOG.info(strList.get(i)+" results "+result.get(i)+"\n");
		}
		
	}

	public void runCaseFive() throws TaskException {
		System.out.println("Enter the input email address: ");
		String input = TaskUtility.getStringInput();
		
		if(taskObj.validateEmail(input)) {
			LOG.info("Valid Email Address.");
		}
		else {
			message = "The given input does not match the email format. (\ni.Should have a \"@\" character & it should be between two strings.\n"+"ii.Should have a \".\" character & it should be between two strings.\n";
			LOG.severe(message);
			throw new CustomException(message);
		}
	}

	public void runCaseSix() throws TaskException{
		List<String> strList = new ArrayList<String>();
		
		System.out.println("Enter the number of elements in the list: ");
		int size = TaskUtility.getIntInput();
		for(int i=1;i<=size;i++) {
			System.out.println("Enter the "+i+" string: ");
			String element = TaskUtility.getStringInput();
			strList.add(element);
		}
		
		System.out.println("Enter the range of each input: ");
		int range=TaskUtility.getIntInput();
		
		List<Boolean> result= taskObj.checkRangeOfInput(strList,range);
		for(int i=0;i<size;i++) {
			LOG.info(strList.get(i)+" results "+result.get(i)+"\n");
		}
	}
	
	public void runCaseSeven() throws TaskException{
		
		List<String> referenceList = new ArrayList<String>();
		List<String> inputList = new ArrayList<String>();
		
		System.out.println("Enter the number of elements in the reference list: ");
		int refSize = TaskUtility.getIntInput();
		for(int i=1;i<=refSize;i++) {
			System.out.println("Enter the "+i+" string: ");
			String element = TaskUtility.getStringInput();
			taskObj.checkDistinctList(referenceList,element);
			referenceList.add(element);
		}
		
		System.out.println("Enter the number of elements such that every element in input list should be present in the reference list: ");
		int inpSize = TaskUtility.getIntInput();
		for(int i=1;i<=inpSize;i++) {
			System.out.println("Enter the "+i+" string: ");
			String element = TaskUtility.getStringInput();
			taskObj.checkDistinctList(inputList,element);
			inputList.add(element);
		}
		
		Map<String,Integer> result = taskObj.getMapOfMatchingInput(referenceList, inputList);
		
		for(Map.Entry<String, Integer> entry : result.entrySet()) {
			LOG.info(entry.getKey() + " => " + entry.getValue()+"\n");
		}
		
	}
	
	public void runCaseEight() throws TaskException{
		
		System.out.println("Enter the input string with HTML tags: ");
		String input = TaskUtility.getStringInput();
		List<String> result = taskObj.getHTMLTags(input);
		LOG.info("The resultant HTML Tags are: "+"\n");
		for(String word:result) {
			LOG.info(word+"\n");
		}
	}
}
