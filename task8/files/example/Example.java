package task8.files.example;

public class Example {
	
	private String strValue;
	private int intValue;
	
	public Example() {
		
	}
	public Example(String strValue,int intValue) {
		this.intValue=intValue;
		this.strValue=strValue;
	}
	public void setStrValue(String strValue) {
		this.strValue=strValue;
	}
	
	public void setIntValue(int intValue) {
		this.intValue=intValue;
	}
	
	public String getStrValue() {
		return strValue;
	}
	
	public int getIntValue() {
		return intValue;
	}
	
	public String toString() {
		return "String: "+strValue+" Integer: "+intValue;
	}
}
