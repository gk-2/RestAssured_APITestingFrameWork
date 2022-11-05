package com.gk.APITesting.testcases;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gk.APITesting.APIs.CreateCustomerAPI;
import com.gk.APITesting.SetUp.BaseTest;
import com.gk.APITesting.Utilities.DataUtil;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;
public class CreateCustomer extends BaseTest   {
	
	@Test(dataProviderClass=DataUtil.class, dataProvider="data")
	public void validateCreateCustomerAPIWithValidKey(Hashtable<String,String> data) {
		
	Response response=CreateCustomerAPI.sendPostRequestToCreateCustomerWithValidAuthKey(data);
		
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("status code::"+response.statusCode());
	}
	
	@Test(dataProviderClass=DataUtil.class, dataProvider="data")
	public void validateCreateCustomerAPIWithInValidKey(Hashtable<String,String> data) {
		
		Response response=CreateCustomerAPI.sendPostRequestToCreateCustomerWithInValidAuthKey(data);

		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 401);
		System.out.println("status code::"+response.statusCode());
	}
	
	
}
