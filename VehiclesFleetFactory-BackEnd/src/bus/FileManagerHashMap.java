package bus;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class FileManagerHashMap {

	private static String filePath = "src//data//VehicleFleet.ser";
	
	public static void writeSerializedFile(HashMap <Long, Vehicle> vehicleMap) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(vehicleMap);
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	public static HashMap <Long, Vehicle> readSerializedFile() throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		HashMap <Long, Vehicle> vehicleMap = new HashMap <Long, Vehicle>();
		vehicleMap = (HashMap <Long, Vehicle>) ois.readObject();
		fis.close();
		return vehicleMap;
	}
}
