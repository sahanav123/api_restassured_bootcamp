package apiendpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import apipayload.User;
import io.restassured.http.ContentType;

public class UserAPI {

	public static RequestSpecification givenWithAuth(String username, String password) {
		return given().auth().basic(username, password);
	}

	public static RequestSpecification givenWithoutAuth() {
		return given();
	}

	public static Response getPublicInfo() {
		return givenWithoutAuth().contentType("application/json").when().get(Routes.GET_USER_BY_ID).then().extract()
				.response();
	}

	public static Response createUser(User payload, String username, String password) {
		Response response = givenWithAuth(username, password).contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.CREATE_USER);
		return response;
	}

	public static Response updateUserByPut(int userId, User payload, String username, String password) {
		Response response = givenWithAuth(username, password).contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("userId", userId)
				.body(payload).when()
				.put(Routes.UPDATE_USER_BY_PUT);
		return response;
	}
//
//	public static Response updateUserByPatch(int patchuserId, User payload, String username, String password) {
//		Response response = givenWithAuth(username, password)
//				.contentType(ContentType.JSON)
//				.accept(ContentType.JSON)
//				.pathParam("userId", patchuserId)
//				.body(payload).when()
//				.patch(Routes.UPDATE_USER_BY_PATCH);
//		return response;
//	}
	public static Response updateUserByPatch(int userId, String patchBody, String username, String password) {
		Response response = givenWithAuth(username, password)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("userId", userId)
				.body(patchBody).when()
				.patch(Routes.UPDATE_USER_BY_PATCH);
		return response;
	}


	public static Response deleteUserById(int userId, String username, String password) {
		Response response = givenWithAuth(username, password).pathParam("userId", userId).when()
				.post(Routes.DELETE_USER_BY_USERID);
		return response;
	}

	public static Response deleteUserByUserName(String userFirstName, String username, String password) {
		Response response = givenWithAuth(username, password).pathParam("userFirstName", userFirstName).when()
				.get(Routes.DELETE_USER_BY_USERNAME);
		return response;
	}

	public static Response getUserById(int userId, String username, String password) {
		Response response = givenWithAuth(username, password).pathParam("userId", userId).when()
				.get(Routes.GET_USER_BY_ID);
		return response;
	}
	public static Response getUserByUserName(String userFirstName, String username, String password) {
		Response response = givenWithAuth(username, password).pathParam("userFirstName", userFirstName).when()
				.get(Routes.GET_USER_BY_USERNAME);
		return response;
	}

}
