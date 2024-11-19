package utility;

import java.util.Scanner;
import exception.StringException;

public class StringUtility{
	
	public Scanner scan = new Scanner(System.in);
		
	public void validateNullString(String input) throws StringException {
        if (input == null) {
            throw new StringException("Invalid String: Null value is given.");
        }
    }

    public void validateEmptyString(int length) throws StringException {
        if (length == 0) {
            throw new StringException("Invalid String: Empty value is given.");
        }
    }

    public void validateIndexInBounds(int index, int length) throws StringException {
		validateEmptyString(length);
        if (index < 0 || index >= length) {
            throw new StringException("Invalid index: Exceeds string length or out of bounds.");
        }
    }
	
	public int getLength(String input) throws StringException {
        try{
			validateNullString(input);
			return input.length();
		}
		catch(StringException e){
			throw new StringException("Exception caught in StringUtility Class - getLength method",e);
		}
    }
	
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