package exceptions.minimumcharexception;

import exceptions.taskexception.TaskException;

public class MinimumCharException extends TaskException{
	
	public MinimumCharException(String message){
		super(message);
	}
	
	public MinimumCharException(String message,Throwable cause){
		super(message,cause);
	}
}
