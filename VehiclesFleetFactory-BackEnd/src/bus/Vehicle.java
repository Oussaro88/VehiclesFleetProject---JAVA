package bus;

import java.io.Serializable;

/**
 * Public Abstract Class Vehicle, the parent of GasVehicle and ElectricVehicle
 * @author Sengsamrach Vong 1931314
 * @see GasVehicle
 * @see ElectricVehicle
 */
public abstract class Vehicle extends Object implements IMileageEfficiency, Serializable {

	/**
	 * Serial of this vehicle.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param serialNumber The serial number of this vehicle as a Long.
	 * @param made The made of this vehicle as a String.
	 * @param model The model of this vehicle as a String.
	 * @param date The date of this vehicle as a Integer.
	 * @param tripCounter The TripCounter of this vehicle as a Integer.
	 * @param maxSpeed The maxSpeed of this vehicle as a Double.
	 * @param brakePower The brakePower of this vehicle as a Double.
	 */
	private Long serialNumber;
	private String made;
	private String model;
	private Integer date;
	protected Integer tripCounter;
	private Double maxSpeed;
	private Double brakePower;
	
	/**
	 * Constructor that does not receives any value and initialize with given 
	 * value to the parameters of this vehicle.
	 * 
	 * @param serialNumber The serial number of this vehicle as a Long.
	 * @param made The made of this vehicle as a String.
	 * @param model The model of this vehicle as a String.
	 * @param date The date of this vehicle as a Integer.
	 * @param tripCounter The trip counter of this vehicle as a Integer.
	 * @param maxSpeed The max speed of this vehicle as a Double.
	 * @param brakePower The brake power of this vehicle as a Double.
	 * @throws RaiseException If initial value doesn't respect the criteria of 
	 *         the vehicle which defines it, raise exception.
	 */
	public Vehicle() throws RaiseException {
		super();
		this.setSerialNumber(0l);
		this.setMade("Undefined");
		this.setModel("Undefined");
		this.setDate(0);
		this.setTripCounter(0);
		this.setMaxSpeed(0.0);
		this.setBrakePower(0.0);
	}
	
	/**
	 * Constructor that receives the serial number, the made, 
	 * the model, the date, the max speed and the brake power
	 * and initialize trip counter to 0, and set them as value 
	 * for this vehicle.
	 * 
	 * @param serialNumber The serial number of this vehicle as a Long.
	 * @param made The made of this vehicle as a String.
	 * @param model The model of this vehicle as a String.
	 * @param date The date of this vehicle as a Integer.
	 * @param tripCounter The TripCounter of this vehicle as a Integer.
	 * @param maxSpeed The maxSpeed of this vehicle as a Double.
	 * @param brakePower The brakePower of this vehicle as a Double.
	 * @throws RaiseException If entered value doesn't respect the criteria of 
	 *         the vehicle which defines it, raise exception.
	 */
	public Vehicle(Long serialNumber, String made, String model, Integer date, Double maxSpeed, Double brakePower) throws RaiseException {
		super();
		this.setSerialNumber(serialNumber);
		this.setMade(made);
		this.setModel(model);
		this.setDate(date);
		this.setTripCounter(0);
		this.setMaxSpeed(maxSpeed);
		this.setBrakePower(brakePower);
	}
	
	/**
	 * Constructor that receives the serial number, the made, 
	 * the model, the date, the trip counter, the max speed 
	 * and the brake power and set them as value for this vehicle.
	 * 
	 * @param serialNumber The serial number of this vehicle as a Long.
	 * @param made The made of this vehicle as a String.
	 * @param model The model of this vehicle as a String.
	 * @param date The date of this vehicle as a Integer.
	 * @param tripCounter The TripCounter of this vehicle as a Integer.
	 * @param maxSpeed The maxSpeed of this vehicle as a Double.
	 * @param brakePower The brakePower of this vehicle as a Double.
	 * @throws RaiseException If entered value doesn't respect the criteria of 
	 *         the vehicle which defines it, raise exception.
	 */
	public Vehicle(Long serialNumber, String made, String model, Integer date, Integer tripCounter, Double maxSpeed, Double brakePower) throws RaiseException {
		super();
		this.setSerialNumber(serialNumber);
		this.setMade(made);
		this.setModel(model);
		this.setDate(date);
		this.setTripCounter(tripCounter);
		this.setMaxSpeed(maxSpeed);
		this.setBrakePower(brakePower);
	}

	/**
	 * Long Get Method returning serial number of this vehicle.
	 * @return 
	 */
	public Long getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Void Set Method setting the received Long serial number to this vehicle's serial number.
	 * @param serialNumber
	 */
	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * String Get Method returning made of this vehicle.
	 * @return
	 */
	public String getMade() {
		return made;
	}

	/**
	 * Void Set Method setting the received String made to this vehicle's made.
	 * @param made
	 * @throws RaiseException If entered value doesn't respect the criteria of 
	 *         the vehicle which defines it, raise exception.
	 */
	public void setMade(String made) throws RaiseException {
		Validator.isChar(made);
		this.made = made;
	}

	/**
	 * String Get Method returning model of this vehicle.
	 * @return
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Void Set Method setting the received String model to this vehicle's model.
	 * @param model
	 * @throws RaiseException If entered value doesn't respect the criteria of 
	 *         the vehicle which defines it, raise exception.
	 */
	public void setModel(String model) throws RaiseException {
		Validator.isChar(model);
		this.model = model;
	}
	
	/**
	 * Integer Get Method returning date of this vehicle.
	 * @return
	 */
	public Integer getDate() {
		return date;
	}

	/**
	 * Void Set Method setting the received Integer date to this vehicle's date.
	 * @param date
	 */
	public void setDate(Integer date) {
		this.date = date;
	}
	
	/**
	 * Integer Get Method returning trip counter of this vehicle.
	 * @return
	 */
	public Integer getTripCounter() {
		return tripCounter;
	}

	/**
	 * Void Set Method setting the received Integer trip counter to this vehicle's trip counter.
	 * @param tripCounter
	 */
	public void setTripCounter(Integer tripCounter) {
		this.tripCounter = tripCounter;
	}

	/**
	 * Double Get Method returning max speed of this vehicle.
	 * @return
	 */
	public Double getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * Void Set Method setting the received Double max speed to this vehicle's max speed.
	 * @param maxSpeed
	 * @throws RaiseException If entered value doesn't respect the criteria of 
	 *         the vehicle which defines it, raise exception.
	 */
	public void setMaxSpeed(Double maxSpeed) throws RaiseException {
		Validator.isDigit(maxSpeed);
		this.maxSpeed = maxSpeed;
	}

	/**
	 * Double Get Method returning brake power of this vehicle.
	 * @return
	 */
	public Double getBrakePower() {
		return brakePower;
	}

	/**
	 * Void Set Method setting the received Double brake power to this vehicle's brake power.
	 * @param brakePower
	 * @throws RaiseException If entered value doesn't respect the criteria of 
	 *         the vehicle which defines it, raise exception.
	 */
	public void setBrakePower(Double brakePower) throws RaiseException {
		Validator.isDigit(brakePower);
		this.brakePower = brakePower;
	}

	/**
	 * String Method toString overridden to return values of this vehicle's parameters.
	 */
	@Override
	public String toString() {
		return "Vehicle [serialNumber=" + serialNumber + 
				", made=" + made + 
				", model=" + model + 
				", date=" + date +
				", tripCounter=" + tripCounter + 
				", maxSpeed=" + maxSpeed +
				", brakePower=" + brakePower + "]";
	}

	/**
	 * Public Abstract Void Method called MakeTrip() receiving nothing, 
	 * received from the interface, used by its children.
	 * @see IMileageEfficiency
	 * @see GasVehicle
	 * @see ElectricVehicle
	 */
	public abstract void makeTrip();
	
	/**
	 * Public Abstract Void Method called MakeTrip() 
	 * receiving values for parameters tripCounter and energyConsumed, 
	 * received from the interface, used by its children.
	 * @see IMileageEfficiency
	 * @see GasVehicle
	 * @see ElectricVehicle
	 */
	public abstract void makeTrip(Integer tripCounter, Double energyConsumed);
	
	/**
	 * Public Abstract Void Method called getMilePerUnitofEnergyConsumed() 
	 * receiving nothing, received from the interface, used by its children.
	 * @see IMileageEfficiency
	 * @see GasVehicle
	 * @see ElectricVehicle
	 */
	public abstract Double getMilePerUnitOfEnergyConsumed();
	
}
