package exceptions.custom;

import exceptions.taskexception.TaskException;

public class CustomException extends TaskException{
	
	private static final long serialVersionUID = 1L;

	public CustomException(String message){
		super(message);
	}
	
	public CustomException(String message,Throwable cause){
		super(message,cause);
	}
}
