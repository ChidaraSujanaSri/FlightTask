package com.app.db;

import java.util.ArrayList;
import java.util.List;

import com.app.util.FlightUtil;

import day5.sets.Flight;

public class FlightDB {
	
	List<Flight> allflights = new ArrayList<>();
	
	public List<Flight> getAllFlights()
	{
		return allflights;
	}
	
	public Flight saveFlightInDB1(Flight flight)
	{
		if(flight != null)
		{
			flight.setFlightId(FlightUtil.getRandomId());
			boolean status = allflights.add(flight);
			if(status) return flight;
			else return null;
		}
		
		else
		{
			return null;
		}
	}
	
	 public List<Flight> getAllFlightByCarrierName(String searchCarrier)
     {

         List<Flight> outputFlights = new ArrayList<>();
         for (Flight flight : allflights) {
             if(flight.getCarrierName().equalsIgnoreCase(searchCarrier))
             {
                 outputFlights.add(flight);
             }
         }
         return outputFlights;
     }
	 
	 public List<Flight> getAllFlightsBetweenSourceAndDestination( String sourceAirport , String destinationAirport)
     {

         List<Flight> outputFlights = new ArrayList<>();
         for (Flight flight : allflights) {
             if(flight.getSourceAirport().equalsIgnoreCase(sourceAirport) && flight.getDestinationAirport().equalsIgnoreCase(destinationAirport))
             {
                 outputFlights.add(flight);
             }
         }
         return outputFlights;
     }
	 
	 public List<Flight> getAllFlightsBetweenSourceAndDestinationWithPriceFilter( String sourceAirport , String destinationAirport , int priceRange1, int priceRange2)
     {

         List<Flight> outputFlights = new ArrayList<>();
         for (Flight flight : allflights) {
             if(flight.getSourceAirport().equalsIgnoreCase(sourceAirport) && flight.getDestinationAirport().equalsIgnoreCase(destinationAirport))
             {
                 outputFlights.add(flight);
             }
         }
         return outputFlights;
     }
	 
	 
	 public List<Flight> getAllFlightsByDate(String sourceAirport , String destinationAirport , String date)
     {

         List<Flight> outputFlights = new ArrayList<>();
         for (Flight flight : allflights) {
             if(flight.getSourceAirport().equalsIgnoreCase(sourceAirport) && flight.getDestinationAirport().equalsIgnoreCase(destinationAirport) && flight.getDate().equalsIgnoreCase(date))
             {
                 outputFlights.add(flight);
             }
         }
         return outputFlights;
     }


     public Flight saveFlightInDB(Flight flight)
     {
         if(flight != null)
         {
             flight.setFlightId(FlightUtil.getRandomId());
             boolean status =  allflights.add(flight);
             if(status) return flight;
             else return null;
         }
         else
         {
             return null;
         }

     }

	

 }


