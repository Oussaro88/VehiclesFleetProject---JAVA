package bus;

public class ElectricVehicle extends Vehicle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double kwPowerConsumed;
	
	public ElectricVehicle() throws RaiseException {
		super();
		this.setKwPowerConsumed(0);
	}
	
	public ElectricVehicle(String serialNumber, String made, String model, EnumType type, double maxSpeed, double brakePower) throws RaiseException {
		super(serialNumber, made, model, type, maxSpeed, brakePower);
		this.setTripCounter(0);
		this.setKwPowerConsumed(0);
	}
	
	public ElectricVehicle(String serialNumber, String made, String model, EnumType type, int tripCounter, double maxSpeed, double brakePower, double kwPowerConsumed) throws RaiseException {
		super(serialNumber, made, model, type, tripCounter, maxSpeed, brakePower);
		this.setKwPowerConsumed(kwPowerConsumed);
	}
	
	public double getKwPowerConsumed() {
		return kwPowerConsumed;
	}

	public void setKwPowerConsumed(double kwPowerConsumed) {
		this.kwPowerConsumed = kwPowerConsumed;
	}
	
	@Override
	public void makeTrip() {
		super.setTripCounter(100);
		this.setKwPowerConsumed(2.22);
	}

	@Override
	public void makeTrip(int tripCounter, double energyConsumed) {
		super.setTripCounter(tripCounter);
		this.setKwPowerConsumed(energyConsumed);
	}

	@Override
	public Double getMilePerUnitOfEnergyConsumed() {
		return super.getTripCounter() / this.getKwPowerConsumed();
	}

	@Override
	public String toString() {
		return "ElectricVehicle [serialNumber=" + super.getSerialNumber() + 
				", made=" + super.getMade() + 
				", model=" + super.getModel() + 
				", type=" + super.getType() + 
				", tripCounter=" + super.getTripCounter() + 
				", maxSpeed=" + super.getMaxSpeed() +
				", brakePower=" + super.getBrakePower() +
				", kwPowerConsumed=" + this.getKwPowerConsumed() + "]";
	}
}
