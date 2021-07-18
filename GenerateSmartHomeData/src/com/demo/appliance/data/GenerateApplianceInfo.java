package com.demo.appliance.data;


import java.util.Random;
import java.util.UUID;

public class GenerateApplianceInfo {

	public static boolean generateBooleanData() {
		return new Random().nextBoolean();
	}
	
	public static String generateRandomhomeId() {
		return UUID.randomUUID().toString();
	}

	public static String generateRandomhomeType() {
		String[] homeTypeArray = { "Bungalow", "Apartment", "Compact" };
		return homeTypeArray[new Random().nextInt(homeTypeArray.length)];
	}

	public static double generatewashingmachineData(double min, double max) {
		return Math.random() * (max - min) + min;
	}
	public static double generatefridgeData(double min, double max) {
		return Math.random() * (max - min) + min;
	}
	public static double generateacData(double min, double max) {
		return Math.random() * (max - min) + min;
	}

	public static int generatewaterlevel(int min, int max) {
		return new Random().nextInt(max);
	}

}
