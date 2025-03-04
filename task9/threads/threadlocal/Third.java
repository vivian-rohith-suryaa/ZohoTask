package task9.threads.threadlocal;

public class Third {
	
	public void getUser() {
		System.out.println(First.user.get()+" is called by a method in Class Third()");
		Fourth frh = new Fourth();
		frh.getUser();
	}
	
}
