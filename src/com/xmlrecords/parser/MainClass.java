package com.xmlrecords.parser;

import java.io.File;

public class MainClass
{	
	public static void main(String[] args) {
		
		//TODO take the list of files(rather than single file) and handle each file for parsing
		File file = new File(args[0]);
		//File file = new File("c:/Data/newData.xml");
		//ParseRecordService parseRecord = new ParseRecordServiceImpl();
		
		//Handle list of files to parse
		ParseRecordService parseRecord = new ParseRecordListImpl();
		parseRecord.XMLToDB(file);
		
		//TODO return the list of files for which the parsing could not be performed
		// In shell script use files which are successfully parsed to zip into single file
		
	}

}
