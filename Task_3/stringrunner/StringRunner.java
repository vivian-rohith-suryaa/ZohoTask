package com.string.runner;

import com.string.exception.NullStringException;
import com.string.task.StringTask;
import java.util.Scanner;

public class StringRunner{
	
	public static String str;
	public static int len;
	public static int position;
	public static String userStr;
	public static int userPos;
	public static char userChar;
	
	public static void main(String[] args){
		
		StringTask strObj = new StringTask();
		
		System.out.print("Enter the sequence number for the exercise (1-20): ");
		
		Scanner sequenceScan = new Scanner(System.in);
		int sequenceNumber = sequenceScan.nextInt();
		
		
			switch(sequenceNumber){
				case 1:
					try{
						str = strObj.readString(args);
						len = strObj.stringLength(str);
						if (len == 0){
							System.out.println("OOPS, run the program again and give it a command line string!!!");
						}
						else{
						System.out.println("The given string is "+str+" and its length is "+len);
						}
					}
					
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
				
				case 2:
					try{
						System.out.print("Enter a String: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						char[] charArr = strObj.charArrayConvert(userStr);
						for(char c : charArr){
							System.out.print(c+" ");
						}
					}
					
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
					
				case 3:
					try{
						System.out.print("Enter a String: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						System.out.print("Enter a position(Number): ");
						Scanner scanPosition = new Scanner(System.in);
						userPos = scanPosition.nextInt();
						char printChar = strObj.charPosition(userStr,userPos);
						System.out.println(printChar);
					}
					
						
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
					
				case 4:
					try{
						System.out.print("Enter a String: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						System.out.print("Enter a char: ");
						Scanner scanChar = new Scanner(System.in);
						userChar = scanChar.next().charAt(0);
						System.out.println("The number of occurrences of character "+userChar+" are: "+strObj.numberOfOccurrences(userStr,userChar));
					}
					
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
					
				case 5:
					try{
						System.out.print("Enter a String: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						System.out.print("Enter a char: ");
						Scanner scanChar = new Scanner(System.in);
						userChar = scanChar.next().charAt(0);
						System.out.println("The greatest occurrences of character "+userChar+" is: "+strObj.greatestPosition(userStr,userChar));
					}
					
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
				
				case 6:
					try{
						System.out.print("Enter a String: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						System.out.print("Enter a position(Number):");
						Scanner scanPosition = new Scanner(System.in);
						userPos = scanPosition.nextInt();
						System.out.println("The characters of the given String is: "+strObj.lastChar(userStr,userPos));
					}
					
						
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
					
				case 7:
					try{
						System.out.print("Enter a String: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						System.out.print("Enter a position(Number): ");
						Scanner scanPosition = new Scanner(System.in);
						userPos = scanPosition.nextInt();
						System.out.println("The characters of the given String is: "+strObj.firstChar(userStr,userPos));
					}
					
						
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
				
				case 8:
					try{
						System.out.print("Enter a String: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						System.out.print("Enter a String to be added: ");
						Scanner scanAdd = new Scanner(System.in);
						String userStrAdd = scanAdd.nextLine();
						System.out.println("The resulted string is:"+strObj.atBegining(userStr, userStrAdd));
					}
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
					
				case 9:
					try{
						System.out.print("Enter a String: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						System.out.print("Enter a String to be checked: ");
						Scanner scanCheck = new Scanner(System.in);
						String userStrCheck = scanCheck.nextLine();
						System.out.println("Whether the given String '"+userStrCheck+"' starts with "+userStrCheck+" ? "+strObj.startCheck(userStr, userStrCheck));
					}
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
				
				case 10:
					try{
						System.out.print("Enter a String: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						System.out.print("Enter a String to be checked: ");
						Scanner scanCheck = new Scanner(System.in);
						String userStrCheck = scanCheck.nextLine();
						System.out.println("Whether the given String '"+userStrCheck+"' ends with "+userStrCheck+" ? "+strObj.endCheck(userStr, userStrCheck));
					}
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
				
				case 11:
					try{
						System.out.print("Enter a String: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						System.out.println("The given string converted to upper case is: "+strObj.convertLowerToUpper(userStr));
						}
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
					
				case 12:
					try{
						System.out.print("Enter a String: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						System.out.println("The given string converted to lower case is: "+strObj.convertUpperToLower(userStr));
						}
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
					
				case 13:
					try{
						System.out.print("Enter a String: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						System.out.println("The reversed input String is: "+strObj.reverseString(userStr));
					}
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;

			
				case 14:
					try{
						System.out.print("Enter a String: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						System.out.println("The input String is: "+strObj.multipleLine(userStr));
					}
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
					
				case 15:
					try{
						System.out.print("Enter a String: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						System.out.println("The concatenated String is: "+strObj.multiLineConcat(userStr));
					}
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
					
				case 16:
					try{
						System.out.print("Enter multiple Strings: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						String[] loopArr = strObj.stringArrayConvert(userStr);
						System.out.print("{");
						for (int i = 0; i<loopArr.length;i++){
							System.out.print("\""+loopArr[i]+"\"");
							if(i<loopArr.length - 1){
								System.out.print(",");
							}
						}
						System.out.print("}");
					}
					
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
					
				case 17:
					try{
						System.out.print("Enter multiple Strings: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						String[] loopArr = strObj.stringArrayConvert(userStr);
						for (int i=0; i<loopArr.length;i++){
							System.out.print(loopArr[i]);
							if(i<loopArr.length - 1){
								System.out.print("-");
							}
						}
						System.out.print(".");
					}
					
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
					
				case 18:
					try{
						System.out.print("Enter a String: ");
						Scanner scanOne = new Scanner(System.in);
						String strOne = scanOne.nextLine();
						System.out.print("Enter a String: ");
						Scanner scanTwo = new Scanner(System.in);
						String strTwo = scanTwo.nextLine();
						System.out.println("Whether the two strings are equal(Case sensitive)? "+strObj.compareTwoString(strOne,strTwo));
					}
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
					
				case 19:
					try{
						System.out.print("Enter a String: ");
						Scanner scanOne = new Scanner(System.in);
						String strOne = scanOne.nextLine();
						System.out.print("Enter a String: ");
						Scanner scanTwo = new Scanner(System.in);
						String strTwo = scanTwo.nextLine();
						System.out.println("Whether the two strings are equal(Case insensitive)? "+strObj.compareTwoStringInsensitive(strOne,strTwo));
					}
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
					
				case 20:
					try{
						System.out.print("Enter a String: ");
						Scanner scan = new Scanner(System.in);
						userStr = scan.nextLine();
						System.out.println("The Trimmed version of Original String is "+strObj.trimSpace(userStr));
					}
					
					catch(NullStringException strEx){
						System.out.println(strEx.getMessage());
					}
					
					break;
						

				default:
					System.out.println("Please choose the number between 1 to 20");
					break;
			}
	}
}				
				
		
