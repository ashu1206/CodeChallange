package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseConfig {
	
   	 private static Properties properties;
	 private final static String propertyFilePath= "./UserTestDefault.properties";
	
	public static String getproperty(String key) {
		
		 String value = null;		 
		 BufferedReader reader;
		 try {
		 reader = new BufferedReader(new FileReader(propertyFilePath));
		 properties = new Properties();
		 try {
		 properties.load(reader);
		 value = properties.getProperty(key);
		 reader.close();
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		 }
		return value; 
		 }
	
	
	}


