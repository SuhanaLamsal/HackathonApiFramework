package com.simpletests;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

	public class TestCase2 {
		
		
				String token;
				@BeforeClass
				 public void setUp() {
					RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
				}
			
								  	
			  @Test   
			  
			 
			   public void createUserData() {
				   Header tokenHeader= new Header("token", token);
				  Response res= RestAssured
				   .given()
				   .body("{\"id\":8511,\"employee_name\":\"Tiger Bun\",\"employee_salary\":800,\"employee_age\":60,\"profile_image\":\"\"}")
				       .header(tokenHeader)
				   .when()
				   .post("/create");
				 res.then().statusCode(200);
				 res.prettyPrint();
				 res.then().body("status", is("success"));
				 
				  

		
		}
		  
	
	   
 }

	


