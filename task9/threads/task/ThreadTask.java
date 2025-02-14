package task9.threads.task;

import java.util.List;
import exceptions.taskexception.TaskException;
import utility.TaskUtility;

public class ThreadTask {
	
	public void setThreadPriority(Thread thread,int priority) throws TaskException {
		TaskUtility.validateNullValue(thread);
		TaskUtility.validateNullValue(priority);
		thread.setPriority(priority);
		
	}
	
	public void setThreadName(Thread thread,String name) throws TaskException {
		TaskUtility.validateNullValue(thread);
		TaskUtility.validateNullValue(name);
		thread.setName(name);
	}
	
	public void runThreads(List<Thread> threadList,Thread thread)throws TaskException {
		TaskUtility.validateNullValue(threadList);
		TaskUtility.validateNullValue(thread);
		threadList.add(thread);
		thread.start();
	}
	
	public void isThreadAlive(List<Thread> threadList) throws TaskException, InterruptedException{
		TaskUtility.validateNullValue(threadList);
		boolean allThreadsExited = false;
	    
	    while(!allThreadsExited) {
	    	allThreadsExited = true;
	    	
	    	for(Thread thread : threadList) {
	    		if(thread.isAlive()) {
	    			allThreadsExited = false;
	    			break;
	    		}
	    	}
	    	if(!allThreadsExited) {
	    		Thread.sleep(5000);
	    	}
	    }
		
	}
	
}
