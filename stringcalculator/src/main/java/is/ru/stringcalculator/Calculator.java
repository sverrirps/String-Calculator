package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if (text.equals(""))
		{
			return 0;
		}
		else if (text.contains(","))
		{
			String[] numbers = text.split(",");
			int total = 0;
			for (int i = 0; i < numbers.length; i++)
			{
				total += toInt(numbers[i]);
			}
			return total;
		}
		else
		{
			return toInt(text);
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}
}
