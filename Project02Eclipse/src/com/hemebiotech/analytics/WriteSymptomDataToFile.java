package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

/**
 * Concrete class that implements the ISymptomWriter interface to write symptom data to a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter{
	/**
	 * Instance variable that contains the path to the file to write to.
	 */
	private final Path filepath;

	/**
	 * Constructs a WriteSymptomDataToFile object with the given file path.
	 *
	 * @param filepath a full or partial path of the file to write to.
	 */
	public WriteSymptomDataToFile (String filepath){
		this.filepath = Path.of(filepath);
	}

	/**
	 * Formats symptoms and their occurrences into a string so that they can be written to a file.
	 * This method is private because it is used only within this class.
	 *
	 * @param symptoms the map containing all the symptoms and their number of occurrences.
	 * @return the formatted string ready to be written to the file.
	 */
	private String formatSymptomsData(Map<String, Integer> symptoms) {
		var symptomsEntriesList = symptoms.entrySet();

		StringBuilder symptomsDataToWrite = new StringBuilder();

		for (var symptomEntry : symptomsEntriesList) {
			symptomsDataToWrite.append(symptomEntry.getKey() + ":" + symptomEntry.getValue() + "\n");
		}

		return symptomsDataToWrite.toString();
	}

	/**
	 * Implementation of the writeSymptoms method provided by the ISymptomWriter interface.
	 * Writes symptoms and their occurrences to the file specified during object construction.
	 *
	 * @param symptoms the map containing all the symptoms and their number of occurrences.
	 */
	@Override
	public void writeSymptoms (Map<String, Integer> symptoms) {
		String symptomsDataToWrite = formatSymptomsData(symptoms);

		try {
			Files.writeString(
					filepath,
					symptomsDataToWrite
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
