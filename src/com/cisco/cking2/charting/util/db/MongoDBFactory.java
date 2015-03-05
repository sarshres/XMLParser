package com.cisco.cking2.charting.util.db;

import java.io.IOException;
import java.net.UnknownHostException;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.xmlrecords.properties.PropertyManager;

public class MongoDBFactory {
	
	private static MongoDBFactory instance = null;
	
	//private final String MONGO_SERVER = "rtp-alm-svc1.cisco.com";
	private MongoClient m;
	
	private MongoDBFactory() throws MongoException, IOException {
		//m = new MongoClient(MONGO_SERVER);
		PropertyManager propertyManager = PropertyManager.getInstance();
		m = new MongoClient(propertyManager.getValue("MongoServer"));
	}
	
	public static MongoDBFactory getInstance() throws MongoException, IOException {
		if(instance == null) {
			instance = new MongoDBFactory();
		}
		return instance;
	}
	
	public com.mongodb.DB getDB(String dbname) {
		return m.getDB(dbname);
	}
	
	public void close() {
		m.close();
	}
}
