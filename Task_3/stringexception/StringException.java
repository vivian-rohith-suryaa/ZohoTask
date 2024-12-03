package stringexception;
import taskexception.TaskException;

public class StringException extends TaskException{
	
	public StringException(String message){
		super(message);
	}
	
	public StringException (String message, Throwable cause){
		super(message,cause);
	}
}