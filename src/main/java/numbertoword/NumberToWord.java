package numbertoword;

public class NumberToWord {
	public String convertNumberToWord(long number) {

			String[] numbers = new String[] {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
			String[] tens = new String[] {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
			String[] thousands = new String[] {"","thousand", "million", "billion", "trillion"};
			
			String words = "";
			int thousandMultiplier = 0;
			
			if (number < 0 || number > 999999999999999L)
				throw new IndexOutOfBoundsException("Input value out of bounds: please enter between 0 to 999,999,999,999,999");
			else if (number == 0)
				words = "zero";
			else {
				while (number!=0) {
					long n1 = number%1000;
					int n2 = (int) (n1%100);
					int n3 = (int) (n1/100);
					
					if (n1 > 0) { //determine thousands
						if (words.length() != 0)
							words = thousands[thousandMultiplier] + ", " + words;
						else
							words = thousands[thousandMultiplier] + " " + words;
						if (n2 == 0 && n3 != 0)
							words = numbers[n3] + " hundred " + words;
						else if (n2 >= 0) { //determine number in the thousand
							if (n2 < 20)
								words = numbers[n2] + " " + words;
							else if (n2%10 == 0)
								words = tens[n2/10] + " " + words;
							else
								words = tens[n2/10] + "-" + numbers[n2%10] + " " + words;
							if (n3 != 0) //determine number in the hundred
								words = numbers[n3] + " hundred and " + words;
						}
					}
					thousandMultiplier++;
					number = number/1000; //next thousand
				}
			}
			
			words = words.replaceAll("\\s+$",""); //remove whitespace
			return words;
		}
}
