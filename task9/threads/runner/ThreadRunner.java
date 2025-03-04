package task9.threads.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import exceptions.taskexception.TaskException;
import task9.threads.logger.ThreadLogger;
import task9.threads.task.ExtendedThread;
import task9.threads.task.RunnableThread;
import task9.threads.task.ThreadTask;
import utility.TaskUtility;

public class ThreadRunner {
	
	private static final Logger LOG = ThreadLogger.createLogger();
	static {
		showTasks();
			try {
				TaskUtility.setupLogger(LOG);
			} catch (TaskException e) {
				LOG.severe("Exception in creating a Logger");
			}
	}
	
	public static void main(String[] args) {
		
		ThreadRunner runnerObj = new ThreadRunner();
		boolean loop = true;
		
		while(loop) {
			System.out.println("Enter the sequence number for the exercise (1-7, or 0 to exit):");
			int sequenceNumber = TaskUtility.getIntInput();
			if(sequenceNumber==0) {
				LOG.info("Exiting the program!!!!");
				loop = false;
			}
			else {
				try {
					switch(sequenceNumber) {
						
						case 1:
							runnerObj.runCaseOne();
							break;
							
						case 2:
							runnerObj.runCaseTwo();
							break;
							
						case 3:
							runnerObj.runCaseThree();
							break;
							
						case 4:
						case 5:
							runnerObj.runCaseFour();
							break;
							
						case 6:
							runnerObj.runCaseSix();
							break;
							
						case 7:
							runnerObj.runCaseSeven();
							break;
							
						case 8:
							runnerObj.runCaseEight();
							break;
							
						default:
							LOG.info("Please choose between numbers 1 to 7.");
							break;
					}
				}
				
				catch(Exception e) {
					LOG.severe("Exception caught in main method: "+e.getMessage());
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void showTasks() {
		System.out.println("1. Create a ExtendedThread Class which extends Thread class and override run method to print its name,priority and state before and after using the start() method.");
		System.out.println("2. Create a RunnableThread Class which implements Runnable class and override run method to print its name,priority and state before and after using the start() method.");
		System.out.println("3. Providing the names for the threads form ExtendedThread and RunnableThread and calling run method to print its name,priority and state before and after using the start() method.");
		System.out.println("4. Create multiple threads and use sleep method to give a certain delay.");
		System.out.println("5. Giving each thread a name and seperate delay.");
		System.out.println("6. Creating threads for both classes and making them to run in a loop for a period of time and then stoping them. Thread Dumps are taken at intervals of time during the execution.");
		System.out.println("7. Creating threads for both classes and making them to run in a loop for a period of time and then stoping them one at a time. Thread Dumps are taken at intervals of time during and after execution.");
		System.out.println("8. Taking a Thread Dump for a synchronized method and also viewing the states of  various threads.");
	}
	
	public void runCaseOne() throws TaskException{
		
		ThreadTask taskObj = new ThreadTask();
		ExtendedThread exThread = new ExtendedThread();
		LOG.info("run() method called before invoking the start() method.");
		exThread.run();
		System.out.println("Enter the value of priority to set to the thread: ");
		int priority = TaskUtility.getIntInput();
		taskObj.setThreadPriority(exThread,priority);
		LOG.info("run() method called after invoking the start() method.");
		exThread.start();
		
	}
	
	public void runCaseTwo() throws TaskException {
		
		ThreadTask taskObj = new ThreadTask();
		RunnableThread thread = new RunnableThread();
		Thread runThread = new Thread(thread);
		LOG.info("run() method called before invoking the start() method.");
		runThread.run();
		System.out.println("Enter the value of priority to set to the thread: ");
		int priority = TaskUtility.getIntInput();
		taskObj.setThreadPriority(runThread,priority);
		LOG.info("run() method called after invoking the start() method.");
		runThread.start();

	}
	
	public void runCaseThree() throws InterruptedException,TaskException {
		
		ThreadTask taskObj = new ThreadTask();
		ExtendedThread exThread = new ExtendedThread();
		RunnableThread thread = new RunnableThread();
		Thread runThread = new Thread(thread);
		
		LOG.info("ExtendedThread Class's run() method called before invoking the start() method.");
		exThread.run();

		LOG.info("Runnable Class's run() method called before invoking the start() method.");
		runThread.run();
		
		System.out.println("Enter the name to be set for the ExtendedThread Class's thread: ");
		String exThreadName = TaskUtility.getStringInput();
		taskObj.setThreadName(exThread,exThreadName);
		System.out.println("Enter the name to be set for the RunnableThread Class's thread: ");
		String runThreadName = TaskUtility.getStringInput();
		taskObj.setThreadName(runThread,runThreadName);
		
		System.out.println("Enter the value of priority to set for the threads: ");
		int priority = TaskUtility.getIntInput();
		taskObj.setThreadPriority(exThread,priority);
		taskObj.setThreadPriority(runThread,priority);
		
		LOG.info("ExtendedThread Class's run() method called after invoking the start() method.");
		exThread.start();

		LOG.info("Runnable Class's run() method called after invoking the start() method.");
		runThread.start();

	}
	
	public void runCaseFour() throws InterruptedException, TaskException {
		
		ThreadTask taskObj = new ThreadTask();
		List<Thread> threadList = new ArrayList<>();
		List<Long> exThreadDelay = new ArrayList<>();
		List<Long> runThreadDelay = new ArrayList<>();
		
		System.out.println("Enter the number of threads to create for ExtendedThread Classes: ");
		int exThreadCount = TaskUtility.getIntInput();
		
		for(int i = 0; i<exThreadCount;i++) {
			System.out.println("Enter the time of delay for thread "+(i+1)+": ");
			long delay = TaskUtility.getLongInput();
			exThreadDelay.add(delay);
		}
		
		System.out.println("Enter the number of threads to create for RunnableThread Classes: ");
		int runThreadCount = TaskUtility.getIntInput();
		
		for(int i=0;i<runThreadCount;i++) {
			System.out.println("Enter the time of delay for thread "+(i+1)+": ");
			long delay = TaskUtility.getLongInput();
			runThreadDelay.add(delay);
		}
		
		for(int i = 1;i<=exThreadCount;i++) {
			ExtendedThread exThread = new ExtendedThread("ExtendThread-"+i,exThreadDelay.get(i-1));
			taskObj.runThreads(threadList, exThread);
			Thread.sleep(exThreadDelay.get(i-1));
			exThread.setRunning(false);
		}
		
		for(int i = 1;i<=runThreadCount;i++) {
			RunnableThread thread = new RunnableThread("RunnableThread-"+i,runThreadDelay.get(i-1));
			Thread runThread = new Thread(thread);
			taskObj.runThreads(threadList, runThread);
			Thread.sleep(runThreadDelay.get(i-1));
			thread.setRunnable(false);
		}
		
	}
	
	public void runCaseSix() throws InterruptedException, TaskException {
		
		ThreadTask taskObj = new ThreadTask();
		
		List<Thread> threadList = new ArrayList<>();
		
		List<ExtendedThread> exThreadObjList = new ArrayList<>();
		List<RunnableThread> runThreadObjList = new ArrayList<>();
		
		List<Long> exThreadDelay = new ArrayList<>();
		List<Long> runThreadDelay = new ArrayList<>();
		
		
		System.out.println("Enter the number of threads to create for ExtendedThread Classes: ");
		int exThreadCount = TaskUtility.getIntInput();
		
		for(int i = 0; i<exThreadCount;i++) {
			System.out.println("Enter the time of delay for thread "+(i+1)+": ");
			long delay = TaskUtility.getLongInput();
			exThreadDelay.add(delay);
		}
		
		System.out.println("Enter the number of threads to create for RunnableThread Classes: ");
		int runThreadCount = TaskUtility.getIntInput();
		
		for(int i=0;i<runThreadCount;i++) {
			System.out.println("Enter the time of delay for thread "+(i+1)+": ");
			long delay = TaskUtility.getLongInput();
			runThreadDelay.add(delay);
		}
		
		for(int i = 1;i<=exThreadCount;i++) {

			ExtendedThread exThread = new ExtendedThread("ExtendThread-"+i,exThreadDelay.get(i-1));
			exThreadObjList.add(exThread);
			taskObj.runThreads(threadList, exThread);
		}
		
		for(int i = 1;i<=runThreadCount;i++) {
			RunnableThread thread = new RunnableThread("RunnableThread-"+i,runThreadDelay.get(i-1));
			Thread runThread = new Thread(thread,"RunnableThread-"+i);
			runThreadObjList.add(thread);
			taskObj.runThreads(threadList, runThread);
		}
		
		Thread.sleep(1000);
		
		for (int i = 1; i <= 3; i++) {
			LOG.info("\nTaking Thread Dump #" + i);
			TaskUtility.getThreadDump(LOG);
			TaskUtility.getAllThreadDump(LOG);
	        Thread.sleep(3000);
	    }

	    for (ExtendedThread thread : exThreadObjList) {
	        thread.setRunning(false);
	    }

	    for (RunnableThread thread : runThreadObjList) {
	        thread.setRunnable(false);
	    }

	    LOG.info("All threads stopped.");
	    System.out.println("======= Task 7 Done =======");
	}

	
	public void runCaseSeven() throws InterruptedException, TaskException {
		
		ThreadTask taskObj = new ThreadTask();
		
		List<Thread> threadList = new ArrayList<>();
		
		List<ExtendedThread> exThreadObjList = new ArrayList<>();
		List<RunnableThread> runThreadObjList = new ArrayList<>();
		
		List<Long> exThreadDelay = new ArrayList<>();
		List<Long> runThreadDelay = new ArrayList<>();
		
		System.out.println("Enter the number of threads to create for ExtendedThread Classes: ");
		int exThreadCount = TaskUtility.getIntInput();
		
		for(int i = 0; i<exThreadCount;i++) {
			System.out.println("Enter the time of delay for thread "+(i+1)+": ");
			long delay = TaskUtility.getLongInput();
			exThreadDelay.add(delay);
		}
		
		System.out.println("Enter the number of threads to create for RunnableThread Classes: ");
		int runThreadCount = TaskUtility.getIntInput();
		
		for(int i=0;i<runThreadCount;i++) {
			System.out.println("Enter the time of delay for thread "+(i+1)+": ");
			long delay = TaskUtility.getLongInput();
			runThreadDelay.add(delay);
		}
		
		for(int i = 1;i<=exThreadCount;i++) {
			ExtendedThread exThread = new ExtendedThread("ExtendThread-"+i,exThreadDelay.get(i-1));
			exThreadObjList.add(exThread);
			taskObj.runThreads(threadList, exThread);
		}
		
		for(int i = 1;i<=runThreadCount;i++) {
			RunnableThread thread = new RunnableThread("RunnableThread-"+i,runThreadDelay.get(i-1));
			Thread runThread = new Thread(thread,"RunnableThread-"+i);
			runThreadObjList.add(thread);
			taskObj.runThreads(threadList, runThread);
		}
		
		Thread.sleep(1000);
		
		for(int i=1;i<=10;i++) {
			LOG.info("\nTaking Thread Dump #"+i);
			TaskUtility.getThreadDump(LOG);
			TaskUtility.getAllThreadDump(LOG);
			Thread.sleep(4000);
		}
		
		for (ExtendedThread thread : exThreadObjList) {
	        thread.setRunning(false);
	        Thread.sleep(6000);
	    }

	    for (RunnableThread thread : runThreadObjList) {
	        thread.setRunnable(false);
	        Thread.sleep(6000);
	    }
		
	    taskObj.isThreadAlive(threadList);
	    
	    LOG.info("Tasks are completed!!!!!!");

	    TaskUtility.getThreadDump(LOG);

	    LOG.info("Final thread dump taken after all tasks completed.");
	    
	    System.out.println("======== Task 7 Done========");
		
	}
	
	public void runCaseEight() throws InterruptedException {
		ExtendedThread exThread = new ExtendedThread();
		
		for(int i =1; i<=5; i++) {
			Thread thread = new Thread (() -> {
				try {
					exThread.checkSyncThreadState();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			},"Thread -"+i);
			thread.start();
			Thread.sleep(10000);
			
		}
		TaskUtility.getAllThreadDump(LOG);
		System.out.println("======= Task 8 Done!!!!=======");
	}


}
