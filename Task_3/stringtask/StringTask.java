package stringtask;

import taskexception.TaskException;
import nullexception.NullValueException;
import stringexception.StringException;
import utility.TaskUtility;
import indexexception.IndexBoundException;

public class StringTask {
	

    public char[] convertToCharArray(String input) throws TaskException {
		TaskUtility.validateNullValue(input);
		return input.toCharArray();
    }


    public char getCharPosition(String input, int position) throws TaskException {
		int length = TaskUtility.getLength(input);
		TaskUtility.validateIndexInBounds(position-1,length);
		return input.charAt(position - 1);
    }


    public int getCharOccurrences(String input, char checkerChar, boolean caseSensitive) throws TaskException {
		int length = TaskUtility.getLength(input);
		int count = 0;
		if (!caseSensitive) {
			input = input.toLowerCase();
			checkerChar = Character.toLowerCase(checkerChar);
		}
		for (int i = 0; i < length; i++) {
			if (input.charAt(i) == checkerChar) {
				count++;
			}
		}
		return count;
    }


    public int getGreatestPosition(String input, char checkerChar) throws TaskException {
		int length = TaskUtility.getLength(input);
		TaskUtility.validateEmptyValue(length);
		return input.lastIndexOf(checkerChar);
    }


    public String getSuffixChars(String input, int position) throws TaskException {
		int length = TaskUtility.getLength(input);
		TaskUtility.validateIndexInBounds(position,length);
		return input.substring(length - position, length);
    }
	
	
    public String getPrefixChars(String input, int position) throws TaskException {
		int length = TaskUtility.getLength(input);
		TaskUtility.validateIndexInBounds(position,length);
		return input.substring(0, position);
	}



    public String replaceCharInString(String input, String replacedString, int replacedChar) throws TaskException {
		TaskUtility.validateNullValue(input);
		TaskUtility.validateNullValue(replacedString);
		return replacedString + input.substring(replacedChar);	
    }


    public boolean checkPrefix(String input, String checkerString) throws TaskException {
		TaskUtility.validateNullValue(input);
		TaskUtility.validateNullValue(checkerString);
		return input.startsWith(checkerString);
    }


    public boolean checkSuffix(String input, String checkerString) throws TaskException {
		TaskUtility.validateNullValue(input);
		TaskUtility.validateNullValue(checkerString);
		return input.endsWith(checkerString);
    }


    public String convertToUpperCase(String input) throws TaskException {
		TaskUtility.validateNullValue(input);
		return input.toUpperCase();
    }


    public String convertToLowerCase(String input) throws TaskException {
		TaskUtility.validateNullValue(input);
		return input.toLowerCase();
    }


    public String reverseString(String input) throws TaskException {
		int length = TaskUtility.getLength(input);
		char[] charArr = convertToCharArray(input);
		int leftPoint = 0;
		int rightPoint = length - 1;
		while (leftPoint < rightPoint) {
			char temp = charArr[leftPoint];
			charArr[leftPoint] = charArr[rightPoint];
			charArr[rightPoint] = temp;
			leftPoint++;
			rightPoint--;
		}
		return new String(charArr);
    }


    public String getMultipleString(String input) throws TaskException {
		TaskUtility.validateNullValue(input);
		return input;
    }


    public String mergeStringUsingDelimiter(String input, String spliterDelimiter, String combinerDelimiter) throws TaskException {
		TaskUtility.validateNullValue(input);
		TaskUtility.validateNullValue(spliterDelimiter);
		TaskUtility.validateNullValue(combinerDelimiter);
		String[] strArr = input.split(spliterDelimiter);
		return String.join(combinerDelimiter, strArr);
    }


    public String[] convertToStringArray(String input, String delimiter) throws TaskException {
		TaskUtility.validateNullValue(input);
		TaskUtility.validateNullValue(delimiter);
		return input.split(delimiter);
    }



    public boolean compareTwoStrings(String firstString, String secondString, boolean caseSensitive) throws TaskException {
		TaskUtility.validateNullValue(firstString);
		TaskUtility.validateNullValue(secondString);
		if (!caseSensitive) {
			return firstString.equalsIgnoreCase(secondString);
		}
		return firstString.equals(secondString);
    }


    public String trimSpaces(String input) throws TaskException {
		TaskUtility.validateNullValue(input);
		return input.trim();
    }

    
}
