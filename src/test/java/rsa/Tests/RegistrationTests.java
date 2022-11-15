package rsa.Tests;

import org.testng.annotations.Test;
import rsa.TestComponents.BaseTest;

public class RegistrationTests extends BaseTest {

    @Test
    public void registerTest() throws InterruptedException {
        landingPage.goTo();
        landingPage.clickRegisterButton();

        registerPage.enterFirstName("Yaro");
        registerPage.enterLastName("Baro");
        registerPage.enterEmail("YaroBaro@com");
        registerPage.enterPhoneNumber("123456789");
        registerPage.chooseOccupation("Doctor");
        registerPage.chooseGenderMale();
        registerPage.enterPassword("YaroBaro");
        registerPage.enterConfirmPassword("YaroBaro");
        registerPage.clickAdultCheckbox();
    }
}
