package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest{

	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
	}

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testOneNumber2() {
		assertEquals(2, Calculator.add("2"));
	}
	
	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testThreeNumbers() {
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testMultipleNumbers() {
		assertEquals(24, Calculator.add("2,4,5,1,12"));
	}

	@Test
	public void testNewLinesBetweenNumbers() {
		assertEquals(3, Calculator.add("1\n2"));
	}

	@Test
	public void testSplitWithCommaAndNewline() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}
}
