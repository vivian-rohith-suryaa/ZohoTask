package nullexception;
import taskexception.TaskException;

public class NullValueException extends TaskException{
	
	public NullValueException(String message){
		super(message);
	}
	
	public NullValueException (String message, Throwable cause){
		super(message,cause);
	}
}