package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

	private final Path filepath;

	public WriteSymptomDataToFile (String filepath){
		this.filepath = Path.of(filepath);
	}

	private String formatSymptomsData(Map<String, Integer> symptoms) {
		var symptomsEntriesList = symptoms.entrySet();

		StringBuilder symptomsDataToWrite = new StringBuilder();

		for (var symptomEntry : symptomsEntriesList) {
			symptomsDataToWrite.append(symptomEntry.getKey() + ":" + symptomEntry.getValue() + "\n");
		}

		return symptomsDataToWrite.toString();
	}

	@Override
	public void writeSymptoms (Map<String, Integer> symptoms) throws IOException {
		String symptomsDataToWrite = formatSymptomsData(symptoms);

		Files.writeString(
				filepath,
				symptomsDataToWrite
		);
	}

}
