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
	
	public StringBuilder appendDelimiter(StringBuilder strBuilder, String delimiter,String helperStr) throws TaskException{
		TaskUtility.validateNullValue(strBuilder);
		TaskUtility.validateNullValue(delimiter);
		TaskUtility.validateNullValue(helperStr);
		return strBuilder.append(delimiter).append(helperStr);
	}
	
	public StringBuilder insertAtPosition(StringBuilder strBuilder, String helperStr, String delimiter, int position) throws TaskException {
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
		return strBuilder.insert(insertPosition, helperStr+delimiter);
	}
		
	public StringBuilder deleteAtPosition(StringBuilder strBuilder,String delimiter, int position) throws TaskException{
		int delimiterLen = TaskUtility.getLength(delimiter);
		int len = TaskUtility.getLength(strBuilder);
		TaskUtility.validateIndexInBounds(position, len);
		int startIndex = getDelimiterIndex(strBuilder,delimiter,position-1);
		int endIndex = getDelimiterIndex(strBuilder, delimiter, position);
		if (position == 1) {
			endIndex = endIndex+TaskUtility.getLength(delimiter);
		}
		else if(endIndex == -1){
			endIndex = len;
		}
		return strBuilder.delete(startIndex,endIndex);
	}

	public StringBuilder replaceDelimiter(StringBuilder strBuilder, String splitterDelimiter, String replacerDelimiter) throws TaskException {
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
		return strBuilder;
	}
	
	public StringBuilder reverseStrBuilder (StringBuilder strBuilder) throws TaskException{
		TaskUtility.validateNullValue(strBuilder);
		return strBuilder.reverse();
	}

	public StringBuilder deleteChars(StringBuilder strBuilder,int startValue,int endValue) throws TaskException{
		len = TaskUtility.getLength(strBuilder);
		TaskUtility.validateIndexInBounds(startValue,len);
		TaskUtility.validateIndexInBounds(endValue,len);
		return strBuilder.delete(startValue-1,endValue);
	}

	public StringBuilder insertChars(StringBuilder strBuilder,int startValue,int endValue, String replacerString) throws TaskException{
		len = TaskUtility.getLength(strBuilder);
		TaskUtility.validateNullValue(replacerString);
		TaskUtility.validateIndexInBounds(startValue,len);
		TaskUtility.validateIndexInBounds(endValue,len);
		return strBuilder.replace(startValue,endValue,replacerString);
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
	