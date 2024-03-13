package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Defines behavior for writing symptoms and their occurrences to an external resource.
 */
public interface ISymptomWriter {
	/**
	 * Nothing happens if no files are found.
	 *
	 * @param symptoms Map containing all the symptoms and their respective number of occurrences.
	 */
	void writeSymptoms(Map<String, Integer> symptoms);

}
