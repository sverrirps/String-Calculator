package is.ru.stringcalculator;
//import java.lang.*;

public class Calculator {

	public static int add(String text){
		if (text.equals(""))
		{
			return 0;
		}
		else if (text.contains("-"))
		{
			String errormessage = "Negatives not allowed: -1";
			throw new IllegalArgumentException(errormessage);
		}
		else if (text.startsWith("//"))
		{
			return splitWithNewDelimiter(text);
		}
		else if (text.contains(",") || text.contains("\n"))
		{
			return sum(splitNumbers(text));
		}
		else
		{
			return toInt(text);
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split(",|\n");
	}

	private static int splitWithNewDelimiter(String numbers){
		String delimiter = Character.toString(numbers.charAt(2));
		return sum(numbers.substring(4).split(delimiter));
	}

	private static int sum(String[] numbers){
		int total = 0;
		for (int i = 0; i < numbers.length; i++)
		{
			total += toInt(numbers[i]);
		}
		return total;
	}
}
