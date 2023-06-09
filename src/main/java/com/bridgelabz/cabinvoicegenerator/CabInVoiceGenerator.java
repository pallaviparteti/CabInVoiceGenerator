package com.bridgelabz.cabinvoicegenerator;

import java.util.HashMap;

public class CabinvoiceGenerator
{
	public HashMap<Integer,NoOfRides[]> rideRepository = new HashMap<>();
	private static final double FARE_PER_KM_REGULAR = 10;
	private static final double FARE_PER_MINUTE_REGULAR = 1;
	private static final double MINIMUM_FARE_REGULAR = 5;

	private static final double FARE_PER_KM_PREMIUM = 15;
	private static final double FARE_PER_MINUTE_PREMIUM = 2;
	private static final double MINIMUM_FARE_PREMIUM = 20;

	public double getfare(double distance, double time,String rideType)
	{
		if (rideType.equals("premium"))
		{
			return Math.max(MINIMUM_FARE_PREMIUM, distance*FARE_PER_KM_PREMIUM + time*FARE_PER_MINUTE_PREMIUM );
		}
		return Math.max(MINIMUM_FARE_REGULAR, distance*FARE_PER_KM_REGULAR + time*FARE_PER_MINUTE_REGULAR);
	}

	public InvoiceServices calculateTotalFare(int userId,NoOfRides[] rides,String rideType)
	{
		double totalFare = 0;
		for (NoOfRides ride : rides)
		{
			totalFare+=getfare(ride.distance, ride.time,rideType);
		}
		rideRepository.put(userId,rides);
		return  new InvoiceServices(userId,rides.length, totalFare);
	}
}