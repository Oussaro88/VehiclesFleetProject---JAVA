package bus;

public class Validator {

	public static void isChar(String value) throws RaiseException //IsChar
	{
		for(int i=0; i < value.length(); i++)
		{
			if(!Character.isAlphabetic(value.charAt(i)))
			{
				throw new RaiseException("Invalid Input; Value must be Alphabetical;");
			}
		}
	}
	
	/*public static void isDigit(String value) throws RaiseException
	{
		for(int i=0; i < value.length(); i++)
		{
			if(value.charAt(i) >= '0' && value.charAt(i) <= '9')
			{
				throw new RaiseException("Invalid Input; Value must be Numerical;");
			}
		}
	}*/
	
	public static void isDigit(Double value) throws RaiseException
	{
		if(value.isNaN())
		{
			throw new RaiseException("Invalid Input; Enter a Numeral Value;");
		}
	}
	
	public static void isInRange(Integer value) throws RaiseException 
	{
		if(value <=1 && value >= 999)
		{
			throw new RaiseException("Invalid Input; Value must be within 1 and 999;");
		}
	}
}
