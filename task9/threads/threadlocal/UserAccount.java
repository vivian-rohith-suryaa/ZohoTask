package task9.threads.threadlocal;

public class UserAccount {
	
	
	public static void main(String[] args) {
		
		Runnable userOne = () ->{
			BankRegister.depositAmount(1000.00);
			BankRegister.withdrawAmount(500.00);
			BankRegister.getBalance();
			BankRegister.clearThreadLocal();
		};
		
		Runnable userTwo = () ->{
			BankRegister.depositAmount(10000.00);
			BankRegister.withdrawAmount(7500.00);
			BankRegister.getBalance();
			BankRegister.clearThreadLocal();
		};
		
		Thread t1 = new Thread(userOne,"Vivian");
		Thread t2 = new Thread(userTwo,"Rohith");
		
		t1.start();
		t2.start();
		
	}
	

}
