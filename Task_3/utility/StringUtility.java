package utility;

import java.util.Scanner;
import exception.StringException;

public class StringUtility{
	
	public static Scanner scan = new Scanner(System.in);
		
	public static void validateNullString(String input) throws StringException {
        if (input == null) {
            throw new StringException("Invalid String: Null value is given.");
        }
    }

    public static void validateEmptyValue(int length) throws StringException {
        if (length == 0) {
            throw new StringException("Invalid String: Empty value is given.");
        }
    }

    public static void validateIndexInBounds(int index, int length) throws StringException {
		validateEmptyValue(length);
        if (index < 0 || index >= length) {
            throw new StringException("Invalid index: Exceeds string length or out of bounds.");
        }
    }
	
	public static int getLength(String input) throws StringException {
        try{
			validateNullString(input);
			return input.length();
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringUtility Class - getLength method",e);
		}
    }
	
	public static String getStringInput() {
        return scan.nextLine();
    }

    public static int getIntInput() {
		int input = scan.nextInt();
		scan.nextLine();
        return input;
    }

    public static char getCharInput() {
        char character = scan.next().charAt(0);
		scan.nextLine();
		return character;
    }

    public static boolean getBoolInput() {
        boolean bool = scan.nextBoolean();
		scan.nextLine();
		return bool;
    }
}