package com.api.util;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class PropertiesUtil {

    public static final String propdir = System.getProperty("user.dir") + File.separator + Constants.PROPERTIRS_PATH;

	static Properties props = new Properties();


    public static String getEnvProperty(String value) {
		String propertyValue = null;

		try {
	
            props.load(new FileInputStream(propdir + "test" + ".properties"));
			propertyValue = props.getProperty(value);
		} catch (Exception e) {
			propertyValue = "NOT_FOUND_CHECK_PROPERTY";
		}
		return propertyValue;
	}
}