package exceptions.nullexception;

import exceptions.taskexception.TaskException;

public class NullValueException extends TaskException{
	
	private static final long serialVersionUID = 1L;

	public NullValueException(String message){
		super(message);
	}
	
	public NullValueException (String message, Throwable cause){
		super(message,cause);
	}
}