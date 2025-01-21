package arraylisttask;

import taskexception.TaskException;
import nullexception.NullValueException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import stringexception.StringException;
import indexexception.IndexBoundException;
import minimumcharexception.MinimumCharException;
import utility.TaskUtility;
import custom.Custom;

public class ALTask{
	
	public <T> ArrayList<T> getArrayList(){
		return new ArrayList<>();
	}
	
	public <T> Iterator<T> getIterator(ArrayList<T> arrList) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		return arrList.iterator();
	}
	
	public <T> int getALSize(ArrayList<T> arrList) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		return arrList.size();
	}
	
	public <T> void addElement(ArrayList<T> arrList, T element) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		TaskUtility.validateNullValue(element);
		arrList.add(element);
	}
	
	public <T> int getElementIndex(ArrayList<T> arrList, T element) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		TaskUtility.validateNullValue(element);
		return arrList.indexOf(element);		
	}
	
	public <T> T getElementAtIndex(ArrayList<T> arrList, int index) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		TaskUtility.validateNullValue(index);
		return arrList.get(index);
	}
	
	public <T> int getElementLastIndex(ArrayList<T> arrList, T element) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		TaskUtility.validateNullValue(element);
		return arrList.lastIndexOf(element);		
	}
	
	public <T> void addElementAtIndex(ArrayList<T> arrList, T element,int index) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		TaskUtility.validateNullValue(element);
		TaskUtility.validateNullValue(index);
		arrList.add(index,element);
	}
	
	public <T> List<T> createArrListOfPosition(ArrayList<T> arrList,int start,int end) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		TaskUtility.validateNullValue(start);
		TaskUtility.validateNullValue(end);
		return arrList.subList(start,end);
	}
	
	public <T> int getListSize(List<T> list) throws TaskException{
		TaskUtility.validateNullValue(list);
		return list.size();
	}
	
	public <T> ArrayList<T> addArrLists(ArrayList<T> first,ArrayList<T> second,ArrayList<T> arrList3) throws TaskException{
		TaskUtility.validateNullValue(first);
		TaskUtility.validateNullValue(second);
		TaskUtility.validateNullValue(arrList3);
		arrList3.addAll(first);
		arrList3.addAll(second);
		return arrList3;
	}
	
	public <T> void removeElementAtIndex(ArrayList<T> arrList, int position) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		TaskUtility.validateNullValue(position);
		arrList.remove(position);
	}
	
	public <T> void removeArrListElements(ArrayList<T> arrList1, ArrayList<T> arrList2) throws TaskException{
		TaskUtility.validateNullValue(arrList1);
		TaskUtility.validateNullValue(arrList2);
		arrList1.removeAll(arrList2);
	}
	
	public <T> void retainArrListElements(ArrayList<T> arrList1, ArrayList<T> arrList2) throws TaskException{
		TaskUtility.validateNullValue(arrList1);
		TaskUtility.validateNullValue(arrList2);
		arrList1.retainAll(arrList2);
	}
	
	public <T> void clearAllElements(ArrayList<T> arrList) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		arrList.clear();
	}
	
	public <T> boolean checkElement(ArrayList<T> arrList,T element) throws TaskException{
		TaskUtility.validateNullValue(arrList);
		TaskUtility.validateNullValue(element);
		return arrList.contains(element);
	}
}