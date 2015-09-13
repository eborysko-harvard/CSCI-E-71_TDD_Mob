package tddMob;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanNumeralsTest {

	@Test
	public void testBaseRomanNumerals() {
		assertEquals(1, RomanNumerals.toInt("I"));
		assertEquals(5, RomanNumerals.toInt("V"));
		assertEquals(10, RomanNumerals.toInt("X"));
		assertEquals(50, RomanNumerals.toInt("L"));
		assertEquals(100, RomanNumerals.toInt("C"));
		assertEquals(500, RomanNumerals.toInt("D"));
		assertEquals(1000, RomanNumerals.toInt("M"));
	}

	@Test
	public void testAddRomanNumerals() {
		assertEquals(2, RomanNumerals.toInt("II"));
		assertEquals(3, RomanNumerals.toInt("III"));
		assertEquals(6, RomanNumerals.toInt("VI"));
		assertEquals(15, RomanNumerals.toInt("XV"));
		assertEquals(3888, RomanNumerals.toInt("MMMDCCCLXXXVIII"));
	}

	@Test
	public void testSubrtractRomanNumerals() {
		assertEquals(4, RomanNumerals.toInt("IV"));
		assertEquals(9, RomanNumerals.toInt("IX"));
		assertEquals(40, RomanNumerals.toInt("XL"));
		assertEquals(90, RomanNumerals.toInt("XC"));
		assertEquals(900, RomanNumerals.toInt("CM"));
	}

	@Test
	public void testAddNSubtract() {
		assertEquals(41, RomanNumerals.toInt("XLI"));
		assertEquals(44, RomanNumerals.toInt("XLIV"));
		assertEquals(95, RomanNumerals.toInt("XCV"));
		assertEquals(48, RomanNumerals.toInt("XLVIII"));
		assertEquals(49, RomanNumerals.toInt("XLIX"));
		assertEquals(2991, RomanNumerals.toInt("MMCMXCI"));
	}
	
	@Test(expected = InvalidRomanNumeralException.class)
	public void testInvalidCharacter() {
        RomanNumerals.toInt("A");
	}
	
	@Test(expected = InvalidRomanNumeralException.class)
	public void testMixedCharacters() {
        RomanNumerals.toInt("ABC");
	}
	
	@Test(expected = InvalidRomanNumeralException.class)
	public void testInvalidCharacters() {
        RomanNumerals.toInt("ABE");
	}
	
	@Test(expected = InvalidRomanNumeralException.class)
	public void testTooManyConsecutiveCharacters() {
        RomanNumerals.toInt("IIII");
	}
	
	@Test(expected = InvalidRomanNumeralException.class)
	public void testInvalidOrderOfCharacters() {
        RomanNumerals.toInt("ILX");
	}
}
