package runner;

import utility.StringUtility;
import exception.StringBuilderException;
import task.StringBuilderTask;

public class StringBuilderRunner{
	
	public StringUtility utilObj = new StringUtility();
	public StringBuilderTask taskObj = new StringBuilderTask();
	public StringBuilderRunner runnerObj = new StringBuilderRunner();
	public StringBuilder strBuilder = new StringBuilder();
	
	public static void main(String[] args){
		boolean loop = true;
		
		while(loop){
			System.out.println("Enter the sequence number for the exercise (1 - 20, or 0 to exit):");
			int sequenceNumber = utilObj.getIntInput();		
				
			if(sequenceNumber==0){
				System.out.println("Exiting program!!!");
				loop = false;
				runnerObj.scan.close();
			}
			
			else{
				try{
					switch(sequenceNumber){
						case 1:
							try{
								runnerObj.printLength(utilObj,args);
							}
							catch (StringBuilderException e){
								throw new StringBuilderException ("Exception caught in StringBuilderRunner class - Case 1",e);
							}
							break;
					}
				}
				catch(StringBuilderException e){
					System.err.println("Exception caught in StringBuilderRunner class - Main method\n"+e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
	
	public void printStrBuilderLength(StringTask taskObj,StringUtility utilObj){
		
}