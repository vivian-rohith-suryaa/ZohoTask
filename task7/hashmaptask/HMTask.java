package task7.hashmaptask;

import exceptions.taskexception.TaskException;
import utility.TaskUtility;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class HMTask{
	
	public <K,V> Map<K,V> getMap(){
		return new HashMap<K,V>();
	}
	
	public <K,V> int getSize(Map<K,V> map) throws TaskException{
		
		TaskUtility.validateNullValue(map);
		return map.size();
	}
	
	public <K,V> void putKeyValue(Map<K,V> map, K key, V value) throws TaskException{
		
		TaskUtility.validateNullValue(map);
		map.put(key,value);
	}
	
	public <K,V> void replaceNullKeyValue(Map<K,V> map, K key,boolean order) throws TaskException{
		
		TaskUtility.validateNullValue(map);
		TaskUtility.validateNullValue(order);
		if(checkKey(map,key)){
			V value = removeKey(key,map);
			if(order){
				key = null;
			}
			else{
				value = null;
			}
			putKeyValue(map,key,value);
		}
	}
	
	public <K,V> boolean checkKey(Map<K,V> map,K key) throws TaskException{
		
		TaskUtility.validateNullValue(map);
		return map.containsKey(key);
	}
	
	public <K,V> boolean checkValue(Map<K,V> map,V value) throws TaskException{
		
		TaskUtility.validateNullValue(map);
		return map.containsValue(value);
	}
		
	public <K,V> V findValue(Map<K,V> map, K key) throws TaskException{
		
		TaskUtility.validateNullValue(map);
		return map.get(key);
	}
	
	public <K,V> void createNewValue(Map<K,V> map, K key,V value) throws TaskException{
		
		TaskUtility.validateNullValue(map);
		if(!(checkKey(map,key))){
			putKeyValue(map,key,value);
		}
	}
	
	public <K,V> void removeKey(Map<K,V> map, K key) throws TaskException{
		
		TaskUtility.validateNullValue(map);
		map.remove(key);
	}
	
	public <K,V> V removeKey(K key,Map<K,V> map) throws TaskException{
		
		TaskUtility.validateNullValue(map);
		return map.remove(key);
	}
	
	public <K,V> void removeKeyByMatchingValue(Map<K,V> map, K key,V value) throws TaskException{
		
		TaskUtility.validateNullValue(map);
		map.remove(key,value);
	}
	
	public <K,V> void replaceValue(Map<K,V> map, K key,V value) throws TaskException{
		
		TaskUtility.validateNullValue(map);
		map.replace(key,value);
	}
	
	public <K,V> void replaceOldByNewValue(Map<K,V> map, K key,V oldValue, V newValue) throws TaskException{
		
		TaskUtility.validateNullValue(map);
		map.replace(key,oldValue,newValue);
	}
	
	public <K,V> void transferKeyValue(Map<K,V> map,Map<K,V> newMap) throws TaskException{
		
		TaskUtility.validateNullValue(map);
		TaskUtility.validateNullValue(newMap);
		newMap.putAll(map);
	}
	
	public <K,V> Set<Map.Entry<K,V>> createEntrySet(Map<K,V> map) throws TaskException{
		
		TaskUtility.validateNullValue(map);
		return map.entrySet();
	}
	
	public <K,V> K returnKey(Map.Entry<K,V> mapEntry) throws TaskException{
		
		TaskUtility.validateNullValue(mapEntry);
		return mapEntry.getKey();
	}
	
	public <K,V> V returnValue(Map.Entry<K,V> mapEntry) throws TaskException{
		
		TaskUtility.validateNullValue(mapEntry);
		return mapEntry.getValue();
	}
	
	public <K,V> void clearMap(Map<K,V> map) throws TaskException{
		
		TaskUtility.validateNullValue(map);
		map.clear();
	}
	
}
