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

	/*
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
	*/

	public StringBuilder insertAtPosition(StringBuilder strBuilder,String helperStr, String delimiter, int position) throws TaskException{
		TaskUtility.validateNullValue(strBuilder);
		TaskUtility.validateNullValue(delimiter);
		TaskUtility.validateNullValue(helperStr);
		int currentposition = 1;
		int len = TaskUtility.getLength(strBuilder);
		TaskUtility.validateIndexInBounds(position, len);
		StringBuilder result = getStringBuilder();
		int start = 0;
		
		for (int i=0;i<len;i++){
			if(strBuilder.charAt(i)== delimiter.charAt(0) || i==len-1){
				if(currentposition == position){
					result.append(helperStr).append(delimiter);
				}
				result.append(strBuilder,start,i+1);
				start = i+1;
				currentposition++;
				if (currentposition < position) {
					result.append(delimiter);
				}
			}
		}
		if(currentposition==position){
			result.append(delimiter).append(helperStr);
		}
		return result;
	}
	
	/*
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
	*/
	
	public StringBuilder deleteAtPosition(StringBuilder strBuilder,String delimiter, int position) throws TaskException{
		TaskUtility.validateNullValue(strBuilder);
		TaskUtility.validateNullValue(delimiter);
		int currentposition = 1;
		int len = TaskUtility.getLength(strBuilder);
		TaskUtility.validateIndexInBounds(position, len);
		StringBuilder result = getStringBuilder();
		int start = 0;
		while (start < len) {
			int end = strBuilder.indexOf(delimiter, start);  
			if (end == -1) {
				end = len;
			}
			if (currentposition != position) {
				result.append(strBuilder, start, end); 
				if (end != len) {
					result.append(delimiter);
				}
			}
			start = end + TaskUtility.getLength(delimiter);
			currentposition++;
		}
		return result;
	}
	
	/*
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
	*/
	
	public StringBuilder replaceDelimiter(StringBuilder strBuilder, String splitterDelimiter, String replacerDelimiter) throws TaskException {
		TaskUtility.validateNullValue(strBuilder);
		TaskUtility.validateNullValue(splitterDelimiter);
		TaskUtility.validateNullValue(replacerDelimiter);
		int len = strBuilder.length();
		StringBuilder result = new StringBuilder();
		int start = 0;
		while (start < len) {
			int end = strBuilder.indexOf(splitterDelimiter, start);

			if (end == -1) {
				result.append(strBuilder.substring(start));
				break;
			} else {
				result.append(strBuilder.substring(start, end));
				result.append(replacerDelimiter);
			}
			start = end + splitterDelimiter.length();
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
		
}
	