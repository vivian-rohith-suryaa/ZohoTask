package inheritancetask.cars;

import inheritancetask.cars.Car;

public class SCross extends Car{
	
	private int seatNumber;
	private int airbagNumber;
	private String carModel;
	private String carColor;
	
	public void setSeatNumber (int seatNumber){
		this.seatNumber = seatNumber;
	}
	public int getSeatNumber(){
		return seatNumber;
	}
	
	public void setAirbagNumber (int airbagNumber){
		this.airbagNumber = airbagNumber;
	}
	public int getAirbagNumber(){
		return airbagNumber;
	}
	
	public void setCarModel (String carModel){
		this.carModel = carModel;
	}
	public String getCarModel(){
		return carModel;
	}
	
	public void setCarColor (String carColor){
		this.carColor = carColor;
	}
	public String getCarColor(){
		return carColor;
	}
	
	public void maintenance(){
		System.out.println("Maruti SCross under maintenance.");
	}
	
}