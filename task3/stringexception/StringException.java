package task3.stringexception;

import exceptions.taskexception.TaskException;

public class StringException extends TaskException{
	
	public StringException(String message){
		super(message);
	}
	
	public StringException (String message, Throwable cause){
		super(message,cause);
	}
}