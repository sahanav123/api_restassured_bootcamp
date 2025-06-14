package apiutilities;

import apipayload.User;

public class TestData {

    private String scenario;
    private int expectedStatusCode;
    private String expectedStatusLine;
    private User userCreateData;

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public int getExpectedStatusCode() {
        return expectedStatusCode;
    }

    public void setExpectedStatusCode(int expectedStatusCode) {
        this.expectedStatusCode = expectedStatusCode;
    }

    public String getExpectedStatusLine() {
        return expectedStatusLine;
    }

    public void setExpectedStatusLine(String expectedStatusLine) {
        this.expectedStatusLine = expectedStatusLine;
    }

    public User getUserCreateData() {
        return userCreateData;
    }

    public void setUserCreateData(User userCreateData) {
        this.userCreateData = userCreateData;
    }
}

