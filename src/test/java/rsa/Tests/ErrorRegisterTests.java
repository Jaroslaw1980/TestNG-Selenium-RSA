package rsa.Tests;

import org.testng.Assert;
import org.testng.annotations.*;
import rsa.TestComponents.BaseTest;


public class ErrorRegisterTests extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void startUp() {
        landingPage.goTo();
        landingPage.clickRegisterButton();
    }

    @Test(groups = {"ErrorHandling"})
    public void wrongFirstNameTest() throws InterruptedException {
        registerPage.enterFirstName("");
        registerPage.clickSubmitRegisterButton();

        String errorText = registerPage.firstNameError();
        Assert.assertEquals(errorText, "*First Name is required");
    }

    @Test(groups = {"ErrorHandling"})
    public void wrongEmailTest() {
        registerPage.enterEmail("");
        registerPage.clickSubmitRegisterButton();

        String errorText = registerPage.emailError();
        Assert.assertEquals(errorText, "*Email is required");
    }

    @Test(groups = {"ErrorHandling"})
    public void wrongPhoneNumberTest() {
        registerPage.enterPhoneNumber("");
        registerPage.clickSubmitRegisterButton();

        String errorText = registerPage.phoneNumberError();
        Assert.assertEquals(errorText, "*Phone Number is required");
    }

    @Test(groups = {"ErrorHandling"})
    public void wrongPasswordTest() {
        registerPage.enterPassword("");
        registerPage.clickSubmitRegisterButton();

        String errorText = registerPage.passwordError();
        Assert.assertEquals(errorText, "*Password is required");
    }

    @Test(groups = {"ErrorHandling"})
    public void wrongConfirmPasswordTest() {
        registerPage.enterConfirmPassword("");
        registerPage.clickSubmitRegisterButton();

        String errorText = registerPage.confirmPasswordError();
        Assert.assertEquals(errorText, "Confirm Password is required");
    }

    @Test(groups = {"ErrorHandling"})
    public void adultCheckboxNotSelectedTest() {
        registerPage.clickSubmitRegisterButton();
        registerPage.adultCheckboxError();

        String errorText = registerPage.adultCheckboxError();
        Assert.assertEquals(errorText, "*Please check above checkbox");
    }
}
