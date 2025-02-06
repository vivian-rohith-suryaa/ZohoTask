package task8.files.singletons;

import java.io.Serializable;

public class EarlySingleton implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static final EarlySingleton earlyInst = new EarlySingleton();
	
	private EarlySingleton(){
		if(earlyInst!=null) {
			throw new IllegalStateException("Instance already exists.");
		}
	}

	public  static EarlySingleton getInstance() {
		return earlyInst;
	}
	
	protected Object readResolve() {
		return earlyInst;
	}
}
