package rsa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import rsa.abstractComponents.BasePage;

public class ConfirmationPage extends BasePage {
    WebDriver driver;
    By successText = By.cssSelector(".hero-primary");

    public ConfirmationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // selenium actions
    public String checkProperPucharse(){
        waitForVisibilityOfElement(successText);
        String text = driver.findElement(successText).getText().toLowerCase();
        return text;

    }

}

