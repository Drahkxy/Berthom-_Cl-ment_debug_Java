package com.hemebiotech.analytics;

public class Main {
	public static void main (String[] args) {
		ISymptomWriter writer = new WriteSymptomDataToFile("Project02Eclipse/result.out");
		ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

		AnalyticsCounter ac = new AnalyticsCounter(reader, writer);

		var symptomsData = ac.getSymptoms();

		var symptomsMap = ac.countSymptoms(symptomsData);

		ac.writeSymptoms(symptomsMap);
	}
}
