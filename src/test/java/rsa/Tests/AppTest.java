package rsa.Tests;

import org.testng.Assert;
import org.testng.annotations.*;
import rsa.TestComponents.BaseTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class AppTest extends BaseTest{



    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") +
                "\\src\\test\\java\\rsa\\Data\\AppTest.json");

        return new Object[][]{{data.get(0)}, {data.get(1)}};
    }
    @Test(dataProvider = "getData")
    public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {

        String successMessage = "THANKYOU FOR THE ORDER.";

        landingPage.goTo();

        landingPage.loginUser(input.get("email"), input.get("password"));
        productCataloge.getProductByName(input.get("product"));
        productCataloge.addProductToCart(input.get("product"));
        productCataloge.clickCartButton();
        Boolean match = cartPage.productCheck(input.get("product"));
        Assert.assertTrue(match);
        cartPage.clickOnCheckout();

        checkoutPage.selectCountry(input.get("country"));
        checkoutPage.placeOrder();

        Assert.assertTrue(confirmationPage.checkProperPucharse().equalsIgnoreCase(successMessage));


    }
}

