package com.xmlrecords.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.xmlrecords.dao.RecordDao;
import com.xmlrecords.dao.RecordDaoImpl;

public class ParseRecordServiceImpl implements ParseRecordService {
	//public static void main(String[] args) 
	
	public void XMLToDB(File file){
		
		try {
								
			//Input the location of xml file to be parsed
			//File file = new File(args[0]);
			JAXBContext jaxbContext = JAXBContext
					.newInstance(Refined_Data.class);

			//check the correct xml file that contains report data
			InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream);
            char[] ch = new char[200];
            
            //read characters from xml file to search for the xml header <Refined_Data>
            reader.read(ch, 0, 54);
            StringBuffer strBuf = new StringBuffer();
            
            //close InputStreamReader and FileInputStream
            reader.close();
            inputStream.close();
            
            //read the search term '<Refined_Data>' from xml file
            for(int i=40;i<54;i++){
            	strBuf.append(ch[i]);
            }
            String line = strBuf.toString();  
            
            if(line.equals("<Refined_Data>")){
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Refined_Data refData = (Refined_Data) jaxbUnmarshaller
					.unmarshal(file);

			// insert the list of objects obtained from xml parsing into mongo
			// database
			RecordDao rec = new RecordDaoImpl();
			rec.addRecords(refData.getRecord());
            }

		} catch (JAXBException e) {
			e.printStackTrace();
			//TODO handle the bad formatted files
			
		} catch (FileNotFoundException e) {
			//Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			//Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
