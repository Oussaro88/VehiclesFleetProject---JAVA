package bus;

public class GasVehicle extends Vehicle {

	private double fuelConsumed;
	
	public GasVehicle() {
		super();
		this.setFuelConsumed(0);
	}
	
	public GasVehicle(String serialNumber, String made, String model, EnumType type, double maxSpeed, double brakePower) {
		super(serialNumber, made, model, type, maxSpeed, brakePower);
		this.setTripCounter(0);
		this.setFuelConsumed(0);
	}
	
	public GasVehicle(String serialNumber, String made, String model, EnumType type, int tripCounter, double maxSpeed, double brakePower, double fuelConsumed) {
		super(serialNumber, made, model, type, tripCounter, maxSpeed, brakePower);
		this.setFuelConsumed(fuelConsumed);
	}
	
	public double getFuelConsumed() {
		return fuelConsumed;
	}

	public void setFuelConsumed(double fuelConsumed) {
		this.fuelConsumed = fuelConsumed;
	}

	@Override
	public void makeTrip() {
		super.setTripCounter(100);
		this.setFuelConsumed(7.77);
	}

	@Override
	public void makeTrip(int tripCounter, double energyConsumed) {
		super.setTripCounter(tripCounter);
		this.setFuelConsumed(energyConsumed);
	}

	@Override
	public Double getMilePerUnitOfEnergyConsumed() {
		return super.getTripCounter() / this.getFuelConsumed();
	}

	@Override
	public String toString() {
		return "GasVehicle [serialNumber=" + super.getSerialNumber() + 
				", made=" + super.getMade() + 
				", model=" + super.getModel() + 
				", type=" + super.getType() + 
				", tripCounter=" + super.getTripCounter() +
				", maxSpeed=" + super.getMaxSpeed() +
				", brakePower=" + super.getBrakePower() +
				", fuelConsumed=" + this.getFuelConsumed() + "]";
	}
}
