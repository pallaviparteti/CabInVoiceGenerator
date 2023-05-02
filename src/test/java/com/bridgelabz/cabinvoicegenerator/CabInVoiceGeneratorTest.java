package com.bridgelabz.cabinvoicegenerator;

import javax.management.relation.Role;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CabInVoiceGeneratorTest {


    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
    	CabInVoiceGenerator  invoiceService = new CabInVoiceGenerator();
        double distance = 2;
        int time = 5;
        double fare = ( invoiceService).calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
    	CabInVoiceGenerator invoiceService = new CabInVoiceGenerator();
        double distance = 0.1;
        int time = 1;
        Double fare = invoiceService.calculateFaree(distance, time);
        Assert.assertEquals(5, fare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
    	CabInVoiceGenerator invoiceService = new CabInVoiceGenerator();
        Ride[] rides = {new Ride(2, 5), new Ride(0.1, 1)
        };
        double fare = invoiceService.calculateFare(rides);
        Assert.assertEquals(30, fare, 0);
    }}