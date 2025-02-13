package task9.threads.task;

import java.util.logging.Logger;
import utility.TaskUtility;

public class ExtendedThread extends Thread{
	
	private static final Logger LOG = TaskUtility.createLogger(ExtendedThread.class.getName());
	private String threadName;
	private int delay;
	private boolean loop;
	
	private volatile boolean running = true;
	
	public ExtendedThread() {}
	public ExtendedThread(String threadName,int delay,boolean loop) {
		super(threadName);
		this.threadName=threadName;
		this.delay=delay;
		this.loop=loop;
	}
	@Override
	public void run() {
		
		if(loop == true) {
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
		else {
			LOG.info("Name of the thread: "+Thread.currentThread().getName());
			LOG.info("Priority of the thread: "+Thread.currentThread().getPriority());
			LOG.info("State of the thread: "+Thread.currentThread().getState());
		}
	}
	
	public void setRunning(boolean value) {
		running = value;
	}
}
