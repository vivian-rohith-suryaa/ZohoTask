package task8.files.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import exceptions.custom.CustomException;

public class CarsRunner {

	public static void main(String[] args) throws IOException, ClassNotFoundException, CustomException, CloneNotSupportedException {
		Cars car = new Cars("SUV","Red","AZ23",2201);
		CarsRunner cr = new CarsRunner();
		cr.writingObject(car);
		System.out.println(cr.readingObject());
		Cars car2 = (Cars) car.cloneObj();
		System.out.println(car);
		System.out.println(car2);
	}
	
	public void writingObject(Cars car) throws IOException {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Cars1.ser"))){
			out.writeObject(car);
		}
		catch(IOException e) {
			System.out.println("Error in writing an object");
		}
	}
	
	public Cars readingObject() throws IOException, ClassNotFoundException, CustomException {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("Cars1.ser"))){
			return (Cars)in.readObject();
		}
		catch(IOException|ClassNotFoundException e) {
			throw new CustomException("Exception"+e);
		}
	}

}
