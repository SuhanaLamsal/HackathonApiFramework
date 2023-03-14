package com.POJOs;

import io.restassured.RestAssured;

public class JsonObjectResponseToPOJO {
	
	public static void main(String[] args) {
		
		
		GetDataGetterSetter getDataGetterSetter
		=RestAssured.get("https://dummy.restapiexample.com/api/v1")
		.as(GetDataGetterSetter.class);
		
		String name = getDataGetterSetter.getEmployee_name();
		System.out.println(name);
		
		String age= getDataGetterSetter.getEmployee_age();
		System.out.println(age);
		
		String salary= getDataGetterSetter.getEmployee_salary();
		System.out.println(salary);
		
		String profileImage= getDataGetterSetter.getProfile_image();
		System.out.println(profileImage);
		
		int id= getDataGetterSetter.getId();
		System.out.println(id);
		
	}

}
