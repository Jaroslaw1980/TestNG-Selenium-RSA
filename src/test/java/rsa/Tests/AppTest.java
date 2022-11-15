package rsa.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rsa.TestComponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class AppTest extends BaseTest {
    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") +
                "\\src\\test\\java\\rsa\\Data\\AppTest.json");

        return new Object[][]{{data.get(0)}, {data.get(1)}};
    }

    @Test(dataProvider = "getData")
    public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {

        String successMessage = "THANKYOU FOR THE ORDER.";

        this.landingPage.goTo();

        this.landingPage.loginUser(input.get("email"), input.get("password"));
        this.productCataloge.getProductByName(input.get("product"));
        this.productCataloge.addProductToCart(input.get("product"));
        this.productCataloge.clickCartButton();
        Boolean match = this.cartPage.productCheck(input.get("product"));
        Assert.assertTrue(match);
        this.cartPage.clickOnCheckout();

        this.checkoutPage.selectCountry(input.get("country"));
        this.checkoutPage.placeOrder();

        Assert.assertTrue(this.confirmationPage.checkProperPucharse().equalsIgnoreCase(successMessage));

    }
}

