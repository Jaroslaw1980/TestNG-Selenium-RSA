package rsa.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rsa.TestComponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginTests extends BaseTest {

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap("C:\\Projects\\SeleniumJava\\src\\test\\java\\rsa\\Data\\LoginData.json");
        return new Object[][]{{data.get(0)}, {data.get(1)}};
    }

    @Test(dataProvider = "getData")
    public void loginTest(HashMap<String, String> input) {

        this.landingPage.goTo();
        this.landingPage.enterUserEmail(input.get("email"));
        this.landingPage.enterUserPassword(input.get("password"));
        this.landingPage.clickLoginButton();
    }
}
