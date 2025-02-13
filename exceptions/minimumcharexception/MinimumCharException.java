package exceptions.minimumcharexception;

import exceptions.taskexception.TaskException;

public class MinimumCharException extends TaskException{
	
	private static final long serialVersionUID = 1L;

	public MinimumCharException(String message){
		super(message);
	}
	
	public MinimumCharException(String message,Throwable cause){
		super(message,cause);
	}
}
