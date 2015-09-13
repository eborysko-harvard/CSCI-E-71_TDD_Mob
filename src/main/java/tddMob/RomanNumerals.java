package tddMob;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RomanNumerals {
	public static int toInt(String s) {
		int sum = 0;
		
		if (!validateNumeral(s))
			throw new InvalidRomanNumeralException("Invalid Roman Numeral Found");
		
		char[] ar = s.toCharArray();

		for (int i = 0; i < ar.length - 1; i++) {
			if (lookup(ar[i]) < lookup(ar[i + 1])) {
				sum -= lookup(ar[i]);
			} else {
				sum += lookup(ar[i]);
			}
		}
		sum += lookup(ar[ar.length - 1]);
		return sum;

	}
	
	private static boolean validateNumeral(String s) {
		Pattern p = Pattern.compile("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
		return p.matcher(s).matches();
	}

	private static int lookup(char c) {
		switch (c) {
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 1;
		}
	}
}
