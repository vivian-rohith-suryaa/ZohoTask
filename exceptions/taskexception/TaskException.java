package exceptions.taskexception;

public class TaskException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public TaskException(String message){
		super(message);
	}
	
	public TaskException (String message, Throwable cause){
		super(message,cause);
	}
}