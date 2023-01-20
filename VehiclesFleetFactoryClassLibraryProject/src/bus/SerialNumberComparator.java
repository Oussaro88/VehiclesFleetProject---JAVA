package bus;

import java.util.Comparator;

public class SerialNumberComparator implements Comparator<Vehicle> {

	public int compare(Vehicle v1, Vehicle v2)
	{
		if(v1.getSerialNumber().compareTo(v2.getSerialNumber()) < 0) return -1;
		else if (v1.getSerialNumber().compareTo(v2.getSerialNumber()) > 0) return 1;
		else return 0;
	}
}
