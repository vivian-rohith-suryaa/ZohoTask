package stringbuildertask;

import taskexception.TaskException;
import nullexception.NullValueException;
import indexexception.IndexBoundException;
import utility.TaskUtility;
import minimumcharexception.MinimumCharException;

public class StringBuilderTask{
	
	public int len;
	
	public StringBuilder getStringBuilder() throws TaskException{
		return new StringBuilder();
	}
	
	public void appendDelimiter(StringBuilder strBuilder, String delimiter,String helperStr) throws TaskException{
		TaskUtility.validateNullValue(strBuilder);
		TaskUtility.validateNullValue(delimiter);
		TaskUtility.validateNullValue(helperStr);
		strBuilder.append(delimiter).append(helperStr);
	}
	
	public void insertAtPosition(StringBuilder strBuilder, String helperStr, String delimiter, int position) throws TaskException {
		TaskUtility.validateNullValue(helperStr);
		int delimiterLen = TaskUtility.getLength(delimiter);
		int len = TaskUtility.getLength(strBuilder);
		TaskUtility.validateIndexInBounds(position, len);
		int insertPosition;
		if (position == 1) {
			insertPosition = 0;
		}
		else {
			insertPosition = getDelimiterIndex(strBuilder,delimiter,position-1);
			insertPosition+=delimiterLen;
		}
		strBuilder.insert(insertPosition, helperStr+delimiter);
	}
		
	public void deleteAtPosition(StringBuilder strBuilder,String delimiter, int position) throws TaskException{
		int delimiterLen = TaskUtility.getLength(delimiter);
		int len = TaskUtility.getLength(strBuilder);
		TaskUtility.validateIndexInBounds(position, len);
		int startIndex = getDelimiterIndex(strBuilder,delimiter,position-1);
		int endIndex = getDelimiterIndex(strBuilder, delimiter, position);
		if (position == 1) {
			endIndex = endIndex+delimiterLen;
		}
		else if(endIndex == -1){
			endIndex = len;
		}
		strBuilder.delete(startIndex,endIndex);
	}

	public void replaceDelimiter(StringBuilder strBuilder, String splitterDelimiter, String replacerDelimiter) throws TaskException {
		TaskUtility.validateNullValue(splitterDelimiter);
		TaskUtility.validateNullValue(replacerDelimiter);
		len = TaskUtility.getLength(strBuilder);
		int delimiterLen = TaskUtility.getLength(splitterDelimiter);
		boolean loop = true;
		int position = 0;
		while(loop){
			int index = getIndexNumber(strBuilder,splitterDelimiter,position);
			if(index>=0){
				strBuilder = strBuilder.replace(index,(index+delimiterLen),replacerDelimiter);
			}
			else{
				loop = false;
			}
		}
	}
	
	public void reverseStrBuilder (StringBuilder strBuilder) throws TaskException{
		TaskUtility.validateNullValue(strBuilder);
		strBuilder.reverse();
	}

	public void deleteChars(StringBuilder strBuilder,int startValue,int endValue) throws TaskException{
		len = TaskUtility.getLength(strBuilder);
		TaskUtility.validateIndexInBounds(startValue,len);
		TaskUtility.validateIndexInBounds(endValue,len);
		strBuilder.delete(startValue-1,endValue);
	}

	public void insertChars(StringBuilder strBuilder,int startValue,int endValue, String replacerString) throws TaskException{
		len = TaskUtility.getLength(strBuilder);
		TaskUtility.validateNullValue(replacerString);
		TaskUtility.validateIndexInBounds(startValue,len);
		TaskUtility.validateIndexInBounds(endValue,len);
		strBuilder.replace(startValue,endValue,replacerString);
	}

	public int getFirstIndexOf(StringBuilder strBuilder,String delimiter) throws TaskException{
		TaskUtility.validateNullValue(strBuilder);
		TaskUtility.validateNullValue(delimiter);
		return strBuilder.indexOf(delimiter);
	}
	
	public int getLastIndexOf(StringBuilder strBuilder,String delimiter) throws TaskException{
		TaskUtility.validateNullValue(strBuilder);
		TaskUtility.validateNullValue(delimiter);
		return strBuilder.lastIndexOf(delimiter);
	}
	
	public int getDelimiterIndex(StringBuilder strBuilder, String delimiter, int position) throws TaskException {
		int index = 0;
		int start = 0;
		for(int i = 0;i<position;i++){
			index = strBuilder.indexOf(delimiter,start);
			 if (index == -1) {
				throw new TaskException("Delimiter not found.");
			}
			start = index+TaskUtility.getLength(delimiter);
		}
		return index;
	}
	
	public int getIndexNumber (StringBuilder strBuilder,String delimiter, int position) throws TaskException{
		return strBuilder.indexOf(delimiter,position);
	}
	
		
}
	