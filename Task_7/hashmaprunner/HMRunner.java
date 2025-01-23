package hashmaprunner;

import taskexception.TaskException;
import nullexception.NullValueException;
import java.util.Map;
import java.util.HashMap;
import stringexception.StringException;
import indexexception.IndexBoundException;
import minimumcharexception.MinimumCharException;
import utility.TaskUtility;
import hashmaptask.HMTask;
import java.util.Set;
import custom.Custom;

public class HMRunner{
	
	HMTask taskObj = new HMTask();
	int number;
	
	public static void main(String[] args){
		
		HMRunner runnerObj = new HMRunner();
		boolean loop = true;
		runnerObj.showTask();
		
		while(loop){
			System.out.println("Enter the sequence number for the exercise (1-20, or 0 to exit):");
			int sequenceNumber = TaskUtility.getIntInput();		
			if(sequenceNumber==0){
				System.out.println("Exiting program!!!");
				loop = false;
			}
			
			else{
				try{
					switch(sequenceNumber){
						case 1:
							runnerObj.runCaseOne();
							break;
					
						case 2:
							runnerObj.runCaseTwo();
							break;
					
						case 3:
							runnerObj.runCaseThree();
							break;
							
						case 4:
							runnerObj.runCaseFour();
							break;
					
						case 5:
							runnerObj.runCaseFive();
							break;
						
						case 6:
						case 7:
							runnerObj.runCaseSix();
							break;
						
						case 8:
							runnerObj.runCaseEight();
							break;
						
						case 9:
							runnerObj.runCaseNine();
							break;
					
						case 10:
							runnerObj.runCaseTen();
							break;
					
						case 11:
						case 12:
							runnerObj.runCaseEleven();
							break;
						
						case 13:
							runnerObj.runCaseThirteen();
							break;
					
						case 14:
							runnerObj.runCaseFourteen();
							break;
					
						case 15:
							runnerObj.runCaseFifteen();
							break;
						
						case 16:
							runnerObj.runCaseSixteen();
							break;
					
						case 17:
							runnerObj.runCaseSeventeen();
							break;
					
						case 18:
							runnerObj.runCaseEighteen();
							break;
						
						case 19:
							runnerObj.runCaseNineteen();
							break;
					
						case 20:
							runnerObj.runCaseTwenty();
							break;
					
						default:
							System.out.println("Please choose the number between 1 to 20");
							break;
					}
				}
				catch(TaskException e){
					System.err.println("Exception caught in HashMap Runner class - Main method\n"+e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
	
	public void showTask(){
		System.out.println("1. Create a HashMap & print its size.");
		System.out.println("2. Create a HashMap & add String key value pairs and print the size of arraylist.");
		System.out.println("3. Create a HashMap & add integer key value pairs and print the size of arraylist.");
		System.out.println("4. Create a HashMap & add string key and integer value pairs and print the size of arraylist.");
		System.out.println("5. Create a HashMap & add String key and Object value pairs and print the size of arraylist.");
		System.out.println("6. Create a HashMap & add string key and integer value pairs and change the value to null.");
		System.out.println("7. Create a HashMap & string key and integer value pairs and change the key to null.");
		System.out.println("8. Create a HashMap & check for key.");
		System.out.println("9. Create a HashMap & check for value.");
		System.out.println("10. Create a HashMap & replace the values with new values.");
		System.out.println("11. Create a HashMap & get the value of existing key.");
		System.out.println("12. Create a HashMap & get the value of non-existing key.");
		System.out.println("13. Create a HashMap & add new value for non-existing key.");
		System.out.println("14. Create a HashMap & remove the key.");
		System.out.println("15. Create a HashMap & remove the key if it matches the value.");
		System.out.println("16. Create a HashMap & replace the value.");
		System.out.println("17. Create a HashMap & replace the value if it matches the old value.");
		System.out.println("18. Create a HashMap & copy its entire key value pairs to a new HashMap.");
		System.out.println("19. Create a HashMap & iterate to print the key value pairs.");
		System.out.println("20. Create a HashMap & remove all entries.");

	}
	
	public void runCaseOne() throws TaskException{
		
		Map<Object,Object> hmap = taskObj.getMap();
		System.out.println("An ArrayList has been created "+hmap+" and its size is: "+taskObj.getSize(hmap));
		System.out.println("The result is of type: "+((Object)hmap).getClass().getSimpleName());		
	}
	
	public void runCaseTwo() throws TaskException{
		
		Map<String,String> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter String Value "+(i+1)+" : ");
			String strValue = TaskUtility.getStringInput();
			taskObj.putKeyValue(hmap,strKey,strValue);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
	}
	
	public void runCaseThree() throws TaskException{
		
		Map<Integer,Integer> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter Integer Key "+(i+1)+" : ");
			int intKey = TaskUtility.getIntInput();
			System.out.println("Enter Integer Value "+(i+1)+" : ");
			int intValue = TaskUtility.getIntInput();
			taskObj.putKeyValue(hmap,intKey,intValue);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
	}
	
	public void runCaseFour() throws TaskException{
		
		Map<String,Integer> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter Integer Value "+(i+1)+" : ");
			int intValue = TaskUtility.getIntInput();
			taskObj.putKeyValue(hmap,strKey,intValue);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
	}
	
	public void runCaseFive() throws TaskException{
		
		Map<String,Object> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			Custom obj = new Custom("Object"+(i+1));
			taskObj.putKeyValue(hmap,strKey,obj);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
	}

	public void runCaseSix() throws TaskException{
		
		Map<String,Integer> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter Integer Value "+(i+1)+" : ");
			int intValue = TaskUtility.getIntInput();
			taskObj.putKeyValue(hmap,strKey,intValue);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
		System.out.println("Enter 'True' to allocate 'Null' for Key and 'False' to allocate 'Null' for Value: ");
		boolean order = TaskUtility.getBoolInput();
		System.out.println("Enter the key for which NULL KEY should be alloted: ");
		String nullKey = TaskUtility.getStringInput();
		taskObj.replaceNullKeyValue(hmap,nullKey,order);
		System.out.println("The resultant HashMap is: "+hmap);
	}
	
	public void runCaseEight() throws TaskException{
	
		Map<String,Integer> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter Integer Value "+(i+1)+" : ");
			int intValue = TaskUtility.getIntInput();
			taskObj.putKeyValue(hmap,strKey,intValue);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
		System.out.println("Enter the key to check in HashMap: ");
		String key = TaskUtility.getStringInput();
		System.out.println("Whether the given key is present in the HashMap? " +taskObj.checkKey(hmap,key));
	}
	
	public void runCaseNine() throws TaskException{
	
		Map<String,Integer> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter Integer Value "+(i+1)+" : ");
			int intValue = TaskUtility.getIntInput();
			taskObj.putKeyValue(hmap,strKey,intValue);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
		System.out.println("Enter the value to check in HashMap: ");
		int value = TaskUtility.getIntInput();
		System.out.println("Whether the given key is present in the HashMap? " +taskObj.checkValue(hmap,value));
	}
	
	public void runCaseTen() throws TaskException{
		
		Map<String,String> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter String Value "+(i+1)+" : ");
			String strValue = TaskUtility.getStringInput();
			taskObj.putKeyValue(hmap,strKey,strValue);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
		System.out.println("Enter new values for the key - value pair: ");
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter String Value "+(i+1)+" : ");
			String newValue = TaskUtility.getStringInput();
			taskObj.replaceNewValues(hmap,strKey,newValue);
		}
		System.out.println("The New Valued HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));

	}
	
	public void runCaseEleven() throws TaskException{
		
		Map<String,String> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter String Value "+(i+1)+" : ");
			String strValue = TaskUtility.getStringInput();
			taskObj.putKeyValue(hmap,strKey,strValue);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
		System.out.println("Enter the Key to find the value of: ");
		String key = TaskUtility.getStringInput();
		System.out.println("The Value of the given key: "+taskObj.findValue(hmap,key));
	}
	
	public void runCaseThirteen() throws TaskException{
		
		Map<String,String> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter String Value "+(i+1)+" : ");
			String strValue = TaskUtility.getStringInput();
			taskObj.putKeyValue(hmap,strKey,strValue);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
		System.out.println("Enter the Key to check if it exists: ");
		String key = TaskUtility.getStringInput();
		System.out.println("Enter the value for non-existing key: ");
		String value = TaskUtility.getStringInput();
		taskObj.createNewValue(hmap,key,value);
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
	}
	
	public void runCaseFourteen() throws TaskException{
		
		Map<String,String> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter String Value "+(i+1)+" : ");
			String strValue = TaskUtility.getStringInput();
			taskObj.putKeyValue(hmap,strKey,strValue);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
		System.out.println("Enter the Key to remove: ");
		String key = TaskUtility.getStringInput();
		taskObj.removeKey(hmap,key);
		System.out.println("The Resultant HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
	}
	
	public void runCaseFifteen() throws TaskException{
		
		Map<String,String> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter String Value "+(i+1)+" : ");
			String strValue = TaskUtility.getStringInput();
			taskObj.putKeyValue(hmap,strKey,strValue);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
		System.out.println("Enter the Key to remove: ");
		String key = TaskUtility.getStringInput();
		System.out.println("Enter the value of the key to check for removing: ");
		String value= TaskUtility.getStringInput();
		taskObj.removeKeyByMatchingValue(hmap,key,value);
		System.out.println("The Resultant HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
	}
	
	public void runCaseSixteen() throws TaskException{
		
		Map<String,String> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter String Value "+(i+1)+" : ");
			String strValue = TaskUtility.getStringInput();
			taskObj.putKeyValue(hmap,strKey,strValue);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
		System.out.println("Enter the Key for which the value should be replaced: ");
		String key = TaskUtility.getStringInput();
		System.out.println("Enter the value to replace: ");
		String value = TaskUtility.getStringInput();
		taskObj.replaceValue(hmap,key,value);
		System.out.println("The Resultant HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
	}
	
	public void runCaseSeventeen() throws TaskException{
		
		Map<String,String> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter String Value "+(i+1)+" : ");
			String strValue = TaskUtility.getStringInput();
			taskObj.putKeyValue(hmap,strKey,strValue);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
		System.out.println("Enter the key for which the value should be replaced:: ");
		String key = TaskUtility.getStringInput();
		System.out.println("Enter the old value to check: ");
		String oldValue= TaskUtility.getStringInput();
		System.out.println("Enter the new value to replace: ");
		String newValue= TaskUtility.getStringInput();
		taskObj.replaceOldByNewValue(hmap,key,oldValue,newValue);
		System.out.println("The Resultant HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
	}
	
	public void runCaseEighteen() throws TaskException{
		
		Map<String,String> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter String Value "+(i+1)+" : ");
			String strValue = TaskUtility.getStringInput();
			taskObj.putKeyValue(hmap,strKey,strValue);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
		Map<String,String> newHMap = taskObj.getMap();
		taskObj.transferKeyValue(hmap,newHMap);
		System.out.println("The New HashMap is "+newHMap+" and its size is: "+taskObj.getSize(newHMap));
	}	

	public void runCaseNineteen() throws TaskException{
		
		Map<String,String> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter String Value "+(i+1)+" : ");
			String strValue = TaskUtility.getStringInput();
			taskObj.putKeyValue(hmap,strKey,strValue);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
		for(Map.Entry<String, String> mapEntry : taskObj.createEntrySet(hmap)) {
			System.out.println("Key: "+taskObj.returnKey(mapEntry)+" Value: "+taskObj.returnValue(mapEntry));
		}
	}
	
	public void runCaseTwenty() throws TaskException{
		
		Map<String,String> hmap = taskObj.getMap();
		System.out.println("Enter the number of key - value pairs to add in the HashMap: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter String Key "+(i+1)+" : ");
			String strKey = TaskUtility.getStringInput();
			System.out.println("Enter String Value "+(i+1)+" : ");
			String strValue = TaskUtility.getStringInput();
			taskObj.putKeyValue(hmap,strKey,strValue);
		}
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
		taskObj.clearMap(hmap);
		System.out.println("The HashMap is "+hmap+" and its size is: "+taskObj.getSize(hmap));
	}
}
