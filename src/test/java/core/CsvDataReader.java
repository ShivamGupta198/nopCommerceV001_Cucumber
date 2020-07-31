package core;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvDataReader {
	private CsvDataReader() {

	}

	public static CSVRecord readTestDataFromFile(String filePath, String testCaseID) {
		try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
			CSVParser csvParser = new CSVParser(reader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

			for (CSVRecord csvRecord : csvParser) {
				if (testCaseID.equalsIgnoreCase(csvRecord.get("testID"))) {
					return csvRecord;
				}
			}
		} catch (IOException e) {
		}
		return null;
	}
}