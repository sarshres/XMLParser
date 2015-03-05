package com.xmlrecords.parser;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//root node of xml file
@XmlRootElement(name = "Refined_Data")
public class Refined_Data {
	List<Record> records; // get all record node from parent node of
							// Refined_Data

	public List<Record> getRecord() {
		return records;
	}

	/**
	 * element that is going to be marshaled in the xml
	 */
	@XmlElement(name = "Record")
	public void setRecord(List<Record> records) {
		this.records = records;
	}

}