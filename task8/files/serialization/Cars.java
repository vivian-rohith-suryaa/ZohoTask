package task8.files.serialization;

import java.io.Serializable;

public class Cars implements Serializable,Cloneable{
	
	private static final long serialVersionUID = 1;
	
	private String name;
	private String color;
	private String model;
	private int yearOfMake;
	
	public Cars(String name,String color,String model,int yearOfMake) {
		this.name = name;
		this.color= color;
		this.model = model;
		this.yearOfMake= yearOfMake;
	}
	
	@Override
	public String toString() {
		return "Name: "+name+" Color: "+color+" Model: "+model+" Year of Make: "+yearOfMake;
	}
	
	public Object cloneObj() throws CloneNotSupportedException {
		return super.clone();
	}
}
