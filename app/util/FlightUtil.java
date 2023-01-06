package com.app.util;

import java.util.Random;

public class FlightUtil {
	
	public static int getRandomId()
	{
		Random random = new Random();
		int flightId = random.nextInt();
		return flightId;
	}

}
