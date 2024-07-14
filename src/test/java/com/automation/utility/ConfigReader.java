package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	static Properties properties;
	
	public ConfigReader() {
		File src = new File("./Config/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			properties = new Properties();
			properties.load(fis);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getValueFromConfig(String key) {
		return properties.getProperty(key);
	}
	
	
}
