package task8.files.singletons;

import java.io.Serializable;

import exceptions.custom.CustomException;

public class DoubleCheckSingleton implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static volatile DoubleCheckSingleton dcInst;
	
	private DoubleCheckSingleton() throws CustomException {
		if(dcInst!=null) {
			throw new CustomException("Instance already exists.");
		}
	};
	
	public static DoubleCheckSingleton getInstance() throws CustomException {
		
		if(dcInst == null) {
			synchronized(DoubleCheckSingleton.class) {
				if(dcInst == null) {
					dcInst = new DoubleCheckSingleton();
				}
			}
			
		}
		return dcInst;
	}
	
	protected Object readResolve() {
		return dcInst;
		
	}
	
}
