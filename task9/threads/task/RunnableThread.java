package task9.threads.task;

import java.util.logging.Logger;
import task9.threads.logger.ThreadLogger;

public class RunnableThread implements Runnable{
	
	private static final Logger LOG = ThreadLogger.createLogger();
	private String threadName;
	private long delay;
	
	private boolean running = true;
	
	public RunnableThread() {}
	public RunnableThread(String threadName,long delay) {
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
	
	public void setRunnable(boolean value) {
		running = value;
	}

}
