package apiutilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;

import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataProvider {
	private static List<TestData> allData;

	static {
		ObjectMapper mapper = new ObjectMapper();
		try {
			allData = Arrays.asList(
					mapper.readValue(new File("src/test/resources/testdata/CreateUsers.json"), TestData[].class));
		} catch (IOException e) {
			e.printStackTrace();
			allData = new ArrayList<>();
		}
	}

	@DataProvider(name = "createdata")
	public static Object[][] createdata(ITestNGMethod testMethod) {
		String scenarioKey = testMethod.getDescription();

		return allData.stream().filter(data -> data.getScenario().equalsIgnoreCase(scenarioKey))
				.map(data -> new Object[] { data }).toArray(Object[][]::new);
	}
	
}