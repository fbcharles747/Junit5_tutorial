package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BMICalculatorTest {

	@Test
	void should_ReturnTrue_When_DietRecomended() {
		//given
		double weight=89.0;
		double height=1.72;
		
		//when
		boolean recommended=BMICalculator.isDietRecommended(weight,height);
		
		//then
		assertTrue(recommended);
		
	}
	
	@Test
	void should_ReturnFalse_When_DietNotRecomended() {
		//given
		double weight=50;
		double height=1.92;
		
		//when
		boolean recommended=BMICalculator.isDietRecommended(weight,height);
		
		//then
		assertFalse(recommended);
		
	}
	@Test
	void should_ThrowArithmeticException_When_HightIsZero() {
		//given
		double weight=50;
		double height=0;
		boolean exceptionCatched=false;
		
		//when
		try {
			BMICalculator.isDietRecommended(weight,height);
			
		}catch(ArithmeticException e) {
			exceptionCatched=true;
		}
		
		
		//then
		assertTrue(exceptionCatched);
		
	}
	@Test
	void should_returnCoder_withWorstBMI() {
		//given
		List<Coder> coderList=new ArrayList<>();
		coderList.add(new Coder(1.82,60));
		coderList.add(new Coder(1.81,61));
		coderList.add(new Coder(1.80,62));
		//when
		Coder worstBMICoder=BMICalculator.findCoderWithWorstBMI(coderList);
		
		//then
		
		assertAll(
				()->assertEquals(1.80,worstBMICoder.getHeight()),
				()->assertEquals(62, worstBMICoder.getWeight())
				);
		
	}
	@Test
	void should_returnNull_CoderListIsEmpty() {
		//given
		List<Coder> coderList=new ArrayList<>();
		
		
		//when
		Coder worstBMICoder=BMICalculator.findCoderWithWorstBMI(coderList);
		
		//then
		assertNull(worstBMICoder);
		
	}
	@Test 
	void getBMIScoreTest() {
		//given
		List<Coder> coderList=new ArrayList<>();
		coderList.add(new Coder(1.80,60));
		coderList.add(new Coder(1.82,98));
		coderList.add(new Coder(1.82,64.7));
		
		
		double[] expected= {18.52,29.59,19.53};
		//when
		double[] result=BMICalculator.getBMIScores(coderList);
		//then
		assertArrayEquals(result, expected);
	}
	


}
