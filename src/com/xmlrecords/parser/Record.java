package com.xmlrecords.parser;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = {"userName", "hostName", "productName" , "date"})
@XmlRootElement(name= "Record")
public class Record {
	
	private String userName;
	private String hostName;
	private String productName;
	private String date;
	
	public String getUserName() {
		return userName;
	}
	@XmlElement(name = "Username")
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getHostName() {
		return hostName;
	}
	@XmlElement(name = "Hostname")
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	
	
	public String getProductName() {
		return productName;
	}
	@XmlElement(name = "Product")
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	public String getDate() {
		return date;
	}	
	@XmlElement(name = "Date")
	public void setDate(String dateAccessed) {
		this.date = dateAccessed;
	}
	
	@Override
	public String toString(){
		StringBuffer str = new StringBuffer("Username: "+ getUserName());
		str.append(" HostName: "+ getHostName());
		str.append(" Product: "+getProductName());
		str.append(" DateAccessed: "+getDate());
		str.append("\n");
		
		return str.toString();
		
	}

}
