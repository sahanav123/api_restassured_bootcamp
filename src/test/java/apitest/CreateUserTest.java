package apitest;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.Test;

import apiendpoints.UserAPI;

import apipayload.User;
import apitesthelper.UserAPITestHelper;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import apiutilities.JsonDataProvider;
import apiutilities.StoringFields;
import apiutilities.TestData;
import base.Base;
import io.restassured.response.Response;

public class CreateUserTest extends Base {

	@Test(description = "Validusercreation", dataProvider = "createdata", dataProviderClass = JsonDataProvider.class, priority = 1)
	public void verifyUserCreationWithValidData(TestData testData) {
		
		User payload = testData.getUserCreateData();
		Response response = UserAPI.createUser(payload, username, password);
		
		 int postresponseuserId = response.jsonPath().getInt("userId");
		 String postresponseuserFirstName = response.jsonPath().getString("userFirstName");

		    StoringFields.put("postresponseuserId", postresponseuserId);
		    StoringFields.put("postresponseuserFirstName", postresponseuserFirstName);
		    
		    
		    
		    
		    
		    System.out.println("post response userId: " + postresponseuserId);
		    System.out.println("post response userFirstName: "+ postresponseuserFirstName);
		
		Assert.assertEquals(response.getStatusCode(), testData.getExpectedStatusCode());

	}

	@Test(description = "MissinguserFirstName", dataProvider = "createdata", dataProviderClass = JsonDataProvider.class, priority = 2)
	public void verifyUserCreationWithMissingFirstName(TestData testData) {
		User payload = testData.getUserCreateData();
		Response response = UserAPI.createUser(payload, username, password);
		Assert.assertEquals(response.getStatusCode(), testData.getExpectedStatusCode());	   
	}
	
	
	
	
	
	
	
}



//if (!testData.getScenario().contains("Validusercreation")) {
//throw new SkipException("Skipping: not a valid user creation test");
//}
//
//User payload = testData.getUserCreateData();
//Response response = UserAPI.createUser(payload, username, password);
//Assert.assertEquals(response.getStatusCode(), testData.getExpectedStatusCode(), "Status code mismatch");