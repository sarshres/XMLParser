package com.xmlrecords.dao;

import java.util.List;

import com.xmlrecords.parser.Record;

public interface RecordDao {
	
	public List<Record> getRecords();
	public void addRecords(List<Record> records);

}
