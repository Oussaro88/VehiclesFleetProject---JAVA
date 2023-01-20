package bus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class VehiclesFleetHashMap {

	private static VehiclesFleetHashMap singleInstance = null;
	
	private HashMap <Long, Vehicle> vehicleList;
	
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
		vehicleList = new HashMap <Long, Vehicle>();
	}
	
	public void setVehicleList(HashMap <Long, Vehicle> vehicleList)
	{
		singleInstance.vehicleList = vehicleList;
	}
	
	public HashMap <Long, Vehicle> getVehicleList()
	{
		return singleInstance.vehicleList;
	}
	
	public HashMap <Long, GasVehicle> getGasVehicleList()
	{
		HashMap <Long, GasVehicle> gasList = new HashMap <Long, GasVehicle>();
		for (Vehicle vehicle : singleInstance.vehicleList.values())
		{
			if (vehicle instanceof GasVehicle)
			{
				gasList.put(vehicle.getSerialNumber(), (GasVehicle)vehicle);
			}
		}
		return gasList;
	}
	
	public HashMap <Long, ElectricVehicle> getElectricVehicleList()
	{
		HashMap <Long, ElectricVehicle> electricList = new HashMap <Long, ElectricVehicle>();
		for (Vehicle vehicle : singleInstance.vehicleList.values())
		{
			if (vehicle instanceof ElectricVehicle)
			{
				electricList.put(vehicle.getSerialNumber(), (ElectricVehicle)vehicle);
			}
		}
		return electricList;
	}
	
	public void add(Vehicle object)
	{
		singleInstance.vehicleList.put(object.getSerialNumber(), object);
	}
	
	public void remove(Long key)
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
	
	public Vehicle searchBySerialNumber(Long key)
	{
		Vehicle searchedVehicle = null;
		
		for (Vehicle vehicle : singleInstance.vehicleList.values())
		{
			if (vehicle.getSerialNumber().equals(key))
			{
				searchedVehicle = vehicle;
				break;
			}
		}
		return searchedVehicle;
	}
	
	public Vehicle searchByModel(String key)
	{
		Vehicle searchedVehicle = null;
		
		for (Vehicle vehicle : singleInstance.vehicleList.values())
		{
			if (vehicle.getModel().equals(key))
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
	
	/*
	 * In ApplicationTester
	 * VehicleFleet.Sort(new SerialNumberComparator());
	 */
	public void Sort(SerialNumberComparator predict)
	{
		ArrayList<Vehicle> sortList = new ArrayList<Vehicle>(singleInstance.vehicleList.values());
		Collections.sort(sortList, predict);
		singleInstance.vehicleList.clear();
		for (Vehicle vehicle : sortList)
		{
			System.out.println(vehicle.toString() + " MileageEfficiency= " + String.format("%.2f", vehicle.getMilePerUnitOfEnergyConsumed()));
			singleInstance.vehicleList.put(vehicle.getSerialNumber(), vehicle);
		}
	}
	
	public void Sort(MileageEfficiencyComparator predict)
	{
		ArrayList<Vehicle> sortList = new ArrayList<Vehicle>(singleInstance.vehicleList.values());
		Collections.sort(sortList, predict);
		singleInstance.vehicleList.clear();
		for (Vehicle vehicle : sortList)
		{
			System.out.println(vehicle.toString() + " MileageEfficiency= " + String.format("%.2f", vehicle.getMilePerUnitOfEnergyConsumed()));
			singleInstance.vehicleList.put(vehicle.getSerialNumber(), vehicle);
		}
	}
	
	public void sortBySerialNumber()
	{
		ArrayList<Vehicle> sortList = new ArrayList<Vehicle>(singleInstance.vehicleList.values());
		Collections.sort(sortList, new SerialNumberComparator());
		singleInstance.vehicleList.clear();
		for (Vehicle vehicle : sortList)
		{
			System.out.println(vehicle.toString() + " MileageEfficiency= " + String.format("%.2f", vehicle.getMilePerUnitOfEnergyConsumed()));
			singleInstance.vehicleList.put(vehicle.getSerialNumber(), vehicle);
		}
	}
	
	public void sortByMileageEfficiency()
	{
		ArrayList<Vehicle> sortList = new ArrayList<Vehicle>(singleInstance.vehicleList.values());
		Collections.sort(sortList, new MileageEfficiencyComparator());
		singleInstance.vehicleList.clear();
		for (Vehicle vehicle : sortList)
		{
			System.out.println(vehicle.toString() + " MileageEfficiency= " + String.format("%.2f", vehicle.getMilePerUnitOfEnergyConsumed()));
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
	
	public void printAllVehiclesWME()
	{
		System.out.println("List of all Vehicles; with MileageEfficiency");
		for (Vehicle vehicle : getVehicleList().values()) 
		{
			System.out.println(vehicle.toString() + " MileageEfficiency= " + String.format("%.2f", vehicle.getMilePerUnitOfEnergyConsumed()));
		}
	}
	
	public void saveVehicleList() throws IOException
	{
		FileManagerHashMap.writeSerializedFile(singleInstance.vehicleList);
	}
	
	public HashMap<Long, Vehicle> loadVehicleList() throws IOException, ClassNotFoundException
	{
		singleInstance.vehicleList = FileManagerHashMap.readSerializedFile();
		return FileManagerHashMap.readSerializedFile();
	}
}
