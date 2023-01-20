package bus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class VehiclesFleetHashMap {

	private static VehiclesFleetHashMap singleInstance = null;
	
	private HashMap <String, Vehicle> vehicleList;
	
	public static VehiclesFleetHashMap getSingleInstance() 
	{
		if(singleInstance == null)
		{
			singleInstance = new VehiclesFleetHashMap();
		}
		return singleInstance;
	}
	
	private VehiclesFleetHashMap()
	{
		vehicleList = new HashMap<String, Vehicle>();
	}
	
	public void setVehicleList(HashMap<String, Vehicle> vehicleList)
	{
		singleInstance.vehicleList = vehicleList;
	}
	
	public HashMap <String, Vehicle> getVehicleList()
	{
		return singleInstance.vehicleList;
	}
	
	public HashMap <String, GasVehicle> getGasVehicleList()
	{
		HashMap <String, GasVehicle> gasList = new HashMap <String, GasVehicle>();
		for (Vehicle vehicle : singleInstance.vehicleList.values())
		{
			if (vehicle instanceof GasVehicle)
			{
				gasList.put(vehicle.getSerialNumber(), (GasVehicle)vehicle);
			}
		}
		return gasList;
	}
	
	public HashMap <String, ElectricVehicle> getElectricVehicleList()
	{
		HashMap <String, ElectricVehicle> electricList = new HashMap <String, ElectricVehicle>();
		for (Vehicle vehicle : singleInstance.vehicleList.values())
		{
			if (vehicle instanceof ElectricVehicle)
			{
				electricList.put(vehicle.getSerialNumber(), (ElectricVehicle)vehicle);
			}
		}
		return electricList;
	}
	
	public void add(String key, Vehicle object)
	{
		singleInstance.vehicleList.put(key, object);
	}
	
	public void remove(String key)
	{
		for (Vehicle vehicle : singleInstance.vehicleList.values())
		{
			if (vehicle.getSerialNumber().equals(key))
			{
				singleInstance.vehicleList.remove(vehicle.getSerialNumber());
				break;
			}
		}
	}
	
	public Vehicle search(String key)
	{
		Vehicle searchedVehicle = null;
		/*
		ArrayList<Vehicle> searchedList = new ArrayList<Vehicle>();
		
		if (singleInstance.vehicleList.containsKey(key))
		{
			searchedList.add(singleInstance.vehicleList.get(key));
		}
		
		for(Vehicle vehicle : searchedList)
		{
			searchedVehicle = vehicle;
		}
		*/
		if (singleInstance.vehicleList.containsKey(key))
		{
			searchedVehicle = singleInstance.vehicleList.get(key);
		}
		
		return searchedVehicle;
	}
	
	public ArrayList<Vehicle> searchList(String key)
	{
		ArrayList<Vehicle> searchedList = new ArrayList<Vehicle>();
		
		if (singleInstance.vehicleList.containsKey(key))
		{
			searchedList.add(singleInstance.vehicleList.get(key));
		}
		
		return searchedList;
	}
	
	public void printGasVehicles()
	{
		System.out.println("List of Gas Vehicles");
		for (GasVehicle gv : getGasVehicleList().values()) 
		{
			System.out.println(gv.toString());
		}
	}
	
	public void printElectricVehicles()
	{
		System.out.println("List of Electric Vehicles");
		for (ElectricVehicle ev : getElectricVehicleList().values()) 
		{
			System.out.println(ev.toString());
		}
	}
	
	public void clear() 
	{
		singleInstance.vehicleList.clear();
	}
	
	public void sortBySerialNumber()
	{
		ArrayList<Vehicle> sortList = new ArrayList<Vehicle>(singleInstance.vehicleList.values());
		Collections.sort(sortList, new SerialNumberComparator());
		clear();
		for (Vehicle vehicle : sortList)
		{
			singleInstance.vehicleList.put(vehicle.getSerialNumber(), vehicle);
		}
	}
	
	public void sortByMileageEfficiency()
	{
		ArrayList<Vehicle> sortList = new ArrayList<Vehicle>(singleInstance.vehicleList.values());
		Collections.sort(sortList, new MileageEfficiencyComparator());
		clear();
		for (Vehicle vehicle : sortList)
		{
			singleInstance.vehicleList.put(vehicle.getSerialNumber(), vehicle);
		}
	}
	
	public void printAllVehicles()
	{
		System.out.println("List of all Vehicles");
		for (Vehicle vehicle : getVehicleList().values()) 
		{
			System.out.println(vehicle.toString());
		}
	}
	
	public void saveVehicleList() throws IOException
	{
		ArrayList<Vehicle> sortList = new ArrayList<Vehicle>(singleInstance.vehicleList.values());
		FileManager.writeSerializedFile(sortList);
	}
	
	public ArrayList<Vehicle> loadVehicleList() throws IOException, ClassNotFoundException
	{
		return FileManager.readSerializedFile();
	}
}
