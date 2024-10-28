package runner;

import exception.StringException;
import task.StringTask;
import java.util.Scanner;
import java.util.Arrays;

public class StringRunner{
	
	public static String str;
	public static int len;
	public static int position;
	public static String userStr;
	public static int userPos;
	public static char userChar;
	public static boolean userBool;
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
										throw new StringException("Invalid String: Null value is given."); // Custom exception if no argument is provided
									}
									str = args[0];
									System.out.println("The length of the given string is " + taskObj.getLength(str));
								} 
								catch (StringException strEx) {
									System.out.println(strEx.getMessage());
								}
								break;
							
							case 2:
								System.out.println("Enter a String to convert into character array: ");
								userStr = runnerObj.getStringInput();
								char[] charArr = taskObj.convertToCharArray(userStr);
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
								userStr = runnerObj.getStringInput();
								System.out.println("Enter a position to find: ");
								userPos = runnerObj.getIntInput();
								System.out.println("The character at the "+userPos+ " is :"+taskObj.getCharPosition(userStr,userPos));
								
								break;
								
							case 4:
								System.out.println("Enter a String to find the number of occurrences: ");
								userStr = runnerObj.getStringInput();
								System.out.println("Enter a character to find the occurrence: ");
								userChar = runnerObj.getCharInput();
								System.out.println("Should it be case sensitive (true/false)?");
								userBool = runnerObj.getBoolInput();
								System.out.println("The number of occurrences of character "+userChar+" are: "+taskObj.getCharOccurrences(userStr,userChar,userBool));
								break;
								
							case 5:
								System.out.println("Enter a String to find the greatest position of a character: ");
								userStr = runnerObj.getStringInput();
								System.out.println("Enter a character to find: ");
								userChar = runnerObj.getCharInput();
								System.out.println("The greatest occurrences of character "+userChar+" is: "+taskObj.getGreatestPosition(userStr,userChar));
								break;
							
							case 6:
								System.out.println("Enter a String to print the ending characters: ");
								userStr = runnerObj.getStringInput();
								System.out.println("Enter a position:");
								userPos = runnerObj.getIntInput();
								System.out.println("The characters of the given String is: "+taskObj.getSuffixChars(userStr,userPos));
								break;
								
							case 7:
								System.out.println("Enter a String to print the starting characters: ");
								userStr = runnerObj.getStringInput();
								System.out.println("Enter a position: ");
								userPos = runnerObj.getIntInput();
								System.out.println("The characters of the given String is: "+taskObj.getFirstChars(userStr,userPos));
								break;
							
							case 8:
								System.out.println("Enter a String that is replaced: ");
								userStr = runnerObj.getStringInput();
								System.out.println("Enter a String to be replaced: ");
								String userStrAdd = runnerObj.getStringInput();
								System.out.println("Enter the number of characters to be replaced: ");
								int charsToReplace = runnerObj.getIntInput();
								System.out.println("The resulted string is:"+taskObj.replaceCharInString(userStr, userStrAdd,charsToReplace));
								break;
								
							case 9:
								System.out.println("Enter a String to check: ");
								userStr = runnerObj.getStringInput();
								System.out.println("Enter a String to be checked: ");
								String userStrCheck = runnerObj.getStringInput();
								System.out.println("Whether the given String '"+userStr+"' starts with "+userStrCheck+" ? "+taskObj.checkPrefix(userStr, userStrCheck));
								break;
							
							case 10:
								System.out.println("Enter a String to check: ");
								userStr = runnerObj.getStringInput();
								System.out.println("Enter a String to be checked: ");
								userStrCheck = runnerObj.getStringInput();
								System.out.println("Whether the given String '"+userStr+"' ends with "+userStrCheck+" ? "+taskObj.checkSuffix(userStr, userStrCheck));
								break;
							
							case 11:
								System.out.println("Enter a String to be converted from lowercase: ");
								userStr = runnerObj.getStringInput();
								System.out.println("The given string converted to upper case is: "+taskObj.convertToUpperCase(userStr));
								break;
								
							case 12:
								System.out.println("Enter a String to be converted from uppercase: ");
								userStr = runnerObj.getStringInput();
								System.out.println("The given string converted to lower case is: "+taskObj.convertToLowerCase(userStr));
								break;
								
							case 13:
								System.out.println("Enter a String to reverse: ");
								userStr = runnerObj.getStringInput();
								System.out.println("The reversed input String is: "+taskObj.reverseString(userStr));
								break;

						
							case 14:
								System.out.println("Enter a line with multiple strings: ");
								userStr = runnerObj.getStringInput();
								System.out.println("The result is: "+taskObj.getMultipleString(userStr));
								break;
								
							case 15:
								System.out.println("Enter a line with multiple strings to concatenate: ");
								userStr = runnerObj.getStringInput();
								System.out.println("The concatenated String is: "+taskObj.joinMultipleString(userStr));
								break;
								
							case 16:
								System.out.println("Enter a line with multiple strings: ");
								userStr = runnerObj.getStringInput();
								String[] result = taskObj.convertToStringArray(userStr);
								System.out.print("{");
								for (int i = 0; i<result.length;i++){
									System.out.print("\""+result[i]+"\"");
									if(i < result.length - 1){
										System.out.print(",");
									}
								}
								System.out.println("}");
								break;
								
							case 17:
								System.out.println("Enter a line with multiple Strings: ");
								userStr = runnerObj.getStringInput();
								System.out.println("Enter a delimiter to split the string: ");
								String delimiterStr = runnerObj.getStringInput();
								System.out.println(taskObj.mergeStringUsingDelimiter(userStr,delimiterStr));
								break;
								
							case 18:						
							case 19:
								System.out.println("Enter a String to be checked: ");
								String strOne = runnerObj.getStringInput();
								System.out.println("Enter another String to be checked: ");
								String strTwo = runnerObj.getStringInput();
								System.out.println("Should it be case sensitive (true/false)?");
								userBool = runnerObj.getBoolInput();
								System.out.println("Whether the two strings are equal? "+taskObj.compareTwoStrings(strOne,strTwo,userBool));
								break;
								
							case 20:
								System.out.println("Enter a String with spaces at front or end or both: ");
								userStr = runnerObj.getStringInput();
								System.out.println("The Trimmed version of Original String is "+taskObj.trimSpaces(userStr));
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