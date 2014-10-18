package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

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

	@Test
	public void testDifferentDelimiter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testNegativeNumbersByThrowingIllegalArgumentException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(equalTo("Negatives not allowed: -1"));
		Calculator.add("-1,2");
	}

	@Test
	public void testMultipleNegativeNumbersByThrowingIllegalArgumentException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(equalTo("Negatives not allowed: -4,-5"));
		Calculator.add("2,-4,3,-5");
	}

	@Test
	public void testNumbersBiggerThan1000() {
		assertEquals(2, Calculator.add("1001,2"));
	}

	@Test
	public void testSingleNumberBiggerThan1000() {
		assertEquals(0, Calculator.add("1234"));
	}

	@Test
	public void testNumbersBiggerThan1000SplitByDifferentDelimiter() {
		assertEquals(8, Calculator.add("//;\n1;2345;7"));
	}

	@Test
	public void testDifferentDelimiterOfAnyLength() {
		assertEquals(6, Calculator.add("//[svessi]\n1svessi2svessi3"));
	}

	@Test
	public void testDifferentDelimiterOfAnyLength2(){
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}

	@Test
	public void testMultipleDelimiters() {
		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
	}

}