package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import bus.Vehicle;
import bus.GasVehicle;
import bus.RaiseException;
import bus.ElectricVehicle;
import bus.EnumType;
//import bus.VehiclesFleet;
import bus.VehiclesFleetHashMap;

public class ConsoleApplicationTesterHashMap {

	public static void displayMenu(Scanner scan) throws RaiseException, IOException, ClassNotFoundException 
	{
		int value = 0;
		System.out.println(""
				+ "1. Create & Add Gas Vehicle to List"
				+ "\n2. Create & Add Electric Vehicle to List"
				+ "\n3. Print Vehicles from List"
				+ "\n4. Print Gas Vehicles from List"
				+ "\n5. Print Electric Vehicles from List"
				+ "\n6. Remove Vehicle from List" 
				+ "\n7. Search Vehicle by Serial Number"
				+ "\n8. Sort Vehicles by Serial Number"
				+ "\n9. Sort Vehicles by Mileage Efficiency"
				+ "\n10. Make Trip Vehicles in List"
				+ "\n11. Save Vehicles List into File"
				+ "\n12. Load Vehicles List from File");
		System.out.println("Select an action (Number from 1 to 12)");
		value = scan.nextInt();
		switch(value)
		{
		case 1: //Create & Add Gas Vehicle to List
			System.out.println("Creating Gas Vehicle");
			createGasVehicle(scan);
			break;
		case 2: //Create & Add Electric Vehicle to List
			System.out.println("Creating Electric Vehicle");
			createElectricVehicle(scan);
			break;
		case 3: //Print Vehicles from List
			System.out.println("Printing Vehicles from List");
			VehiclesFleetHashMap.getSingleInstance().printAllVehicles();
			break;
		case 4: //Print Gas Vehicles from List
			System.out.println("Printing Gas Vehicles");
			VehiclesFleetHashMap.getSingleInstance().printGasVehicles();
			break;
		case 5: //Print Electric Vehicles from List
			System.out.println("Printing Electric Vehicles");
			VehiclesFleetHashMap.getSingleInstance().printElectricVehicles();
			break;
		case 6: //Remove Vehicle from List by Serial Number
			System.out.println("Removing Vehicles into Vehicles Fleet");
			System.out.println("Enter the Serial Number of the Vehicle you wish to remove.");
			VehiclesFleetHashMap.getSingleInstance().remove(scan.next());
			break;
		case 7: //Search Vehicle by Serial Number
			System.out.println("Enter the Serial Number you are searching for: ");
			System.out.println(VehiclesFleetHashMap.getSingleInstance().search(scan.next()).toString());
			break;
		case 8: //Sort Vehicles Fleet by Serial Number
			System.out.println("Sorting Vehicles by Serial Number");
			VehiclesFleetHashMap.getSingleInstance().sortBySerialNumber();
			break;
		case 9: //Sort Vehicles Fleet by Mileage Efficiency
			System.out.println("Sorting Vehicles by Mileage Efficiency");
			VehiclesFleetHashMap.getSingleInstance().sortByMileageEfficiency();
			break;
		case 10: //Make Trip Vehicles in List
			System.out.println("Make Trip Vehicles in List");
			makeTripVehiclesFleet(scan);
			break;
		case 11: //Save Vehicles Fleet into File
			System.out.println("Saving Vehicles into File");
			VehiclesFleetHashMap.getSingleInstance().saveVehicleList();
			break;
		case 12: //Load Vehicles Fleet from File
			System.out.println("Loading Vehicles from File");
			ArrayList<Vehicle> vehicleListFromFile = new ArrayList<Vehicle>();
			vehicleListFromFile = VehiclesFleetHashMap.getSingleInstance().loadVehicleList();
			System.out.println("Printing Vehicles from File");
			for (Vehicle vehicle : vehicleListFromFile)
			{
				System.out.println(vehicle.toString());
			}
			break;
		default: //WHEN DEFAULT - Print Vehicles from List
			System.out.println("Printing Vehicles from List");
			VehiclesFleetHashMap.getSingleInstance().printAllVehicles();
			break;
		}
	}
	
	//Create GasVehicle
	public static void createGasVehicle(Scanner scan) throws RaiseException 
	{
		
		boolean valid = false;
		GasVehicle gv = new GasVehicle();
		gv.setType(EnumType.GasVehicle);
			
		System.out.println("Enter Serial Number for Gas Vehicle: ");
		gv.setSerialNumber(scan.next());
		System.out.println("Enter Made for Gas Vehicle: ");
		gv.setMade(scan.next());
		System.out.println("Enter Model for Gas Vehicle: ");
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
		System.out.println("Enter Max Speed for Gas Vehicle: ");
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
		System.out.println("Enter Brake Power for Gas Vehicle: ");
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
		VehiclesFleetHashMap.getSingleInstance().add(gv.getSerialNumber(), gv);
	}
		
	//Create ElectricVehicle
	public static void createElectricVehicle(Scanner scan) throws RaiseException
	{
		boolean valid = false;
		ElectricVehicle ev = new ElectricVehicle();
		ev.setType(EnumType.ElectricVehicle);
			
		System.out.println("Enter Serial Number for Electric Vehicle: ");
		ev.setSerialNumber(scan.next());
		System.out.println("Enter Made for Electric Vehicle: ");
		ev.setMade(scan.next());
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
		VehiclesFleetHashMap.getSingleInstance().add(ev.getSerialNumber(), ev);
	}
		
	//Make Trip for all Vehicles in VehiclesFleet
	public static void makeTripVehiclesFleet(Scanner scan) throws RaiseException
	{
		GasVehicle gv = new GasVehicle();
		ElectricVehicle ev = new ElectricVehicle();
			
		for (Vehicle vehicle : VehiclesFleetHashMap.getSingleInstance().getVehicleList().values())
		{
			if (vehicle instanceof GasVehicle) //Make Trip Gas Vehicles
			{
				gv = (GasVehicle) vehicle;
				makeTripGasVehicle(scan, gv);
				vehicle = gv;
			}
			else if (vehicle instanceof ElectricVehicle) //Make Trip Electric Vehicles
			{
				ev = (ElectricVehicle) vehicle;
				makeTripElectricVehicle(scan, ev);
				vehicle = ev;
			}
		}
	}
		
	//Personalized MakeTrip for GasVehicle
	public static void makeTripGasVehicle(Scanner scan, GasVehicle gv)
	{
		int tripCounter;
		double fuelConsumed;
		System.out.println("Enter Trip Counter for Gas Vehicle: ");
		tripCounter = scan.nextInt();
		System.out.println("Enter Fuel Consumed for Gas Vehicle: ");
		fuelConsumed = scan.nextDouble();
		gv.makeTrip(tripCounter, fuelConsumed);
	}
		
	//Personalized MakeTrip for ElectricVehicle
	public static void makeTripElectricVehicle(Scanner scan, ElectricVehicle ev)
	{
		int tripCounter;
		double kwPowerConsumed;
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
			displayMenu(scan);
			
			System.out.println("\nDo you wish to exit the application? 0 for YES; Any Integer for NO.");
			exitApplication = scan.nextInt();
			
		} while (exitApplication != 0);
		
		System.out.println("You exited the application. Thank you very much.");
		
		scan.close();
		System.exit(0);
	}
}

/********** **Output** **********

1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
1
Creating Gas Vehicle
Enter Serial Number for Gas Vehicle: 
WER001
Enter Made for Gas Vehicle: 
2000
Enter Model for Gas Vehicle: 
120
Invalid Input; Value must be Alphabetical
Mazda
Enter Max Speed for Gas Vehicle: 
-10
Invalid Input; Enter a Positive Value
120
Enter Brake Power for Gas Vehicle: 
-60
Invalid Input; Enter a Positive Value
60
Adding Vehicles into Vehicles Fleet

Do you wish to exit the application? 0 for YES; Any Integer for NO.
1
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
1
Creating Gas Vehicle
Enter Serial Number for Gas Vehicle: 
WER002
Enter Made for Gas Vehicle: 
2002
Enter Model for Gas Vehicle: 
Nissan
Enter Max Speed for Gas Vehicle: 
125
Enter Brake Power for Gas Vehicle: 
75
Adding Vehicles into Vehicles Fleet

Do you wish to exit the application? 0 for YES; Any Integer for NO.
2
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
1
Creating Gas Vehicle
Enter Serial Number for Gas Vehicle: 
WER003
Enter Made for Gas Vehicle: 
2005
Enter Model for Gas Vehicle: 
150
Invalid Input; Value must be Alphabetical
90
Invalid Input; Value must be Alphabetical
Honda
Enter Max Speed for Gas Vehicle: 
150
Enter Brake Power for Gas Vehicle: 
90
Adding Vehicles into Vehicles Fleet

Do you wish to exit the application? 0 for YES; Any Integer for NO.
3
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
2
Creating Electric Vehicle
Enter Serial Number for Electric Vehicle: 
SAV001
Enter Made for Electric Vehicle: 
2010
Enter Model for Electric Vehicle: 
Tesla
Enter Max Speed for Electric Vehicle: 
120
Enter Brake Power for Electric Vehicle: 
60
Adding Vehicles into Vehicles Fleet

Do you wish to exit the application? 0 for YES; Any Integer for NO.
3
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
2
Creating Electric Vehicle
Enter Serial Number for Electric Vehicle: 
SAV002
Enter Made for Electric Vehicle: 
2014
Enter Model for Electric Vehicle: 
Tesla
Enter Max Speed for Electric Vehicle: 
140
Enter Brake Power for Electric Vehicle: 
80
Adding Vehicles into Vehicles Fleet

Do you wish to exit the application? 0 for YES; Any Integer for NO.
4
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
2
Creating Electric Vehicle
Enter Serial Number for Electric Vehicle: 
SAV003
Enter Made for Electric Vehicle: 
2018
Enter Model for Electric Vehicle: 
Tesla
Enter Max Speed for Electric Vehicle: 
160
Enter Brake Power for Electric Vehicle: 
100
Adding Vehicles into Vehicles Fleet

Do you wish to exit the application? 0 for YES; Any Integer for NO.
5
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
3
Printing Vehicles from List
List of all Vehicles
GasVehicle [serialNumber=WER001, made=2000, model=Mazda, type=GasVehicle, tripCounter=0, maxSpeed=120.0, brakePower=60.0, fuelConsumed=0.0]
GasVehicle [serialNumber=WER002, made=2002, model=Nissan, type=GasVehicle, tripCounter=0, maxSpeed=125.0, brakePower=75.0, fuelConsumed=0.0]
GasVehicle [serialNumber=WER003, made=2005, model=Honda, type=GasVehicle, tripCounter=0, maxSpeed=150.0, brakePower=90.0, fuelConsumed=0.0]
ElectricVehicle [serialNumber=SAV001, made=2010, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=120.0, brakePower=60.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=SAV002, made=2014, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=140.0, brakePower=80.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=SAV003, made=2018, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=160.0, brakePower=100.0, kwPowerConsumed=0.0]

Do you wish to exit the application? 0 for YES; Any Integer for NO.
4
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
4
Printing Gas Vehicles
List of Gas Vehicles
GasVehicle [serialNumber=WER001, made=2000, model=Mazda, type=GasVehicle, tripCounter=0, maxSpeed=120.0, brakePower=60.0, fuelConsumed=0.0]
GasVehicle [serialNumber=WER002, made=2002, model=Nissan, type=GasVehicle, tripCounter=0, maxSpeed=125.0, brakePower=75.0, fuelConsumed=0.0]
GasVehicle [serialNumber=WER003, made=2005, model=Honda, type=GasVehicle, tripCounter=0, maxSpeed=150.0, brakePower=90.0, fuelConsumed=0.0]

Do you wish to exit the application? 0 for YES; Any Integer for NO.
4
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
5
Printing Electric Vehicles
List of Electric Vehicles
ElectricVehicle [serialNumber=SAV001, made=2010, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=120.0, brakePower=60.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=SAV002, made=2014, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=140.0, brakePower=80.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=SAV003, made=2018, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=160.0, brakePower=100.0, kwPowerConsumed=0.0]

Do you wish to exit the application? 0 for YES; Any Integer for NO.
5
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
7
Enter the Serial Number you are searching for: 
WER002
GasVehicle [serialNumber=WER002, made=2002, model=Nissan, type=GasVehicle, tripCounter=0, maxSpeed=125.0, brakePower=75.0, fuelConsumed=0.0]

Do you wish to exit the application? 0 for YES; Any Integer for NO.
5
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
8
Sorting Vehicles by Serial Number

Do you wish to exit the application? 0 for YES; Any Integer for NO.
4
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
3
Printing Vehicles from List
List of all Vehicles
ElectricVehicle [serialNumber=SAV001, made=2010, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=120.0, brakePower=60.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=SAV002, made=2014, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=140.0, brakePower=80.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=SAV003, made=2018, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=160.0, brakePower=100.0, kwPowerConsumed=0.0]
GasVehicle [serialNumber=WER001, made=2000, model=Mazda, type=GasVehicle, tripCounter=0, maxSpeed=120.0, brakePower=60.0, fuelConsumed=0.0]
GasVehicle [serialNumber=WER002, made=2002, model=Nissan, type=GasVehicle, tripCounter=0, maxSpeed=125.0, brakePower=75.0, fuelConsumed=0.0]
GasVehicle [serialNumber=WER003, made=2005, model=Honda, type=GasVehicle, tripCounter=0, maxSpeed=150.0, brakePower=90.0, fuelConsumed=0.0]

Do you wish to exit the application? 0 for YES; Any Integer for NO.
5
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
9
Sorting Vehicles by Mileage Efficiency

Do you wish to exit the application? 0 for YES; Any Integer for NO.
4
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
3
Printing Vehicles from List
List of all Vehicles
ElectricVehicle [serialNumber=SAV001, made=2010, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=120.0, brakePower=60.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=SAV002, made=2014, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=140.0, brakePower=80.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=SAV003, made=2018, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=160.0, brakePower=100.0, kwPowerConsumed=0.0]
GasVehicle [serialNumber=WER001, made=2000, model=Mazda, type=GasVehicle, tripCounter=0, maxSpeed=120.0, brakePower=60.0, fuelConsumed=0.0]
GasVehicle [serialNumber=WER002, made=2002, model=Nissan, type=GasVehicle, tripCounter=0, maxSpeed=125.0, brakePower=75.0, fuelConsumed=0.0]
GasVehicle [serialNumber=WER003, made=2005, model=Honda, type=GasVehicle, tripCounter=0, maxSpeed=150.0, brakePower=90.0, fuelConsumed=0.0]

Do you wish to exit the application? 0 for YES; Any Integer for NO.
3
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
10
Make Trip Vehicles in List
Enter Trip Counter for Electric Vehicle: 
100
Enter Kw Power Consumed for Electric Vehicle: 
4,44
Enter Trip Counter for Electric Vehicle: 
150
Enter Kw Power Consumed for Electric Vehicle: 
6,66
Enter Trip Counter for Electric Vehicle: 
75
Enter Kw Power Consumed for Electric Vehicle: 
2,22
Enter Trip Counter for Gas Vehicle: 
100
Enter Fuel Consumed for Gas Vehicle: 
8,88
Enter Trip Counter for Gas Vehicle: 
150
Enter Fuel Consumed for Gas Vehicle: 
5,55
Enter Trip Counter for Gas Vehicle: 
125
Enter Fuel Consumed for Gas Vehicle: 
6,66

Do you wish to exit the application? 0 for YES; Any Integer for NO.
4
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
9
Sorting Vehicles by Mileage Efficiency

Do you wish to exit the application? 0 for YES; Any Integer for NO.
3
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
3
Printing Vehicles from List
List of all Vehicles
GasVehicle [serialNumber=WER001, made=2000, model=Mazda, type=GasVehicle, tripCounter=100, maxSpeed=120.0, brakePower=60.0, fuelConsumed=8.88]
GasVehicle [serialNumber=WER003, made=2005, model=Honda, type=GasVehicle, tripCounter=125, maxSpeed=150.0, brakePower=90.0, fuelConsumed=6.66]
ElectricVehicle [serialNumber=SAV001, made=2010, model=Tesla, type=ElectricVehicle, tripCounter=100, maxSpeed=120.0, brakePower=60.0, kwPowerConsumed=4.44]
ElectricVehicle [serialNumber=SAV002, made=2014, model=Tesla, type=ElectricVehicle, tripCounter=150, maxSpeed=140.0, brakePower=80.0, kwPowerConsumed=6.66]
GasVehicle [serialNumber=WER002, made=2002, model=Nissan, type=GasVehicle, tripCounter=150, maxSpeed=125.0, brakePower=75.0, fuelConsumed=5.55]
ElectricVehicle [serialNumber=SAV003, made=2018, model=Tesla, type=ElectricVehicle, tripCounter=75, maxSpeed=160.0, brakePower=100.0, kwPowerConsumed=2.22]

Do you wish to exit the application? 0 for YES; Any Integer for NO.
6
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
11
Saving Vehicles into File

Do you wish to exit the application? 0 for YES; Any Integer for NO.
5
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
12
Loading Vehicles from File
Printing Vehicles from File
GasVehicle [serialNumber=WER001, made=2000, model=Mazda, type=GasVehicle, tripCounter=100, maxSpeed=120.0, brakePower=60.0, fuelConsumed=8.88]
GasVehicle [serialNumber=WER003, made=2005, model=Honda, type=GasVehicle, tripCounter=125, maxSpeed=150.0, brakePower=90.0, fuelConsumed=6.66]
ElectricVehicle [serialNumber=SAV001, made=2010, model=Tesla, type=ElectricVehicle, tripCounter=100, maxSpeed=120.0, brakePower=60.0, kwPowerConsumed=4.44]
ElectricVehicle [serialNumber=SAV002, made=2014, model=Tesla, type=ElectricVehicle, tripCounter=150, maxSpeed=140.0, brakePower=80.0, kwPowerConsumed=6.66]
GasVehicle [serialNumber=WER002, made=2002, model=Nissan, type=GasVehicle, tripCounter=150, maxSpeed=125.0, brakePower=75.0, fuelConsumed=5.55]
ElectricVehicle [serialNumber=SAV003, made=2018, model=Tesla, type=ElectricVehicle, tripCounter=75, maxSpeed=160.0, brakePower=100.0, kwPowerConsumed=2.22]

Do you wish to exit the application? 0 for YES; Any Integer for NO.
5
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
6
Removing Vehicles into Vehicles Fleet
Enter the Serial Number of the Vehicle you wish to remove.
WER001

Do you wish to exit the application? 0 for YES; Any Integer for NO.
4
1. Create & Add Gas Vehicle to List
2. Create & Add Electric Vehicle to List
3. Print Vehicles from List
4. Print Gas Vehicles from List
5. Print Electric Vehicles from List
6. Remove Vehicle from List
7. Search Vehicle by Serial Number
8. Sort Vehicles by Serial Number
9. Sort Vehicles by Mileage Efficiency
10. Make Trip Vehicles in List
11. Save Vehicles List into File
12. Load Vehicles List from File
Select an action (Number from 1 to 12)
3
Printing Vehicles from List
List of all Vehicles
GasVehicle [serialNumber=WER003, made=2005, model=Honda, type=GasVehicle, tripCounter=125, maxSpeed=150.0, brakePower=90.0, fuelConsumed=6.66]
ElectricVehicle [serialNumber=SAV001, made=2010, model=Tesla, type=ElectricVehicle, tripCounter=100, maxSpeed=120.0, brakePower=60.0, kwPowerConsumed=4.44]
ElectricVehicle [serialNumber=SAV002, made=2014, model=Tesla, type=ElectricVehicle, tripCounter=150, maxSpeed=140.0, brakePower=80.0, kwPowerConsumed=6.66]
GasVehicle [serialNumber=WER002, made=2002, model=Nissan, type=GasVehicle, tripCounter=150, maxSpeed=125.0, brakePower=75.0, fuelConsumed=5.55]
ElectricVehicle [serialNumber=SAV003, made=2018, model=Tesla, type=ElectricVehicle, tripCounter=75, maxSpeed=160.0, brakePower=100.0, kwPowerConsumed=2.22]

Do you wish to exit the application? 0 for YES; Any Integer for NO.
0
You exited the application. Thank you very much.

 *********** ********** **********/
