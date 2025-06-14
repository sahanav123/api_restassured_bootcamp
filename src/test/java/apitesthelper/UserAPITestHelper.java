package apitesthelper;

import org.testng.Assert;
import org.testng.SkipException;

import apiendpoints.UserAPI;
import apipayload.User;
import apiutilities.TestData;
import io.restassured.response.Response;

public class UserAPITestHelper {
	
//	public static void runUserCreationTest(TestData testData, String expectedScenario, String username,
//			String password) {
//		
//		if (testData.getScenario().contains(expectedScenario)) {
//
//			User payload = testData.getUserCreateData();
//
//			Response response = UserAPI.createUser(payload, username, password);
//
//			Assert.assertEquals(response.getStatusCode(), testData.getExpectedStatusCode(), "Status code mismatch");
//
//		}
//
//	}
}
