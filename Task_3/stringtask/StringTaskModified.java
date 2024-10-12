package taskmodified;

import java.util.Scanner;
import stringexception.NullStringException;

public class StringTaskModified{
	
	public void taskStringException(String str) throws NullStringException{
		if(str==null){
			throw new NullStringException("Invalid String or Null value is given. Please enter a valid string.");
		}
	}				
	
	//Example1 
	
	public String readString(String[] args){
		if (args!=null&&args.length > 0){
			return args[0];
		}
		else{
			return null;
		}			

	}
	

	public int stringLength(String str) throws NullStringException{
		taskStringException(str);
		return str.length();
	}
	
	//Example2

	public char[] charArrayConvert(String str) throws NullStringException{
		taskStringException(str);
		return str.toCharArray();
	}
	 
	
	//Example3

	public char charPosition(String str,int position) throws NullStringException{
		taskStringException(str);
		int len = str.length();
		return str.charAt(len-position);
	}
	
	//Example4

	public int numberOfOccurrences(String str,char checkChar) throws NullStringException{
		taskStringException(str);
		int count=0;
		str = str.toLowerCase();
		checkChar = Character.toLowerCase(checkChar);
		int len = str.length();
		for(int i=0; i<len;i++){
			if(str.charAt(i)== checkChar){
				count++;
			}
		}
		return count;
	}
	
	//Example5

	public int greatestPosition(String str, char checkChar) throws NullStringException{
		taskStringException(str);
		return str.lastIndexOf(checkChar);
	}
	
	//Example6

	public String lastChar(String str,int position)throws NullStringException{
		taskStringException(str);
		int len = str.length();
		 
		String lastStr = str.substring(len-position,len);
		return lastStr;
	}
	
	//Example7

	public String firstChar(String str,int position)throws NullStringException{
		taskStringException(str);
		String firstStr = str.substring(0,position);
		return firstStr;
	}
	
	//Example8

	public String atBegining(String str,String strAdd) throws NullStringException{
		taskStringException(str);
		int len = strAdd.length();
		return strAdd+str.substring(len);
	}
	
	//Example9

	public boolean startCheck(String str,String checkStr) throws NullStringException{
		taskStringException(str);
		int len = checkStr.length();
		String check = str.substring(0,len);
		boolean result=check.equals(checkStr);
		return result;
	}
	
	//Example10
	
	public boolean endCheck(String str,String checkStr) throws NullStringException{
		taskStringException(str);
		int len = checkStr.length();
		String check = str.substring(len,str.length());
		boolean result=check.equals(checkStr);
		return result;
	}
	
	//Example11

	public String convertLowerToUpper(String str) throws NullStringException{
		taskStringException(str);
		str=str.toUpperCase();
		return str;
	}
	
	//Example12

	public String convertUpperToLower(String str) throws NullStringException{
		taskStringException(str);
		str=str.toLowerCase();
		return str;
	}
	
	//Example13

	public String reverseString(String str) throws NullStringException{
		taskStringException(str);
		char[] charRev = str.toCharArray();
		int len = str.length();
		 
		int leftPoint = 0;
		int rightPoint = len-1;
		while(leftPoint<rightPoint){
			char temp = charRev[leftPoint];
			charRev[leftPoint]=charRev[rightPoint];
			charRev[rightPoint]=temp;
			leftPoint++;
			rightPoint--;
		}
		return new String(charRev);
		
	}
	
	//Example14

	public String multipleLine(String str) throws NullStringException{
		taskStringException(str);
		return str;
	}
	
	//Example15

	public String multiLineConcat(String str) throws NullStringException{
    taskStringException(str);
    String[] concatStrArr = str.split("\\s");
    return String.join("\\s", concatStrArr);
}

	
	//Example16

	public String[] stringArrayConvert(String str) throws NullStringException{
		taskStringException(str);
		String[] stringArray = str.split("\\s");
		return stringArray;
	}
	
	//Example17

	
	//Example18

	public boolean compareTwoString(String firstString,String secondString) throws NullStringException{
		taskStringException(firstString);
		taskStringException(secondString);
		return firstString.equals(secondString);
	}
	
	//Example19

	public boolean compareTwoStringInsensitive(String firstInsensitiveString,String secondInsensitiveString) throws NullStringException{
		taskStringException(firstInsensitiveString);
		taskStringException(secondInsensitiveString);
		return firstInsensitiveString.equalsIgnoreCase(secondInsensitiveString);
	}
	
	//Example20

	public String trimSpace(String str) throws NullStringException{
		taskStringException(str);
		String trimmedString = str.trim();
		return trimmedString;
	}
		
		

}
	