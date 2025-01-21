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

public class HMRunner{
	
	HMTask taskObj = new HMTask();
	int number;
	
	public static void main(String[] args){
		
		HMRunner runnerObj = new HMRunner();
		boolean loop = true;
		runnerObj.showTask();
		
		while(loop){
			System.out.println("Enter the sequence number for the exercise (1-18, or 0 to exit):");
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
					/*
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
							runnerObj.runCaseSix();
							break;
						
						case 7:
							runnerObj.runCaseSeven();
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
							runnerObj.runCaseEleven();
							break;
						
						case 12:
						case 13:
							runnerObj.runCaseTwelve();
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
					*/
						default:
							System.out.println("Please choose the number between 1 to 18");
							break;
					}
				}
				catch(TaskException e){
					System.err.println("Exception caught in StringBuilderRunner class - Main method\n"+e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
	
	public void showTask(){
		System.out.println("1. Create an hashmap & print its size.");
		System.out.println("2. Create an ArrayList & add Strings and print the size of arraylist");
		System.out.println("3. Create an ArrayList & add integers and print the size of arraylist");
		System.out.println("4. Create an ArrayList & add Objects and print the size of arraylist");
		System.out.println("5. Create an ArrayList & add Strings,Integers and Objects and print the size of arraylist");
		System.out.println("6. Create an ArrayList & add strings, find the index of any string and print the size of arraylist");
		System.out.println("7. Create an ArrayList & add strings, print elements using for loop and iterator");
		System.out.println("8. Create an ArrayList & add strings, find the string at the index and its size");
		System.out.println("9. Create an ArrayList & add Strings with duplicates and print the first and last index of the duplicates");
		System.out.println("10. Create an ArrayList & add Strings, and add another string at the given position.");
		System.out.println("11. Create an ArrayList & add Strings, and create new ArrayList with starting and ending positions.");
		System.out.println("12. Create 2 ArrayList & add Strings, and create the third arraylist using first and second");
		System.out.println("13. Create 2 ArrayList & add Strings, and create the third arraylist using first and second");
		System.out.println("14. Create an ArrayList & add float number, and remove the value at position");
		System.out.println("15. Create an ArrayList & add Strings, and remove the duplicate elements in arraylist1 and arraylist2");
		System.out.println("16. Create an ArrayList & add Strings, and remove the non duplicate elements in arraylist1 and arraylist2");
		System.out.println("17. Create an ArrayList & add long numbers, and remove all the values in the arraylist");
		System.out.println("18. Create an ArrayList & add Strings, and check whether the given string is present");

	}
	
	public void runCaseOne() throws TaskException{
		
		Map<Object,Object> hmap = taskObj.getMap();
		System.out.println("An ArrayList has been created "+hmap+" and its size is: "+taskObj.getSize(hmap));
		System.out.println("The result is of type: "+((Object)hmap).getClass().getSimpleName());		
	}
	
	
}
