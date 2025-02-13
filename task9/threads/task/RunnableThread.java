package task9.threads.task;

import java.util.logging.Logger;
import task9.threads.logger.ThreadLogger;

public class RunnableThread implements Runnable{
	
	private static final Logger LOG = ThreadLogger.createLogger();
	private String threadName;
	private long delay;
	private boolean loop;
	
	private boolean running = true;
	
	public RunnableThread() {}
	public RunnableThread(String threadName,long delay,boolean loop) {
		this.threadName=threadName;
		this.delay=delay;
		this.loop = loop;
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
	
	public void setRunnable(boolean value) {
		running = value;
	}

}
