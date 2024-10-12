package stringexception;
import java.io.IOException;

public class NullStringException extends Exception{
	
	public NullStringException(String message){
		super(message);
	}
}