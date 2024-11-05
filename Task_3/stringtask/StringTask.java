package task;

import exception.StringException;

public class StringTask {

    public void validateNullString(String str) throws StringException {
        if (str == null) {
            throw new StringException("Invalid String: Null value is given.");
        }
    }

    public void validateEmptyString(int len) throws StringException {
        if (len == 0) {
            throw new StringException("Invalid String: Empty value is given.");
        }
    }

    public void validateIndexInBounds(int index, int length) throws StringException {
        if (index < 0 || index >= length) {
            throw new StringException("Invalid index: Exceeds string length or out of bounds.");
        }
    }

    // Example1
    public int getLength(String str) throws StringException {
        validateNullString(str);
        return str.length();
    }

    // Example2
    public char[] convertToCharArray(String str) throws StringException {
        validateNullString(str);
        return str.toCharArray();
    }

    // Example3
    public char getCharPosition(String str, int position) throws StringException {
        int len = getLength(str);
		validateIndexInBounds(position-1,len);
		return str.charAt(position - 1);
    }

    // Example4
    public int getCharOccurrences(String str, char checkChar, boolean isCaseSensitive) throws StringException {
        int len = getLength(str);
		int count = 0;
		if (!isCaseSensitive) {
			str = str.toLowerCase();
			checkChar = Character.toLowerCase(checkChar);
		}
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == checkChar) {
				count++;
			}
		}
		return count;

    }

    // Example5
    public int getGreatestPosition(String str, char checkChar) throws StringException {
        int len = getLength(str);
		validateEmptyString(len);
        return str.lastIndexOf(checkChar);
    }

    // Example6
    public String getSuffixChars(String str, int position) throws StringException {
        int len = getLength(str);
		validateIndexInBounds(position,len);
		return str.substring(len - position, len);
    }

    // Example7
    public String getPrefixChars(String str, int position) throws StringException {
        int len = getLength(str);
		validateIndexInBounds(position,len);
		return str.substring(0, position);
    }

    // Example8
    public String replaceCharInString(String str, String strAdd, int charsToReplace) throws StringException {
        validateNullString(str);
        validateNullString(strAdd);
        return strAdd + str.substring(charsToReplace);
    }

    // Example9
    public boolean checkPrefix(String str, String checkStr) throws StringException {
        validateNullString(str);
        validateNullString(checkStr);
        return str.startsWith(checkStr);
    }

    // Example10
    public boolean checkSuffix(String str, String checkStr) throws StringException {
        validateNullString(str);
        validateNullString(checkStr);
        return str.endsWith(checkStr);
    }

    // Example11
    public String convertToUpperCase(String str) throws StringException {
        validateNullString(str);
        return str.toUpperCase();
    }

    // Example12
    public String convertToLowerCase(String str) throws StringException {
        validateNullString(str);
        return str.toLowerCase();
    }

    // Example13
    public String reverseString(String str) throws StringException {
        int len = getLength(str);
        char[] charRev = convertToCharArray(str);
        int leftPoint = 0;
        int rightPoint = len - 1;
        while (leftPoint < rightPoint) {
            char temp = charRev[leftPoint];
            charRev[leftPoint] = charRev[rightPoint];
            charRev[rightPoint] = temp;
            leftPoint++;
            rightPoint--;
        }
        return new String(charRev);
    }

    // Example14
    public String getMultipleString(String str) throws StringException {
        validateNullString(str);
        return str;
    }

    // Example15 and 17
    public String mergeStringUsingDelimiter(String str, String splitDelimiter, String joinDelimiter) throws StringException {
        validateNullString(str);
		validateNullString(splitDelimiter);
		validateNullString(joinDelimiter);
        String[] splitStrArr = str.split(splitDelimiter);
        return String.join(joinDelimiter, splitStrArr);
    }

    // Example16
    public String[] convertToStringArray(String str, String delimiter) throws StringException {
        validateNullString(str);
		validateNullString(delimiter);
        return str.split(delimiter);
    }


    // Example18 and 19
    public boolean compareTwoStrings(String firstString, String secondString, boolean isCaseSensitive) throws StringException {
        validateNullString(firstString);
        validateNullString(secondString);
        if (!isCaseSensitive) {
            return firstString.equalsIgnoreCase(secondString);
        }
        return firstString.equals(secondString);
    }

    // Example20
    public String trimSpaces(String str) throws StringException {
        validateNullString(str);
        return str.trim();
    }

    
}
