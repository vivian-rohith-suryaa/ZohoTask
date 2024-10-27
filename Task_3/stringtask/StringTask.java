package task;

import java.util.Scanner;
import exception.StringException;

public class StringTask {

    public void validateNullString(String str) throws StringException {
        if (str == null) {
            throw new StringException("Invalid String: Null value is given.");
        }
    }

    public void validateEmptyString(String str) throws StringException {
	validateNullString(str);
        if (str.isEmpty()) {
            throw new StringException("Invalid String: Empty value is given.");
        }
    }

    public void validateIndexInBounds(String str, int index) throws StringException {
        if (index < 0 || index >= str.length()) {
            throw new StringException("Invalid index: Exceeds string length or out of bounds.");
        }
    }

    // Example1
    public String getCommandLineArgument(String[] args) {
        if (args != null && args.length > 0) {
            return args[0];
        }
        return null;
    }

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
        validateEmptyString(str);
        validateIndexInBounds(str, position);
        return str.charAt(position - 1);
    }

    // Example4
    public int getCharOccurrences(String str, char checkChar, boolean caseSensitive) throws StringException {
        int len = getLength(str);
        validateEmptyString(str);
        int count = 0;
        if (!caseSensitive) {
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
    public int findGreatestPosition(String str, char checkChar) throws StringException {
	validateEmptyString(str);
        return str.lastIndexOf(checkChar);
    }

    // Example6
    public String getLastNChars(String str, int position) throws StringException {
        int len = getLength(str);
        validateEmptyString(str);
        validateIndexInBounds(str, position);
        return str.substring(len - position, len);
    }

    // Example7
    public String getFirstNChars(String str, int position) throws StringException {
        validateEmptyString(str);
        validateIndexInBounds(str, position);
        return str.substring(0, position);
    }

    // Example8
    public String replaceCharInString(String str, String strAdd, int charsToReplace) throws StringException {
        validateNullString(str);
        validateNullString(strAdd);
        return strAdd + str.substring(charsToReplace);
    }

    // Example9
    public boolean checkBeginning(String str, String checkStr) throws StringException {
        validateEmptyString(str);
        validateEmptyString(checkStr);
        return str.startsWith(checkStr);
    }

    // Example10
    public boolean checkEnding(String str, String checkStr) throws StringException {
        validateEmptyString(str);
        validateEmptyString(checkStr);
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
    public String getString(String str) throws StringException {
        validateNullString(str);
        return str;
    }

    // Example15
    public String joinStrings(String str) throws StringException {
        validateNullString(str);
        String[] concatStrArr = str.split("\\s");
        return String.join("", concatStrArr);
    }

    // Example16
    public String[] convertToStringArray(String str) throws StringException {
        validateNullString(str);
        return str.split("\\s+");
    }

    // Example17
    public String mergeStringUsingDelimiter(String str, String delimiter) throws StringException {
        validateEmptyString(str);
        validateEmptyString(delimiter);
        String[] strArr = str.split("\\s+");
        return String.join(delimiter, strArr);
    }

    // Example18 and 19
    public boolean compareTwoStrings(String firstString, String secondString, boolean caseSensitive) throws StringException {
        validateNullString(firstString);
        validateNullString(secondString);
        if (!caseSensitive) {
            return firstString.equalsIgnoreCase(secondString);
        }
        return firstString.equals(secondString);
    }

    // Example20
    public String trimSpaces(String str) throws StringException {
        validateNullString(str);
        return str.trim();
    }

    // Scanner Methods
    private Scanner scan = new Scanner(System.in);

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
}
