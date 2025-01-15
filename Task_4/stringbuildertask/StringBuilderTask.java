package stringbuildertask;

import taskexception.TaskException;
import nullexception.NullValueException;
import indexexception.IndexBoundException;
import utility.TaskUtility;
import minimumcharexception.MinimumCharException;

public class StringBuilderTask{
	
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
		TaskUtility.validateNullValue(strBuilder);
		TaskUtility.validateNullValue(delimiter);
		TaskUtility.validateNullValue(helperStr);
		String str = TaskUtility.convertToString(strBuilder);
		String[] strArray = str.split(delimiter);
		int len = strArray.length;
		TaskUtility.validateIndexInBounds(position, len);
		StringBuilder result = getStringBuilder();

		for (int i = 0; i < len; i++) {
			if (i == position-1) {
				result.append(helperStr);
				if(i<len){
					result.append(delimiter);
				}
			}
			result.append(strArray[i]);
			if (i < len - 1) {
				result.append(delimiter);
			}
		}
		if (position == len + 1) {
			result.append(delimiter).append(helperStr);
		}
		return result;
	}

	
	public StringBuilder deleteAtPosition(StringBuilder strBuilder,String delimiter,int position) throws TaskException{
		TaskUtility.validateNullValue(strBuilder);
		TaskUtility.validateNullValue(delimiter);
		String str = TaskUtility.convertToString(strBuilder);
		String[] strArray = str.split(delimiter);
		int len = strArray.length;
		TaskUtility.validateIndexInBounds(position,len);
		StringBuilder result = getStringBuilder();
		
		for(int i=0;i<len;i++){
			if(i==position-1){
				continue;
			}
			result.append(strArray[i]);
			if(i<len-1 && !(i==len-2 && position ==len)){
				result.append(delimiter);
			}
		}
		return result;
	}
	
	public StringBuilder replaceDelimiter(StringBuilder strBuilder, String splitterDelimiter, String replacerDelimiter) throws TaskException{
		TaskUtility.validateNullValue(strBuilder);
		TaskUtility.validateNullValue(splitterDelimiter);
		TaskUtility.validateNullValue(replacerDelimiter);
		String str = TaskUtility.convertToString(strBuilder);
		String[] strArray = str.split(splitterDelimiter);
		StringBuilder result = getStringBuilder();
		int len = strArray.length;
		for (int i=0; i<len;i++){
			result.append(strArray[i]);
			if(i<len-1){
				result.append(replacerDelimiter);
			}
		}
		return result;
	}

	public StringBuilder reverseStrBuilder (StringBuilder strBuilder) throws TaskException{
		TaskUtility.validateNullValue(strBuilder);
		return strBuilder.reverse();
	}

	public StringBuilder deleteChars(StringBuilder strBuilder,int startValue,int endValue) throws TaskException{
		int len = TaskUtility.getLength(strBuilder);
		TaskUtility.validateNullValue(strBuilder);
		TaskUtility.validateIndexInBounds(startValue,len);
		TaskUtility.validateIndexInBounds(endValue,len);
		return strBuilder.delete(startValue-1,endValue);
	}

	public StringBuilder insertChars(StringBuilder strBuilder,int startValue,int endValue, String replacerString) throws TaskException{
		int len = TaskUtility.getLength(strBuilder);
		TaskUtility.validateNullValue(strBuilder);
		TaskUtility.validateNullValue(replacerString);
		TaskUtility.validateIndexInBounds(startValue,len);
		TaskUtility.validateIndexInBounds(endValue,len);
		return strBuilder.replace(startValue,endValue,replacerString);
	}

	public StringBuilder getIndices(StringBuilder strBuilder,String delimiter) throws TaskException{
		TaskUtility.validateNullValue(strBuilder);
		TaskUtility.validateNullValue(delimiter);
		String str = TaskUtility.convertToString(strBuilder);
		StringBuilder result = getStringBuilder();
		int index = str.indexOf(delimiter);
		while(index != -1){
			result.append(index+1).append(" ");
			index = str.indexOf(delimiter,index+1);
		}
		return result;
	}
		
}
	