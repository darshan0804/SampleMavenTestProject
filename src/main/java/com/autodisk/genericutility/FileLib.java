package com.autodisk.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Darshan
 *		this is utility class used to read the data from properties file
 */


public class FileLib {

	/**
	 * used to get the data from properties file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertieFileData(String key) throws Throwable
	{
/* step1 : create java represention object for the phisical File */
		
		FileInputStream fis = new FileInputStream("./resource/commondata.properties");
		
		/*step  using properties class load all the key into java object */
		
		Properties prop = new Properties();
		prop.load(fis);
		/* read data from properties file */
		//System.out.println(prop.getProperty("url"));
		
			String value= prop.getProperty(key);
		
		
		return value;
	}

	
	
}
