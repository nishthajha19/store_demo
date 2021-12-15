package com.example.store.utils;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;

@Component
public class CommonUtils {

	public static List<String[]> readCSV(String fileName) throws IOException, URISyntaxException {
		Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(fileName).toURI()));
		CSVReader csvReader = new CSVReader(reader);
		List<String[]> list = new ArrayList<>();
		list = csvReader.readAll();
		reader.close();
		csvReader.close();
		return list;
	}

}
