package bus;

public interface IMileageEfficiency {
	
	public void makeTrip();
	
	public void makeTrip(Integer tripCounter, Double energyConsumed);
	
	public abstract Double getMilePerUnitOfEnergyConsumed();
}
