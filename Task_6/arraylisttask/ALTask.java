package arraylisttask;

import taskexception.TaskException;
import nullexception.NullValueException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import stringexception.StringException;
import indexexception.IndexBoundException;
import minimumcharexception.MinimumCharException;
import utility.TaskUtility;
import custom.Custom;

public class ALTask{
	
	public <T> List<T> getArrayList(){
		return new ArrayList<>();
	}
	
	public <T> Iterator<T> getIterator(List<T> arrList) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		return arrList.iterator();
	}
	
	public <T> int getSize(List<T> arrList) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		return arrList.size();
	}
	
	public <T> void addElement(List<T> arrList, T element) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		TaskUtility.validateNullValue(element);
		arrList.add(element);
	}
	
	public <T> int getElementIndex(List<T> arrList, T element) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		TaskUtility.validateNullValue(element);
		return arrList.indexOf(element);		
	}
	
	public <T> T getElementAtIndex(List<T> arrList, int index) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		TaskUtility.validateNullValue(index);
		return arrList.get(index);
	}
	
	public <T> int getElementLastIndex(List<T> arrList, T element) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		TaskUtility.validateNullValue(element);
		return arrList.lastIndexOf(element);		
	}
	
	public <T> void addElementAtIndex(List<T> arrList, T element,int index) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		TaskUtility.validateNullValue(element);
		TaskUtility.validateNullValue(index);
		arrList.add(index,element);
	}
	
	public <T> List<T> createListByPositions(List<T> arrList,int start,int end) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		TaskUtility.validateNullValue(start);
		TaskUtility.validateNullValue(end);
		return arrList.subList(start,end);
	}
	
	
	public <T> List<T> addLists(List<T> first,List<T> second) throws TaskException{
		TaskUtility.validateNullValue(first);
		TaskUtility.validateNullValue(second);
		first.addAll(second);
		return first;
	}
	
	public <T> void removeElementAtIndex(List<T> arrList, int position) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		TaskUtility.validateNullValue(position);
		arrList.remove(position);
	}
	
	public <T> void removeListElements(List<T> arrList1, List<T> arrList2) throws TaskException{
		TaskUtility.validateNullValue(arrList1);
		TaskUtility.validateNullValue(arrList2);
		arrList1.removeAll(arrList2);
	}
	
	public <T> void retainListElements(List<T> arrList1, List<T> arrList2) throws TaskException{
		TaskUtility.validateNullValue(arrList1);
		TaskUtility.validateNullValue(arrList2);
		arrList1.retainAll(arrList2);
	}
	
	public <T> void clearAllElements(List<T> arrList) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		arrList.clear();
	}
	
	public <T> boolean checkElement(List<T> arrList,T element) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		TaskUtility.validateNullValue(element);
		return arrList.contains(element);
	}
}