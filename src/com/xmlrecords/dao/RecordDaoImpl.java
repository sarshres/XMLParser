package com.xmlrecords.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cisco.cking2.charting.util.db.MongoDBFactory;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.xmlrecords.parser.Record;
import com.xmlrecords.properties.PropertyManager;

public class RecordDaoImpl implements RecordDao {
	
	private DB db = null;
	private DBCollection dBCollection = null;
	
	public RecordDaoImpl() throws MongoException, IOException{
		
			MongoDBFactory mongoDBFactory = MongoDBFactory.getInstance();
			PropertyManager propertyManager = PropertyManager.getInstance();
			db = mongoDBFactory.getDB(propertyManager.getValue("DBName"));
			dBCollection = db.getCollection(propertyManager.getValue("CollectionName"));
		
	}
	
	@Override
	public List<Record> getRecords() {
		new ArrayList<Record>();
		//DB db = null;
/*
		try {
			db = (new MongoClient("localhost", 27017)).getDB("testDB");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBCollection dBCollection = db.getCollection("testRecord");*/
		DBCursor dbCursor = dBCollection.find();
		while (dbCursor.hasNext()) {
			// TODO convert query result to object
			// basicDBObject = (BasicDBObject) dbCursor.next();
			System.out.println(dbCursor.next());
			// records.add((Record) dbCursor.next());
		}
		return null;
	}

	@Override
	public void addRecords(List<Record> records) {
		// TODO Auto-generated method stub
		Iterator<Record> it = records.iterator();
		//DB db = null;
		/*try {
			db = (new MongoClient("localhost", 27017)).getDB("testDB");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBCollection dBCollection = db.getCollection("testRecord");*/
		List<DBObject> colObj = new ArrayList<DBObject>();
		while (it.hasNext()) {
			Record r = it.next();
			BasicDBObject basicDBObject = new BasicDBObject();
			basicDBObject.put("username", r.getUserName());
			basicDBObject.put("hostname", r.getHostName());
			basicDBObject.put("product", r.getProductName());
			basicDBObject.put("date_accessed", r.getDate());
			colObj.add(basicDBObject);
			// dBCollection.insert(basicDBObject);
		}
		dBCollection.insert(colObj);
	}

}
