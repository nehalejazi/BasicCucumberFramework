package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	public Properties init_prop()
	{
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
