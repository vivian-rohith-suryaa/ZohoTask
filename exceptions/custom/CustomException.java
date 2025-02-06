package exceptions.custom;

import exceptions.taskexception.TaskException;

public class CustomException extends TaskException{
	
	public CustomException(String message){
		super(message);
	}
	
	public CustomException(String message,Throwable cause){
		super(message,cause);
	}
}
