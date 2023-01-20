package bus;

public class Validator {

	public static void isNotNegative(double value) throws RaiseException
	{
		if(value < 0)
		{
			throw new RaiseException("Invalid Input; Enter a Positive Value");
		}
	}
	
	public static void isDigital(double value) throws RaiseException
	{
		if(Double.isNaN(value))
		{
			throw new RaiseException("Invalid Input; Enter a Numeral Value");
		}
	}
	
	public static void isAlphabetic(String value) throws RaiseException
	{
		for(int i=0; i < value.length(); i++)
		{
			if(!Character.isAlphabetic(value.charAt(i)))
			{
				throw new RaiseException("Invalid Input; Value must be Alphabetical");
			}
		}
	}
}
