package runner;

import exception.StringException;
import task.StringTask;
import utility.StringUtility;
import java.util.Scanner;

public class StringRunner{
	
	public String input;
	public int position;
	public String userString;
	public int userPosition;
	public char userCharacter;
	public boolean userBoolean;
	public Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		StringUtility utilObj = new StringUtility();
		StringTask taskObj = new StringTask();
		StringRunner runnerObj = new StringRunner();
		boolean loop = true;
			
		while(loop){
			System.out.println("Enter the sequence number for the exercise (1 - 20, or 0 to exit):");
			int sequenceNumber = utilObj.getIntInput();		
				
			if(sequenceNumber==0){
				System.out.println("Exiting program!!!");
				loop = false;
				runnerObj.scan.close();
			}
				
			else{
				try{
					switch(sequenceNumber){
						case 1:
							try{
								runnerObj.printLength(utilObj,args);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 1",e);
							}
							break;
							
						case 2:
							try{
								runnerObj.printCharArray(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 2",e);
							}
							break;
						
						case 3:
							try{
								runnerObj.printCharPosition(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 3",e);
							}
							break;
						
						case 4:
							try{
								runnerObj.printCharOccurrence(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 4",e);
							}
							break;
						
						case 5:
							try{
								runnerObj.printGreatestPosition(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 5",e);
							}
							break;
							
						case 6:
							try{
								runnerObj.printSuffixChar(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 6",e);
							}
							break;
						
						case 7:
							try{
								runnerObj.printPrefixChar(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 7",e);
							}
							break;
							
						case 8:
							try{
								runnerObj.printReplacedString(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 8",e);
							}
							break;
						
						case 9:
							try{
								runnerObj.runCheckPrefix(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 9",e);
							}
							break;
							
						case 10:
							try{
								runnerObj.runCheckSuffix(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 10",e);
							}
							break;
							
						case 11:
							try{
								runnerObj.printUpperCaseString(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 11",e);
							}
							break;
						
						case 12:
							try{
								runnerObj.printLowerCaseString(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 12",e);
							}
							break;
						
						case 13:
							try{
								runnerObj.printReversedtring(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 13",e);
							}
							break;
		
						case 14:
							try{
								runnerObj.printMultipleString(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 14",e);
							}
							break;
						
						case 16:
							try{
								runnerObj.printStringArray(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 16",e);
							}
							break;
							
						case 15:								
						case 17:
							try{
								runnerObj.printMergedString(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 15/17",e);
							}
							break;
						
						case 18:						
						case 19:
							try{
								runnerObj.runCompareStrings(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 18/19",e);
							}
							break;
						
						case 20:
							try{
								runnerObj.printTrimmedString(taskObj,utilObj);
							}
							catch (StringException e){
								throw new StringException ("Exception caught in StringRunner class - Case 20",e);
							}
							break;
							
						default:
							System.out.println("Please choose the number between 1 to 20");
							break;
					}
				}	
				catch (StringException e){
					System.err.println("Exception caught in StringRunner class - Main method\n"+e.getMessage());
					e.printStackTrace();
				}
			}
		}	
	}
	
	//method 1
	public void printLength(StringUtility utilObj, String[] args) throws StringException{
		try {
			if (args.length == 0) {
				throw new StringException("Invalid String: Empty argument is given.");
			}
			input = args[0];
			System.out.println("The length of the given string is " + utilObj.getLength(input));
		}
		catch (StringException e){
			throw new StringException("Exception caught in StringRunner Class - printLength method",e);
		}
	}
	//method 2
	public void printCharArray(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a String to convert into character array: ");
			userString = utilObj.getStringInput();
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
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - printCharArray method",e);
		}
	}
	//method 3
	public void printCharPosition(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a String to find the position of a character: ");
			userString = utilObj.getStringInput();
			System.out.println("Enter a position to find: ");
			userPosition = utilObj.getIntInput();
			System.out.println("The character at the "+userPosition+ " is :"+taskObj.getCharPosition(userString,userPosition));
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - printCharPosition method",e);
		}
	}
	//method 4
	public void printCharOccurrence(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a String to find the number of occurrences: ");
			userString = utilObj.getStringInput();
			System.out.println("Enter a character to find the occurrence: ");
			userCharacter = utilObj.getCharInput();
			System.out.println("Should it be case sensitive (true/false)?");
			userBoolean = utilObj.getBoolInput();
			System.out.println("The number of occurrences of character "+userCharacter+" are: "+taskObj.getCharOccurrences(userString,userCharacter,userBoolean));
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - printCharOccurrence method",e);
		}
	}
	//method 5
	public void printGreatestPosition(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a String to find the greatest position of a character: ");
			userString = utilObj.getStringInput();
			System.out.println("Enter a character to find: ");
			userCharacter = utilObj.getCharInput();
			System.out.println("The greatest occurrences of character "+userCharacter+" is: "+taskObj.getGreatestPosition(userString,userCharacter));
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - printGreatestPosition method",e);
		}
	}
	//method 6
	public void printSuffixChar(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a String to print the ending characters: ");
			userString = utilObj.getStringInput();
			System.out.println("Enter a position:");
			userPosition = utilObj.getIntInput();
			System.out.println("The characters of the given String is: "+taskObj.getSuffixChars(userString,userPosition));
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - printSuffixChar method",e);
		}
	}
	//method 7
	public void printPrefixChar(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a String to print the starting characters: ");
			userString = utilObj.getStringInput();
			System.out.println("Enter a position: ");
			userPosition = utilObj.getIntInput();
			System.out.println("The characters of the given String is: "+taskObj.getPrefixChars(userString,userPosition));
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - printPrefixChar method",e);
		}
	}
	//method 8
	public void printReplacedString(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a String that is replaced: ");
			userString = utilObj.getStringInput();
			System.out.println("Enter a String to be replaced: ");
			String userStringAdd = utilObj.getStringInput();
			System.out.println("Enter the number of characters to be replaced: ");
			int charsToReplace = utilObj.getIntInput();
			System.out.println("The resulted string is:"+taskObj.replaceCharInString(userString, userStringAdd,charsToReplace));
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - printReplacedString method",e);
		}
	}
	//method 9
	public void runCheckPrefix(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a String to check: ");
			userString = utilObj.getStringInput();
			System.out.println("Enter a String to be checked: ");
			String userStringCheck = utilObj.getStringInput();
			System.out.println("Whether the given String '"+userString+"' starts with "+userStringCheck+" ? "+taskObj.checkPrefix(userString, userStringCheck));
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - runCheckPrefix method",e);
		}
	}
	//method 10
	public void runCheckSuffix(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a String to check: ");
			userString = utilObj.getStringInput();
			System.out.println("Enter a String to be checked: ");
			String userStringCheck = utilObj.getStringInput();
			System.out.println("Whether the given String '"+userString+"' ends with "+userStringCheck+" ? "+taskObj.checkSuffix(userString, userStringCheck));
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - runCheckSuffix method",e);
		}
	}
	//method 11
	public void printUpperCaseString(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a String to be converted from lowercase: ");
			userString = utilObj.getStringInput();
			System.out.println("The given string converted to upper case is: "+taskObj.convertToUpperCase(userString));
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - printUpperCaseString method",e);
		}
	}
	//method 12
	public void printLowerCaseString(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a String to be converted from uppercase: ");
			userString = utilObj.getStringInput();
			System.out.println("The given string converted to lower case is: "+taskObj.convertToLowerCase(userString));
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - printLowerCaseString method",e);
		}
	}
	//method 13
	public void printReversedtring(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a String to reverse: ");
			userString = utilObj.getStringInput();
			System.out.println("The reversed input String is: "+taskObj.reverseString(userString));
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - printReversedtring method",e);
		}
	}
	//method 14
	public void printMultipleString(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a line with multiple strings: ");
			userString = utilObj.getStringInput();
			System.out.println("The result is: "+taskObj.getMultipleString(userString));
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - printMultipleString method",e);
		}
	}
	//method 15
	public void printMergedString(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a line with multiple strings to concatenate: ");
			userString = utilObj.getStringInput();
			System.out.println("Enter a delimiter to split the string: ");
			String spliterDelimiter = utilObj.getStringInput();
			System.out.println("Enter a delimiter to join the string: ");
			String combinerDelimiter = utilObj.getStringInput();
			System.out.println("The resultant String is: "+taskObj.mergeStringUsingDelimiter(userString,spliterDelimiter,combinerDelimiter));
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - printMergedString method",e);
		}
	}
	//method 16
	public void printStringArray(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a line with multiple strings: ");
			userString = utilObj.getStringInput();
			System.out.println("Enter a delimiter to split the string: ");
			String spliterDelimiter = utilObj.getStringInput();
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
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - printStringArray method",e);
		}
	}
	//method 17
	public void runCompareStrings(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a String to be checked: ");
			String firstString = utilObj.getStringInput();
			System.out.println("Enter another String to be checked: ");
			String secondString = utilObj.getStringInput();
			System.out.println("Should it be case sensitive (true/false)?");
			userBoolean = utilObj.getBoolInput();
			System.out.println("Whether the two strings are equal? "+taskObj.compareTwoStrings(firstString,secondString,userBoolean));
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - runCompareStrings method",e);
		}
	}
	//method 18
	public void printTrimmedString(StringTask taskObj,StringUtility utilObj) throws StringException{
		try{
			System.out.println("Enter a String with spaces at front or end or both: ");
			userString = utilObj.getStringInput();
			System.out.println("The Trimmed version of Original String is "+taskObj.trimSpaces(userString));
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringRunner Class - printTrimmedString method",e);
		}
	}

}