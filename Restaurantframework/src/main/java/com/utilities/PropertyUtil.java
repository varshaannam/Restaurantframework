package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
	
	public static final String currentDir = System.getProperty("user.dir");
	public static String filepath = currentDir + "/src/main/resources/";

	public static Properties getProperty(String fileName) {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(filepath + fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			throw new RuntimeException("File not found");

		} catch (IOException ioe) {
			throw new RuntimeException("File not found");
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				throw new RuntimeException("Error while closing file");
			}

		}
		System.out.println("url is :" + prop.getProperty("url"));
		System.out.println("username is :" + prop.getProperty("username"));
		System.out.println("password is :" + prop.getProperty("password"));
		return prop;

	}
}
