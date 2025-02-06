package task8.files.singletons;

import java.io.Serializable;
import exceptions.custom.CustomException;

public class LazySingleton implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static volatile LazySingleton lazyInst;
	
	private LazySingleton() throws CustomException{
		if(lazyInst!=null) {
			throw new IllegalStateException("Instance already exists.");
		}
	}
	
	public static LazySingleton getInstance() throws CustomException {
		if(lazyInst==null) {
			lazyInst= new LazySingleton();					
		}
		return lazyInst;
	}
	
	protected Object readResolve() {
		return lazyInst;
		
	}
	
}
