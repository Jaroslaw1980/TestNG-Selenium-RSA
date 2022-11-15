package rsa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rsa.abstractComponents.BasePage;

import java.util.List;

public class CheckoutPage extends BasePage {
    WebDriver driver;
    @FindBy(css = "input[placeholder='Select Country']")
    WebElement getSelectCountryField;
    @FindBy(xpath = "//button[contains(@class, 'ta-item')]")
    List<WebElement> hintList;

    @FindBy(xpath = "//a[contains(text(), 'Place Order ')]")
    WebElement checkoutButton;
    By getHintList = By.xpath("//button[contains(@class, 'ta-item')]");


    // selenium actions
    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCountry(String country) {
        Actions action = new Actions(driver);
        action.sendKeys(getSelectCountryField, country).build().perform();
        waitForVisibilityOfElement(getHintList);
        List<WebElement> selectCountryList = hintList;
        for (WebElement ele : selectCountryList) {
            if (ele.getText().equalsIgnoreCase(country)) {
                ele.click();
            }
        }
    }

    public void placeOrder() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(2000);

        checkoutButton.click();
    }
}
