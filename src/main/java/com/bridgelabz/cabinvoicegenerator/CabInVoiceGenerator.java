package com.bridgelabz.cabinvoicegenerator;

public class CabInVoiceGenerator {
	public class MoneyGenerator<Ride, InvoiceSummary> {
		private static final double MINIMUM_COST_PER_KILOMETER = 10;
		private static final int COST_PER_MINUTE = 1;
		private static final double MINIMUM_FARE = 5;

		public Double calculateFare(double distance, int time) {
			double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_MINUTE;
			if (totalFare < MINIMUM_FARE) {
				return MINIMUM_FARE;
			} else {
				return totalFare;
			}
		}
		public double calculateFare(Ride[] rides) {
			double totalFare = 0;
			for (Ride ride : rides) {
				totalFare += this.calculateFare(rides);
			}
			return totalFare;
		}
	}
}