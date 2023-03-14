package com.simpletests;

import static org.hamcrest.Matchers.is;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class TestCase4 {
	
	String token;
	@BeforeClass
	 public void setUp() {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
			
	}
	
	@Test   
	  
	   public void deletedUserData() {
		   Header tokenHeader= new Header("token", token);
		  Response res= RestAssured
		   .given()
	
		       .header(tokenHeader)
		   .when()
		   .delete("/delete/0");
		 res.then().statusCode(400);
		 String contentType= res.contentType();
			System.out.println("content type=" + contentType);
		 
		 res.prettyPrint();
		 res.then().body("status", is("success"));
	}
}
