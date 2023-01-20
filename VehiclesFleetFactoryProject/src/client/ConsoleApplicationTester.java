package client;

import java.util.Scanner;
import bus.Vehicle;
import bus.GasVehicle;
import bus.ElectricVehicle;
import bus.EnumType;
import bus.VehiclesFleet;

public class ConsoleApplicationTester {

	//Create GasVehicle
	public static void createGasVehicle(Scanner scan, GasVehicle gv) 
	{
		gv.setType(EnumType.GasVehicle);
			
		System.out.println("Enter Serial Number for Gas Vehicle: ");
		gv.setSerialNumber(scan.next());
		System.out.println("Enter Made for Gas Vehicle: ");
		gv.setMade(scan.next());
		System.out.println("Enter Model for Gas Vehicle: ");
		gv.setModel(scan.next());
		System.out.println("Enter Max Speed for Gas Vehicle: ");
		gv.setMaxSpeed(scan.nextDouble());
		System.out.println("Enter Brake Power for Gas Vehicle: ");
		gv.setBrakePower(scan.nextDouble());
	}
		
	//Create ElectricVehicle
	public static void createElectricVehicle(Scanner scan, ElectricVehicle ev)
	{
		ev.setType(EnumType.ElectricVehicle);
			
		System.out.println("Enter Serial Number for Electric Vehicle: ");
		ev.setSerialNumber(scan.next());
		System.out.println("Enter Made for Electric Vehicle: ");
		ev.setMade(scan.next());
		System.out.println("Enter Model for Electric Vehicle: ");
		ev.setModel(scan.next());
		System.out.println("Enter Max Speed for Electric Vehicle: ");
		ev.setMaxSpeed(scan.nextDouble());
		System.out.println("Enter Brake Power for Electric Vehicle: ");
		ev.setBrakePower(scan.nextDouble());
	}
		
	//Make Trip for all Vehicles in VehiclesFleet
	public static void makeTripVehiclesFleet(Scanner scan)
	{
		GasVehicle gv = new GasVehicle();
		ElectricVehicle ev = new ElectricVehicle();
			
		for (Vehicle vehicle : VehiclesFleet.getVehicleList())
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
		
	public static void main(String[] args) {
			
		Scanner scan = new Scanner(System.in);
			
		//To Manage
		//Create Fleet of Vehicles
		//Creating Fleet of Gas Vehicles
		System.out.println("Creating Gas Vehicle"); //WER000
		GasVehicle gv1 = new GasVehicle();
		createGasVehicle(scan, gv1);
		GasVehicle gv2 = new GasVehicle();
		createGasVehicle(scan, gv2);
		GasVehicle gv3 = new GasVehicle();
		createGasVehicle(scan, gv3);
		//Creating Fleet of Electric Vehicles
		System.out.println("Creating Electric Vehicle"); //SAV000
		ElectricVehicle ev1 = new ElectricVehicle();
		createElectricVehicle(scan, ev1);
		ElectricVehicle ev2 = new ElectricVehicle();
		createElectricVehicle(scan, ev2);
		ElectricVehicle ev3 = new ElectricVehicle();
		createElectricVehicle(scan, ev3);
			
		//Add Vehicle to Fleet
		//Adding Gas Vehicles to Fleet
		System.out.println("Adding Vehicles into Vehicles Fleet");
		VehiclesFleet.add(gv1);
		VehiclesFleet.add(gv2);
		VehiclesFleet.add(gv3);
		//Adding Electric Vehicles to Fleet
		VehiclesFleet.add(ev1);
		VehiclesFleet.add(ev2);
		VehiclesFleet.add(ev3);
			
		//Print Gas Vehicles
		System.out.println("Printing Gas Vehicles");
		VehiclesFleet.printGasVehicles();
			
		//Print Electric Vehicles
		System.out.println("Printing Electric Vehicles");
		VehiclesFleet.printElectricVehicles();
			
		//Sort by Serial Number
		System.out.println("Sorting Vehicles by Serial Number");
		VehiclesFleet.sortBySerialNumber();
			
		//Search by Serial Number
		System.out.println("Enter the Serial Number you are searching for: ");
		System.out.println(VehiclesFleet.search(scan.next()).toString());
			
		//Print Fleet of Vehicles
		System.out.println("Printing Vehicles from List");
		VehiclesFleet.printAllVehicles();
			
		//To Test
		//Make Trip
		System.out.println("Make Trip Vehicles in List");
		makeTripVehiclesFleet(scan);
			
		//Sort by Mileage Efficiency
		System.out.println("Sorting Vehicles by Mileage Efficiency");
		VehiclesFleet.sortByMileageEfficiency();
			
		//Print Fleet of Vehicles
		System.out.println("Printing Vehicles from List");
		VehiclesFleet.printAllVehicles();
			
		scan.close();
		System.exit(0);
	}
}

/********** **Output** **********

Creating Gas Vehicle
Enter Serial Number for Gas Vehicle: 
WER001
Enter Made for Gas Vehicle: 
2000
Enter Model for Gas Vehicle: 
Mazda
Enter Max Speed for Gas Vehicle: 
120
Enter Brake Power for Gas Vehicle: 
60
Enter Serial Number for Gas Vehicle: 
WER002
Enter Made for Gas Vehicle: 
2002
Enter Model for Gas Vehicle: 
Nissan
Enter Max Speed for Gas Vehicle: 
135
Enter Brake Power for Gas Vehicle: 
75
Enter Serial Number for Gas Vehicle: 
WER003
Enter Made for Gas Vehicle: 
2005
Enter Model for Gas Vehicle: 
Honda
Enter Max Speed for Gas Vehicle: 
150
Enter Brake Power for Gas Vehicle: 
90
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
Printing Gas Vehicles
List of Gas Vehicles
GasVehicle [serialNumber=WER001, made=2000, model=Mazda, type=GasVehicle, tripCounter=0, maxSpeed=120.0, brakePower=60.0, fuelConsumed=0.0]
GasVehicle [serialNumber=WER002, made=2002, model=Nissan, type=GasVehicle, tripCounter=0, maxSpeed=135.0, brakePower=75.0, fuelConsumed=0.0]
GasVehicle [serialNumber=WER003, made=2005, model=Honda, type=GasVehicle, tripCounter=0, maxSpeed=150.0, brakePower=90.0, fuelConsumed=0.0]
Printing Electric Vehicles
List of Electric Vehicles
ElectricVehicle [serialNumber=SAV001, made=2010, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=120.0, brakePower=60.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=SAV002, made=2014, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=140.0, brakePower=80.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=SAV003, made=2018, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=160.0, brakePower=100.0, kwPowerConsumed=0.0]
Sorting Vehicles by Serial Number
Enter the Serial Number you are searching for: 
WER001
GasVehicle [serialNumber=WER001, made=2000, model=Mazda, type=GasVehicle, tripCounter=0, maxSpeed=120.0, brakePower=60.0, fuelConsumed=0.0]
Printing Vehicles from List
List of all Vehicles
ElectricVehicle [serialNumber=SAV001, made=2010, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=120.0, brakePower=60.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=SAV002, made=2014, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=140.0, brakePower=80.0, kwPowerConsumed=0.0]
ElectricVehicle [serialNumber=SAV003, made=2018, model=Tesla, type=ElectricVehicle, tripCounter=0, maxSpeed=160.0, brakePower=100.0, kwPowerConsumed=0.0]
GasVehicle [serialNumber=WER001, made=2000, model=Mazda, type=GasVehicle, tripCounter=0, maxSpeed=120.0, brakePower=60.0, fuelConsumed=0.0]
GasVehicle [serialNumber=WER002, made=2002, model=Nissan, type=GasVehicle, tripCounter=0, maxSpeed=135.0, brakePower=75.0, fuelConsumed=0.0]
GasVehicle [serialNumber=WER003, made=2005, model=Honda, type=GasVehicle, tripCounter=0, maxSpeed=150.0, brakePower=90.0, fuelConsumed=0.0]
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
Sorting Vehicles by Mileage Efficiency
Printing Vehicles from List
List of all Vehicles
GasVehicle [serialNumber=WER001, made=2000, model=Mazda, type=GasVehicle, tripCounter=100, maxSpeed=120.0, brakePower=60.0, fuelConsumed=8.88]
GasVehicle [serialNumber=WER003, made=2005, model=Honda, type=GasVehicle, tripCounter=125, maxSpeed=150.0, brakePower=90.0, fuelConsumed=6.66]
ElectricVehicle [serialNumber=SAV001, made=2010, model=Tesla, type=ElectricVehicle, tripCounter=100, maxSpeed=120.0, brakePower=60.0, kwPowerConsumed=4.44]
ElectricVehicle [serialNumber=SAV002, made=2014, model=Tesla, type=ElectricVehicle, tripCounter=150, maxSpeed=140.0, brakePower=80.0, kwPowerConsumed=6.66]
GasVehicle [serialNumber=WER002, made=2002, model=Nissan, type=GasVehicle, tripCounter=150, maxSpeed=135.0, brakePower=75.0, fuelConsumed=5.55]
ElectricVehicle [serialNumber=SAV003, made=2018, model=Tesla, type=ElectricVehicle, tripCounter=75, maxSpeed=160.0, brakePower=100.0, kwPowerConsumed=2.22]

 *********** ********** **********/
