package bus;

import java.util.ArrayList;
import java.util.Collections;

public class VehiclesFleet {

	private static ArrayList <Vehicle> vehicleList = new ArrayList<Vehicle>();
	
	public static void setVehicleList(ArrayList<Vehicle> vehicleList)
	{
		VehiclesFleet.vehicleList = vehicleList;
	}
	
	public static ArrayList <Vehicle> getVehicleList()
	{
		return vehicleList;
	}
	
	public static ArrayList <GasVehicle> getGasVehicleList()
	{
		ArrayList <GasVehicle> gasList = new ArrayList <GasVehicle>();
		for (Vehicle vehicle : vehicleList)
		{
			if (vehicle instanceof GasVehicle)
			{
				gasList.add((GasVehicle)vehicle);
			}
		}
		return gasList;
	}
	
	public static ArrayList <ElectricVehicle> getElectricVehicleList()
	{
		ArrayList <ElectricVehicle> electricList = new ArrayList <ElectricVehicle>();
		for (Vehicle vehicle : vehicleList)
		{
			if (vehicle instanceof ElectricVehicle)
			{
				electricList.add((ElectricVehicle)vehicle);
			}
		}
		return electricList;
	}
	
	public static void add(Vehicle object)
	{
		vehicleList.add(object);
	}
	
	public static void remove(Vehicle object)
	{
		vehicleList.remove(object);
	}
	
	public static Vehicle search(String key)
	{
		Vehicle searchedVehicle = null;
		
		for (Vehicle vehicle : vehicleList)
		{
			if (vehicle.getSerialNumber().equals(key))
			{
				searchedVehicle = vehicle;
				break;
			}
		}
		return searchedVehicle;
	}
	
	public static void printGasVehicles()
	{
		System.out.println("List of Gas Vehicles");
		for (GasVehicle gv : getGasVehicleList()) 
		{
			System.out.println(gv.toString());
		}
	}
	
	public static void printElectricVehicles()
	{
		System.out.println("List of Electric Vehicles");
		for (ElectricVehicle ev : getElectricVehicleList()) 
		{
			System.out.println(ev.toString());
		}
	}
	
	public static void sortBySerialNumber()
	{
		Collections.sort(vehicleList, new SerialNumberComparator());
	}
	
	public static void sortByMileageEfficiency()
	{
		Collections.sort(vehicleList, new MileageEfficiencyComparator());
	}
	
	public static void printAllVehicles()
	{
		System.out.println("List of all Vehicles");
		for (Vehicle vehicle : getVehicleList()) 
		{
			System.out.println(vehicle.toString());
		}
	}
}
