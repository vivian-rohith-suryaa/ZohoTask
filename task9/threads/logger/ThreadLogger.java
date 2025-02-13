package task9.threads.logger;

import java.util.logging.Logger;

public class ThreadLogger {

	public static Logger createLogger(){
		return Logger.getLogger(ThreadLogger.class.getName());
	}
	
}
