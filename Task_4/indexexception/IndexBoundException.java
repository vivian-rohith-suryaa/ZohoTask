package indexexception;
import taskexception.TaskException;

public class IndexBoundException extends TaskException{
	
	public IndexBoundException(String message){
		super(message);
	}
	
	public IndexBoundException(String message, Throwable cause){
		super(message,cause);
	}
}
