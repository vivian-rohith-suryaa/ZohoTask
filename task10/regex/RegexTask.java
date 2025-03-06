package task10.regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import exceptions.custom.CustomException;
import exceptions.taskexception.TaskException;
import utility.TaskUtility;

public class RegexTask {
	
	public boolean getMatcherResult(String input, String regex) throws TaskException {
		TaskUtility.validateNullValue(input);
		TaskUtility.validateNullValue(regex);
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
	
	public Matcher getPatternMatcher(String input, String regex) throws TaskException {
		TaskUtility.validateNullValue(input);
		TaskUtility.validateNullValue(regex);
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(input);
	}
	
	public boolean validateMobileNumber(String mobile) throws TaskException{
		String regex = "^[789]\\d{9}$";
		return getMatcherResult(mobile, regex);
	}
	
	public boolean validateAlphaNumeric(String input) throws TaskException{
		String regex = "\\p{Alnum}";
		return getMatcherResult(input, regex);
		
	}
	
	public boolean checkInputWithReference(String input, String reference, int option) throws TaskException{
		TaskUtility.validateNullValue(option);
		String regex;
		switch(option) {
		case 1:
			regex = "^"+reference+ ".*";
			if(getMatcherResult(input, regex)) {
				return true;
			}
			throw new CustomException("The given input does not start with the reference value.");
		
		case 2:
			regex = ".*"+reference+ ".*";
			if(getMatcherResult(input, regex)) {
				return true;
			}
			throw new CustomException("The given input does not contain the reference value.");
			
		case 3:
			regex = ".*"+reference+ "$";
			if(getMatcherResult(input, regex)) {
				return true;
			}
			throw new CustomException("The given input does not end with the reference value.");
			
		case 4:
			if(getMatcherResult(input, reference)) {
				return true;
			}
			throw new CustomException("The given input does not exactly match with the reference value.");
			
		default:
			return false;
		}
	}
	
	public List<Boolean> matchCaseInsensitiveString(List<String> strList, String reference) throws TaskException {
		TaskUtility.validateNullValue(strList);
		List<Boolean> result = new ArrayList<Boolean>();
		for(String word : strList) {
			Matcher matcher = getPatternMatcher(word.toLowerCase(), reference.toLowerCase());
			if(matcher.matches()) {
				result.add(true);
			}
			else {
				result.add(false);
			}
		}
		return result;
	}

	public boolean validateEmail(String input) throws TaskException{
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z.]{2,}$";
		return getMatcherResult(input, regex);
	}
	
	public List<Boolean> checkRangeOfInput(List<String> strList, int range) throws TaskException{
		TaskUtility.validateNullValue(strList);
		List<Boolean> result = new ArrayList<Boolean>();
		String regex = ".{"+range+"}";
		for(String word : strList) {
			Matcher matcher = getPatternMatcher(word, regex);
			if(matcher.matches()) {
				result.add(true);
			}
			else {
				result.add(false);
			}
		}
		return result;
	}
	
	public Map<String, Integer> getMapOfMatchingInput(List<String> referenceList,List<String> inputList) throws TaskException{
		TaskUtility.validateNullValue(referenceList);
		TaskUtility.validateNullValue(inputList);
		checkInputValueInReference(referenceList,inputList);
		Map<String, Integer> result = new HashMap<String, Integer>();
		for(int i=0;i<referenceList.size();i++) {
			for(int j=0; j<inputList.size();j++) {
				Matcher matcher = getPatternMatcher(referenceList.get(i), inputList.get(j));
				if(matcher.matches()) {
					result.put(inputList.get(j),i);
					break;
				}
			}
		}
		return result;
	}
	
	public List<String> getHTMLTags(String input) throws TaskException{
		TaskUtility.validateNullValue(input);
		String regex = "</?[a-z]+[^>]*>";
		List<String> result = new ArrayList<String>();
		
		Matcher matcher = getPatternMatcher(input, regex);
		while(matcher.find()) {
			result.add(matcher.group());
		}
		return result;
	}
	
	public void checkInputValueInReference(List<String> referenceList,List<String> inputList) throws CustomException {
		if(!(referenceList.containsAll(inputList))) {
			throw new CustomException("The given reference list does not contain the element in the input list.");
		}
	}
	
	public void checkDistinctList(List<String> lst, String element) throws TaskException {
		TaskUtility.validateNullValue(lst);
		TaskUtility.validateNullValue(element);
		if(!(lst.contains(element))) {
			lst.add(element);
		}
		else {
			throw new CustomException("The List should not contain a duplicate element.");
		}
		
	}
}
