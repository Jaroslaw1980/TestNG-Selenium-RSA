package rsa.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import rsa.TestComponents.BaseTest;


public class ErrorRegisterTests extends BaseTest {

    @Test(groups = {"ErrorHandling"})
    public void wrongFirstNameTest() throws InterruptedException {
        this.landingPage.goTo();
        this.landingPage.clickRegisterButton();
        this.registerPage.enterFirstName("");
        this.registerPage.clickSubmitRegisterButton();

        String errorText = this.registerPage.firstNameError();
        Assert.assertEquals(errorText, "*First Name is required");
    }

    @Test(groups = {"ErrorHandling"})
    public void wrongEmailTest() {
        this.landingPage.goTo();
        this.landingPage.clickRegisterButton();
        this.registerPage.enterEmail("");
        this.registerPage.clickSubmitRegisterButton();

        String errorText = this.registerPage.emailError();
        Assert.assertEquals(errorText, "*Email is required");
    }

    @Test(groups = {"ErrorHandling"})
    public void wrongPhoneNumberTest() {
        this.landingPage.goTo();
        this.landingPage.clickRegisterButton();
        this.registerPage.enterPhoneNumber("");
        this.registerPage.clickSubmitRegisterButton();

        String errorText = this.registerPage.phoneNumberError();
        Assert.assertEquals(errorText, "*Phone Number is required");

    }

    @Test(groups = {"ErrorHandling"})
    public void wrongPasswordTest() {
        this.landingPage.goTo();
        this.landingPage.clickRegisterButton();
        this.registerPage.enterPassword("");
        this.registerPage.clickSubmitRegisterButton();

        String errorText = this.registerPage.passwordError();
        Assert.assertEquals(errorText, "*Password is required");

    }

    @Test(groups = {"ErrorHandling"})
    public void wrongConfirmPasswordTest(){
        this.landingPage.goTo();
        this.landingPage.clickRegisterButton();
        this.registerPage.enterConfirmPassword("");
        this.registerPage.clickSubmitRegisterButton();

        String errorText = this.registerPage.confirmPasswordError();
        Assert.assertEquals(errorText, "Confirm Password is required");
    }

    @Test(groups = {"ErrorHandling"})
    public void adultCheckboxNotSelectedTest(){
        this.landingPage.goTo();
        this.landingPage.clickRegisterButton();
        this.registerPage.clickSubmitRegisterButton();
        this.registerPage.adultCheckboxError();

        String errorText = this.registerPage.adultCheckboxError();
        Assert.assertEquals(errorText, "*Please check above checkbox");

    }
}
