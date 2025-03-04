package task9.threads.threadlocal;

public class Fourth {
	
	public void getUser() {
		System.out.println(First.user.get()+" is called by a method in Class Fourth()");
	}
	
//	public static void main(String[] args) {
//		First fst = new First();
//		
//		Runnable userOne = ()->{
//			fst.getUser("Vivian");
//			First.removeThreadLocal();
//		};
//		
//		Runnable userTwo = ()->{
//			fst.getUser("Rohith");
//			First.removeThreadLocal();
//		};
//		
//		Thread t1 = new Thread(userOne);
//		Thread t2 = new Thread(userTwo);
//		t1.start();
//		t2.start();
//	}
	
}
