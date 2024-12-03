package stringbuilderexception;
import taskexception.TaskException;

public class StringBuilderException extends TaskException{
	
	public StringBuilderException(String message){
		super(message);
	}
	
	public StringBuilderException(String message,Throwable cause){
		super(message,cause);
	}
}
		