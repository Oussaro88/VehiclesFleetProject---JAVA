package bus;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager {

	private static String filePath = "src//data//VehicleFleet.ser";
	
	public static void writeSerializedFile(ArrayList<Vehicle> vehicleList) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(vehicleList);
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList <Vehicle> readSerializedFile() throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles = (ArrayList<Vehicle>) ois.readObject();
		fis.close();
		return vehicles;
	}
}
