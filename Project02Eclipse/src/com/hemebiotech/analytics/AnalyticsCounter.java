package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * A class for analyzing and counting symptoms, using provided reader and writer implementations.
 */
public class AnalyticsCounter {
	/**
	 * Instance variable representing the reader implementation to read symptom data.
	 */
	private final ISymptomReader reader;

	/**
	 * Instance variable representing the writer implementation to write symptom data.
	 */
	private final ISymptomWriter writer;

	/**
	 * Constructs an AnalyticsCounter object with the given reader and writer implementations.
	 *
	 * @param reader the ISymptomReader implementation to read symptom data.
	 * @param writer the ISymptomWriter implementation to write symptom data.
	 */
	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Retrieves the list of symptoms by delegating the task to the ISymptomReader implementation.
	 *
	 * @return a list of symptoms obtained from the reader implementation.
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * Counts the occurrences of each symptom in the given list of symptoms.
	 *
	 * @param symptoms a list of symptoms to be counted.
	 * @return a map containing all the symptoms and their number of occurrences.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		TreeMap<String, Integer> symptomsMap = new TreeMap<>();

		for (String symptom : symptoms) {
			symptomsMap.merge(symptom, 1, Integer::sum);
		}

		return symptomsMap;
	}

	/**
	 * Writes the provided map of symptoms and their occurrences using the ISymptomWriter implementation.
	 *
	 * @param symptoms a map containing all the symptoms and their number of occurrences.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
