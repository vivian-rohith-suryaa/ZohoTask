package arraylistrunner;

import taskexception.TaskException;
import nullexception.NullValueException;
import java.util.ArrayList;
import java.util.List;
import stringexception.StringException;
import indexexception.IndexBoundException;
import minimumcharexception.MinimumCharException;
import utility.TaskUtility;
import java.util.Iterator;
import arraylisttask.ALTask;
import custom.Custom;

public class ALRunner{
	
	ALTask taskObj = new ALTask();
	int number;
	
	public static void main(String[] args){
		
		ALRunner runnerObj = new ALRunner();
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
					
						default:
							System.out.println("Please choose the number between 1 to 18");
							break;
					}
				}
				catch(TaskException e){
					System.err.println("Exception caught in ArrayList Runner class - Main method\n"+e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
	
	public void showTask(){
		System.out.println("1. Create an arraylist & print its size.");
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
		
		List<Object> arrList = taskObj.getArrayList();
		System.out.println("An ArrayList has been created "+arrList+" and its size is: "+taskObj.getSize(arrList));
		System.out.println("The result is of type: "+((Object)arrList).getClass().getSimpleName());		
	}
	
	public void runCaseTwo() throws TaskException{
		
		List<String> arrList = taskObj.getArrayList();
		System.out.println("Enter the number of String elements to add in the ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			String str = TaskUtility.getStringInput();
			taskObj.addElement(arrList,str);
		}
		System.out.println("The ArrayList is: "+arrList+" and its size is: "+taskObj.getSize(arrList));
	}

	public void runCaseThree() throws TaskException{
		
		List<Integer> arrList = taskObj.getArrayList();
		System.out.println("Enter the number of Integer elements to add in the ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			int value = TaskUtility.getIntInput();
			taskObj.addElement(arrList,value);
		}
		System.out.println("The ArrayList is: "+arrList+" and its size is: "+taskObj.getSize(arrList));
	}
	
	public void runCaseFour() throws TaskException{
		
		List<Object> arrList = taskObj.getArrayList();
		System.out.println("Enter the number of Object elements to add in the ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			Custom obj = new Custom("Obj"+(i+1));
			taskObj.addElement(arrList,obj);
		}
		System.out.println("The ArrayList is: "+arrList+" and its size is: "+taskObj.getSize(arrList));
	}
	
	public void runCaseFive() throws TaskException{
	
		List<Object> arrList = taskObj.getArrayList();
		System.out.println("Enter the number of String elements to add in the ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			String str = TaskUtility.getStringInput();
			taskObj.addElement(arrList,str);
		}
		System.out.println("Enter the number of Integer elements to add in the ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			int value = TaskUtility.getIntInput();
			taskObj.addElement(arrList,value);
		}
		System.out.println("Enter the number of Object elements to add in the ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			Custom obj = new Custom("Obj"+(i+1));
			taskObj.addElement(arrList,obj);
		}
		System.out.println("The Resultant ArrayList is: "+arrList+" and its size is: "+taskObj.getSize(arrList));
	}
	
	public void runCaseSix() throws TaskException{
	
		List<String> arrList = taskObj.getArrayList();
		System.out.println("Enter the number of String elements to add in the ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			String str = TaskUtility.getStringInput();
			taskObj.addElement(arrList,str);
		}
		System.out.println("Enter the string to find in the arraylist: ");
		String helper = TaskUtility.getStringInput();
		System.out.println("The ArrayList is: "+arrList+" and its size is: "+taskObj.getSize(arrList));
		System.out.println("The index of "+helper+" is at position: "+taskObj.getElementIndex(arrList,helper));
	}
	
	public void runCaseSeven() throws TaskException{
		
		List<String> arrList = taskObj.getArrayList();
		System.out.println("Enter the number of String elements to add in the ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			String str = TaskUtility.getStringInput();
			taskObj.addElement(arrList,str);
		}
		System.out.println("The ArrayList is: "+arrList+" and its size is: "+taskObj.getSize(arrList));
		System.out.println("The elements in the ArrayList are (using for loop): ");
		for(String value : arrList){
			System.out.println(value);
		}
		System.out.println("The elements in the ArrayList are (using Iterator): ");
		Iterator<String> itr = taskObj.getIterator(arrList);
		while(itr.hasNext()){
			String value = itr.next();
			System.out.println(value);
		}
	}
	
	public void runCaseEight() throws TaskException{
		
		List<String> arrList = taskObj.getArrayList();
		System.out.println("Enter the number of String elements to add in the ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			String str = TaskUtility.getStringInput();
			taskObj.addElement(arrList,str);
		}
		System.out.println("The ArrayList is: "+arrList+" and its size is: "+taskObj.getSize(arrList));
		System.out.println("Enter the index of the element: ");
		int index = TaskUtility.getIntInput();
		String str = taskObj.getElementAtIndex(arrList,index);
		System.out.println("The element at position "+index+" is: "+str+" and its length is: "+TaskUtility.getLength(str));
	}
	
	public void runCaseNine() throws TaskException{
		
		List<String> arrList = taskObj.getArrayList();
		System.out.println("Enter the number of String elements to add in the ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			String str = TaskUtility.getStringInput();
			taskObj.addElement(arrList,str);
		}
		System.out.println("The ArrayList is: "+arrList+" and its size is: "+taskObj.getSize(arrList));
		System.out.println("Enter the string to find in the arraylist: ");
		String helper = TaskUtility.getStringInput();
		System.out.println("The first index of "+helper+" is at position: "+taskObj.getElementIndex(arrList,helper));
		System.out.println("The last index of "+helper+" is at position: "+taskObj.getElementLastIndex(arrList,helper));
	}
	
	public void runCaseTen() throws TaskException{
		
		List<String> arrList = taskObj.getArrayList();
		System.out.println("Enter the number of String elements to add in the ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			String str = TaskUtility.getStringInput();
			taskObj.addElement(arrList,str);
		}
		System.out.println("The ArrayList is: "+arrList+" and its size is: "+taskObj.getSize(arrList));
		System.out.println("Enter the string to add in the array list: ");
		String helper = TaskUtility.getStringInput();
		System.out.println("Enter the position to add the string: ");
		int position = TaskUtility.getIntInput();
		taskObj.addElementAtIndex(arrList,helper,position);
		System.out.println("The Resultant ArrayList is: "+arrList+" and its size is: "+taskObj.getSize(arrList));
	}
	
	public void runCaseEleven() throws TaskException{
		
		List<String> arrList = taskObj.getArrayList();
		System.out.println("Enter the number of String elements to add in the ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			String str = TaskUtility.getStringInput();
			taskObj.addElement(arrList,str);
		}
		System.out.println("The ArrayList is: "+arrList+" and its size is: "+taskObj.getSize(arrList));
		System.out.println("Enter the starting position: ");
		int start = TaskUtility.getIntInput();
		System.out.println("Enter the ending position: ");
		int end = TaskUtility.getIntInput();
		List<String> result = taskObj.createListByPositions(arrList,start,end);
		System.out.println("The Resultant ArrayList is: "+result+" and its size is: "+taskObj.getSize(result));
	}
	
	public void runCaseTwelve() throws TaskException{
		
		//First Array List
		List<String> arrList1 = taskObj.getArrayList();
		System.out.println("Enter the number of String elements to add in the First ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			String str = TaskUtility.getStringInput();
			taskObj.addElement(arrList1,str);
		}
		
		//Second Array List
		List<String> arrList2 = taskObj.getArrayList();
		System.out.println("Enter the number of String elements to add in the Second ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			String str = TaskUtility.getStringInput();
			taskObj.addElement(arrList2,str);
		}
		System.out.println("Enter whether First ArrayList should be ahead of Second ArrayList (true/false): ");
		boolean order = TaskUtility.getBoolInput();

		if(order){
			taskObj.addLists(arrList1,arrList2);
			System.out.println("The ArrayList is: "+arrList1+" and its size is: "+taskObj.getSize(arrList1));
		}
		else{
			taskObj.addLists(arrList2,arrList1);
			System.out.println("The ArrayList is: "+arrList2+" and its size is: "+taskObj.getSize(arrList2));
		}
	}
	
	public void runCaseFourteen() throws TaskException{
		
		List<Float> arrList = taskObj.getArrayList();
		System.out.println("Enter the number of float elements to add in the ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			float value = TaskUtility.getFloatInput();
			taskObj.addElement(arrList,value);
		}
		System.out.println("The ArrayList is: "+arrList+" and its size is: "+taskObj.getSize(arrList));
		System.out.println("Enter the position to remove: ");
		int position = TaskUtility.getIntInput();
		taskObj.removeElementAtIndex(arrList,position);
		System.out.println("The Resultant ArrayList is: "+arrList+" and its size is: "+taskObj.getSize(arrList));
	}
	
	public void runCaseFifteen() throws TaskException{
		
		//First Array List
		List<String> arrList1 = taskObj.getArrayList();
		System.out.println("Enter the number of String elements to add in the First ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			String str = TaskUtility.getStringInput();
			taskObj.addElement(arrList1,str);
		}
		System.out.println("The First ArrayList is: "+arrList1+" and its size is: "+taskObj.getSize(arrList1));

		//Second Array List
		List<String> arrList2 = taskObj.getArrayList();
		System.out.println("Enter the number of String elements to add in the Second ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			String str = TaskUtility.getStringInput();
			taskObj.addElement(arrList2,str);
		}
		System.out.println("The Second ArrayList is: "+arrList2+" and its size is: "+taskObj.getSize(arrList2));

		taskObj.removeListElements(arrList1,arrList2);
		System.out.println("The Resultant ArrayList is: "+arrList1+" and its size is: "+taskObj.getSize(arrList1));
	}

	public void runCaseSixteen() throws TaskException{
		
		//First Array List
		List<String> arrList1 = taskObj.getArrayList();
		System.out.println("Enter the number of String elements to add in the First ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			String str = TaskUtility.getStringInput();
			taskObj.addElement(arrList1,str);
		}
		System.out.println("The First ArrayList is: "+arrList1+" and its size is: "+taskObj.getSize(arrList1));

		//Second Array List
		List<String> arrList2 = taskObj.getArrayList();
		System.out.println("Enter the number of String elements to add in the Second ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			String str = TaskUtility.getStringInput();
			taskObj.addElement(arrList2,str);
		}
		System.out.println("The Second ArrayList is: "+arrList2+" and its size is: "+taskObj.getSize(arrList2));

		taskObj.retainListElements(arrList1,arrList2);
		System.out.println("The Resultant ArrayList is: "+arrList1+" and its size is: "+taskObj.getSize(arrList1));
	}
	
	public void runCaseSeventeen() throws TaskException{
		
		List<Long> arrList = taskObj.getArrayList();
		System.out.println("Enter the number of Long numbers to add in the ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			long value = TaskUtility.getLongInput();
			taskObj.addElement(arrList,value);
		}
		taskObj.clearAllElements(arrList);
		System.out.println("The ArrayList is: "+arrList+" and its size is: "+taskObj.getSize(arrList));
	}
	
	public void runCaseEighteen() throws TaskException{
		
		List<String> arrList = taskObj.getArrayList();
		System.out.println("Enter the number of String elements to add in the ArrayList: ");
		number = TaskUtility.getIntInput();
		for (int i =0;i<number;i++){
			System.out.println("Enter the "+(i+1)+" value: ");
			String str = TaskUtility.getStringInput();
			taskObj.addElement(arrList,str);
		}
		System.out.println("The ArrayList is: "+arrList+" and its size is: "+taskObj.getSize(arrList));
		System.out.println("Enter the string to check in the arraylist: ");
		String helper = TaskUtility.getStringInput();
		System.out.println("Whether the given string is present? "+taskObj.checkElement(arrList,helper));
	}

}