package task5.inheritancetask.cars;

public class Car{
	private int yearOfMake;
	private String engineNumber;
	private String carType;
	
	public Car(){
	}
	
	public Car(String input){
		System.out.println("Inside Car Class."+input);
	}
	
	public void setYearOfMake(int yearOfMake){
		this.yearOfMake = yearOfMake;
	}
	
	public int getYearOfMake(){
		return yearOfMake;
	}
	
	public void setEngineNumber(String engineNumber){
		this.engineNumber = engineNumber;
	}
	
	public String getEngineNumber(){
		return engineNumber;
	}
	
	public void setCarType(String carType){
		this.carType = carType;
	}
	
	public String getCarType(){
		return carType;
	}
	
	public void maintenance(){
		System.out.println("Car under maintenance.");
	}
}
	