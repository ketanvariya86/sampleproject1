package com.ikkon.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	// create an object of properties class
	Properties properties;
	
	// create the path variable and add the path of config.properties file.
	String path = "D:\\JavaSelenium\\IKKON\\Configuration\\config.properties";
		
	
	// create constructor
	public ReadConfig() {
		try {
			// Initialize the object of properties class
			properties = new Properties();

			// create the file input stream object to read the properties file
			FileInputStream fis = new FileInputStream(path);
			//Load the properties file
			properties.load(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getBaseUrl()
	{
		String value = properties.getProperty("baseUrl");
		if(value!=null)
		{
			return value;
		}
		else
		{
			throw new RuntimeException("Base URL is not specified in config.properties file");
		}
	}
	
	public String getBrowser()
	{
		String value = properties.getProperty("browser");
		
		if(value != null)
		{
			return value;
		}
		else
		{
			throw new RuntimeException("Browser is not specified in config.properties file");
		}
	}
}
