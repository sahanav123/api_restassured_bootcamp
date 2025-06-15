package apitest;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import apiendpoints.UserAPI;
import apipayload.User;
import apiutilities.JsonDataProvider;
import apiutilities.PutStoringFields;
import apiutilities.StoringFields;
import apiutilities.TestData;
import base.Base;
import io.restassured.response.Response;

public class PutTest extends Base{
	
	@Test(description = "updatingfirstname", dataProvider = "createdata", dataProviderClass = JsonDataProvider.class, priority = 1)
	public void verifyUserCreationWithValidData(TestData testData) {
		
		int userId = StoringFields.getInt("postresponseuserId");
		
		
        User payload = testData.getUserCreateData();
		Response response = UserAPI.updateUserByPut(userId, payload, username, password);
		
		
		
		int putresponseId = response.jsonPath().getInt("userId");
		 String putresponseuserFirstName = response.jsonPath().getString("userFirstName");
		 
		 PutStoringFields.put("putresponseId", putresponseId );
		 PutStoringFields.put("putresponseuserFirstName", putresponseuserFirstName);
		 
		    System.out.println("Put response userId : " + putresponseId);
		    System.out.println("put response userFirstName : "+ putresponseuserFirstName);   
		
		Assert.assertEquals(response.getStatusCode(), testData.getExpectedStatusCode());

	}

	@Test(description = "MissinguserFirstNameput", dataProvider = "createdata", dataProviderClass = JsonDataProvider.class, priority = 2)
	public void verifyUserCreationWithMissingFirstName(TestData testData) {
		int userId = StoringFields.getInt("postresponseuserId");

		User payload = testData.getUserCreateData();
		Response response = UserAPI.updateUserByPut(userId,payload, username, password);
		Assert.assertEquals(response.getStatusCode(), testData.getExpectedStatusCode());	   
	}
	
	
}
