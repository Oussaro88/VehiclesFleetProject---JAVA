package bus;

import java.util.Comparator;

public class MileageEfficiencyComparator implements Comparator<Vehicle> {

	public int compare(Vehicle v1, Vehicle v2)
	{
		if(v1.getMilePerUnitOfEnergyConsumed().compareTo(v2.getMilePerUnitOfEnergyConsumed()) < 0) return -1;
		else if (v1.getMilePerUnitOfEnergyConsumed().compareTo(v2.getMilePerUnitOfEnergyConsumed()) > 0) return 1;
		else return 0;
	}
}
