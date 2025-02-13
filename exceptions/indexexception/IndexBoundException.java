package exceptions.indexexception;

import exceptions.taskexception.TaskException;

public class IndexBoundException extends TaskException{
	
	private static final long serialVersionUID = 1L;

	public IndexBoundException(String message){
		super(message);
	}
	
	public IndexBoundException(String message, Throwable cause){
		super(message,cause);
	}
}
