package inheritancerunner;

import taskexception.TaskException;
import nullexception.NullValueException;
import java.util.Scanner;
import indexexception.IndexBoundException;
import minimumcharexception.MinimumCharException;
import utility.TaskUtility;
import inheritancetask.birds.BirdAbstract;
import inheritancetask.birds.Bird;
import inheritancetask.birds.ParrotMod;
import inheritancetask.birds.Duck;
import inheritancetask.cars.Car;
import inheritancetask.cars.XUV;
import inheritancetask.cars.Swift;
import inheritancetask.cars.SCross;

public class InheritanceRunner{
	
	Car carObj = new Car();
	XUV xuvObj = new XUV();
	Swift swiftObj = new Swift();
	SCross scObj = new SCross();
	//BirdAbstract absObj = new BirdAbstract();
	ParrotMod parrotObj = new ParrotMod();
	Duck duckObj = new Duck();
	String input;

	public static void main(String[] args){
		
		InheritanceRunner runnerObj = new InheritanceRunner();
		boolean loop = true;
		
		while(loop){
			System.out.println("Enter the sequence number for the exercise (1 - 10, or 0 to exit):");
			int sequenceNumber = TaskUtility.getIntInput();		
			Scanner scan = new Scanner(System.in);	
			if(sequenceNumber==0){
				System.out.println("Exiting program!!!");
				loop = false;
				scan.close();
			}
			
			else{
				try{
					switch(sequenceNumber){
	
						case 1:
						case 2:
							runnerObj.runCaseOne();
							break;
							
						case 3:
							runnerObj.runCaseTwo();
							break;
							
						case 4:
						case 5:
							runnerObj.runCaseThree();
							break;
						
						case 6:
							runnerObj.runCaseFour();
							break;
						
						case 7:
							runnerObj.runCaseFive();
							break;
						
						case 8:
							runnerObj.runCaseSix();
							break;
							
						case 9:
							runnerObj.runCaseSeven();
							break;
							
						case 10:
							runnerObj.runCaseEight();
							break;
							
						default:
							System.out.println("Please choose the number between 1 to 10");
							break;
					}
				}
				catch(TaskException e){
					System.err.println("Exception caught in InheritanceRunner class - Main method\n"+e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
	
	public void runCaseOne() throws TaskException{
		
		TaskUtility.validateNullValue(swiftObj);
		
		System.out.println("Enter the detials of Car:");
		System.out.println("Enter number of seats: ");
		int seatNumber = TaskUtility.getIntInput();
		TaskUtility.validateNullValue(seatNumber);
		swiftObj.setSeatNumber(seatNumber);
		
		System.out.println("Enter number of airbags: ");
		int airbagNumber = TaskUtility.getIntInput();
		TaskUtility.validateNullValue(airbagNumber);
		swiftObj.setAirbagNumber(airbagNumber);
		
		System.out.println("Enter model of car: ");
		String carModel = TaskUtility.getStringInput();
		TaskUtility.validateNullValue(carModel);
		swiftObj.setCarModel(carModel);
		
		System.out.println("Enter color of car: ");
		String carColor = TaskUtility.getStringInput();
		TaskUtility.validateNullValue(carColor);
		swiftObj.setCarColor(carColor);
		
		System.out.println("Detials of Swift Car:");
		System.out.println("Number of Seats: "+swiftObj.getSeatNumber());
		System.out.println("Number of Airbags: "+swiftObj.getAirbagNumber());
		System.out.println("Car Model: "+swiftObj.getCarModel());
		System.out.println("Car Color: "+swiftObj.getCarColor());
	}
	
	public void runCaseTwo() throws TaskException{
		
		TaskUtility.validateNullValue(scObj);
		
		System.out.println("Enter the detials of Car:");
		System.out.println("Enter the year of Manufacture: ");
		int yearOfMake = TaskUtility.getIntInput();
		TaskUtility.validateNullValue(yearOfMake);
		scObj.setYearOfMake(yearOfMake);
		
		System.out.println("Enter Engine number: ");
		String engineNumber = TaskUtility.getStringInput();
		TaskUtility.validateNullValue(engineNumber);
		scObj.setEngineNumber(engineNumber);
		
		System.out.println("Enter the type of car: ");
		String carType = TaskUtility.getStringInput();
		TaskUtility.validateNullValue(carType);
		scObj.setCarType(carType);
		
		System.out.println("Enter number of seats: ");
		int seatNumber = TaskUtility.getIntInput();
		TaskUtility.validateNullValue(seatNumber);
		scObj.setSeatNumber(seatNumber);
		
		System.out.println("Enter number of airbags: ");
		int airbagNumber = TaskUtility.getIntInput();
		TaskUtility.validateNullValue(airbagNumber);
		scObj.setAirbagNumber(airbagNumber);
		
		System.out.println("Enter model of car: ");
		String carModel = TaskUtility.getStringInput();
		TaskUtility.validateNullValue(carModel);
		scObj.setCarModel(carModel);
		
		System.out.println("Enter color of car: ");
		String carColor = TaskUtility.getStringInput();
		TaskUtility.validateNullValue(carColor);
		scObj.setCarColor(carColor);
		
		System.out.println("Detials of SCross Car:");
		System.out.println("Year of Manufacturing: "+scObj.getYearOfMake());
		System.out.println("Engine Number: "+scObj.getEngineNumber());
		System.out.println("Car Type:"+scObj.getCarType());
		System.out.println("Number of Seats: "+scObj.getSeatNumber());
		System.out.println("Number of Airbags: "+scObj.getAirbagNumber());
		System.out.println("Car Model: "+scObj.getCarModel());
		System.out.println("Car Color: "+scObj.getCarColor());
	}
	
	public void identifyCarArgument (Car car) throws TaskException{
		
		TaskUtility.validateNullValue(car);
		
		if (car instanceof XUV){
			System.out.println("Method is invoked by XUV.\nCar: XUV - SUV.");
		}
		else if(car instanceof Swift){
			System.out.println("Method is invoked by Swift.\nCar: Swift - Hatch.");
		}
		else if(car instanceof SCross){
			System.out.println("Method is invoked by SCross.\nCar: SCross - Sedan.");
		}
		else{
			System.out.println("Method is invoked by an Object of Class Car.");
		}
	}
	
	public void runCaseThree() throws TaskException{
		
		System.out.println("Please enter the type of Object which can be used to invoke the method.\nAvailable Options:\nCar\nXUV\nSwift\nSCross");
		input = TaskUtility.getStringInput();
		TaskUtility.validateNullValue(input);
		boolean bool = true;
		switch(input.toLowerCase()){
			
			case "car":
				identifyCarArgument(carObj);
				break;
			
			case "xuv":
				identifyCarArgument(xuvObj);
				break;
				
			case "swift":
				identifyCarArgument(swiftObj);
				break;
				
			case "scross":
				identifyCarArgument(scObj);
				break;
				
			default:
				System.out.println("Please select between the given choices.");
				break;
		}
	}
	
	public void identifySwiftArgument (Swift swift) throws TaskException{
		
		TaskUtility.validateNullValue(swift);
		
		if(swift instanceof Swift){
			System.out.println("Method is invoked by an object of Swift Class.");
		}
		else{
			System.out.println("Method is not invoked by the object of Swift Class.");
		}
	}
	
	public void runCaseFour() throws TaskException{
		
		System.out.println("Please enter the type of Object which can be used to invoke the method.\nAvailable Options:\nCar\nXUV\nSwift\nSCross");
		input = TaskUtility.getStringInput();
		TaskUtility.validateNullValue(input);
		switch(input.toLowerCase()){
			
			//Downcasting should be done in order to allow the below case
			
			//case "car":
			//	Car swiftCar = new Swift();
			//	identifySwiftArgument((Swift) swiftCar);
			//	break;
			
			case "swift":
				identifySwiftArgument(swiftObj);
				break;
				
			//XUV and Scross cant be converted to Swift	
			
			//case "xuv":
			//	identifySwiftArgument(xuvObj);
			//	break;
			
			//case "scross":
			//	identifySwiftArgument(scObj);
			//	break;
				
			default:
				System.out.println("Object Instances of types other than Swift instance cannot be used.");
				break;
		}
	}
	
	public void runCaseFive() throws TaskException{
		
		Car scCar = new SCross();
		TaskUtility.validateNullValue(scCar);
		System.out.println("\nCase 1: Maintenance method called by SCross object.");
		scObj.maintenance();
		System.out.println("\nCase 2: Maintenance method called by an instance of SCross which have a reference type of Car Class.");
		scCar.maintenance();
		System.out.println("\nCase 3: Maintenance method called by Car object.");
		carObj.maintenance();
		System.out.println("\nCase 4: Maintenance method called by Swift object.");
		swiftObj.maintenance();
	}
	
	public void runCaseSix() throws TaskException{
		
		System.out.println("Default Constructor");
		XUV xuv1 = new XUV();
		TaskUtility.validateNullValue(xuv1);
		
		//No such overloaded constructor is available in XUV class to accept a String argument
		
		//System.out.println("Overloaded Constructor");
		//XUV xuv2 = new XUV("Input");
		//TaskUtility.validateNullValue(xuv2);
	}
	
	public void runCaseSeven() throws TaskException{
		
		//Object instance cannot be created for an Abstract class
		
		//TaskUtility.validateNullValue(absObj);
		//System.out.println("Methods called using BirdAbstract Class");
		//absObj.fly();
		//absObj.speak();
		
		TaskUtility.validateNullValue(parrotObj);
		System.out.println("Methods called using ParrotMod Class");
		parrotObj.fly();
		parrotObj.speak();
	}
	
	public void runCaseEight() throws TaskException{
		
		TaskUtility.validateNullValue(duckObj);
		System.out.println("Methods called using Duck Class");
		duckObj.fly();
		duckObj.speak();
	}
}
	
	