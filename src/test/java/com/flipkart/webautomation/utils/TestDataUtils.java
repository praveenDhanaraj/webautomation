package com.flipkart.webautomation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;


public class TestDataUtils {

	public static Map<String, String> getPropertiesFileAsMap(String fileName) {
		Properties prop = new Properties();
		InputStream input = null;
		Map<String, String> dataTable = new HashMap<String, String>();

		String directory = System.getProperty("user.dir") + "/src/test/resources/" + fileName+ ".properties";
		
		try {
			input = new FileInputStream(directory);
			prop.load(input);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		dataTable.putAll(prop.entrySet().stream()
				.collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString())));

		return dataTable;
	}
}
