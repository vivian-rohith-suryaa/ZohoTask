package task3.stringexception;

import exceptions.taskexception.TaskException;

public class StringException extends TaskException{
	
	private static final long serialVersionUID = 1L;

	public StringException(String message){
		super(message);
	}
	
	public StringException (String message, Throwable cause){
		super(message,cause);
	}
}