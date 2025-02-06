package task8.files.singletons;

import java.io.Serializable;

public class StaticSingleton implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static volatile StaticSingleton staticInst;
	
	private StaticSingleton() {};
	
	static {
		
		try {
			staticInst= new StaticSingleton();
		}
		catch(Exception e) {
			System.out.println("Exception occured in creating the Static singleton class");
		}
	}
	
	public static StaticSingleton getInstance() {
		return staticInst;
	}
	
	protected Object readResolve() {
		return staticInst;
		
	}
}
