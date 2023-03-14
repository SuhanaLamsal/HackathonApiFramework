package com.simpletests;

 
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.POJOs.LoginDataPOJO;
import com.POJOs.UserDataResponsePOJO;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

	public  class TestCase1  {
	
	/*	String token;
		@BeforeClass
		 public void setUp() {
			RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		}
	/*		  	
	 @Test   
	  
	   public void getUserData() {
		   Header tokenHeader= new Header("token", token);
		  Response res= RestAssured
		   .given()
		       .header(tokenHeader)
		   .when()
		   .get("/employees");
		 res.then().statusCode(200);
		 res.prettyPrint();
		 */
		
		
		public static void main(String[] args) {
		
		Response response = RestAssured.get("https://dummy.restapiexample.com/api/v1/employees");
		String returnObject= response.getBody().asString();
		JsonPath path = response.getBody().jsonPath();
		System.out.println(path.get("status"));
		java.util.List<?> lstList = path.get("data");
		System.out.println(lstList.size());
		for (Object lst : lstList) {
			System.out.println(lst);
		}
		   
		 
	}  
}	   
	   
	   
 

	


