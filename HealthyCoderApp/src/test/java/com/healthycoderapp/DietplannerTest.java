package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DietplannerTest{
	
	private DietPlanner dietPlanner;

	@BeforeEach
	void setUp() throws Exception {
		this.dietPlanner=new DietPlanner(20,30,50);
		
	}

	@Test
	void should_returnCorrectDietPlan_WhenGivenCoder() {
		//given
		Coder coder=new Coder(1.82, 75.0, 26,Gender.MALE);
		DietPlan expected =new DietPlan(2202, 110, 73, 275);
		
		//when
		DietPlan result= dietPlanner.calculateDiet(coder);
		
		
		//then
		assertAll(
				
				()->assertEquals(expected.getCalories(), result.getCalories()),
				()->assertEquals(expected.getCarbohydrate(), result.getCarbohydrate()),
				()->assertEquals(expected.getProtein(), result.getProtein()),
				()-> assertEquals(expected.getFat(), result.getFat())
				
				);
		
	}

}
