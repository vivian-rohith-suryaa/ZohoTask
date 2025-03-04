package task9.threads.threadlocal;

public class First {
	
	protected static ThreadLocal<String> user = new ThreadLocal<String>();
	
	public void getUser(String name) {
		user.set(name);
		System.out.println(user.get()+" is called by a method in Class First()");
		Second sec = new Second();
		sec.getUser();
	}
	
	public static void removeThreadLocal() {
		user.remove();
	}
	
	public static void main(String[] args) {
		First fst = new First();
		
		Runnable userOne = ()->{
			fst.getUser("Vivian");
			First.removeThreadLocal();
		};
		
		Runnable userTwo = ()->{
			fst.getUser("Rohith");
			First.removeThreadLocal();
		};
		
		Thread t1 = new Thread(userOne);
		Thread t2 = new Thread(userTwo);
		t1.start();
		t2.start();
	}

}
