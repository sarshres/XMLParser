package com.xmlrecords.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
	//private static final String PROPS_FILE = "src/resources/xmlparser.properties";
	private static PropertyManager instance;
	
	private Properties props=null;
	
	// this ensures there is one and only one instance of the class.
	public static synchronized PropertyManager getInstance() throws IOException {
		if(instance == null) {
			instance = new PropertyManager();
		}
		return instance;
	}
	
	// constructor loads the property file.
	private PropertyManager() throws IOException {
					
		//File propsFile = new File(PROPS_FILE);
		
		props = new Properties();
		/*InputStream in = new FileInputStream(PROPS_FILE);
		props.load(in);
		in.close();*/
		String configFile = System.getProperty("config");
		if(configFile!=null){
			props.load(new FileInputStream(configFile));
		}
		
		}
	
	// returns value mapping to the key supplied.
	public String getValue(String key) {
		String value = props.getProperty(key);
		return value;
	}
	
}
