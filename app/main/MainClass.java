package com.app.main;

import java.util.List;
import java.util.Scanner;

 

import com.app.controller.FlightController;
import com.app.main.MainClass;

import day5.sets.Flight;

 

public class MainClass {
	
	Scanner sc = new Scanner(System.in);
    FlightController server = new FlightController();

 

    public static void main(String[] args) {

 

        MainClass app = new MainClass();

 

        while(true)
        {
            System.out.println("\n\n-------- App MENU ---------");
            System.out.println("1.Insert Flight In Database.");
            System.out.println("2.Display All Flights");
            System.out.println("3.Flights by Carrier Name");
            System.out.println("4.All Flights Between Source and Destination Airport");
            System.out.println("5.All Flights Between Source and Destination Airport with Price Filter");
            System.out.println("6.All Flights Between Source and Destination Airport &Date");
            System.out.println("0. EXIT ");

            
            System.out.println(" --- Enter Choice :- ");
            int choice = Integer.parseInt(app.sc.nextLine());

            switch (choice) {
                case 1:
                    app.takeUserInputForFlight();
                    break;

                case 2:
                    app.displayAllFlights();
                    break;

                case 3:
                    app.getFlightByCarrier();
                    break;

                case 4:
                    app.getAllFlightsBetweenSourceAndDestination();
                    break;

                case 5:
                    app.getAllFlightsBetweenSourceAndDestinationWithPriceFilter();
                    break;
                case 6:
                    app.getAllFlightsByDate();
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    break;
            }//end of switch

        }//end of while

    }//end main

 
    /*private void displayAllFlights() {
        // TODO Auto-generated method stub
    	

    }
    

    /*private void takeUserInputForFlight() {
        // TODO Auto-generated method stub

    }*/

    
    public void displayAllFlights() {
        List<Flight> allFlights = server.getAllFlights();
        System.out.println("\n\n ----All Saved Products---");
        for (Flight flight : allFlights) {
            displayFlights(flight, "");
        }

    }


    public void takeUserInputForFlight()
    {
        try {
            System.out.println("\n\t ---- Enter Flight Details ------\n");
            

            System.out.println("\n Enter Carrier Name ");
            String carrierName = sc.nextLine();

            System.out.println("\n Enter Source Airport ");
            String sourceAirport = sc.nextLine();

            System.out.println("\n Enter Destination Airport ");
            String destinationAirport=sc.nextLine();

            System.out.println("\n Enter takeoff time ");
            float takeoffTime = Float.parseFloat(sc.nextLine());
            
            System.out.println("\n Enter landing time " );
            float landingTime = Float.parseFloat(sc.nextLine());

            System.out.println("\n Enter Date");
            String date = sc.nextLine();
            
            System.out.println("\n Enter cost:");
            int cost = Integer.parseInt(sc.nextLine());
            
            System.out.println("\n Enter flight duration ");
            float flightduration = Float.parseFloat(sc.nextLine());

            // NOTE : id will be auto generated ...

            Flight userInputFlight = new Flight(0, carrierName, sourceAirport, destinationAirport, takeoffTime, landingTime, date, cost, flightduration);
            // Now click the submit button
            Flight serverSavedFlight = server.insertFlight(userInputFlight);

            if(serverSavedFlight != null)
                displayFlights(serverSavedFlight,"Flight Inserted !!!");
            else
                displayErrors("Flight Not Saved , Try again or check Authority ");

        }

        catch (Exception e) {
            displayErrors(" Wrong Input , Enter Again");
            takeUserInputForFlight();
        }

    }

 
    public void displayErrors(String errorMsg)
    {
        System.out.println("_______ !!! Error !!! _________________________");
        System.out.println(errorMsg);
    }


    public void getFlightByCarrier()
    {

        System.out.println("\n Enter Search Flight Carrier name:");
        String carrier = sc.nextLine();

        List<Flight> outputFlights = server.getAllFlightsByCarrier(carrier);
        System.out.println(" -------- ALL  "+carrier+" --------------");
        for (Flight flight : outputFlights) {
            displayFlights(flight, "");
        }
    }


    public void getAllFlightsBetweenSourceAndDestination()
    {
        System.out.println("\n Enter Source: ");
        String sourceAirport = sc.nextLine();

        System.out.println("\n Enter destination ");
        String destinationAirport = sc.nextLine();

        
        
        List<Flight> outputFlight = server.getAllFlightsBetweenSourceAndDestination(sourceAirport , destinationAirport);
        System.out.println(" -------- Flights between source and destination --------------");
        for (Flight flight : outputFlight) {
            displayFlights(flight, "");
        }
    }
    
    public void getAllFlightsBetweenSourceAndDestinationWithPriceFilter()
    {
    	System.out.println("\n Enter the source Airport:");
    	String sourceAirport = sc.nextLine();
    	
    	System.out.println("\n Enter destination airport:");
    	String destinationAirport = sc.nextLine();
    	
    	System.out.println("\n Enter price range1:");
    	int priceRange1 = sc.nextInt();
    	
    	System.out.println("\n Enter price range2:");
    	int priceRange2 = sc.nextInt();
    	
    	List<Flight> outputFlight = server.getAllFlightsBetweenSourceAndDestinationWithPriceFilter(sourceAirport , destinationAirport, priceRange1, priceRange2);
        System.out.println(" -------- Price of flights between source and destination --------------");
        for (Flight flight : outputFlight) {
            displayFlights(flight, "");
        }
    	
    }
    
    public void getAllFlightsByDate()
    {
    	System.out.println("\n Enter source airport:");
        String sourceAirport = sc.nextLine();
    	
    	System.out.println("\n Enter destination airport:");
    	String destinationAirport = sc.nextLine();
    	
    	System.out.println("\n Enter the date:");
    	String date = sc.nextLine();
    	
    	List<Flight> outputFlight = server.getAllFlightsByDate(sourceAirport , destinationAirport, date);
        System.out.println(" -------- Price of flights between source and destination --------------");
        for (Flight flight : outputFlight) {
            displayFlights(flight, "");
        }
    	
    }
    

 

    public void displayFlights(Flight f,String tagline)
    {
        System.out.println(tagline);
        System.out.println(f.getFlightId()+" - "+f.getCarrierName()+" - "+f.getSourceAirport()+" - "+f.getDestinationAirport()+" - "+f.getTakeoffTime()+"-"+f.getLandingTime()+"-"+f.getDate()+"-"+f.getCost());
    }

 

}
