package bus;

import java.sql.SQLException;
import java.util.ArrayList;

import data.GasVehicleDB;
/**
 * 
 * @author jawha
 * @numeroetudiant 1835342
 */
public class GasVehicle extends Vehicle {

	
	private static final long serialVersionUID = 1L;
	/**
	 *  private variable that will be used to return the fuel consumed by the gas vehicle
	 */
	private Double fuelConsumed;
	/**
	 * A constructor of the gas vehicle that uses the default values of the default vehicle constructor
	 * @throws RaiseException
	 * 
	 * @see {@link Vehicle#Vehicle()}
	 */
	public GasVehicle() throws RaiseException {
		super();
		this.setFuelConsumed(0.0);
	}
	/**
	 * Inherits the serial number, the made, the model, the date of manufacture, the trip counter, the type from the super
	 * and specifies the value of the fuel consumed of this GasVehicle created.
	 *
	 *@param serialNumber the serial number of this GasVehicle as a Long
	 *@param made the made of this GasVehicle as a String
	 *@param model the model of this GasVehicle as a String
	 *@param dateOfManufacture the date of manufacture of this GasVehicle as a Date
	 *@param tripCounter the trip counter of this GasVehicle as an Integer
	 *@param type the type of this GasVehicle as an EnumType
	 *@param fuelConsumed the fuel consumed by this GasVehicle as a Double
	 *@throws RaiseException if the argument doesn't respect the criteria
	 *			that define the purpose of this variable
	 *@see Vehicle#Vehicle(Long, String, String, Date, Integer, Enuntype)
	 */
	
	public GasVehicle(Long serialNumber, String made, String model, Integer date, Double maxSpeed, Double brakePower) throws RaiseException {
		super(serialNumber, made, model, date, maxSpeed, brakePower);
		this.setTripCounter(0);
		this.setFuelConsumed(0.0);
	}
	/**
	 * Gets the value of fuel consumed by this GasVehicle.
	 *The fuel consumed refers to the energy used by gasoline vehicles.
	 *
	 * @return A Double which represents this GasVehicle's fuelConsumed
	 * @see GasVehicle#fuelConsumed
	 */
	public GasVehicle(Long serialNumber, String made, String model, Integer date, Integer tripCounter, Double maxSpeed, Double brakePower, Double fuelConsumed) throws RaiseException {
		super(serialNumber, made, model, date, tripCounter, maxSpeed, brakePower);
		this.setFuelConsumed(fuelConsumed);
	}
	/**
	 * 
	 * @return fuelConsumed
	 */
	public Double getFuelConsumed() {
		return fuelConsumed;
	}
	/**
	 * 
	 * @param fuelConsumed
	 */
	public void setFuelConsumed(Double fuelConsumed) {
		this.fuelConsumed = fuelConsumed;
	}
	/**
	 * a void method that sets a default value for the maketrip
	 */
	@Override
	public void makeTrip() {
		super.setTripCounter(100);
		this.setFuelConsumed(7.77);
	}
	/**
	 * a void method that returns a new value of the make trip depending on the tripCounter and the energyconsumed
	 */
	@Override
	public void makeTrip(Integer tripCounter, Double energyConsumed) {
		super.setTripCounter(tripCounter);
		this.setFuelConsumed(energyConsumed);
	}
	/**
	 * a double method that return the efficiency of the car energy consommation
	 */
	@Override
	public Double getMilePerUnitOfEnergyConsumed() {
		return super.getTripCounter() / this.getFuelConsumed();
	}
	/**
	 * a string method that returns the state of the electric vehicle
	 */
	@Override
	public String toString() {
		return "GasVehicle [serialNumber=" + super.getSerialNumber() + 
				", made=" + super.getMade() + 
				", model=" + super.getModel() + 
				", date=" +super.getDate() +
				", tripCounter=" + super.getTripCounter() +
				", maxSpeed=" + super.getMaxSpeed() +
				", brakePower=" + super.getBrakePower() +
				", fuelConsumed=" + this.getFuelConsumed() + "]";
	}
	/**
	 * 
	 * @param element an object of class gas vehicle
	 * @return the gas vehicle added
	 * @throws SQLException
	 */
	public static int add(GasVehicle element) throws SQLException {
		return GasVehicleDB.insert(element);
	}
	/**
	 * 	
	 * @param element an object of class gas vehicle
	 * @return the gas vehicle updated
	 * @throws SQLException
	 */
	public static int update(GasVehicle element) throws SQLException {
		return GasVehicleDB.update(element);
	}
	/**
	 * 	a method that removes the gas vehicle from the database list of gas vehicles based on its Serial number
	 * 
	 * @param id: the serial number of the gas vehicle to remove
	 * @return the gas vehicle removed
	 * @throws SQLException
	 */
	public static int remove(String id) throws SQLException {
		return GasVehicleDB.delete(id);
	}
	/**
	 * 	a method that searches the gas vehicle in the database list of gas vehicles based on its Serial number 
	 * @param id : the serial number of the gas vehicle to look for
	 * @return the gas vehicle searched for
	 * @throws SQLException
	 * @throws NumberFormatException
	 * @throws RaiseException
	 */
	public static GasVehicle search(String id) throws SQLException, NumberFormatException, RaiseException {
		return GasVehicleDB.search(id);
	}
	/**
	 * a method that returns data about all the gas vehicles in the database gas vehicle list	
	 * @return the data of all vehicles list in the list
	 * @throws SQLException
	 * @throws NumberFormatException
	 * @throws RaiseException
	 */
	public static ArrayList<GasVehicle> getData() throws SQLException, NumberFormatException, RaiseException {
		return GasVehicleDB.select();
	}
}
