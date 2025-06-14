package apiutilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonDataReader {

    public static TestData[] getTestData(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        TestData[] testDataArray = null;
        try {
            testDataArray = mapper.readValue(new File(filePath), TestData[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testDataArray;
    }
}
