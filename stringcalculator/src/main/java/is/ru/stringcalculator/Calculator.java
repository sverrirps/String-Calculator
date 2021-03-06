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
			return sum(splitWithNewDelimiter(text));
		}
		else if (text.contains(",") || text.contains("\n"))
		{
			return sum(splitNumbers(text));
		}
		else
		{
			if (toInt(text) <= 1000)
			{
				return toInt(text);
			}
			else
			{
				return 0;
			}
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split(",|\n");
	}

	private static String[] splitWithNewDelimiter(String numbers){
		if ((numbers.charAt(2) == '[') && (numbers.contains("]")))
		{
			int indexOfNewline = numbers.indexOf("\n");
			if (numberOfSquareBrackets(numbers) > 1)
			{
				String delimiters = "[";
				for (int k = 0; k <= indexOfNewline; k++)
				{
					if (numbers.charAt(k) == '[')
					{
						int l = k + 1;
						while (numbers.charAt(l) != ']')
						{
							delimiters += numbers.charAt(l);
							l++;
						}
					}
				}
				delimiters += "]+";
				return numbers.substring(indexOfNewline + 1).split(delimiters);
			}
			else
			{
				int counter = 5;
				String multiCharDelimiter = "[";
				for (int i = 3; numbers.charAt(i) != ']'; i++)
				{
					multiCharDelimiter += numbers.charAt(i);
					counter++;
				}
				multiCharDelimiter += "]+";
				return numbers.substring(counter).split(multiCharDelimiter);
			}
		}
		else
		{
			String delimiter = Character.toString(numbers.charAt(2));
			return numbers.substring(4).split(delimiter);
		}
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

	private static int numberOfSquareBrackets(String text)
	{
		int numberOfSquareBrackets = 0;
			for (int j = 0; j < text.length(); j++)
			{
				if (text.charAt(j) == '[')
				{
					numberOfSquareBrackets++;
				}
			}
		return numberOfSquareBrackets;
	}
}
