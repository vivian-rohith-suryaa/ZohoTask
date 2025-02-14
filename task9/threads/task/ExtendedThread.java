package task9.threads.task;

import java.util.logging.Logger;
import task9.threads.logger.ThreadLogger;
import utility.TaskUtility;

public class ExtendedThread extends Thread{
	
	private static final Logger LOG = ThreadLogger.createLogger();
	private String threadName;
	private long delay;
	
	private boolean running = true;
	
	public ExtendedThread() {}
	public ExtendedThread(String threadName,long delay) {
		super(threadName);
		this.threadName=threadName;
		this.delay=delay;
	}
	@Override
	public void run() {
		
		LOG.info("Name of the thread: "+Thread.currentThread().getName()+" Priority of the thread: "+Thread.currentThread().getPriority()+" State of the thread: "+Thread.currentThread().getState());
		while(running) {
			LOG.info("Going to sleep: "+threadName+" for: "+delay+" ms.");
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				LOG.info("Exception in Thread sleeping"+e.getMessage());
			}
			LOG.info("After sleeping: "+threadName);
		}
		
		LOG.info(threadName+" is stopped.");
	}
	
	public void setRunning(boolean value) {
		running = value;
	}
	
	public synchronized void checkSyncThreadState () throws InterruptedException{
		
		LOG.info("Current Thread: "+Thread.currentThread().getName());
		TaskUtility.getAllThreadDump(LOG);
		Thread.sleep(30000);		
	}
}
