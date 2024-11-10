package runner;

import exception.StringException;
import task.StringTask;
import java.util.Scanner;
import java.util.Arrays;

public class StringRunner{
	
	public static String input;
	public static int position;
	public static String userString;
	public static int userPosition;
	public static char userCharacter;
	public static boolean userBoolean;
    public static Scanner scan = new Scanner(System.in);

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
				}
				
				else{
					try{
						switch(sequenceNumber){
							case 1:
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
								break;
							
							case 2:
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
								break;
								
							case 3:
								System.out.println("Enter a String to find the position of a character: ");
								userString = runnerObj.getStringInput();
								System.out.println("Enter a position to find: ");
								userPosition = runnerObj.getIntInput();
								System.out.println("The character at the "+userPosition+ " is :"+taskObj.getCharPosition(userString,userPosition));
								
								break;
								
							case 4:
								System.out.println("Enter a String to find the number of occurrences: ");
								userString = runnerObj.getStringInput();
								System.out.println("Enter a character to find the occurrence: ");
								userCharacter = runnerObj.getCharInput();
								System.out.println("Should it be case sensitive (true/false)?");
								userBoolean = runnerObj.getBoolInput();
								System.out.println("The number of occurrences of character "+userCharacter+" are: "+taskObj.getCharOccurrences(userString,userCharacter,userBoolean));
								break;
								
							case 5:
								System.out.println("Enter a String to find the greatest position of a character: ");
								userString = runnerObj.getStringInput();
								System.out.println("Enter a character to find: ");
								userCharacter = runnerObj.getCharInput();
								System.out.println("The greatest occurrences of character "+userCharacter+" is: "+taskObj.getGreatestPosition(userString,userCharacter));
								break;
							
							case 6:
								System.out.println("Enter a String to print the ending characters: ");
								userString = runnerObj.getStringInput();
								System.out.println("Enter a position:");
								userPosition = runnerObj.getIntInput();
								System.out.println("The characters of the given String is: "+taskObj.getSuffixChars(userString,userPosition));
								break;
								
							case 7:
								System.out.println("Enter a String to print the starting characters: ");
								userString = runnerObj.getStringInput();
								System.out.println("Enter a position: ");
								userPosition = runnerObj.getIntInput();
								System.out.println("The characters of the given String is: "+taskObj.getPrefixChars(userString,userPosition));
								break;
							
							case 8:
								System.out.println("Enter a String that is replaced: ");
								userString = runnerObj.getStringInput();
								System.out.println("Enter a String to be replaced: ");
								String userStringAdd = runnerObj.getStringInput();
								System.out.println("Enter the number of characters to be replaced: ");
								int charsToReplace = runnerObj.getIntInput();
								System.out.println("The resulted string is:"+taskObj.replacedCharInString(userString, userStringAdd,charsToReplace));
								break;
								
							case 9:
								System.out.println("Enter a String to check: ");
								userString = runnerObj.getStringInput();
								System.out.println("Enter a String to be checked: ");
								String userStringCheck = runnerObj.getStringInput();
								System.out.println("Whether the given String '"+userString+"' starts with "+userStringCheck+" ? "+taskObj.checkPrefix(userString, userStringCheck));
								break;
							
							case 10:
								System.out.println("Enter a String to check: ");
								userString = runnerObj.getStringInput();
								System.out.println("Enter a String to be checked: ");
								userStringCheck = runnerObj.getStringInput();
								System.out.println("Whether the given String '"+userString+"' ends with "+userStringCheck+" ? "+taskObj.checkSuffix(userString, userStringCheck));
								break;
							
							case 11:
								System.out.println("Enter a String to be converted from lowercase: ");
								userString = runnerObj.getStringInput();
								System.out.println("The given string converted to upper case is: "+taskObj.convertToUpperCase(userString));
								break;
								
							case 12:
								System.out.println("Enter a String to be converted from uppercase: ");
								userString = runnerObj.getStringInput();
								System.out.println("The given string converted to lower case is: "+taskObj.convertToLowerCase(userString));
								break;
								
							case 13:
								System.out.println("Enter a String to reverse: ");
								userString = runnerObj.getStringInput();
								System.out.println("The reversed input String is: "+taskObj.reverseString(userString));
								break;

						
							case 14:
								System.out.println("Enter a line with multiple strings: ");
								userString = runnerObj.getStringInput();
								System.out.println("The result is: "+taskObj.getMultipleString(userString));
								break;
								
								
							case 16:
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
								break;
								
							case 15:								
							case 17:
								System.out.println("Enter a line with multiple strings to concatenate: ");
								userString = runnerObj.getStringInput();
								System.out.println("Enter a delimiter to split the string: ");
								spliterDelimiter = runnerObj.getStringInput();
								System.out.println("Enter a delimiter to join the string: ");
								String combinerDelimiter = runnerObj.getStringInput();
								System.out.println("The resultant String is: "+taskObj.mergeStringUsingDelimiter(userString,spliterDelimiter,combinerDelimiter));
								break;
								
							case 18:						
							case 19:
								System.out.println("Enter a String to be checked: ");
								String firstString = runnerObj.getStringInput();
								System.out.println("Enter another String to be checked: ");
								String secondString = runnerObj.getStringInput();
								System.out.println("Should it be case sensitive (true/false)?");
								userBoolean = runnerObj.getBoolInput();
								System.out.println("Whether the two strings are equal? "+taskObj.compareTwoStrings(firstString,secondString,userBoolean));
								break;
								
							case 20:
								System.out.println("Enter a String with spaces at front or end or both: ");
								userString = runnerObj.getStringInput();
								System.out.println("The Trimmed version of Original String is "+taskObj.trimSpaces(userString));
								break;
									

							default:
								System.out.println("Please choose the number between 1 to 20");
								break;
						}
					}
					
					catch (StringException strEx){
						System.out.println(strEx.getMessage());
					}
				}
			}
			
			scan.close();
		}
}