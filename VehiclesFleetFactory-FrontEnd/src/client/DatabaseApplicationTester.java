package client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import bus.ElectricVehicle;
import bus.GasVehicle;
import bus.MileageEfficiencyComparator;
import bus.RaiseException;
//import bus.Vehicle;
//import bus.VehiclesFleet;
//import bus.VehiclesFleetHashMap;

public class DatabaseApplicationTester {
	
	public static int displayMenu(Scanner scan) throws RaiseException, IOException, ClassNotFoundException, SQLException 
	{
		int value = 0;
		System.out.println(""
				+ "\n1. Create & Add Vehicle to Database"
				+ "\n2. Search Vehicle by Serial Number"
				+ "\n3. Update Vehicle in Database"
				+ "\n4. Sort by Mileage Efficiency"
				+ "\n5. Remove Vehicle from Database"
				+ "\n6. Print Gasoline Vehicles from Database"
				+ "\n7. Print Electric Vehicles from Database"
				+ "\n8. Make Trip Vehicles Fleet in Database"
				+ "\n9. Print Vehicles from Fleet with Mileage Efficiency");
		System.out.println("Select an action (Number from 1 to 9) "
				+ "or any other Integer to Exit the Application");
		value = scan.nextInt();
		switch(value)
		{
		case 1: //Create & Add Vehicle to Database
			System.out.println("Adding a Vehicle into the Fleet of Vehicles");
			createChoiceVehicle(scan);
			break;
		case 2: //Search Vehicle by Serial Number
			System.out.println("Searching Vehicle by Serial Number in Database");
			searchChoiceVehicle(scan);
			break;
		case 3: //Update Vehicle in Database
			System.out.println("Updating Vehicle in Database");
			updateChoiceVehicle(scan);
			break;
		case 4: //Sort Vehicles Fleet by Mileage Efficiency
			System.out.println("Sorting Vehicles by Mileage Efficiency");
			sortByMileageEfficiency(scan);
			break;
		case 5: //Remove Vehicle from Database
			System.out.println("Removing Vehicles from Database");
			removeChoiceVehicle(scan);
			break;
		case 6: //Print Gasoline Vehicles from Database
			System.out.println("Printing Gasoline Vehicles");
			ArrayList<GasVehicle> gvList = GasVehicle.getData();
			for (GasVehicle gv : gvList) 
			{
				System.out.println(gv.toString());
			}
			break;
		case 7: //Print Electric Vehicles from Database
			System.out.println("Printing Electric Vehicles");
			ArrayList<ElectricVehicle> evList = ElectricVehicle.getData();
			for (ElectricVehicle ev : evList) 
			{
				System.out.println(ev.toString());
			}
			break;
		case 8: //Make Trip in Database
			System.out.println("Make Trip Vehicles in Database");
			makeTripVehiclesFleet(scan);
			break;
		case 9: //Print Vehicles from Database with Mileage Efficiency
			System.out.println("Printing Gasoline Vehicles");
			ArrayList<GasVehicle> gvList2 = GasVehicle.getData();
			for (GasVehicle gv : gvList2) 
			{
				System.out.println(gv.toString() + " MileageEfficiency= " + String.format("%.2f", gv.getMilePerUnitOfEnergyConsumed()));
			}
			System.out.println("Printing Electric Vehicles");
			ArrayList<ElectricVehicle> evList2 = ElectricVehicle.getData();
			for (ElectricVehicle ev : evList2) 
			{
				System.out.println(ev.toString() + " MileageEfficiency= " + String.format("%.2f", ev.getMilePerUnitOfEnergyConsumed()));
			}
			break;
		default: //WHEN DEFAULT - Exit Application
			return 0;
		}
		return 1;
	}
	
	//Choose Type of Vehicle to Add
	public static void createChoiceVehicle(Scanner scan) throws RaiseException, SQLException 
	{
		int value = 0;
		System.out.println("Which Type of Vehicle you which to add to the Fleet? (1) Gasoline or (2) Electric?");
		value = scan.nextInt();
		switch(value)
		{
		case 1: 
			System.out.println("Creating Gasoline Vehicle");
			createGasVehicle(scan);
			break;
		case 2:
			System.out.println("Creating Electric Vehicle");
			createElectricVehicle(scan);
			break; 
		default:
			System.out.println("Creating Gasoline Vehicle");
			createGasVehicle(scan);
			break;
		}
	}
	
	//Create GasVehicle
	public static void createGasVehicle(Scanner scan) throws RaiseException, SQLException 
	{
		
		boolean valid = false;
		GasVehicle gv = new GasVehicle();
			
		System.out.println("Enter Serial Number for Gasoline Vehicle: ");
		gv.setSerialNumber(scan.nextLong());
		System.out.println("Enter Made for Gasoline Vehicle: ");
		do
		{
			try
			{
				gv.setMade(scan.next());
				valid = true;
			}
			catch (RaiseException ex)
			{
				System.out.println(ex.getMessage());
			}
		} while (!valid);
		valid = false;
		System.out.println("Enter Model for Gasoline Vehicle: ");
		do
		{
			try
			{
				gv.setModel(scan.next());
				valid = true;
			}
			catch (RaiseException ex)
			{
				System.out.println(ex.getMessage());
			}
		} while (!valid);
		valid = false;
		System.out.println("Enter Date for Gasoline Vehicles: ");
		gv.setDate(scan.nextInt());
		System.out.println("Enter Max Speed for Gasoline Vehicle: ");
		do 
		{
			try 
			{
				gv.setMaxSpeed(scan.nextDouble());
				valid = true;
			}
			catch (RaiseException ex)
			{
				System.out.println(ex.getMessage());
			}
		} while (!valid);
		valid = false;
		System.out.println("Enter Brake Power for Gasoline Vehicle: ");
		do 
		{
			try 
			{
				gv.setBrakePower(scan.nextDouble());
				valid = true;
			}
			catch (RaiseException ex)
			{
				System.out.println(ex.getMessage());
			}
		} while (!valid);
		valid = false;
		
		System.out.println("Adding Vehicles into Vehicles Fleet");
		GasVehicle.add(gv);
	}
		
	//Create ElectricVehicle
	public static void createElectricVehicle(Scanner scan) throws RaiseException, SQLException
	{
		boolean valid = false;
		ElectricVehicle ev = new ElectricVehicle();
			
		System.out.println("Enter Serial Number for Electric Vehicle: ");
		ev.setSerialNumber(scan.nextLong());
		System.out.println("Enter Made for Electric Vehicle: ");
		do
		{
			try
			{
				ev.setMade(scan.next());
				valid = true;
			}
			catch (RaiseException ex)
			{
				System.out.println(ex.getMessage());
			}
		} while (!valid);
		valid = false;
		System.out.println("Enter Model for Electric Vehicle: ");
		do
		{
			try
			{
				ev.setModel(scan.next());
				valid = true;
			}
			catch (RaiseException ex)
			{
				System.out.println(ex.getMessage());
			}
		} while (!valid);
		valid = false;
		System.out.println("Enter Date for Electric Vehicles: ");
		ev.setDate(scan.nextInt());
		System.out.println("Enter Max Speed for Electric Vehicle: ");
		do 
		{
			try 
			{
				ev.setMaxSpeed(scan.nextDouble());
				valid = true;
			}
			catch (RaiseException ex)
			{
				System.out.println(ex.getMessage());
			}
		} while (!valid);
		valid = false;
		System.out.println("Enter Brake Power for Electric Vehicle: ");
		do 
		{
			try 
			{
				ev.setBrakePower(scan.nextDouble());
				valid = true;
			}
			catch (RaiseException ex)
			{
				System.out.println(ex.getMessage());
			}
		} while (!valid);
		valid = false;
		
		System.out.println("Adding Vehicles into Vehicles Fleet");
		ElectricVehicle.add(ev);
	}
		
	//Choose Type of Vehicle to Update
	public static void updateChoiceVehicle(Scanner scan) throws RaiseException, SQLException 
	{
		int value = 0;
		System.out.println("Which Type of Vehicle you which to update? (1) Gasoline or (2) Electric?");
		value = scan.nextInt();
		switch(value)
		{
		case 1: 
			System.out.println("Creating Gasoline Vehicle");
			updateGasVehicle(scan);
			break;
		case 2:
			System.out.println("Creating Electric Vehicle");
			updateElectricVehicle(scan);
			break; 
		default:
			System.out.println("Creating Gasoline Vehicle");
			updateGasVehicle(scan);
			break;
		}
	}
		
	//Update GasVehicle
	public static void updateGasVehicle(Scanner scan) throws RaiseException, SQLException 
	{		
		boolean valid = false;
		GasVehicle gv = new GasVehicle();
				
		System.out.println("Enter Serial Number for Gasoline Vehicle you wish to update: ");
		gv.setSerialNumber(scan.nextLong());
		System.out.println("Enter New Made for Gasoline Vehicle: ");
		do
		{
			try
			{
				gv.setMade(scan.next());
				valid = true;
			}
			catch (RaiseException ex)
			{
				System.out.println(ex.getMessage());
			}
		} while (!valid);
		valid = false;
		System.out.println("Enter New Model for Gasoline Vehicle: ");
		do
		{
			try
			{
				gv.setModel(scan.next());
				valid = true;
			}
			catch (RaiseException ex)
			{
				System.out.println(ex.getMessage());
			}
		} while (!valid);
		valid = false;
		System.out.println("Enter New Date for Gasoline Vehicles: ");
		gv.setDate(scan.nextInt());
		System.out.println("Enter New Max Speed for Gasoline Vehicle: ");
		do 
		{
			try 
			{
				gv.setMaxSpeed(scan.nextDouble());
				valid = true;
			}
			catch (RaiseException ex)
			{
				System.out.println(ex.getMessage());
			}
		} while (!valid);
		valid = false;
		System.out.println("Enter New Brake Power for Gasoline Vehicle: ");
		do 
		{
			try 
			{
				gv.setBrakePower(scan.nextDouble());
				valid = true;
			}
			catch (RaiseException ex)
			{
				System.out.println(ex.getMessage());
			}
		} while (!valid);
		valid = false;
		/*System.out.println("Enter New Trip Counter for Gasoline Vehicle: ");
		gv.setTripCounter(scan.nextInt());
		System.out.println("Enter New Fuel Consumed for Gasoline Vehicle: ");
		gv.setFuelConsumed(scan.nextDouble());*/
		
		System.out.println("Updating Gasoline Vehicle.");
		GasVehicle.update(gv);
	}
			
	//Update ElectricVehicle
	public static void updateElectricVehicle(Scanner scan) throws RaiseException, SQLException
	{
		boolean valid = false;
		ElectricVehicle ev = new ElectricVehicle();
				
		System.out.println("Enter Serial Number for Electric Vehicle you wish to update: ");
		ev.setSerialNumber(scan.nextLong());
		System.out.println("Enter New Made for Electric Vehicle: ");
		do
		{
			try
			{
				ev.setMade(scan.next());
				valid = true;
			}
			catch (RaiseException ex)
			{
				System.out.println(ex.getMessage());
			}
		} while (!valid);
		valid = false;
		System.out.println("Enter New Model for Electric Vehicle: ");
		do
		{
			try
			{
				ev.setModel(scan.next());
				valid = true;
			}
			catch (RaiseException ex)
			{
				System.out.println(ex.getMessage());
			}
		} while (!valid);
		valid = false;
		System.out.println("Enter New Date for Electric Vehicles: ");
		ev.setDate(scan.nextInt());
		System.out.println("Enter New Max Speed for Electric Vehicle: ");
		do 
		{
			try 
			{
				ev.setMaxSpeed(scan.nextDouble());
				valid = true;
			}
			catch (RaiseException ex)
			{
				System.out.println(ex.getMessage());
			}
		} while (!valid);
		valid = false;
		System.out.println("Enter New Brake Power for Electric Vehicle: ");
		do 
		{
			try 
			{
				ev.setBrakePower(scan.nextDouble());
				valid = true;
			}
			catch (RaiseException ex)
			{
				System.out.println(ex.getMessage());
			}
		} while (!valid);
		valid = false;
		
		System.out.println("Updating Electric Vehicles.");
		ElectricVehicle.update(ev);
	}
	
	//Choose Type of Vehicle to search
	public static void searchChoiceVehicle(Scanner scan) throws RaiseException, SQLException 
	{
		int value = 0;
		System.out.println("Which Type of Vehicle you which to add to the Fleet? (1) Gasoline or (2) Electric?");
		value = scan.nextInt();
		switch(value)
		{
		case 1: 
			System.out.println("Enter the Serial Number of the Gasoline Vehicle you wish to search:");
			System.out.println(GasVehicle.search(Long.toString(scan.nextLong())));
			break;
		case 2:
			System.out.println("Enter the Serial Number of the Electric Vehicle you wish to search:");
			System.out.println(ElectricVehicle.search(Long.toString(scan.nextLong())));
			break; 
		default:
			System.out.println("Enter the Serial Number of the Gasoline Vehicle you wish to search:");
			System.out.println(GasVehicle.search(Long.toString(scan.nextLong())));
			break;
		}
	}
	
	//Choose Type of Vehicle to Remove
	public static void removeChoiceVehicle(Scanner scan) throws RaiseException, SQLException 
	{
		int value = 0;
		System.out.println("Which Type of Vehicle you which to add to the Fleet? (1) Gasoline or (2) Electric?");
		value = scan.nextInt();
		switch(value)
		{
		case 1: 
			System.out.println("Enter the Serial Number of the Gasoline Vehicle you wish to remove.");
			GasVehicle.remove(Long.toString(scan.nextLong()));
			break;
		case 2:
			System.out.println("Enter the Serial Number of the Electric Vehicle you wish to remove.");
			ElectricVehicle.remove(Long.toString(scan.nextLong()));
			break; 
		default:
			System.out.println("Enter the Serial Number of the Gasoline Vehicle you wish to remove.");
			GasVehicle.remove(Long.toString(scan.nextLong()));
			break;
		}
	}
	
	//Make Trip for all Vehicles in VehiclesFleet
	public static void makeTripVehiclesFleet(Scanner scan) throws RaiseException, NumberFormatException, SQLException
	{
		GasVehicle gv = new GasVehicle();
			
		for (GasVehicle gasVehicle : GasVehicle.getData())
		{
			if (gasVehicle.getTripCounter() == 0 || gasVehicle.getFuelConsumed() == 0) 
			{
				gv = gasVehicle;
				makeTripGasVehicle(scan, gv);
				GasVehicle.update(gv);
				System.out.println("Gasoline Vehicle's Mileage Efficiency: " + String.format("%.2f", gv.getMilePerUnitOfEnergyConsumed()));
			}
		}

		ElectricVehicle ev = new ElectricVehicle();
		
		for (ElectricVehicle electricVehicle : ElectricVehicle.getData())
		{
			if (electricVehicle.getTripCounter() == 0 || electricVehicle.getKwPowerConsumed() == 0) 
			{
				ev = electricVehicle;
				makeTripElectricVehicle(scan, ev);
				ElectricVehicle.update(ev);
				System.out.println("Electric Vehicle's Mileage Efficiency: " + String.format("%.2f", ev.getMilePerUnitOfEnergyConsumed()));
			}
		}		
	}
			
	//Personalized MakeTrip for GasVehicle
	public static void makeTripGasVehicle(Scanner scan, GasVehicle gv)
	{
		Integer tripCounter;
		Double fuelConsumed;
		System.out.println("Enter Trip Counter for Gasoline Vehicle: ");
		tripCounter = scan.nextInt();
		System.out.println("Enter Fuel Consumed for Gasoline Vehicle: ");
		fuelConsumed = scan.nextDouble();
		gv.makeTrip(tripCounter, fuelConsumed);
	}
			
	//Personalized MakeTrip for ElectricVehicle
	public static void makeTripElectricVehicle(Scanner scan, ElectricVehicle ev)
	{
		Integer tripCounter;
		Double kwPowerConsumed;
		System.out.println("Enter Trip Counter for Electric Vehicle: ");
		tripCounter = scan.nextInt();
		System.out.println("Enter Kw Power Consumed for Electric Vehicle: ");
		kwPowerConsumed = scan.nextDouble();
		ev.makeTrip(tripCounter, kwPowerConsumed);
	}
		
	public static void sortByMileageEfficiency(Scanner scan) throws NumberFormatException, SQLException, RaiseException
	{
		ArrayList<GasVehicle> gvList = GasVehicle.getData();
		Collections.sort(gvList, new MileageEfficiencyComparator());
		
		for (GasVehicle gv : gvList)
		{
			System.out.println(gv.toString() + " MileageEfficiency= " + String.format("%.2f", gv.getMilePerUnitOfEnergyConsumed()));
		}

		ArrayList<ElectricVehicle> evList = ElectricVehicle.getData();
		Collections.sort(evList, new MileageEfficiencyComparator());
		
		for (ElectricVehicle ev : evList)
		{
			System.out.println(ev.toString() + " MileageEfficiency= " + String.format("%.2f", ev.getMilePerUnitOfEnergyConsumed()));
		}
	}

	public static void main(String[] args) throws RaiseException, IOException, ClassNotFoundException, SQLException {

		Scanner scan = new Scanner(System.in);
		
		int exitApplication = 0;
		
		do {
			exitApplication = displayMenu(scan);
		} while (exitApplication != 0);
		
		System.out.println("You exited the application. Thank you very much.");
		
		scan.close();
		System.exit(0);
	}
}

/********** **Output** **********


1. Create & Add Vehicle to Database
2. Search Vehicle by Serial Number
3. Update Vehicle in Database
4. Sort by Mileage Efficiency
5. Remove Vehicle from Database
6. Print Gasoline Vehicles from Database
7. Print Electric Vehicles from Database
8. Make Trip Vehicles Fleet in Database
9. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 9) or any other Integer to Exit the Application
1
Adding a Vehicle into the Fleet of Vehicles
Which Type of Vehicle you which to add to the Fleet? (1) Gasoline or (2) Electric?
1
Creating Gasoline Vehicle
Enter Serial Number for Gasoline Vehicle: 
0016
Enter Made for Gasoline Vehicle: 
England
Enter Model for Gasoline Vehicle: 
Minicooper
Enter Date for Gasoline Vehicles: 
20200404
Enter Max Speed for Gasoline Vehicle: 
260
Enter Brake Power for Gasoline Vehicle: 
50
Adding Vehicles into Vehicles Fleet
Connection successful

1. Create & Add Vehicle to Database
2. Search Vehicle by Serial Number
3. Update Vehicle in Database
4. Sort by Mileage Efficiency
5. Remove Vehicle from Database
6. Print Gasoline Vehicles from Database
7. Print Electric Vehicles from Database
8. Make Trip Vehicles Fleet in Database
9. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 9) or any other Integer to Exit the Application
2
Searching Vehicle by Serial Number in Database
Which Type of Vehicle you which to add to the Fleet? (1) Gasoline or (2) Electric?
1
Enter the Serial Number of the Gasoline Vehicle you wish to search:
0016
Connection successful
GasVehicle [serialNumber=16, made=England, model=Minicooper, date=20200404, tripCounter=0, maxSpeed=260.0, brakePower=50.0, fuelConsumed=0.0]

1. Create & Add Vehicle to Database
2. Search Vehicle by Serial Number
3. Update Vehicle in Database
4. Sort by Mileage Efficiency
5. Remove Vehicle from Database
6. Print Gasoline Vehicles from Database
7. Print Electric Vehicles from Database
8. Make Trip Vehicles Fleet in Database
9. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 9) or any other Integer to Exit the Application
3
Updating Vehicle in Database
Which Type of Vehicle you which to update? (1) Gasoline or (2) Electric?
2
Creating Electric Vehicle
Enter Serial Number for Electric Vehicle you wish to update: 
0006
Enter New Made for Electric Vehicle: 
Japan
Enter New Model for Electric Vehicle: 
Subaru
Enter New Date for Electric Vehicles: 
20190517
Enter New Max Speed for Electric Vehicle: 
270
Enter New Brake Power for Electric Vehicle: 
60
Updating Electric Vehicles.
Connection successful

1. Create & Add Vehicle to Database
2. Search Vehicle by Serial Number
3. Update Vehicle in Database
4. Sort by Mileage Efficiency
5. Remove Vehicle from Database
6. Print Gasoline Vehicles from Database
7. Print Electric Vehicles from Database
8. Make Trip Vehicles Fleet in Database
9. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 9) or any other Integer to Exit the Application
4
Sorting Vehicles by Mileage Efficiency
Connection successful
GasVehicle [serialNumber=14, made=italy, model=opel, date=20140420, tripCounter=210, maxSpeed=180.0, brakePower=40.0, fuelConsumed=19.5] MileageEfficiency= 10,77
GasVehicle [serialNumber=6, made=USA, model=ford, date=20110717, tripCounter=280, maxSpeed=280.0, brakePower=65.0, fuelConsumed=20.2] MileageEfficiency= 13,86
GasVehicle [serialNumber=10, made=france, model=citroen, date=20070528, tripCounter=410, maxSpeed=220.0, brakePower=65.0, fuelConsumed=25.4] MileageEfficiency= 16,14
GasVehicle [serialNumber=5, made=germany, model=mercedes, date=20210717, tripCounter=320, maxSpeed=320.0, brakePower=90.0, fuelConsumed=18.2] MileageEfficiency= 17,58
GasVehicle [serialNumber=13, made=japan, model=honda, date=20190701, tripCounter=310, maxSpeed=270.0, brakePower=55.0, fuelConsumed=15.1] MileageEfficiency= 20,53
GasVehicle [serialNumber=9, made=italy, model=alfaromeo, date=20170420, tripCounter=310, maxSpeed=280.0, brakePower=70.0, fuelConsumed=11.7] MileageEfficiency= 26,50
GasVehicle [serialNumber=15, made=japan, model=toyota, date=20150101, tripCounter=490, maxSpeed=240.0, brakePower=70.0, fuelConsumed=18.3] MileageEfficiency= 26,78
GasVehicle [serialNumber=12, made=usa, model=gmc, date=20180502, tripCounter=510, maxSpeed=280.0, brakePower=75.0, fuelConsumed=17.9] MileageEfficiency= 28,49
GasVehicle [serialNumber=7, made=USA, model=cadillac, date=20150417, tripCounter=580, maxSpeed=300.0, brakePower=80.0, fuelConsumed=20.2] MileageEfficiency= 28,71
GasVehicle [serialNumber=11, made=japan, model=subaru, date=20120502, tripCounter=610, maxSpeed=250.0, brakePower=75.0, fuelConsumed=20.6] MileageEfficiency= 29,61
GasVehicle [serialNumber=2, made=japan, model=nissan, date=20150313, tripCounter=240, maxSpeed=250.0, brakePower=60.0, fuelConsumed=7.7] MileageEfficiency= 31,17
GasVehicle [serialNumber=3, made=france, model=renault, date=20200313, tripCounter=500, maxSpeed=250.0, brakePower=80.0, fuelConsumed=14.2] MileageEfficiency= 35,21
GasVehicle [serialNumber=8, made=germany, model=audi, date=20150417, tripCounter=370, maxSpeed=290.0, brakePower=60.0, fuelConsumed=10.2] MileageEfficiency= 36,27
GasVehicle [serialNumber=4, made=germany, model=bmw, date=20090713, tripCounter=420, maxSpeed=180.0, brakePower=30.0, fuelConsumed=10.2] MileageEfficiency= 41,18
GasVehicle [serialNumber=1, made=japan, model=mazda, date=20050313, tripCounter=0, maxSpeed=150.0, brakePower=60.0, fuelConsumed=0.0] MileageEfficiency= NaN
GasVehicle [serialNumber=16, made=England, model=Minicooper, date=20200404, tripCounter=0, maxSpeed=260.0, brakePower=50.0, fuelConsumed=0.0] MileageEfficiency= NaN
Connection successful
ElectricVehicle [serialNumber=13, made=germany, model=volks, date=20171010, tripCounter=300, maxSpeed=240.0, brakePower=75.0, kwPowerConsumed=14.3] MileageEfficiency= 20,98
ElectricVehicle [serialNumber=8, made=USA, model=minicooper, date=20211001, tripCounter=370, maxSpeed=280.0, brakePower=60.0, kwPowerConsumed=12.8] MileageEfficiency= 28,91
ElectricVehicle [serialNumber=4, made=USA, model=ford, date=20180701, tripCounter=390, maxSpeed=280.0, brakePower=70.0, kwPowerConsumed=10.8] MileageEfficiency= 36,11
ElectricVehicle [serialNumber=6, made=japan, model=nissan, date=20170107, tripCounter=510, maxSpeed=260.0, brakePower=50.0, kwPowerConsumed=14.1] MileageEfficiency= 36,17
ElectricVehicle [serialNumber=7, made=japan, model=toyota, date=20160123, tripCounter=450, maxSpeed=260.0, brakePower=55.0, kwPowerConsumed=12.4] MileageEfficiency= 36,29
ElectricVehicle [serialNumber=3, made=USA, model=Tesla, date=20210101, tripCounter=480, maxSpeed=300.0, brakePower=80.0, kwPowerConsumed=12.7] MileageEfficiency= 37,80
ElectricVehicle [serialNumber=14, made=USA, model=ford, date=20160101, tripCounter=340, maxSpeed=300.0, brakePower=65.0, kwPowerConsumed=8.8] MileageEfficiency= 38,64
ElectricVehicle [serialNumber=1, made=Japan, model=Mazda, date=20150101, tripCounter=400, maxSpeed=250.0, brakePower=50.0, kwPowerConsumed=9.7] MileageEfficiency= 41,24
ElectricVehicle [serialNumber=15, made=USA, model=tesla, date=20190731, tripCounter=400, maxSpeed=290.0, brakePower=85.0, kwPowerConsumed=9.2] MileageEfficiency= 43,48
ElectricVehicle [serialNumber=2, made=France, model=Renault, date=20180122, tripCounter=500, maxSpeed=200.0, brakePower=65.0, kwPowerConsumed=11.2] MileageEfficiency= 44,64
ElectricVehicle [serialNumber=11, made=england, model=jaguar, date=20201218, tripCounter=670, maxSpeed=340.0, brakePower=95.0, kwPowerConsumed=14.5] MileageEfficiency= 46,21
ElectricVehicle [serialNumber=12, made=germany, model=porsche, date=20180510, tripCounter=700, maxSpeed=350.0, brakePower=85.0, kwPowerConsumed=15.1] MileageEfficiency= 46,36
ElectricVehicle [serialNumber=5, made=germany, model=bmw, date=20150507, tripCounter=610, maxSpeed=300.0, brakePower=80.0, kwPowerConsumed=13.1] MileageEfficiency= 46,56
ElectricVehicle [serialNumber=10, made=SKorea, model=kia, date=20210917, tripCounter=580, maxSpeed=270.0, brakePower=95.0, kwPowerConsumed=11.6] MileageEfficiency= 50,00
ElectricVehicle [serialNumber=9, made=germany, model=audi, date=20200507, tripCounter=610, maxSpeed=270.0, brakePower=90.0, kwPowerConsumed=9.1] MileageEfficiency= 67,03

1. Create & Add Vehicle to Database
2. Search Vehicle by Serial Number
3. Update Vehicle in Database
4. Sort by Mileage Efficiency
5. Remove Vehicle from Database
6. Print Gasoline Vehicles from Database
7. Print Electric Vehicles from Database
8. Make Trip Vehicles Fleet in Database
9. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 9) or any other Integer to Exit the Application
5
Removing Vehicles from Database
Which Type of Vehicle you which to add to the Fleet? (1) Gasoline or (2) Electric?
1
Enter the Serial Number of the Gasoline Vehicle you wish to remove.
0016
Connection successful

1. Create & Add Vehicle to Database
2. Search Vehicle by Serial Number
3. Update Vehicle in Database
4. Sort by Mileage Efficiency
5. Remove Vehicle from Database
6. Print Gasoline Vehicles from Database
7. Print Electric Vehicles from Database
8. Make Trip Vehicles Fleet in Database
9. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 9) or any other Integer to Exit the Application
6
Printing Gasoline Vehicles
Connection successful
GasVehicle [serialNumber=1, made=japan, model=mazda, date=20050313, tripCounter=0, maxSpeed=150.0, brakePower=60.0, fuelConsumed=0.0]
GasVehicle [serialNumber=2, made=japan, model=nissan, date=20150313, tripCounter=240, maxSpeed=250.0, brakePower=60.0, fuelConsumed=7.7]
GasVehicle [serialNumber=3, made=france, model=renault, date=20200313, tripCounter=500, maxSpeed=250.0, brakePower=80.0, fuelConsumed=14.2]
GasVehicle [serialNumber=4, made=germany, model=bmw, date=20090713, tripCounter=420, maxSpeed=180.0, brakePower=30.0, fuelConsumed=10.2]
GasVehicle [serialNumber=5, made=germany, model=mercedes, date=20210717, tripCounter=320, maxSpeed=320.0, brakePower=90.0, fuelConsumed=18.2]
GasVehicle [serialNumber=6, made=USA, model=ford, date=20110717, tripCounter=280, maxSpeed=280.0, brakePower=65.0, fuelConsumed=20.2]
GasVehicle [serialNumber=7, made=USA, model=cadillac, date=20150417, tripCounter=580, maxSpeed=300.0, brakePower=80.0, fuelConsumed=20.2]
GasVehicle [serialNumber=8, made=germany, model=audi, date=20150417, tripCounter=370, maxSpeed=290.0, brakePower=60.0, fuelConsumed=10.2]
GasVehicle [serialNumber=9, made=italy, model=alfaromeo, date=20170420, tripCounter=310, maxSpeed=280.0, brakePower=70.0, fuelConsumed=11.7]
GasVehicle [serialNumber=10, made=france, model=citroen, date=20070528, tripCounter=410, maxSpeed=220.0, brakePower=65.0, fuelConsumed=25.4]
GasVehicle [serialNumber=11, made=japan, model=subaru, date=20120502, tripCounter=610, maxSpeed=250.0, brakePower=75.0, fuelConsumed=20.6]
GasVehicle [serialNumber=12, made=usa, model=gmc, date=20180502, tripCounter=510, maxSpeed=280.0, brakePower=75.0, fuelConsumed=17.9]
GasVehicle [serialNumber=13, made=japan, model=honda, date=20190701, tripCounter=310, maxSpeed=270.0, brakePower=55.0, fuelConsumed=15.1]
GasVehicle [serialNumber=14, made=italy, model=opel, date=20140420, tripCounter=210, maxSpeed=180.0, brakePower=40.0, fuelConsumed=19.5]
GasVehicle [serialNumber=15, made=japan, model=toyota, date=20150101, tripCounter=490, maxSpeed=240.0, brakePower=70.0, fuelConsumed=18.3]

1. Create & Add Vehicle to Database
2. Search Vehicle by Serial Number
3. Update Vehicle in Database
4. Sort by Mileage Efficiency
5. Remove Vehicle from Database
6. Print Gasoline Vehicles from Database
7. Print Electric Vehicles from Database
8. Make Trip Vehicles Fleet in Database
9. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 9) or any other Integer to Exit the Application
7
Printing Electric Vehicles
Connection successful
ElectricVehicle [serialNumber=1, made=Japan, model=Mazda, date=20150101, tripCounter=400, maxSpeed=250.0, brakePower=50.0, kwPowerConsumed=9.7]
ElectricVehicle [serialNumber=2, made=France, model=Renault, date=20180122, tripCounter=500, maxSpeed=200.0, brakePower=65.0, kwPowerConsumed=11.2]
ElectricVehicle [serialNumber=3, made=USA, model=Tesla, date=20210101, tripCounter=480, maxSpeed=300.0, brakePower=80.0, kwPowerConsumed=12.7]
ElectricVehicle [serialNumber=4, made=USA, model=ford, date=20180701, tripCounter=390, maxSpeed=280.0, brakePower=70.0, kwPowerConsumed=10.8]
ElectricVehicle [serialNumber=5, made=germany, model=bmw, date=20150507, tripCounter=610, maxSpeed=300.0, brakePower=80.0, kwPowerConsumed=13.1]
ElectricVehicle [serialNumber=6, made=japan, model=nissan, date=20170107, tripCounter=510, maxSpeed=260.0, brakePower=50.0, kwPowerConsumed=14.1]
ElectricVehicle [serialNumber=7, made=japan, model=toyota, date=20160123, tripCounter=450, maxSpeed=260.0, brakePower=55.0, kwPowerConsumed=12.4]
ElectricVehicle [serialNumber=8, made=USA, model=minicooper, date=20211001, tripCounter=370, maxSpeed=280.0, brakePower=60.0, kwPowerConsumed=12.8]
ElectricVehicle [serialNumber=9, made=germany, model=audi, date=20200507, tripCounter=610, maxSpeed=270.0, brakePower=90.0, kwPowerConsumed=9.1]
ElectricVehicle [serialNumber=10, made=SKorea, model=kia, date=20210917, tripCounter=580, maxSpeed=270.0, brakePower=95.0, kwPowerConsumed=11.6]
ElectricVehicle [serialNumber=11, made=england, model=jaguar, date=20201218, tripCounter=670, maxSpeed=340.0, brakePower=95.0, kwPowerConsumed=14.5]
ElectricVehicle [serialNumber=12, made=germany, model=porsche, date=20180510, tripCounter=700, maxSpeed=350.0, brakePower=85.0, kwPowerConsumed=15.1]
ElectricVehicle [serialNumber=13, made=germany, model=volks, date=20171010, tripCounter=300, maxSpeed=240.0, brakePower=75.0, kwPowerConsumed=14.3]
ElectricVehicle [serialNumber=14, made=USA, model=ford, date=20160101, tripCounter=340, maxSpeed=300.0, brakePower=65.0, kwPowerConsumed=8.8]
ElectricVehicle [serialNumber=15, made=USA, model=tesla, date=20190731, tripCounter=400, maxSpeed=290.0, brakePower=85.0, kwPowerConsumed=9.2]

1. Create & Add Vehicle to Database
2. Search Vehicle by Serial Number
3. Update Vehicle in Database
4. Sort by Mileage Efficiency
5. Remove Vehicle from Database
6. Print Gasoline Vehicles from Database
7. Print Electric Vehicles from Database
8. Make Trip Vehicles Fleet in Database
9. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 9) or any other Integer to Exit the Application
8
Make Trip Vehicles in Database
Connection successful
Enter Trip Counter for Gasoline Vehicle: 
250
Enter Fuel Consumed for Gasoline Vehicle: 
7,8
Connection successful
Gasoline Vehicle's Mileage Efficiency: 32,05
Connection successful

1. Create & Add Vehicle to Database
2. Search Vehicle by Serial Number
3. Update Vehicle in Database
4. Sort by Mileage Efficiency
5. Remove Vehicle from Database
6. Print Gasoline Vehicles from Database
7. Print Electric Vehicles from Database
8. Make Trip Vehicles Fleet in Database
9. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 9) or any other Integer to Exit the Application
9
Printing Gasoline Vehicles
Connection successful
GasVehicle [serialNumber=1, made=japan, model=mazda, date=20050313, tripCounter=0, maxSpeed=150.0, brakePower=60.0, fuelConsumed=0.0] MileageEfficiency= NaN
GasVehicle [serialNumber=2, made=japan, model=nissan, date=20150313, tripCounter=240, maxSpeed=250.0, brakePower=60.0, fuelConsumed=7.7] MileageEfficiency= 31,17
GasVehicle [serialNumber=3, made=france, model=renault, date=20200313, tripCounter=500, maxSpeed=250.0, brakePower=80.0, fuelConsumed=14.2] MileageEfficiency= 35,21
GasVehicle [serialNumber=4, made=germany, model=bmw, date=20090713, tripCounter=420, maxSpeed=180.0, brakePower=30.0, fuelConsumed=10.2] MileageEfficiency= 41,18
GasVehicle [serialNumber=5, made=germany, model=mercedes, date=20210717, tripCounter=320, maxSpeed=320.0, brakePower=90.0, fuelConsumed=18.2] MileageEfficiency= 17,58
GasVehicle [serialNumber=6, made=USA, model=ford, date=20110717, tripCounter=280, maxSpeed=280.0, brakePower=65.0, fuelConsumed=20.2] MileageEfficiency= 13,86
GasVehicle [serialNumber=7, made=USA, model=cadillac, date=20150417, tripCounter=580, maxSpeed=300.0, brakePower=80.0, fuelConsumed=20.2] MileageEfficiency= 28,71
GasVehicle [serialNumber=8, made=germany, model=audi, date=20150417, tripCounter=370, maxSpeed=290.0, brakePower=60.0, fuelConsumed=10.2] MileageEfficiency= 36,27
GasVehicle [serialNumber=9, made=italy, model=alfaromeo, date=20170420, tripCounter=310, maxSpeed=280.0, brakePower=70.0, fuelConsumed=11.7] MileageEfficiency= 26,50
GasVehicle [serialNumber=10, made=france, model=citroen, date=20070528, tripCounter=410, maxSpeed=220.0, brakePower=65.0, fuelConsumed=25.4] MileageEfficiency= 16,14
GasVehicle [serialNumber=11, made=japan, model=subaru, date=20120502, tripCounter=610, maxSpeed=250.0, brakePower=75.0, fuelConsumed=20.6] MileageEfficiency= 29,61
GasVehicle [serialNumber=12, made=usa, model=gmc, date=20180502, tripCounter=510, maxSpeed=280.0, brakePower=75.0, fuelConsumed=17.9] MileageEfficiency= 28,49
GasVehicle [serialNumber=13, made=japan, model=honda, date=20190701, tripCounter=310, maxSpeed=270.0, brakePower=55.0, fuelConsumed=15.1] MileageEfficiency= 20,53
GasVehicle [serialNumber=14, made=italy, model=opel, date=20140420, tripCounter=210, maxSpeed=180.0, brakePower=40.0, fuelConsumed=19.5] MileageEfficiency= 10,77
GasVehicle [serialNumber=15, made=japan, model=toyota, date=20150101, tripCounter=490, maxSpeed=240.0, brakePower=70.0, fuelConsumed=18.3] MileageEfficiency= 26,78
Printing Electric Vehicles
Connection successful
ElectricVehicle [serialNumber=1, made=Japan, model=Mazda, date=20150101, tripCounter=400, maxSpeed=250.0, brakePower=50.0, kwPowerConsumed=9.7] MileageEfficiency= 41,24
ElectricVehicle [serialNumber=2, made=France, model=Renault, date=20180122, tripCounter=500, maxSpeed=200.0, brakePower=65.0, kwPowerConsumed=11.2] MileageEfficiency= 44,64
ElectricVehicle [serialNumber=3, made=USA, model=Tesla, date=20210101, tripCounter=480, maxSpeed=300.0, brakePower=80.0, kwPowerConsumed=12.7] MileageEfficiency= 37,80
ElectricVehicle [serialNumber=4, made=USA, model=ford, date=20180701, tripCounter=390, maxSpeed=280.0, brakePower=70.0, kwPowerConsumed=10.8] MileageEfficiency= 36,11
ElectricVehicle [serialNumber=5, made=germany, model=bmw, date=20150507, tripCounter=610, maxSpeed=300.0, brakePower=80.0, kwPowerConsumed=13.1] MileageEfficiency= 46,56
ElectricVehicle [serialNumber=6, made=japan, model=nissan, date=20170107, tripCounter=510, maxSpeed=260.0, brakePower=50.0, kwPowerConsumed=14.1] MileageEfficiency= 36,17
ElectricVehicle [serialNumber=7, made=japan, model=toyota, date=20160123, tripCounter=450, maxSpeed=260.0, brakePower=55.0, kwPowerConsumed=12.4] MileageEfficiency= 36,29
ElectricVehicle [serialNumber=8, made=USA, model=minicooper, date=20211001, tripCounter=370, maxSpeed=280.0, brakePower=60.0, kwPowerConsumed=12.8] MileageEfficiency= 28,91
ElectricVehicle [serialNumber=9, made=germany, model=audi, date=20200507, tripCounter=610, maxSpeed=270.0, brakePower=90.0, kwPowerConsumed=9.1] MileageEfficiency= 67,03
ElectricVehicle [serialNumber=10, made=SKorea, model=kia, date=20210917, tripCounter=580, maxSpeed=270.0, brakePower=95.0, kwPowerConsumed=11.6] MileageEfficiency= 50,00
ElectricVehicle [serialNumber=11, made=england, model=jaguar, date=20201218, tripCounter=670, maxSpeed=340.0, brakePower=95.0, kwPowerConsumed=14.5] MileageEfficiency= 46,21
ElectricVehicle [serialNumber=12, made=germany, model=porsche, date=20180510, tripCounter=700, maxSpeed=350.0, brakePower=85.0, kwPowerConsumed=15.1] MileageEfficiency= 46,36
ElectricVehicle [serialNumber=13, made=germany, model=volks, date=20171010, tripCounter=300, maxSpeed=240.0, brakePower=75.0, kwPowerConsumed=14.3] MileageEfficiency= 20,98
ElectricVehicle [serialNumber=14, made=USA, model=ford, date=20160101, tripCounter=340, maxSpeed=300.0, brakePower=65.0, kwPowerConsumed=8.8] MileageEfficiency= 38,64
ElectricVehicle [serialNumber=15, made=USA, model=tesla, date=20190731, tripCounter=400, maxSpeed=290.0, brakePower=85.0, kwPowerConsumed=9.2] MileageEfficiency= 43,48

1. Create & Add Vehicle to Database
2. Search Vehicle by Serial Number
3. Update Vehicle in Database
4. Sort by Mileage Efficiency
5. Remove Vehicle from Database
6. Print Gasoline Vehicles from Database
7. Print Electric Vehicles from Database
8. Make Trip Vehicles Fleet in Database
9. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 9) or any other Integer to Exit the Application
15
You exited the application. Thank you very much.

 ********** ********** **********/