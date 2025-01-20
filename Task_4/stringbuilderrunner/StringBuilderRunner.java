package stringbuilderrunner;

import taskexception.TaskException;
import nullexception.NullValueException;
import utility.TaskUtility;
import stringbuildertask.StringBuilderTask;
import indexexception.IndexBoundException;
import java.util.Scanner;
import minimumcharexception.MinimumCharException;

public class StringBuilderRunner{
	public StringBuilderTask taskObj = new StringBuilderTask();
	String input;
	int index;
	
	public static void main(String[] args){
		
		StringBuilderRunner runnerObj = new StringBuilderRunner();
		boolean loop = true;
		
		while(loop){
			System.out.println("Enter the sequence number for the exercise (1 -10, or 0 to exit):");
			int sequenceNumber = TaskUtility.getIntInput();		
			if(sequenceNumber==0){
				System.out.println("Exiting program!!!");
				loop = false;
			}
			
			else{
				try{
					switch(sequenceNumber){
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
							
						default:
							System.out.println("Please choose the number between 1 to 10");
							break;
					}
				}
				catch(TaskException e){
					System.err.println("Exception caught in StringBuilderRunner class - Main method\n"+e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
	
	public void runCaseOne() throws TaskException{
		StringBuilder strBuilder = taskObj.getStringBuilder();
		System.out.println("The Input is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
		System.out.println("Enter a String(s): ");
		input = TaskUtility.getStringInput();
		TaskUtility.appendString(strBuilder,input);
		System.out.println("The Result is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
	}
	
	public void runCaseTwo() throws TaskException{
		StringBuilder strBuilder = taskObj.getStringBuilder();
		System.out.println("Enter a String(s): ");
		input = TaskUtility.getStringInput();
		TaskUtility.appendString(strBuilder,input);
		System.out.println("The Input is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
		System.out.println("Enter a delimiter to append: ");
		String delimiter = TaskUtility.getStringInput();
		System.out.println("Enter number of Strings to append: ");
		int strNumber= TaskUtility.getIntInput();
		for(int i =0;i<strNumber;i++){
			System.out.println("Enter the "+(i+1)+" String: ");
			String helperStr  = TaskUtility.getStringInput();
			taskObj.appendDelimiter(strBuilder,delimiter,helperStr);
		}
		System.out.println("The Result is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
	}
	
	public void runCaseThree() throws TaskException{
		StringBuilder strBuilder = taskObj.getStringBuilder();
		System.out.println("Enter String(s): ");
		input = TaskUtility.getStringInput();
		TaskUtility.appendString(strBuilder,input);
		System.out.println("The Input is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
		System.out.println("Enter the delimiter: ");
		String delimiter = TaskUtility.getStringInput();
		System.out.println("Enter a String to append: ");
		String helperStr  = TaskUtility.getStringInput();
		System.out.println("Enter the position to append: ");
		int position= TaskUtility.getIntInput();
		taskObj.insertAtPosition(strBuilder,helperStr,delimiter,position);
		System.out.println("The Result is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
	}
	
	public void runCaseFour() throws TaskException{
		StringBuilder strBuilder = taskObj.getStringBuilder();
		System.out.println("Enter String(s): ");
		input = TaskUtility.getStringInput();
		TaskUtility.appendString(strBuilder,input);
		System.out.println("The Input is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
		System.out.println("Enter the delimiter: ");
		String delimiter = TaskUtility.getStringInput();
		System.out.println("Enter the position to delete: ");
		int position= TaskUtility.getIntInput();
		taskObj.deleteAtPosition(strBuilder,delimiter,position);
		System.out.println("The Result is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
	}
	
	public void runCaseFive() throws TaskException{
		StringBuilder strBuilder = taskObj.getStringBuilder();
		System.out.println("Enter String(s): ");
		input = TaskUtility.getStringInput();
		TaskUtility.appendString(strBuilder,input);
		System.out.println("The Input is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
		System.out.println("Enter the splitting delimiter: ");
		String splitterDelimiter = TaskUtility.getStringInput();
		System.out.println("Enter the replacing delimiter: ");
		String replacerDelimiter = TaskUtility.getStringInput();
		taskObj.replaceDelimiter(strBuilder,splitterDelimiter,replacerDelimiter);
		System.out.println("The Result is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
	}
	
	public void runCaseSix() throws TaskException{
		StringBuilder strBuilder = new StringBuilder();
		System.out.println("Enter String(s): ");
		input = TaskUtility.getStringInput();
		TaskUtility.appendString(strBuilder,input);
		System.out.println("The Input is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
		taskObj.reverseStrBuilder(strBuilder);
		System.out.println("The Result is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
	}
	
	public void runCaseSeven() throws TaskException{
		StringBuilder strBuilder = taskObj.getStringBuilder();
		System.out.println("Enter the limit to number of chars: ");
		int limit = TaskUtility.getIntInput();
		System.out.println("Enter String(s): ");
		String input = TaskUtility.getStringInput();
		TaskUtility.validateMinimumChars(limit,input);
		TaskUtility.appendString(strBuilder,input);
		System.out.println("The Input is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
		System.out.println("Enter starting position to delete: ");
		int startValue= TaskUtility.getIntInput();
		System.out.println("Enter ending position to delete: ");
		int endValue= TaskUtility.getIntInput();
		taskObj.deleteChars(strBuilder,startValue,endValue);
		System.out.println("The Result is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
	}
	
	public void runCaseEight() throws TaskException{
		StringBuilder strBuilder = taskObj.getStringBuilder();
		System.out.println("Enter the limit to number of chars: ");
		int limit = TaskUtility.getIntInput();
		System.out.println("Enter String(s): ");
		String input = TaskUtility.getStringInput();
		TaskUtility.validateMinimumChars(limit,input);
		TaskUtility.appendString(strBuilder,input);
		System.out.println("The Input is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
		System.out.println("Enter starting position to insert: ");
		int startValue= TaskUtility.getIntInput();
		System.out.println("Enter ending position to insert: ");
		int endValue= TaskUtility.getIntInput();
		System.out.println("Enter a String to replace: ");
		String replacerString = TaskUtility.getStringInput();
		taskObj.insertChars(strBuilder,startValue,endValue,replacerString);
		System.out.println("The position of the delimiters are: "+strBuilder);
	}
	
	public void runCaseNine() throws TaskException{
		StringBuilder strBuilder = taskObj.getStringBuilder();
		System.out.println("Enter String(s): ");
		input = TaskUtility.getStringInput();
		TaskUtility.appendString(strBuilder,input);
		System.out.println("The Input is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
		System.out.println("Enter the delimiter: ");
		String delimiter = TaskUtility.getStringInput();
		index = taskObj.getFirstIndexOf(strBuilder,delimiter);
		System.out.println("The position of the delimiter is: "+index);
	}
	
	public void runCaseTen() throws TaskException{
		StringBuilder strBuilder = taskObj.getStringBuilder();
		System.out.println("Enter String(s): ");
		input = TaskUtility.getStringInput();
		TaskUtility.appendString(strBuilder,input);
		System.out.println("The Input is: "+strBuilder+" and its length is: "+TaskUtility.getLength(strBuilder));
		System.out.println("Enter the delimiter: ");
		String delimiter = TaskUtility.getStringInput();
		index = taskObj.getLastIndexOf(strBuilder,delimiter);
		System.out.println("The position of the delimiter is: "+index);
	}
}