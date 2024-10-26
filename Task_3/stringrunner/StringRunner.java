package runner;

import exception.StringException;
import task.StringTask;
import java.util.Scanner;

public class StringRunner{
	
		public static String str;
		public static int len;
		public static int position;
		public static String userStr;
		public static int userPos;
		public static char userChar;
		public static boolean userBool;
	
		public static void main(String[] args){
			
			StringTask strObj = new StringTask();
			Scanner scanner = new Scanner (System.in);
			boolean loop = true;
			
			while(loop){
				System.out.println("Enter the sequence number for the exercise (1 - 20, or 0 to exit):");
				int sequenceNumber = scanner.nextInt();
				scanner.nextLine();				
				
				if(sequenceNumber==0){
					System.out.println("Exiting program!!!");
					loop = false;
				}
				
				else{
					try{
						switch(sequenceNumber){
							case 1:								
								str = strObj.getInputArgument(args);
								len = strObj.getLength(str);
								if (len == 0){
									System.out.println("OOPS, run the program again and give it a command line string!!!");
								}
								else{
									System.out.println("The given string is "+str+" and its length is "+len);
								}
								break;
							
							case 2:
								System.out.println("Enter a String to convert into character array: ");
								userStr = strObj.getStringInput();
								char[] charArr = strObj.convertToCharArray(userStr);
								System.out.println("The String Converted to a character array is:"); 
								for(char c : charArr){
									System.out.println(c+" ");
								}
								
								break;
								
							case 3:
								System.out.println("Enter a String to find the position of a character: ");
								userStr = strObj.getStringInput();
								System.out.println("Enter a position to find: ");
								userPos = strObj.getIntInput();
								System.out.println("The character at the "+userPos+ " is :"+strObj.getCharPosition(userStr,userPos));
								
								break;
								
							case 4:
								System.out.println("Enter a String to find the number of occurrences: ");
								userStr = strObj.getStringInput();
								System.out.println("Enter a character to find the occurrence: ");
								userChar = strObj.getCharInput();
								System.out.println("Should it be case sensitive (true/false)?");
								userBool = strObj.getBoolInput();
								System.out.println("The number of occurrences of character "+userChar+" are: "+strObj.getCharOccurrences(userStr,userChar,userBool));
								break;
								
							case 5:
								System.out.println("Enter a String to find the greatest position of a character: ");
								userStr = strObj.getStringInput();
								System.out.println("Enter a character to find: ");
								userChar = strObj.getCharInput();
								System.out.println("The greatest occurrences of character "+userChar+" is: "+strObj.getLastCharIndex(userStr,userChar));
								break;
							
							case 6:
								System.out.println("Enter a String to print the ending characters: ");
								userStr = strObj.getStringInput();
								System.out.println("Enter a position:");
								userPos = strObj.getIntInput();
								System.out.println("The characters of the given String is: "+strObj.getLastChar(userStr,userPos));
								break;
								
							case 7:
								System.out.println("Enter a String to print the starting characters: ");
								userStr = strObj.getStringInput();
								System.out.println("Enter a position: ");
								userPos = strObj.getIntInput();
								System.out.println("The characters of the given String is: "+strObj.getFirstChar(userStr,userPos));
								break;
							
							case 8:
								System.out.println("Enter a String that is replaced: ");
								userStr = strObj.getStringInput();
								System.out.println("Enter a String to be replaced: ");
								String userStrAdd = strObj.getStringInput();
								System.out.println("Enter the number of characters to be replaced: ");
								int charsToReplace = strObj.getIntInput();
								System.out.println("The resulted string is:"+strObj.replaceCharInString(userStr, userStrAdd,charsToReplace));
								break;
								
							case 9:
								System.out.println("Enter a String to check: ");
								userStr = strObj.getStringInput();
								System.out.println("Enter a String to be checked: ");
								String userStrCheck = strObj.getStringInput();
								System.out.println("Whether the given String '"+userStr+"' starts with "+userStrCheck+" ? "+strObj.checkPrefixChar(userStr, userStrCheck));
								break;
							
							case 10:
								System.out.println("Enter a String to check: ");
								userStr = strObj.getStringInput();
								System.out.println("Enter a String to be checked: ");
								userStrCheck = strObj.getStringInput();
								System.out.println("Whether the given String '"+userStr+"' ends with "+userStrCheck+" ? "+strObj.checkSuffixChar(userStr, userStrCheck));
								break;
							
							case 11:
								System.out.println("Enter a String to be converted from lowercase: ");
								userStr = strObj.getStringInput();
								System.out.println("The given string converted to upper case is: "+strObj.convertLowerCaseToUpperCase(userStr));
								break;
								
							case 12:
								System.out.println("Enter a String to be converted from uppercase: ");
								userStr = strObj.getStringInput();
								System.out.println("The given string converted to lower case is: "+strObj.convertUpperCaseToLowerCase(userStr));
								break;
								
							case 13:
								System.out.println("Enter a String to reverse: ");
								userStr = strObj.getStringInput();
								System.out.println("The reversed input String is: "+strObj.getReverseString(userStr));
								break;

						
							case 14:
								System.out.println("Enter a line with multiple strings: ");
								userStr = strObj.getStringInput();
								System.out.println("The result is: "+strObj.getMultipleString(userStr));
								break;
								
							case 15:
								System.out.println("Enter a line with multiple strings to concatenate: ");
								userStr = strObj.getStringInput();
								System.out.println("The concatenated String is: "+strObj.joinMultipleLines(userStr));
								break;
								
							case 16:
								System.out.println("Enter a line withmultiple Strings: ");
								userStr = strObj.getStringInput();
								System.out.println(strObj.convertToStringArray(userStr));
								break;
								
							case 17:
								System.out.println("Enter a line with multiple Strings: ");
								userStr = strObj.getStringInput();
								System.out.println("Enter a delimiter to split the string: ");
								String delimiterStr = strObj.getStringInput();
								System.out.println(strObj.mergeStringUsingDelimiter(userStr,delimiterStr));
								break;
								
							case 18:						
							case 19:
								System.out.println("Enter a String to be checked: ");
								String strOne = strObj.getStringInput();
								System.out.println("Enter another String to be checked: ");
								String strTwo = strObj.getStringInput();
								System.out.println("Should it be case sensitive (true/false)?");
								userBool = strObj.getBoolInput();
								System.out.println("Whether the two strings are equal? "+strObj.toCompareTwoStrings(strOne,strTwo,userBool));
								break;
								
							case 20:
								System.out.println("Enter a String with spaces at front or end or both: ");
								userStr = strObj.getStringInput();
								System.out.println("The Trimmed version of Original String is "+strObj.toTrimSpace(userStr));
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
			
			scanner.close();
		}
}