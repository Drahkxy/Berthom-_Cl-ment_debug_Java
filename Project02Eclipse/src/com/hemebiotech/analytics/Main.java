package com.hemebiotech.analytics;

import java.io.IOException;

public class Main {

	public static void main (String[] args) {


		ISymptomWriter writer = new WriteSymptomDataToFile("Project02Eclipse/result.out");
		ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

		AnalyticsCounter ac = new AnalyticsCounter(reader, writer);

		var test = ac.getSymptoms();

		var test2 = ac.countSymptoms(test);

		try {
			ac.writeSymptoms(test2);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
