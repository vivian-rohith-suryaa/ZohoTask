package task8.files.singletons;

import java.io.Serializable;
import exceptions.custom.CustomException;

public class ThreadSafeSingleton implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static volatile ThreadSafeSingleton tsInst;
	
	private ThreadSafeSingleton() throws CustomException {
		if(tsInst!=null) {
			throw new CustomException("Instance already exists.");
		}
	}
	
	public static synchronized ThreadSafeSingleton getInstance() throws CustomException {
		
		if(tsInst==null) {
			tsInst=new ThreadSafeSingleton();
		}
		
		return tsInst;
		
	}
	protected Object readResolve() {
		return tsInst;
		
	}
}
