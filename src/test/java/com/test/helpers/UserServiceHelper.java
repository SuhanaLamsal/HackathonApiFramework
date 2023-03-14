package com.test.helpers;

import java.util.Properties;

import com.github.fge.jsonschema.examples.Utils;
import com.test.constants.Endpoints;
import com.test.models.LoginObjectPOJO;
import com.util.utils.PropetiesUtility;

import io.restassured.RestAssured;
import okhttp3.Response;

public class UserServiceHelper {
	
  //  RestAssured.baseURI= "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
    
 /*
 	
 	public static String getBaseUri() {
 	 String baseURI=  PropetiesUtility.getConfigProperty("baseUrl");
		return baseURI;
				
	}
  
	 public static Response LoginToApplication() {
		String username=  PropetiesUtility.getConfigProperty("username");
		String password=  PropetiesUtility.getConfigProperty("password");
		
		LoginObjectPOJO ob= new LoginObjectPOJO();
		ob.setUsername1(username);
		ob.setPassword1(password);
		
		 Response response= RestAssured
				         .given()
				         .contentType("application/json")
			             .body(ob)  
				         .when()
				         .post(Endpoints.EMPLOYEES);
		 return response;
	 }
	  public static String getToken() {
		 Response response = LoginToApplication();
		 String token = response.body().jsonPath().get("[0].token");
		  return getToken();
		  
		  String token = response.getBody().jsonPath().getString("token");
	        return token;   
		    
	  
	  }    
	       
	 */	
}	
		
	 

