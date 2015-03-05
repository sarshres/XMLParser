package com.xmlrecords.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Class to implement the list of files and handle using single JVM
public class ParseRecordListImpl implements ParseRecordService {

	/*public static void main(String[] args) {
		ParseRecordService parseTest = new ParseRecordListImpl();
		File file = new File("C:/Data/listOfFiles");
		parseTest.XMLToDB(file);
	}*/
	
	@Override
	public void XMLToDB(File file) {
		
		String readLine= null;
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			ParseRecordService parseObject = new ParseRecordServiceImpl();
			while((readLine = br.readLine())!=null)
			{
				//Insert the logic to parse the file from implementation ParseRecordServiceImpl
				parseObject.XMLToDB(new File(readLine));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
