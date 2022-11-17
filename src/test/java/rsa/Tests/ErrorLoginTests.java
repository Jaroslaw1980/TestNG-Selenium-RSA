package rsa.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import rsa.TestComponents.BaseTest;

public class ErrorLoginTests extends BaseTest {
    @Test(groups = {"ErrorHandling"})
    public void wrongPasswordTest(){
        landingPage.goTo();
        landingPage.loginUser("yaroBaro@gmail.com", "YaroBaro4$");
        Assert.assertEquals("Incorrect email or password.", landingPage.wrongPasswordMessage());
    }
}
