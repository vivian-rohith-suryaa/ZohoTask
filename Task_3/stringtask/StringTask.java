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
        if (str != null && str.isEmpty()) {
            throw new StringException("Invalid String: Empty value is given.");
        }
    }

    public void validateIndexInBounds(String str, int index) throws StringException {
        if (index < 0 || index >= str.length()) {
            throw new StringException("Invalid index: Exceeds string length or out of bounds.");
        }
    }

    // Example1
    public String getInputArgument(String[] args) {
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
    public int getLastCharIndex(String str, char checkChar) throws StringException {
        validateNullString(str);
        validateEmptyString(str);
        return str.lastIndexOf(checkChar);
    }

    // Example6
    public String getLastChar(String str, int position) throws StringException {
        int len = getLength(str);
        validateEmptyString(str);
        validateIndexInBounds(str, position);
        return str.substring(len - position, len);
    }

    // Example7
    public String getFirstChar(String str, int position) throws StringException {
        validateNullString(str);
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
    public boolean checkPrefixChar(String str, String checkStr) throws StringException {
        validateNullString(str);
        validateNullString(checkStr);
        validateEmptyString(str);
        validateEmptyString(checkStr);
        return str.startsWith(checkStr);
    }

    // Example10
    public boolean checkSuffixChar(String str, String checkStr) throws StringException {
        validateNullString(str);
        validateNullString(checkStr);
        validateEmptyString(str);
        validateEmptyString(checkStr);
        return str.endsWith(checkStr);
    }

    // Example11
    public String convertLowerCaseToUpperCase(String str) throws StringException {
        validateNullString(str);
        return str.toUpperCase();
    }

    // Example12
    public String convertUpperCaseToLowerCase(String str) throws StringException {
        validateNullString(str);
        return str.toLowerCase();
    }

    // Example13
    public String getReverseString(String str) throws StringException {
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

    // Example15
    public String joinMultipleLines(String str) throws StringException {
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
        validateNullString(str);
        validateNullString(delimiter);
        validateEmptyString(str);
        validateEmptyString(delimiter);
        String[] strArr = str.split("\\s+");
        return String.join(delimiter, strArr);
    }

    // Example18 and 19
    public boolean toCompareTwoStrings(String firstString, String secondString, boolean caseSensitive) throws StringException {
        validateNullString(firstString);
        validateNullString(secondString);
        if (!caseSensitive) {
            return firstString.equalsIgnoreCase(secondString);
        }
        return firstString.equals(secondString);
    }

    // Example20
    public String toTrimSpace(String str) throws StringException {
        validateNullString(str);
        return str.trim();
    }

    // Scanner Methods
    private Scanner scan = new Scanner(System.in);

    public String getStringInput() {
        return scan.nextLine();
    }

    public int getIntInput() {
        return scan.nextInt();
    }

    public char getCharInput() {
        return scan.next().charAt(0);
    }

    public boolean getBoolInput() {
        return scan.nextBoolean();
    }
}
