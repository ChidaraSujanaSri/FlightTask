package com.app.controller;

import java.util.List;

import com.app.db.FlightDB;

import day5.sets.Flight;

public class FlightController {
	
	FlightDB db;
	
	public FlightController() 
	{
	db = new FlightDB();
	}

	public List<Flight> getAllFlights()
	{
	return db.getAllFlights();
	}

	public Flight insertFlight(Flight userInputflight)
	{
	Flight savedFlight = db.saveFlightInDB(userInputflight);
	return savedFlight;
	}

	public List<Flight> getAllFlightsByCarrier(String userInputCarrier)
	{
	return db.getAllFlightByCarrierName(userInputCarrier);

	}

	public List<Flight> getAllFlightsBetweenSourceAndDestination(String sourceAirport, String destinationAirport) 
	{
		return db.getAllFlightsBetweenSourceAndDestination(sourceAirport, destinationAirport);
	}



	public List<Flight> getAllFlightsBetweenSourceAndDestinationWithPriceFilter(String sourceAirport,
			String destinationAirport, int priceRange1, int priceRange2)
	{
		return db.getAllFlightsBetweenSourceAndDestinationWithPriceFilter(sourceAirport, destinationAirport, priceRange1, priceRange2);
	}



	public List<Flight> getAllFlightsByDate(String sourceAirport, String destinationAirport, String date) 
	{
		return db.getAllFlightsByDate(sourceAirport, destinationAirport, date);
	}
	


}
