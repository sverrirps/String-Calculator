package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if (text.equals(""))
		{
			return 0;
		}
		else if (text.startsWith("//"))
		{
			String delimiter = Character.toString(text.charAt(2));
			String[] numbers = text.substring(4).split(delimiter);
			int total = 0;
			for (int i = 0; i < numbers.length; i++)
			{
				total += toInt(numbers[i]);
			}

			return total;
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

	private static int sum(String[] numbers){
		int total = 0;
		for (int i = 0; i < numbers.length; i++)
		{
			total += toInt(numbers[i]);
		}
		return total;
	}
}
