package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	 Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/congfig.properties");

		try {
			FileInputStream fs = new FileInputStream(src);
			pro = new Properties();
			pro.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  String getURL() {
		return pro.getProperty("baseURL");
	}

	public  String getUsername() {
		return pro.getProperty("username");
	}

	public  String getPassword() {
		return pro.getProperty("password");
	}

}
