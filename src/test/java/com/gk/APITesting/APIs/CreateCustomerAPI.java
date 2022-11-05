package com.gk.APITesting.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.gk.APITesting.SetUp.BaseTest;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseTest {
	
	
	public static Response sendPostRequestToCreateCustomerWithValidAuthKey(Hashtable<String,String> data) {
		
		
		Response response=given().auth().basic(config.getProperty("validKey"), "")
				.formParam( "name",data.get("name"))
				.formParam( "email",data.get("email")) 
				.formParam("description",data.get("description"))
				.post(config.getProperty("customerAPIEndPoint"));
		
		return response;
	}
	
	public static Response sendPostRequestToCreateCustomerWithInValidAuthKey(Hashtable<String,String> data) {
		
		Response response=given().auth().basic(config.getProperty("inValidKey"), "")
				.formParam( "name",data.get("name"))
				.formParam( "email",data.get("email")) 
				.formParam("description",data.get("description"))
				.post(config.getProperty("customerAPIEndPoint"));
		
		return response;
	}
}