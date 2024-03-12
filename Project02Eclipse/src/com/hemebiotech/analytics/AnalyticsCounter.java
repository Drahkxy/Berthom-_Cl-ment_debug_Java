package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private final ISymptomReader reader;

	private final ISymptomWriter writer;

	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		TreeMap<String, Integer> symptomsMap = new TreeMap<>();

		for (String symptom : symptoms) {
			symptomsMap.merge(symptom, 1, Integer::sum);
		}

		return symptomsMap;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
		writer.writeSymptoms(symptoms);
	}

}
