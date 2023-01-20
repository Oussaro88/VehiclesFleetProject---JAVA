package bus;

import java.sql.SQLException;
import java.util.ArrayList;

import data.ElectricVehicleDB;

/**
 * 
 * @author Oussama Arouch
 * Numéro étudiant : 201911899
 * 
 */

public class ElectricVehicle extends Vehicle {

	/**
	 *  private variable that will be used to return the power level consumed by the electric vehicle
	 */
	private Double kwPowerConsumed;
	
	/**
	 * A constructor of the electric vehicle that uses the default values of the default vehicle constructor
	 * the power level consumed by the electric vehicle is set by default to 0
	 * @throws RaiseException
	 * 
	 * @see {@link Vehicle#Vehicle()}
	 */
	public ElectricVehicle() throws RaiseException {
		super();
		this.setKwPowerConsumed(0.0);
	}
	
	/**
	 * A parametred constructor that inherits some variables of the superclass vehicle
	 * the power level consumed is set is set in this electricvehicle constructor
	 * 
	 * @param serialNumber : returns a Long value that specifies the electric vehicle serial number
	 * @param made : returns a String value that specifies the electric vehicle made
	 * @param model : returns a String value that specifies the electric vehicle model
	 * @param date : returns a Integer value that specifies the electric vehicle date
	 * @param maxSpeed : returns a Double value that specifies the electric vehicle maxspeed
	 * @param brakePower : returns a Double value that specifies the electric vehicle maxspeed
	 * @throws RaiseException
	 * 
	 * @see {@link Vehicle#Vehicle(Long, String, String, Integer, Double, Double)}
	 */
	public ElectricVehicle(Long serialNumber, String made, String model, Integer date, Double maxSpeed, Double brakePower) throws RaiseException {
		super(serialNumber, made, model, date, maxSpeed, brakePower);
		this.setTripCounter(0);
		this.setKwPowerConsumed(0.0);
	}
	
	/**
	 * A parametred constructor that inherits some variables of the superclass vehicle
	 * the power level consumed is set is set in this electricvehicle constructor
	 * 
	 * @param serialNumber : returns a Long value that specifies the electric vehicle serial number
	 * @param made : returns a String value that specifies the electric vehicle made
	 * @param model : returns a String value that specifies the electric vehicle model
	 * @param date : returns a Integer value that specifies the electric vehicle date
	 * @param tripCounter : returns a Integer value that specifies the electric vehicle tripCounter
	 * @param maxSpeed : returns a Double value that specifies the electric vehicle maxspeed
	 * @param brakePower : returns a Double value that specifies the electric vehicle maxspeed
	 * @param kwPowerConsumed : returns a Double value that specifies the electric vehicle power level consumed
	 * @throws RaiseException
	 * 
	 * @see {@link Vehicle#Vehicle(Long, String, String, Integer, Integer, Double, Double)}
	 */
	public ElectricVehicle(Long serialNumber, String made, String model, Integer date, Integer tripCounter, Double maxSpeed, Double brakePower, Double kwPowerConsumed) throws RaiseException {
		super(serialNumber, made, model, date, tripCounter, maxSpeed, brakePower);
		this.setKwPowerConsumed(kwPowerConsumed);
	}
	
	/**
	 * 
	 * @return the value of the power level consumed by the electric car
	 */
	public Double getKwPowerConsumed() {
		return kwPowerConsumed;
	}

	/**
	 * set the value of the power level consumed by the electric car
	 * @param kwPowerConsumed
	 */
	public void setKwPowerConsumed(Double kwPowerConsumed) {
		this.kwPowerConsumed = kwPowerConsumed;
	}
	
	/**
	 * a void method that sets a default value for the maketrip
	 */
	@Override
	public void makeTrip() {
		super.setTripCounter(100);
		this.setKwPowerConsumed(2.22);
	}

	/**
	 * a void method that returns a new value of the make trip depending on the tripCounter and the energyconsumed
	 */
	@Override
	public void makeTrip(Integer tripCounter, Double energyConsumed) {
		super.setTripCounter(tripCounter);
		this.setKwPowerConsumed(energyConsumed);
	}

	/**
	 * a double method that return the efficiency of the car energy consommation
	 */
	@Override
	public Double getMilePerUnitOfEnergyConsumed() {
		return super.getTripCounter() / this.getKwPowerConsumed();
	}

	/**
	 * a string method that returns the state of the electric vehicle
	 */
	@Override
	public String toString() {
		return "ElectricVehicle [serialNumber=" + super.getSerialNumber() + 
				", made=" + super.getMade() + 
				", model=" + super.getModel() + 
				", date=" + super.getDate() +
				", tripCounter=" + super.getTripCounter() + 
				", maxSpeed=" + super.getMaxSpeed() +
				", brakePower=" + super.getBrakePower() +
				", kwPowerConsumed=" + this.getKwPowerConsumed() + "]";
	}
	
	/**
	 * a method that adds the electric vehicle to the database list of electric vehicles
	 * 
	 * @param element : an object of class electric vehicle
	 * @return the electric vehicle added
	 * @throws SQLException
	 */
	public static int add(ElectricVehicle element) throws SQLException {
		return ElectricVehicleDB.insert(element);
	}
	
	/**
	 * a method that updates the electric vehicle elements to the database list of electric vehicles
	 * 
	 * @param element : an object of class electric vehicle
	 * @return the electric vehicle updated
	 * @throws SQLException
	 */
	public static int update(ElectricVehicle element) throws SQLException {
		return ElectricVehicleDB.update(element);
	}
	
	/**
	 * a method that removes the electric vehicle from the database list of electric vehicles based on its Serial number
	 * 
	 * @param id : the serial number of the electric vehicle to remove
	 * @return the electric vehicle removed
	 * @throws SQLException
	 */
	public static int remove(String id) throws SQLException {
		return ElectricVehicleDB.delete(id);
	}
	
	/**
	 * a method that searches the electric vehicle in the database list of electric vehicles based on its Serial number 
	 * 
	 * @param id : the serial number of the electric vehicle to look for
	 * @return the electric vehicle searched for
	 * @throws SQLException
	 * @throws NumberFormatException
	 * @throws RaiseException
	 */
	public static ElectricVehicle search(String id) throws SQLException, NumberFormatException, RaiseException {
		return ElectricVehicleDB.search(id);
	}
	
	/**
	 * a method that returns data about all the electric vehicles in the database electric vehicle list
	 * 
	 * @return the data of all vehicles list in the list
	 * @throws SQLException
	 * @throws NumberFormatException
	 * @throws RaiseException
	 */
	public static ArrayList<ElectricVehicle> getData() throws SQLException, NumberFormatException, RaiseException {
		return ElectricVehicleDB.select();
	}
}
