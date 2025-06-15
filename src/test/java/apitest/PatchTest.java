//package apitest;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import apiendpoints.UserAPI;
//import apipayload.User;
//import apiutilities.JsonDataProvider;
//import apiutilities.PutStoringFields;
//import apiutilities.TestData;
//import base.Base;
//import io.restassured.response.Response;




package apitest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import apiendpoints.UserAPI;
import apipayload.User;
import apiutilities.JsonDataProvider;
import apiutilities.PutStoringFields;
import apiutilities.TestData;
import base.Base;
import io.restassured.response.Response;

public class PatchTest extends Base {

    @Test(description = "updatinguserfirstname", dataProvider = "createdata", dataProviderClass = JsonDataProvider.class, priority = 1)
    public void verifyUserUpdateFirstname(TestData testData) {

        int patchUserId = PutStoringFields.getInt("putresponseId");
        System.out.println("patchuserId is : " + patchUserId);

        try {
            User payload = testData.getUserCreateData();

            // Convert only non-null fields into JSON
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String patchBody = mapper.writeValueAsString(payload);

            System.out.println("PATCH Payload JSON:\n" + patchBody);

            Response response = UserAPI.updateUserByPatch(patchUserId, patchBody, username, password);
            System.out.println("Full PATCH Response:\n" + response.asPrettyString());

            // Optional: Validate that userFirstName was updated if present
            if (payload.getUserFirstName() != null && !payload.getUserFirstName().isBlank()) {
                String returnedFirstName = response.jsonPath().getString("userFirstName");
                System.out.println("Returned userFirstName: " + returnedFirstName);
                Assert.assertEquals(returnedFirstName, payload.getUserFirstName(), "userFirstName mismatch");
            }

            Assert.assertEquals(response.getStatusCode(), testData.getExpectedStatusCode());

        } catch (Exception e) {
            Assert.fail("PATCH test failed with exception: " + e.getMessage(), e);
        }
    }

    @Test(description = "updatingfirstnamewithspecialchar", dataProvider = "createdata", dataProviderClass = JsonDataProvider.class, priority = 2)
    public void verifyUpdateUsernameWithSpecialChar(TestData testData) {

        int patchUserId = PutStoringFields.getInt("putresponseId");

        try {
            User payload = testData.getUserCreateData();

            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String patchBody = mapper.writeValueAsString(payload);

            System.out.println("PATCH Payload JSON:\n" + patchBody);

            Response response = UserAPI.updateUserByPatch(patchUserId, patchBody, username, password);
            System.out.println("Full PATCH Response:\n" + response.asPrettyString());

            Assert.assertEquals(response.getStatusCode(), testData.getExpectedStatusCode());

        } catch (Exception e) {
            Assert.fail("PATCH test failed with exception: " + e.getMessage(), e);
        }
    }
}


//public class PatchTest extends Base {
//
//	@Test(description = "updatinguserfirstname", dataProvider = "createdata", dataProviderClass = JsonDataProvider.class, priority = 1)
//	public void verifyUserupdatefirstname(TestData testData) {
//
//		int patchuserId = PutStoringFields.getInt("putresponseId");
//
//		System.out.println("patchuserId is : " + patchuserId);
//
//		User payload = testData.getUserCreateData();
//		try {
//		    String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(payload);
//		    System.out.println("Payload JSON:\n" + json);
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}
//
//		Response response = UserAPI.updateUserByPatch(patchuserId, payload, username, password);
//
//		String patchresponseuserFirstName = response.jsonPath().getString("userFirstName");
//		System.out.println("printing patchresponseuserFirstName: " + patchresponseuserFirstName);
//
//		Assert.assertEquals(response.getStatusCode(), testData.getExpectedStatusCode());
//	}
//
//	@Test(description = "updatingfirstnamewithspecialchar", dataProvider = "createdata", dataProviderClass = JsonDataProvider.class, priority = 2)
//	public void verifyUpdateUsernameWithSpecialChar(TestData testData) {
//		int patchuserId = PutStoringFields.getInt("putresponseId");
//		User payload = testData.getUserCreateData();
//		Response response = UserAPI.updateUserByPatch(patchuserId, payload, username, password);
//
//		Assert.assertEquals(response.getStatusCode(), testData.getExpectedStatusCode());
//	}
//
//}
