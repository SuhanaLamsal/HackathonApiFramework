package com.day4;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.POJOs.LoginDataPOJO;
import com.POJOs.UserDataResponsePOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class GetDataTest {
	
	public class GetDataWithPOJO {
		String token;
		@BeforeClass
		 public void setUp() {
			RestAssured.baseURI="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
		}
				
	   @Test 
	 
		public  void logintoApi() {
	
		   
		   LoginDataPOJO ob= new LoginDataPOJO();
		   ob.setUsername1("suhanalamsal6@gmail.com");
		   ob.setPassword1("suhanalamsal123");
		   
	   HashMap<String, String> map = new HashMap<String, String>();
	   map.put("username", "suhanalamsal6@gmail.com");
	   map.put("password", "suhanalamsal123");
	   
		Response res= RestAssured
		   .given()
		      .log().headers()
		      .contentType(ContentType.JSON)
	          .body(map)  // Serialization
		   .when()
		      .post("/login");
		res.then().log().all();
		res.then().statusCode(201);
		res.then().time(lessThan(5000L));
		res.then().contentType(ContentType.JSON);
		res.then().header("Content-Length", is("146"));
				
	//	res.prettyPrint();
	    token= res.body().jsonPath().get("[0].token");
		System.out.println("token=" +token);
	}
	  	
	   @Test   (dependsOnMethods= "logintoApi")
	
	   public void getUserData() {
		   Header tokenHeader= new Header("token", token);
		  Response res= RestAssured
		   .given()
		       .header(tokenHeader)
		   .when()
		   .get("/getdata");
		  res.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("getDataSchema.json"));
		  
	   UserDataResponsePOJO[] data = res.as(UserDataResponsePOJO[].class);  // de serialization 
	   System.out.println("number of records=" + data.length);
	//   System.out.println("2nd record account number=" +data[1].getAccountno());
		  
		 res.then().statusCode(200);
		// res.prettyPrint();
		   
	   }	   
	}
}
