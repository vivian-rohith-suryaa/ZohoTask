package task9.threads.threadlocal;

public class BankRegister {
	
	private static ThreadLocal<Double> balance = ThreadLocal.withInitial(()->0.00);	
	
	public static void depositAmount(double amount) {
		balance.set(balance.get()+amount);
		System.out.println(Thread.currentThread().getName()+" deposited "+amount+" .");
		
	}
	
	public static void withdrawAmount(double amount) {
		balance.set(balance.get()-amount);
		System.out.println(Thread.currentThread().getName()+" withdrawn "+amount+" .");
	}
	
	public static void getBalance() {
		System.out.println(Thread.currentThread().getName()+" - Balance: "+balance.get());
	}
	
	public static void clearThreadLocal() {
		balance.remove();
	}
	
}
