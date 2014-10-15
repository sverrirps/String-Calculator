package is.ru.stringcalculator;
import java.util.ArrayList;

public class Calculator {

	public static int add(String text){
		if (text.equals(""))
		{
			return 0;
		}
		else if (text.contains("-"))
		{
			return throwNegativeNumberException(text);
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
		return sum(numbers.substring(4).split(delimiter)); //setja sum inni main fallid
	}

	private static int sum(String[] numbers){
		int total = 0;
		for (int i = 0; i < numbers.length; i++)
		{
			if (toInt(numbers[i]) <= 1000)
			{
				total += toInt(numbers[i]);
			}
		}
		return total;
	}

	private static int throwNegativeNumberException(String text) {
		ArrayList<Character> negativesList = new ArrayList<Character>();
			char[] characters = text.toCharArray();
			for (int i = 0; i < (characters.length -1); i++)
			{
				if (characters[i] == '-')
				{
					negativesList.add(characters[i+1]);
				}
			}

			String errormessage = "Negatives not allowed: -" + negativesList.get(0);
			if (negativesList.size() > 1)
			{
				for (int j = 1; j < negativesList.size(); j++)
				{
					errormessage += (",-" + negativesList.get(j));
				}
			}
			throw new IllegalArgumentException(errormessage);
	}
}
