package com.virtualpariprogrammer.isbntool;

import static org.junit.Assert.*;

import org.junit.Test;

import com.virtualpairprogrammer.isbntool.validateISBN;

public class ValidateISBNTest {

	@Test
	public void checkAValidISBN() {
		//given
		validateISBN validator=new validateISBN();
		
		//when
		boolean result=validator.checkISBN(140449116);
		
		//then
		assertTrue(result);
		
	}

}
