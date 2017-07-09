package com.icehockey.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {

	
	public Connection openConnection(){
		Properties properties=new Properties();
		String driver=null;
		String url=null;
		String username=null;
		String password=null;
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("DBConfig.properties"));
			driver=properties.getProperty("driver");
			url=properties.getProperty("url");
			username=properties.getProperty("username");
			password=properties.getProperty("password");
			Class.forName(driver);
			return DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
