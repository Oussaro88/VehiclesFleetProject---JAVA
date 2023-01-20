package bus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class VehiclesFleet {

	private static VehiclesFleet singleInstance = null;
	
	private ArrayList <Vehicle> vehicleList;
	
	public static VehiclesFleet getSingleInstance() 
	{
		if(singleInstance == null)
		{
			singleInstance = new VehiclesFleet();
		}
		return singleInstance;
	}
	
	private VehiclesFleet()
	{
		vehicleList = new ArrayList<Vehicle>();
	}
	
	public void setVehicleList(ArrayList<Vehicle> vehicleList)
	{
		singleInstance.vehicleList = vehicleList;
	}
	
	public ArrayList <Vehicle> getVehicleList()
	{
		return singleInstance.vehicleList;
	}
	
	public ArrayList <GasVehicle> getGasVehicleList()
	{
		ArrayList <GasVehicle> gasList = new ArrayList <GasVehicle>();
		for (Vehicle vehicle : singleInstance.vehicleList)
		{
			if (vehicle instanceof GasVehicle)
			{
				gasList.add((GasVehicle)vehicle);
			}
		}
		return gasList;
	}
	
	public ArrayList <ElectricVehicle> getElectricVehicleList()
	{
		ArrayList <ElectricVehicle> electricList = new ArrayList <ElectricVehicle>();
		for (Vehicle vehicle : singleInstance.vehicleList)
		{
			if (vehicle instanceof ElectricVehicle)
			{
				electricList.add((ElectricVehicle)vehicle);
			}
		}
		return electricList;
	}
	
	public void add(Vehicle object)
	{
		singleInstance.vehicleList.add(object);
	}
	
	public void remove(String key)
	{
		for (Vehicle vehicle : singleInstance.vehicleList)
		{
			if (vehicle.getSerialNumber().equals(key))
			{
				singleInstance.vehicleList.remove(vehicle);
				break;
			}
		}
	}
	
	public Vehicle search(String key)
	{
		Vehicle searchedVehicle = null;
		
		for (Vehicle vehicle : singleInstance.vehicleList)
		{
			if (vehicle.getSerialNumber().equals(key))
			{
				searchedVehicle = vehicle;
				break;
			}
		}
		return searchedVehicle;
	}
	
	public void printGasVehicles()
	{
		System.out.println("List of Gas Vehicles");
		for (GasVehicle gv : getGasVehicleList()) 
		{
			System.out.println(gv.toString());
		}
	}
	
	public void printElectricVehicles()
	{
		System.out.println("List of Electric Vehicles");
		for (ElectricVehicle ev : getElectricVehicleList()) 
		{
			System.out.println(ev.toString());
		}
	}
	
	public void sortBySerialNumber()
	{
		Collections.sort(singleInstance.vehicleList, new SerialNumberComparator());
	}
	
	public void sortByMileageEfficiency()
	{
		Collections.sort(singleInstance.vehicleList, new MileageEfficiencyComparator());
	}
	
	public void printAllVehicles()
	{
		System.out.println("List of all Vehicles");
		for (Vehicle vehicle : getVehicleList()) 
		{
			System.out.println(vehicle.toString());
		}
	}
	
	public void saveVehicleList() throws IOException
	{
		FileManager.writeSerializedFile(singleInstance.vehicleList);
	}
	
	public ArrayList<Vehicle> loadVehicleList() throws IOException, ClassNotFoundException
	{
		return FileManager.readSerializedFile();
	}
}
