package com.util.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import com.test.constants.SourcePath;


public class PropetiesUtility {
	
	private static PropetiesUtility utility;
	private static final Properties prop = new Properties();
	
	PropetiesUtility() throws IOException {
	
		InputStream inputStream = PropetiesUtility.class.getResourceAsStream("SourcePath.CONFIG_PROPERTIES_PATH");
	prop.load(inputStream);
  }
	
	public static PropetiesUtility getInstance() {
		if(utility == null) {
			synchronized (PropetiesUtility.class) {
				try {
					utility = new PropetiesUtility();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		    return utility;
	}
		    public static 
		    String getConfigProperty(String key) {
		    	return System.getProperty(key, prop.getProperty(key));    
		    	
		    }

			
			}
			
	






/*	public String getPropValues() throws IOException{
				
				String result= "";
				Properties prop= new Properties();
				String propFileName= "config.Properties";
				
				InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
				
				if (inputStream != null) {
					prop.load(inputStream);
				}else {
					throw new FileNotFoundException("property file '"+propFileName + "not found in the classpath");
				
				
			}
				return propFileName;  */

		
	




