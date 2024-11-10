package runner;

import exception.StringException;
import task.StringTask;
import java.util.Scanner;

public class StringRunner{
	
	public String input;
	public int position;
	public String userString;
	public int userPosition;
	public char userCharacter;
	public boolean userBoolean;
    public Scanner scan = new Scanner(System.in);

    public String getStringInput() {
        return scan.nextLine();
    }

    public int getIntInput() {
		int input = scan.nextInt();
		scan.nextLine();
        return input;
    }

    public char getCharInput() {
        char character = scan.next().charAt(0);
		scan.nextLine();
		return character;
    }

    public boolean getBoolInput() {
        boolean bool = scan.nextBoolean();
		scan.nextLine();
		return bool;
    }
	
	public static void main(String[] args){
			
		StringTask taskObj = new StringTask();
		StringRunner runnerObj = new StringRunner();
		boolean loop = true;
			
		while(loop){
			System.out.println("Enter the sequence number for the exercise (1 - 20, or 0 to exit):");
			int sequenceNumber = runnerObj.getIntInput();		
				
			if(sequenceNumber==0){
				System.out.println("Exiting program!!!");
				loop = false;
				runnerObj.scan.close();
			}
				
			else{
				try{
					switch(sequenceNumber){
						case 1:
							runnerObj.printLength(taskObj,args);
							break;
							
						case 2:
							runnerObj.printCharArray(taskObj,runnerObj);
							break;
						
						case 3:
							runnerObj.printCharPosition(taskObj,runnerObj);
							break;
						
						case 4:
							runnerObj.printCharOccurrence(taskObj,runnerObj);
							break;
						
						case 5:
							runnerObj.printGreatestPosition(taskObj,runnerObj);
							break;
							
						case 6:
							runnerObj.printSuffixChar(taskObj,runnerObj);
							break;
						
						case 7:
							runnerObj.printPrefixChar(taskObj,runnerObj);
							break;
							
						case 8:
							runnerObj.printReplacedString(taskObj,runnerObj);
							break;
						
						case 9:
							runnerObj.runCheckPrefix(taskObj,runnerObj);
							break;
							
						case 10:
							runnerObj.runCheckSuffix(taskObj,runnerObj);
							break;
							
						case 11:
							runnerObj.printUpperCaseString(taskObj,runnerObj);
							break;
						
						case 12:
							runnerObj.printLowerCaseString(taskObj,runnerObj);
							break;
						
						case 13:
							runnerObj.printReversedtring(taskObj,runnerObj);
							break;
		
						case 14:
							runnerObj.printMultipleString(taskObj,runnerObj);
							break;
						
						case 16:
							runnerObj.printStringArray(taskObj,runnerObj);
							break;
							
						case 15:								
						case 17:
							runnerObj.printMergedString(taskObj,runnerObj);
							break;
						
						case 18:						
						case 19:
							runnerObj.runCompareStrings(taskObj,runnerObj);
							break;
						
						case 20:
							runnerObj.printTrimmedString(taskObj,runnerObj);
							break;
							
						default:
							System.out.println("Please choose the number between 1 to 20");
							break;
					}
				}	
				catch (StringException ex){
					System.out.println(ex.getMessage());
				}
			}
		}	
	}
	
	//method 1
	public void printLength(StringTask taskObj, String[] args) throws StringException{
		try {
			if (args.length == 0) {
				throw new StringException("Invalid String: Null value is given.");
			}
			input = args[0];
			System.out.println("The length of the given string is " + taskObj.getLength(input));
		} 
		catch (StringException strEx) {
			System.out.println(strEx.getMessage());
		}
	}
	//method 2
	public void printCharArray(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a String to convert into character array: ");
		userString = runnerObj.getStringInput();
		char[] charArr = taskObj.convertToCharArray(userString);
		System.out.print("The String Converted to a character array is: {"); 
		for (int i = 0; i < charArr.length; i++) {
			System.out.print("'" + charArr[i] + "'");
			if (i < charArr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
	//method 3
	public void printCharPosition(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a String to find the position of a character: ");
		userString = runnerObj.getStringInput();
		System.out.println("Enter a position to find: ");
		userPosition = runnerObj.getIntInput();
		System.out.println("The character at the "+userPosition+ " is :"+taskObj.getCharPosition(userString,userPosition));
	}
	//method 4
	public void printCharOccurrence(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a String to find the number of occurrences: ");
		userString = runnerObj.getStringInput();
		System.out.println("Enter a character to find the occurrence: ");
		userCharacter = runnerObj.getCharInput();
		System.out.println("Should it be case sensitive (true/false)?");
		userBoolean = runnerObj.getBoolInput();
		System.out.println("The number of occurrences of character "+userCharacter+" are: "+taskObj.getCharOccurrences(userString,userCharacter,userBoolean));
	}
	//method 5
	public void printGreatestPosition(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a String to find the greatest position of a character: ");
		userString = runnerObj.getStringInput();
		System.out.println("Enter a character to find: ");
		userCharacter = runnerObj.getCharInput();
		System.out.println("The greatest occurrences of character "+userCharacter+" is: "+taskObj.getGreatestPosition(userString,userCharacter));
	}
	//method 6
	public void printSuffixChar(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a String to print the ending characters: ");
		userString = runnerObj.getStringInput();
		System.out.println("Enter a position:");
		userPosition = runnerObj.getIntInput();
		System.out.println("The characters of the given String is: "+taskObj.getSuffixChars(userString,userPosition));
	}
	//method 7
	public void printPrefixChar(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a String to print the starting characters: ");
		userString = runnerObj.getStringInput();
		System.out.println("Enter a position: ");
		userPosition = runnerObj.getIntInput();
		System.out.println("The characters of the given String is: "+taskObj.getPrefixChars(userString,userPosition));
	}
	//method 8
	public void printReplacedString(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a String that is replaced: ");
		userString = runnerObj.getStringInput();
		System.out.println("Enter a String to be replaced: ");
		String userStringAdd = runnerObj.getStringInput();
		System.out.println("Enter the number of characters to be replaced: ");
		int charsToReplace = runnerObj.getIntInput();
		System.out.println("The resulted string is:"+taskObj.replaceCharInString(userString, userStringAdd,charsToReplace));
	}
	//method 9
	public void runCheckPrefix(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a String to check: ");
		userString = runnerObj.getStringInput();
		System.out.println("Enter a String to be checked: ");
		String userStringCheck = runnerObj.getStringInput();
		System.out.println("Whether the given String '"+userString+"' starts with "+userStringCheck+" ? "+taskObj.checkPrefix(userString, userStringCheck));
	}
	//method 10
	public void runCheckSuffix(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a String to check: ");
		userString = runnerObj.getStringInput();
		System.out.println("Enter a String to be checked: ");
		String userStringCheck = runnerObj.getStringInput();
		System.out.println("Whether the given String '"+userString+"' ends with "+userStringCheck+" ? "+taskObj.checkSuffix(userString, userStringCheck));
	}
	//method 11
	public void printUpperCaseString(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a String to be converted from lowercase: ");
		userString = runnerObj.getStringInput();
		System.out.println("The given string converted to upper case is: "+taskObj.convertToUpperCase(userString));
	}
	//method 12
	public void printLowerCaseString(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a String to be converted from uppercase: ");
		userString = runnerObj.getStringInput();
		System.out.println("The given string converted to lower case is: "+taskObj.convertToLowerCase(userString));
	}
	//method 13
	public void printReversedtring(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a String to reverse: ");
		userString = runnerObj.getStringInput();
		System.out.println("The reversed input String is: "+taskObj.reverseString(userString));
	}
	//method 14
	public void printMultipleString(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a line with multiple strings: ");
		userString = runnerObj.getStringInput();
		System.out.println("The result is: "+taskObj.getMultipleString(userString));
	}
	//method 15
	public void printMergedString(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a line with multiple strings to concatenate: ");
		userString = runnerObj.getStringInput();
		System.out.println("Enter a delimiter to split the string: ");
		String spliterDelimiter = runnerObj.getStringInput();
		System.out.println("Enter a delimiter to join the string: ");
		String combinerDelimiter = runnerObj.getStringInput();
		System.out.println("The resultant String is: "+taskObj.mergeStringUsingDelimiter(userString,spliterDelimiter,combinerDelimiter));
	}
	//method 16
	public void printStringArray(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a line with multiple strings: ");
		userString = runnerObj.getStringInput();
		System.out.println("Enter a delimiter to split the string: ");
		String spliterDelimiter = runnerObj.getStringInput();
		String[] result = taskObj.convertToStringArray(userString,spliterDelimiter);
		System.out.print("{");
		for (int i = 0; i<result.length;i++){
			System.out.print("\""+result[i]+"\"");
			if(i < result.length - 1){
				System.out.print(",");
			}
		}
		System.out.println("}");
	}
	//method 17
	public void runCompareStrings(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a String to be checked: ");
		String firstString = runnerObj.getStringInput();
		System.out.println("Enter another String to be checked: ");
		String secondString = runnerObj.getStringInput();
		System.out.println("Should it be case sensitive (true/false)?");
		userBoolean = runnerObj.getBoolInput();
		System.out.println("Whether the two strings are equal? "+taskObj.compareTwoStrings(firstString,secondString,userBoolean));
	}
	//method 18
	public void printTrimmedString(StringTask taskObj, StringRunner runnerObj) throws StringException{
		System.out.println("Enter a String with spaces at front or end or both: ");
		userString = runnerObj.getStringInput();
		System.out.println("The Trimmed version of Original String is "+taskObj.trimSpaces(userString));
	}

}