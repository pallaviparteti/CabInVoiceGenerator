package com.bridgelabz.cabinvoicegenerator;

import static org.junit.Assert.assertEquals;

import javax.management.relation.Role;

import org.junit.Test;

public class CabInvoiceGeneratorTest<InvoiceSummary>
{
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare()
	{
		CabinvoiceGenerator cabInvoiceGenerator = new CabinvoiceGenerator();
		double distance = 5.0;
		double time = 2;
		double totalfare =  cabInvoiceGenerator.getfare(distance,time,"regular");
		assertEquals(52, totalfare,0.0);
	}

	@Test
	public void givenDistanceAndTime_WhenLessThanMinimumFare_ShouldReturnTotalFare()
	{
		CabinvoiceGenerator cabInvoiceGenerator = new CabinvoiceGenerator();
		double distance = 0.1;
		double time = 2;
		double totalfare =  cabInvoiceGenerator.getfare(distance,time,"regular");
		assertEquals(5, totalfare,0.0);
	}

	private double getfare(double distance, double time, String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary()
	{
		CabinvoiceGenerator cabInvoiceGenerator =new CabinvoiceGenerator();
		NoOfRides[] rides = { new NoOfRides(5.0,2),new NoOfRides(0.1,2)};
		InvoiceServices summary =  cabInvoiceGenerator.calculateTotalFare(1,rides,"regular");
		InvoiceServices   expectedSummary = new InvoiceServices (1,2,57.0);
		assertEquals(expectedSummary,summary);
	}

	@Test
	public void givenUserID_ShouldReturnListOfRides()
	{
		CabinvoiceGenerator cabInvoiceGenerator =new CabinvoiceGenerator();
		NoOfRides[] rides = { new NoOfRides(5.0,2),new NoOfRides(0.1,2)};
		cabInvoiceGenerator.calculateTotalFare(1,rides,"regular");
		NoOfRides[] expectedRide = cabInvoiceGenerator.rideRepository.get(1);
		assertEquals(expectedRide.toString(),rides.toString());
	}

	@Test
	public void givenDistanceAndTime_WhenPremium_ShouldReturnTotalFare()
	{
		CabinvoiceGenerator cabInvoiceGenerator = new CabinvoiceGenerator();
		double distance = 2;
		double time = 1;
		double totalfare =  cabInvoiceGenerator.getfare(distance,time,"premium");
		assertEquals(32, totalfare,0.0);
	}

	@Test
	public void givenDistanceAndTime_WhenPremiumAndLessThanMinimum_ShouldReturnTotalFare()
	{
		CabinvoiceGenerator cabInvoiceGenerator = new CabinvoiceGenerator();
		double distance = 1;
		double time = 1;
		double totalfare =  cabInvoiceGenerator.getfare(distance,time,"premium");
		assertEquals(20, totalfare,0.0);
	}
}