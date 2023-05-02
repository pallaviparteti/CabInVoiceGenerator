package com.bridgelabz.cabinvoicegenerator;

public class CabInVoiceGenerator {
	private static final double MIN_COST_PER_KILOMETER = 10;
	private static final double COST_FOR_TIME = 1;
	private static final double MINIMUM_AMOUNT = 5;

	public double travelCost(double distance, double time) {
		double cost = distance * MIN_COST_PER_KILOMETER + time * COST_FOR_TIME;
		if (cost < MINIMUM_AMOUNT)
			return MINIMUM_AMOUNT;
		return cost;
	}
}



