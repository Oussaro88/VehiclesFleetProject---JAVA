package client;

import java.io.IOException;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import bus.Vehicle;
import bus.GasVehicle;
import bus.RaiseException;
import bus.ElectricVehicle;
//import bus.VehiclesFleet;
import bus.VehiclesFleetHashMap;

public class ConsoleApplicationTester {

	public static int displayMenu(Scanner scan) throws RaiseException, IOException, ClassNotFoundException 
	{
		int value = 0;
		System.out.println(""
				+ "\n1. Create & Add Vehicle to Fleet"
				+ "\n2. Search Vehicle by Serial Number"
				+ "\n3. Remove Vehicle from Fleet"
				+ "\n4. Print Vehicles from Fleet"
				+ "\n5. Print Gasoline Vehicles from Fleet"
				+ "\n6. Print Electric Vehicles from Fleet"
				+ "\n7. Save Vehicles List into Fleet"
				+ "\n8. Load Vehicles List from Fleet"
				+ "\n9. Sort Vehicles by Serial Number"
				+ "\n10. Make Trip Vehicles in Fleet"
				+ "\n11. Sort Vehicles by Mileage Efficiency"
				+ "\n12. Print Vehicles from Fleet with Mileage Efficiency");
		System.out.println("Select an action (Number from 1 to 12) "
				+ "or any other Integer to Exit the Application");
		value = scan.nextInt();
		switch(value)
		{
		case 1: //Create & Add Vehicle to List
			System.out.println("Adding a Vehicle into the Fleet of Vehicles");
			createChoiceVehicle(scan);
			break;
		case 2: //Search Vehicle by Serial Number
			System.out.println("Enter the Serial Number you are searching for: ");
			System.out.println(VehiclesFleetHashMap.getSingleInstance().searchBySerialNumber(scan.nextLong()).toString());
			break;
		case 3: //Remove Vehicle from List by Serial Number
			System.out.println("Removing Vehicles into Vehicles Fleet");
			System.out.println("Enter the Serial Number of the Vehicle you wish to remove.");
			VehiclesFleetHashMap.getSingleInstance().remove(scan.nextLong());
			break;
		case 4: //Print Vehicles from Fleet
			System.out.println("Printing Vehicles from Fleet");
			VehiclesFleetHashMap.getSingleInstance().printAllVehicles();
			break;
		case 5: //Print Gasoline Vehicles from List
			System.out.println("Printing Gasoline Vehicles");
			VehiclesFleetHashMap.getSingleInstance().printGasVehicles();
			break;
		case 6: //Print Electric Vehicles from List
			System.out.println("Printing Electric Vehicles");
			VehiclesFleetHashMap.getSingleInstance().printElectricVehicles();
			break;
		case 7: //Save Vehicles Fleet into File
			System.out.println("Saving Vehicles into File");
			VehiclesFleetHashMap.getSingleInstance().saveVehicleList();
			break;
		case 8: //Load Vehicles Fleet from File
			System.out.println("Loading Vehicles from File");
			//ArrayList<Vehicle> vehicleListFromFile = new ArrayList<Vehicle>();
			HashMap <Long, Vehicle> vehicleListFromFile = new HashMap <Long, Vehicle>();
			vehicleListFromFile = VehiclesFleetHashMap.getSingleInstance().loadVehicleList();
			System.out.println("Printing Vehicles from File");
			for (Vehicle vehicle : vehicleListFromFile.values())
			{
				System.out.println(vehicle.toString());
			}
			break;
		case 9: //Sort Vehicles Fleet by Serial Number
			System.out.println("Sorting Vehicles by Serial Number");
			VehiclesFleetHashMap.getSingleInstance().sortBySerialNumber();
			break;
		case 10: //Make Trip Vehicles in List
			System.out.println("Make Trip Vehicles in List");
			makeTripVehiclesFleet(scan);
			break;
		case 11: //Sort Vehicles Fleet by Mileage Efficiency
			System.out.println("Sorting Vehicles by Mileage Efficiency");
			VehiclesFleetHashMap.getSingleInstance().sortByMileageEfficiency();
			break;
		case 12: //Print Vehicle with Efficient Mileage
			System.out.println("Printing Vehicles from Fleet with MileageEfficiency");
			VehiclesFleetHashMap.getSingleInstance().printAllVehiclesWME();
			break;
		default: //WHEN DEFAULT - Exit Application
			return 0;
		}
		return 1;
	}
	
	public static void createChoiceVehicle(Scanner scan) throws RaiseException 
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
	public static void createGasVehicle(Scanner scan) throws RaiseException 
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
		VehiclesFleetHashMap.getSingleInstance().add(gv);
	}
		
	//Create ElectricVehicle
	public static void createElectricVehicle(Scanner scan) throws RaiseException
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
		VehiclesFleetHashMap.getSingleInstance().add(ev);
	}
		
	//Make Trip for all Vehicles in VehiclesFleet
	public static void makeTripVehiclesFleet(Scanner scan) throws RaiseException
	{
		GasVehicle gv = new GasVehicle();
		
		for (GasVehicle gasVehicle : VehiclesFleetHashMap.getSingleInstance().getGasVehicleList().values())
		{
			gv = gasVehicle;
			makeTripGasVehicle(scan, gv);
			gasVehicle = gv;
			System.out.println("Gasoline Vehicle's Mileage Efficiency: " + String.format("%.2f", gasVehicle.getMilePerUnitOfEnergyConsumed()));
		}

		ElectricVehicle ev = new ElectricVehicle();
		
		for (ElectricVehicle electricVehicle : VehiclesFleetHashMap.getSingleInstance().getElectricVehicleList().values())
		{
			ev = electricVehicle;
			makeTripElectricVehicle(scan, ev);
			electricVehicle = ev;
			System.out.println("Electric Vehicle's Mileage Efficiency: " + String.format("%.2f", electricVehicle.getMilePerUnitOfEnergyConsumed()));
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
	
	public static void main(String[] args) throws RaiseException, IOException, ClassNotFoundException {

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


1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
1
Adding a Vehicle into the Fleet of Vehicles
Which Type of Vehicle you which to add to the Fleet? (1) Gasoline or (2) Electric?
1
Creating Gasoline Vehicle
Enter Serial Number for Gasoline Vehicle: 
001
Enter Made for Gasoline Vehicle: 
japan
Enter Model for Gasoline Vehicle: 
mazda
Enter Date for Gasoline Vehicles: 
20060313
Enter Max Speed for Gasoline Vehicle: 
150
Enter Brake Power for Gasoline Vehicle: 
40
Adding Vehicles into Vehicles Fleet

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
1
Adding a Vehicle into the Fleet of Vehicles
Which Type of Vehicle you which to add to the Fleet? (1) Gasoline or (2) Electric?
1
Creating Gasoline Vehicle
Enter Serial Number for Gasoline Vehicle: 
002
Enter Made for Gasoline Vehicle: 
japan
Enter Model for Gasoline Vehicle: 
nissan
Enter Date for Gasoline Vehicles: 
20150419
Enter Max Speed for Gasoline Vehicle: 
250
Enter Brake Power for Gasoline Vehicle: 
60
Adding Vehicles into Vehicles Fleet

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
1
Adding a Vehicle into the Fleet of Vehicles
Which Type of Vehicle you which to add to the Fleet? (1) Gasoline or (2) Electric?
1
Creating Gasoline Vehicle
Enter Serial Number for Gasoline Vehicle: 
003
Enter Made for Gasoline Vehicle: 
france
Enter Model for Gasoline Vehicle: 
renault
Enter Date for Gasoline Vehicles: 
20200921
Enter Max Speed for Gasoline Vehicle: 
250
Enter Brake Power for Gasoline Vehicle: 
50
Adding Vehicles into Vehicles Fleet

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
1
Adding a Vehicle into the Fleet of Vehicles
Which Type of Vehicle you which to add to the Fleet? (1) Gasoline or (2) Electric?
1
Creating Gasoline Vehicle
Enter Serial Number for Gasoline Vehicle: 
004
Enter Made for Gasoline Vehicle: 
italy
Enter Model for Gasoline Vehicle: 
fiat
Enter Date for Gasoline Vehicles: 
20101201
Enter Max Speed for Gasoline Vehicle: 
220
Enter Brake Power for Gasoline Vehicle: 
65
Adding Vehicles into Vehicles Fleet

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
1
Adding a Vehicle into the Fleet of Vehicles
Which Type of Vehicle you which to add to the Fleet? (1) Gasoline or (2) Electric?
2
Creating Electric Vehicle
Enter Serial Number for Electric Vehicle: 
005
Enter Made for Electric Vehicle: 
usa
Enter Model for Electric Vehicle: 
tesla
Enter Date for Electric Vehicles: 
20180615
Enter Max Speed for Electric Vehicle: 
210
Enter Brake Power for Electric Vehicle: 
90
Adding Vehicles into Vehicles Fleet

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
1
Adding a Vehicle into the Fleet of Vehicles
Which Type of Vehicle you which to add to the Fleet? (1) Gasoline or (2) Electric?
2
Creating Electric Vehicle
Enter Serial Number for Electric Vehicle: 
006
Enter Made for Electric Vehicle: 
usa
Enter Model for Electric Vehicle: 
ford
Enter Date for Electric Vehicles: 
20200101
Enter Max Speed for Electric Vehicle: 
260
Enter Brake Power for Electric Vehicle: 
80
Adding Vehicles into Vehicles Fleet

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
1
Adding a Vehicle into the Fleet of Vehicles
Which Type of Vehicle you which to add to the Fleet? (1) Gasoline or (2) Electric?
2
Creating Electric Vehicle
Enter Serial Number for Electric Vehicle: 
007
Enter Made for Electric Vehicle: 
germany
Enter Model for Electric Vehicle: 
mercedes
Enter Date for Electric Vehicles: 
20210901
Enter Max Speed for Electric Vehicle: 
300
Enter Brake Power for Electric Vehicle: 
95
Adding Vehicles into Vehicles Fleet

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
1
Adding a Vehicle into the Fleet of Vehicles
Which Type of Vehicle you which to add to the Fleet? (1) Gasoline or (2) Electric?
2
Creating Electric Vehicle
Enter Serial Number for Electric Vehicle: 
008
Enter Made for Electric Vehicle: 
Skorea
Enter Model for Electric Vehicle: 
kia
Enter Date for Electric Vehicles: 
20180430
Enter Max Speed for Electric Vehicle: 
240
Enter Brake Power for Electric Vehicle: 
65
Adding Vehicles into Vehicles Fleet

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
2
Enter the Serial Number you are searching for: 
007
ElectricVehicle [serialNumber=7, made=germany, model=mercedes, date=20210901, tripCounter=0, maxSpeed=300.0, brakePower=95.0, kwPowerConsumed=0.0]

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
3
Removing Vehicles into Vehicles Fleet
Enter the Serial Number of the Vehicle you wish to remove.
001

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
4
Printing Vehicles from Fleet
List of all Vehicles
GasVehicle [serialNumber=2, made=japan, model=nissan, date=20150419, tripCounter=0, maxSpeed=250.0, brakePower=60.0, fuelConsumed=0.0]
GasVehicle [serialNumber=3, made=france, model=renault, date=20200921, tripCounter=0, maxSpeed=250.0, brakePower=50.0, fuelConsumed=0.0]
GasVehicle [serialNumber=4, made=italy, model=fiat, date=20101201, tripCounter=0, maxSpeed=220.0, brakePower=65.0, fuelConsumed=0.0]
ElectricVehicle [serialNumber=5, made=usa, model=tesla, date=20180615, tripCounter=0, maxSpeed=210.0, brakePower=90.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=6, made=usa, model=ford, date=20200101, tripCounter=0, maxSpeed=260.0, brakePower=80.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=7, made=germany, model=mercedes, date=20210901, tripCounter=0, maxSpeed=300.0, brakePower=95.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=8, made=Skorea, model=kia, date=20180430, tripCounter=0, maxSpeed=240.0, brakePower=65.0, kwPowerConsumed=0.0]

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
5
Printing Gasoline Vehicles
List of Gas Vehicles
GasVehicle [serialNumber=2, made=japan, model=nissan, date=20150419, tripCounter=0, maxSpeed=250.0, brakePower=60.0, fuelConsumed=0.0]
GasVehicle [serialNumber=3, made=france, model=renault, date=20200921, tripCounter=0, maxSpeed=250.0, brakePower=50.0, fuelConsumed=0.0]
GasVehicle [serialNumber=4, made=italy, model=fiat, date=20101201, tripCounter=0, maxSpeed=220.0, brakePower=65.0, fuelConsumed=0.0]

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
6
Printing Electric Vehicles
List of Electric Vehicles
ElectricVehicle [serialNumber=5, made=usa, model=tesla, date=20180615, tripCounter=0, maxSpeed=210.0, brakePower=90.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=6, made=usa, model=ford, date=20200101, tripCounter=0, maxSpeed=260.0, brakePower=80.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=7, made=germany, model=mercedes, date=20210901, tripCounter=0, maxSpeed=300.0, brakePower=95.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=8, made=Skorea, model=kia, date=20180430, tripCounter=0, maxSpeed=240.0, brakePower=65.0, kwPowerConsumed=0.0]

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
7
Saving Vehicles into File

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
8
Loading Vehicles from File
Printing Vehicles from File
GasVehicle [serialNumber=2, made=japan, model=nissan, date=20150419, tripCounter=0, maxSpeed=250.0, brakePower=60.0, fuelConsumed=0.0]
GasVehicle [serialNumber=3, made=france, model=renault, date=20200921, tripCounter=0, maxSpeed=250.0, brakePower=50.0, fuelConsumed=0.0]
GasVehicle [serialNumber=4, made=italy, model=fiat, date=20101201, tripCounter=0, maxSpeed=220.0, brakePower=65.0, fuelConsumed=0.0]
ElectricVehicle [serialNumber=5, made=usa, model=tesla, date=20180615, tripCounter=0, maxSpeed=210.0, brakePower=90.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=6, made=usa, model=ford, date=20200101, tripCounter=0, maxSpeed=260.0, brakePower=80.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=7, made=germany, model=mercedes, date=20210901, tripCounter=0, maxSpeed=300.0, brakePower=95.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=8, made=Skorea, model=kia, date=20180430, tripCounter=0, maxSpeed=240.0, brakePower=65.0, kwPowerConsumed=0.0]

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
9
Sorting Vehicles by Serial Number
GasVehicle [serialNumber=2, made=japan, model=nissan, date=20150419, tripCounter=0, maxSpeed=250.0, brakePower=60.0, fuelConsumed=0.0] MileageEfficiency= NaN
GasVehicle [serialNumber=3, made=france, model=renault, date=20200921, tripCounter=0, maxSpeed=250.0, brakePower=50.0, fuelConsumed=0.0] MileageEfficiency= NaN
GasVehicle [serialNumber=4, made=italy, model=fiat, date=20101201, tripCounter=0, maxSpeed=220.0, brakePower=65.0, fuelConsumed=0.0] MileageEfficiency= NaN
ElectricVehicle [serialNumber=5, made=usa, model=tesla, date=20180615, tripCounter=0, maxSpeed=210.0, brakePower=90.0, kwPowerConsumed=0.0] MileageEfficiency= NaN
ElectricVehicle [serialNumber=6, made=usa, model=ford, date=20200101, tripCounter=0, maxSpeed=260.0, brakePower=80.0, kwPowerConsumed=0.0] MileageEfficiency= NaN
ElectricVehicle [serialNumber=7, made=germany, model=mercedes, date=20210901, tripCounter=0, maxSpeed=300.0, brakePower=95.0, kwPowerConsumed=0.0] MileageEfficiency= NaN
ElectricVehicle [serialNumber=8, made=Skorea, model=kia, date=20180430, tripCounter=0, maxSpeed=240.0, brakePower=65.0, kwPowerConsumed=0.0] MileageEfficiency= NaN

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
10
Make Trip Vehicles in List
Enter Trip Counter for Gasoline Vehicle: 
200
Enter Fuel Consumed for Gasoline Vehicle: 
7,7
Gasoline Vehicle's Mileage Efficiency: 25,97
Enter Trip Counter for Gasoline Vehicle: 
250
Enter Fuel Consumed for Gasoline Vehicle: 
8,5
Gasoline Vehicle's Mileage Efficiency: 29,41
Enter Trip Counter for Gasoline Vehicle: 
300
Enter Fuel Consumed for Gasoline Vehicle: 
7,9
Gasoline Vehicle's Mileage Efficiency: 37,97
Enter Trip Counter for Electric Vehicle: 
280
Enter Kw Power Consumed for Electric Vehicle: 
5,7
Electric Vehicle's Mileage Efficiency: 49,12
Enter Trip Counter for Electric Vehicle: 
400
Enter Kw Power Consumed for Electric Vehicle: 
7,2
Electric Vehicle's Mileage Efficiency: 55,56
Enter Trip Counter for Electric Vehicle: 
305
Enter Kw Power Consumed for Electric Vehicle: 
6,8
Electric Vehicle's Mileage Efficiency: 44,85
Enter Trip Counter for Electric Vehicle: 
240
Enter Kw Power Consumed for Electric Vehicle: 
8,1
Electric Vehicle's Mileage Efficiency: 29,63

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application
12
Printing Vehicles from Fleet with MileageEfficiency
List of all Vehicles; with MileageEfficiency
GasVehicle [serialNumber=2, made=japan, model=nissan, date=20150419, tripCounter=200, maxSpeed=250.0, brakePower=60.0, fuelConsumed=7.7] MileageEfficiency= 25,97
GasVehicle [serialNumber=3, made=france, model=renault, date=20200921, tripCounter=250, maxSpeed=250.0, brakePower=50.0, fuelConsumed=8.5] MileageEfficiency= 29,41
GasVehicle [serialNumber=4, made=italy, model=fiat, date=20101201, tripCounter=300, maxSpeed=220.0, brakePower=65.0, fuelConsumed=7.9] MileageEfficiency= 37,97
ElectricVehicle [serialNumber=5, made=usa, model=tesla, date=20180615, tripCounter=280, maxSpeed=210.0, brakePower=90.0, kwPowerConsumed=5.7] MileageEfficiency= 49,12
ElectricVehicle [serialNumber=6, made=usa, model=ford, date=20200101, tripCounter=400, maxSpeed=260.0, brakePower=80.0, kwPowerConsumed=7.2] MileageEfficiency= 55,56
ElectricVehicle [serialNumber=7, made=germany, model=mercedes, date=20210901, tripCounter=305, maxSpeed=300.0, brakePower=95.0, kwPowerConsumed=6.8] MileageEfficiency= 44,85
ElectricVehicle [serialNumber=8, made=Skorea, model=kia, date=20180430, tripCounter=240, maxSpeed=240.0, brakePower=65.0, kwPowerConsumed=8.1] MileageEfficiency= 29,63

1. Create & Add Vehicle to Fleet
2. Search Vehicle by Serial Number
3. Remove Vehicle from Fleet
4. Print Vehicles from Fleet
5. Print Gasoline Vehicles from Fleet
6. Print Electric Vehicles from Fleet
7. Save Vehicles List into Fleet
8. Load Vehicles List from Fleet
9. Sort Vehicles by Serial Number
10. Make Trip Vehicles in Fleet
11. Sort Vehicles by Mileage Efficiency
12. Print Vehicles from Fleet with Mileage Efficiency
Select an action (Number from 1 to 12) or any other Integer to Exit the Application

You exited the application. Thank you very much.

 *********** ********** **********/
