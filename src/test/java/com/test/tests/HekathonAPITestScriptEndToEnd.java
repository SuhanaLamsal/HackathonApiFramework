package com.test.tests;

import static org.hamcrest.Matchers.is;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.POJOs.GetDataTestDummyPOJO;
import com.test.helpers.UserServiceHelper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class HekathonAPITestScriptEndToEnd extends UserServiceHelper {
	
	@BeforeClass
	 public static String baseUri() {
		return RestAssured.baseURI= baseUri();
	}
	
	@Test(priority = 1, enabled = false)
	
	public static void TestCase1() {}
		public static void main(String[] args) {
	
		Response response = RestAssured.get("https://dummy.restapiexample.com/api/v1/employees");
		String returnObject= response.getBody().asString();
		JsonPath path = response.getBody().jsonPath();
		System.out.println(path.get("status"));
		java.util.List<?> lstList = path.get("data");
		System.out.println(lstList.size());
		for (Object lst : lstList) {
			System.out.println(lst);}
	}
	
	@Test 
	public static void TestCase2() {
		
	/*	Response res= createUserData();
		 res.then().statusCode(200);
		 res.prettyPrint();
		 res.then().body("status", is("success"));
		*/
		
	}


	}

	
	
	
	

	
	

	
	

	
	

	
	
	
	
	
	 
	
	


