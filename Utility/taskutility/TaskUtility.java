package utility;

import taskexception.TaskException;
import nullexception.NullValueException;
import java.util.Scanner;
import stringexception.StringException;
import indexexception.IndexBoundException;
import stringbuilderexception.StringBuilderException;


public class TaskUtility{
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void validateNullValue(Object input) throws TaskException {
        if (input == null) {
			throw new NullValueException("Invalid Input: Null value is given.");
        }
    }

    public static void validateEmptyValue(int length) throws TaskException {
        if (length == 0) {
            throw new StringException("Invalid String: Empty value is given.");
        }
    }

    public static void validateIndexInBounds(int index, int length) throws TaskException {
		validateEmptyValue(length);
        if (index < 0 || index >= length) {
            throw new IndexBoundException("Invalid index: Exceeds input length or out of bounds.");
        }
    }
	
	public static void validateMinimumChars(int limit,String input) throws TaskException{
		validateNullValue(input);
		validateEmptyValue(limit);
		int len = getLength(input);
		if(len<limit){
			throw new StringBuilderException("Invalid Input: Minimum of "+limit+" characters to be given");
		}
	}
	
	public static int getLength(CharSequence input) throws TaskException {
			validateNullValue(input);
			return input.length();
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
	
	public static StringBuilder appendString(StringBuilder strBuilder, String str) throws TaskException{
		validateNullValue(strBuilder);
		validateNullValue(str);
		return strBuilder.append(str);
	}
	
	public static String convertToString(StringBuilder strBuilder) throws TaskException{
		validateNullValue(strBuilder);
		return strBuilder.toString();
	}
}