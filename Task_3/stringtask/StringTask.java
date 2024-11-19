package task;

import exception.StringException;
import utility.StringUtility;

public class StringTask {
	

    // Example2
    public char[] convertToCharArray(String input) throws StringException {
        try{
			StringUtility.validateNullString(input);
			return input.toCharArray();
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - convertToCharArray method",e);
		}
    }

    // Example3
    public char getCharPosition(String input, int position) throws StringException {
		try{
			int length = StringUtility.getLength(input);
			StringUtility.validateIndexInBounds(position-1,length);
			return input.charAt(position - 1);
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - getCharPosition method",e);
		}
    }

    // Example4
    public int getCharOccurrences(String input, char checkerChar, boolean caseSensitive) throws StringException {
		try{
			int length = StringUtility.getLength(input);
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
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - getCharOccurrences method",e);
		}
    }

    // Example5
    public int getGreatestPosition(String input, char checkerChar) throws StringException {
		try{
			int length = StringUtility.getLength(input);
			StringUtility.validateEmptyValue(length);
			return input.lastIndexOf(checkerChar);
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - getGreatestPosition method",e);
		}
    }

    // Example6
    public String getSuffixChars(String input, int position) throws StringException {
		try{
			int length = StringUtility.getLength(input);
			StringUtility.validateIndexInBounds(position,length);
			return input.substring(length - position, length);
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - getSuffixChars method",e);
		}
    }

    // Example7
    public String getPrefixChars(String input, int position) throws StringException {
		try{
			int length = StringUtility.getLength(input);
			StringUtility.validateIndexInBounds(position,length);
			return input.substring(0, position);
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - getPrefixChars method",e);
		}
	}


    // Example8
    public String replaceCharInString(String input, String replacedString, int replacedChar) throws StringException {
		try{
			StringUtility.validateNullString(input);
			StringUtility.validateNullString(replacedString);
			return replacedString + input.substring(replacedChar);
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - replaceCharInString method",e);
		}		
    }

    // Example9
    public boolean checkPrefix(String input, String checkerString) throws StringException {
		try{
			StringUtility.validateNullString(input);
			StringUtility.validateNullString(checkerString);
			return input.startsWith(checkerString);
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - checkPrefix method",e);
		}
    }

    // Example10
    public boolean checkSuffix(String input, String checkerString) throws StringException {
		try{
			StringUtility.validateNullString(input);
			StringUtility.validateNullString(checkerString);
			return input.endsWith(checkerString);
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - checkSuffix method",e);
		}
    }

    // Example11
    public String convertToUpperCase(String input) throws StringException {
		try{
			StringUtility.validateNullString(input);
			return input.toUpperCase();
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - convertToUpperCase method",e);
		}
    }

    // Example12
    public String convertToLowerCase(String input) throws StringException {
		try{
			StringUtility.validateNullString(input);
			return input.toLowerCase();
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - convertToLowerCase method",e);
		}
    }

    // Example13
    public String reverseString(String input) throws StringException {
		try{
			int length = StringUtility.getLength(input);
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
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - reverseString method",e);
		}
    }

    // Example14
    public String getMultipleString(String input) throws StringException {
		try{
			StringUtility.validateNullString(input);
			return input;
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - getMultipleString method",e);
		}
    }

    // Example15 and 17
    public String mergeStringUsingDelimiter(String input, String spliterDelimiter, String combinerDelimiter) throws StringException {
		try{
			StringUtility.validateNullString(input);
			StringUtility.validateNullString(spliterDelimiter);
			StringUtility.validateNullString(combinerDelimiter);
			String[] strArr = input.split(spliterDelimiter);
			return String.join(combinerDelimiter, strArr);
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - mergeStringUsingDelimiter method",e);
		}
    }

    // Example16
    public String[] convertToStringArray(String input, String delimiter) throws StringException {
		try{
			StringUtility.validateNullString(input);
			StringUtility.validateNullString(delimiter);
			return input.split(delimiter);
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - convertToStringArray method",e);
		}
    }


    // Example18 and 19
    public boolean compareTwoStrings(String firstString, String secondString, boolean caseSensitive) throws StringException {
		try{
			StringUtility.validateNullString(firstString);
			StringUtility.validateNullString(secondString);
			if (!caseSensitive) {
				return firstString.equalsIgnoreCase(secondString);
			}
			return firstString.equals(secondString);
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - compareTwoStrings method",e);
		}
    }

    // Example20
    public String trimSpaces(String input) throws StringException {
		try{
			StringUtility.validateNullString(input);
			return input.trim();
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringTask Class - trimSpaces method",e);
		}
    }

    
}
