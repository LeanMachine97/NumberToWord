package numbertoword;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class NumberToWordTest {
	private Object[] getValues() {
		return new Object[] {
				//parameterized test
				//test data for 1 to 19
				new Object[] {1, "one"}, 
				new Object[] {2, "two"}, 
				new Object[] {3, "three"}, 
				new Object[] {4, "four"}, 
				new Object[] {5, "five"}, 
				new Object[] {6, "six"}, 
				new Object[] {7, "seven"}, 
				new Object[] {8, "eight"}, 
				new Object[] {9, "nine"},
				new Object[] {11, "eleven"}, 
				new Object[] {12, "twelve"}, 
				new Object[] {13, "thirteen"}, 
				new Object[] {14, "fourteen"}, 
				new Object[] {15, "fifteen"}, 
				new Object[] {16, "sixteen"}, 
				new Object[] {17, "seventeen"}, 
				new Object[] {18, "eighteen"}, 
				new Object[] {19, "nineteen"},
				//test data for multiples of 10s
				new Object[] {20, "twenty"},
				new Object[] {30, "thirty"},
				new Object[] {40, "forty"},
				new Object[] {50, "fifty"},
				new Object[] {60, "sixty"},
				new Object[] {70, "seventy"},
				new Object[] {80, "eighty"},
				new Object[] {90, "ninety"},
				//test data for 100
				new Object[] {100, "one hundred"},
				//test data for multiples of 1000s
				new Object[] {1, "one"},
				new Object[] {100, "one hundred"}, 
				new Object[] {1000, "one thousand"}, 
				new Object[] {10000, "ten thousand"}, 
				new Object[] {100000, "one hundred thousand"}, 
				new Object[] {1000000, "one million"}, 
				new Object[] {10000000, "ten million"}, 
				new Object[] {100000000, "one hundred million"}, 
				new Object[] {1000000000, "one billion"}, 
				new Object[] {10000000000L, "ten billion"}, 
				new Object[] {100000000000L, "one hundred billion"}, 
				new Object[] {1000000000000L, "one trillion"}, 
				new Object[] {10000000000000L, "ten trillion"}, 
				new Object[] {100000000000000L, "one hundred trillion"},
				//test boundary values
				new Object[] {0, "zero"}, 
				new Object[] {999999999999999L, "nine hundred and ninety-nine trillion, nine hundred and ninety-nine billion, nine hundred and ninety-nine million, nine hundred and ninety-nine thousand, nine hundred and ninety-nine"} 
		};
	}
	
	//test method for convertNumberToWord function
	@Test
	@Parameters(method="getValues")
	public void testConvertNumberToWord(long number, String expected) {
		NumberToWord converter = new NumberToWord();
		String actual = converter.convertNumberToWord(number);
		assertEquals(expected, actual);
	}
	
	//test method for invalid input for convertNumberToWord function
	@Test(expected=IndexOutOfBoundsException.class)
	public void invalidTestConvertNumberToWord() {
		NumberToWord converter = new NumberToWord();
		converter.convertNumberToWord(-1);
		converter.convertNumberToWord(1000000000000000L);
	}
}
