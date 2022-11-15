package rsa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rsa.abstractComponents.BasePage;

public class LandingPage extends BasePage {
    WebDriver driver;
    @FindBy(linkText = "Register")
    WebElement getRegisterButton;
    @FindBy(id = "userEmail")
    WebElement getUserEmail;
    @FindBy(id = "userPassword")
    WebElement getUserPassword;
    @FindBy(id = "login")
    WebElement getLoginButton;
    @FindBy(css = "[class*='flyInOut']")
    WebElement submitError;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    // login YaroBaro@gmail.com
    // password YaroBaro$4

    // selenium actions

    public void goTo() {

        driver.get("https://rahulshettyacademy.com/client");
    }
    public void clickRegisterButton() {
        getRegisterButton.click();
    }

    public void loginUser(String email, String password) {
        getUserEmail.sendKeys(email);
        getUserPassword.sendKeys(password);
        getLoginButton.click();
    }

    public void enterUserEmail(String email) {
        getUserPassword.sendKeys(email);
    }

    public void enterUserPassword(String password) {
        getUserPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        getLoginButton.click();
    }

    public String wrongPasswordMessage() {
        waitForVisibilityOfWebElementToAppear(submitError);
        return submitError.getText();
    }

}
