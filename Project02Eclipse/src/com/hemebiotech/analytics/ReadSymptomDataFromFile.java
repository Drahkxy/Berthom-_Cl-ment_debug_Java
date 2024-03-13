package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A concrete class that implements the ISymptomReader interface to read symptom data from a file.
 * Symptom data is read as Strings, line by line.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	/**
	 * Instance variable that contains the path to the file from which the data is read.
	 */
	private final String filepath;

	/**
	 * Constructs a ReadSymptomDataFromFile object with the given file path.
	 *
	 * @param filepath a full or partial path to file with symptom strings in it, one per line.
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Implementation of the getSymptoms method provided by the ISymptomReader interface.
	 * Allows to read data from the instance file.
	 *
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable.
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}


