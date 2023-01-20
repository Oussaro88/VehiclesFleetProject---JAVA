package bus;

import java.io.Serializable;

public abstract class Vehicle extends Object implements IMileageEfficiency, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String serialNumber;
	private String made;
	private String model;
	private EnumType type;
	protected int tripCounter;
	private double maxSpeed;
	private double brakePower;
	
	public Vehicle() throws RaiseException {
		super();
		this.setSerialNumber("Undefined");
		this.setMade("Undefined");
		this.setModel("Undefined");
		this.setType(EnumType.Undefined);
		this.setTripCounter(0);
		this.setMaxSpeed(0);
		this.setBrakePower(0);
	}
	
	public Vehicle(String serialNumber, String made, String model, EnumType type, double maxSpeed, double brakePower) throws RaiseException {
		super();
		this.setSerialNumber(serialNumber);
		this.setMade(made);
		this.setModel(model);
		this.setType(type);
		this.setTripCounter(0);
		this.setMaxSpeed(maxSpeed);
		this.setBrakePower(brakePower);
	}
	
	public Vehicle(String serialNumber, String made, String model, EnumType type, int tripCounter, double maxSpeed, double brakePower) throws RaiseException {
		super();
		this.setSerialNumber(serialNumber);
		this.setMade(made);
		this.setModel(model);
		this.setType(type);
		this.setTripCounter(tripCounter);
		this.setMaxSpeed(maxSpeed);
		this.setBrakePower(brakePower);
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getMade() {
		return made;
	}

	public void setMade(String made) {
		this.made = made;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) throws RaiseException {
		Validator.isAlphabetic(model);
		this.model = model;
	}
	
	public EnumType getType() {
		return type;
	}

	public void setType(EnumType type) {
		this.type = type;
	}
	
	public int getTripCounter() {
		return tripCounter;
	}

	public void setTripCounter(int tripCounter) {
		this.tripCounter = tripCounter;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) throws RaiseException {
		Validator.isDigital(maxSpeed);
		Validator.isNotNegative(maxSpeed);
		this.maxSpeed = maxSpeed;
	}

	public double getBrakePower() {
		return brakePower;
	}

	public void setBrakePower(double brakePower) throws RaiseException {
		Validator.isDigital(brakePower);
		Validator.isNotNegative(brakePower);
		this.brakePower = brakePower;
	}

	@Override
	public String toString() {
		return "Vehicle [serialNumber=" + serialNumber + 
				", made=" + made + 
				", model=" + model + 
				", type=" + type +
				", tripCounter=" + tripCounter + 
				", maxSpeed=" + maxSpeed +
				", brakePower=" + brakePower + "]";
	}

	public abstract void makeTrip();
	
	public abstract void makeTrip(int tripCounter, double energyConsumed);
	
	public abstract Double getMilePerUnitOfEnergyConsumed();
	
}
