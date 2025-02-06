package task8.files.enumerator;

public enum Colors {
	Violet(1),Indigo(2),Blue(3),Green(4),Yellow(5),Orange(6),Red(7);
	
	private int colorCode;
	
	Colors(int colorCode) {
		this.colorCode= colorCode;
	}
	
	public int getValues() {
		return colorCode;
	}
	
}
