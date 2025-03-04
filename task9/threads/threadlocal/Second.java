package task9.threads.threadlocal;

public class Second {
	
	public void getUser() {
		System.out.println(First.user.get()+" is called by a method in Class Second()");
		Third trd = new Third();
		trd.getUser();
	}
	
}
