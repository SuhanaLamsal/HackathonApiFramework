package com.simpletests;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

	public class TestCase3 {
		

		String token;
		@BeforeClass
		 public void setUp() {
			RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
			
		}
		
		 public void createUserData() {
			   Header tokenHeader= new Header("token", token);
			  Response res= RestAssured
			   .given()
			   .body("{\"id\":8511,\"employee_name\":\"Tiger Bun\",\"employee_salary\":800,\"employee_age\":60,\"profile_image\":\"\"}")
			       .header(tokenHeader)
			   .when()
			   .post("/create");
			 res.then().statusCode(200);
			 res.then().time(lessThan(5000L));
				res.then().contentType(ContentType.JSON);
				res.then().header("Content-Length", is("146"));
				
				res.prettyPrint();
			    String token= res.body().jsonPath().get("[0].token");
				System.out.println("token=" +token);			
		 }
		
			  @Test   
			  	 
			   public void deleteUserData() {
				   Header tokenHeader= new Header("token", token);
				  Response res= RestAssured
				   .given()
				   .body("{\"id\":8511\"}")
				   		
				       .header(tokenHeader)
				   .when()
				   .delete("/delete/id");
				 res.then().statusCode(200);
				 res.prettyPrint();
				 res.then().body("status", is("success"));
				 
		}
		  
	 
		   
		   
	   }
			
	   
 

	


