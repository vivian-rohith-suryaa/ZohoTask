package hashmaptask;

import taskexception.TaskException;
import nullexception.NullValueException;
import stringexception.StringException;
import indexexception.IndexBoundException;
import minimumcharexception.MinimumCharException;
import utility.TaskUtility;
import java.util.Map;
import java.util.HashMap;

public class HMTask{
	
	public <K,V> Map<K,V> getMap(){
		return new HashMap<K,V>();
	}
	
	public <K,V> int getSize(Map<K,V> map) throws TaskException{
		
		TaskUtility.validateNullValue(map);
		return map.size();
	}
}