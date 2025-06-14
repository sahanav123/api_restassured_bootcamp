package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import configReader.ConfigManager;

public class Base {

	protected String username;
	protected String password;

	@BeforeMethod
	public void setUp() {
		String baseURI = ConfigManager.getProperty("baseURI");
		String basePath = ConfigManager.getProperty("basePath");
		username = ConfigManager.getProperty("basicAuthUsername");
		password = ConfigManager.getProperty("basicAuthPassword");

		RestAssured.baseURI = baseURI;
		RestAssured.basePath = basePath;

	}

}
