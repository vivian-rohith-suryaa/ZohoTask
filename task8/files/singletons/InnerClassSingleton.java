package task8.files.singletons;

import java.io.Serializable;

public class InnerClassSingleton implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private InnerClassSingleton() {
		if(InnerSingleton.icInst!=null) {
			throw new IllegalStateException("Instance already exists.");
		}
	}
	
	private static class InnerSingleton{
		
		private static final InnerClassSingleton icInst = new InnerClassSingleton();
	}
	
	public static InnerClassSingleton getInstance() {
		return InnerSingleton.icInst;
	}
	
	protected Object readResolve() {
		return InnerClassSingleton.getInstance();
		
	}

}
