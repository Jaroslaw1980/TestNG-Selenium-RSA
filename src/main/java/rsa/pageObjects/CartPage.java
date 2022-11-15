package rsa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rsa.abstractComponents.BasePage;

import java.util.List;

public class CartPage extends BasePage {

    WebDriver driver;
    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement getCheckoutButton;
    @FindBy(xpath = "//div[@class='infoWrap']//h3")
    List<WebElement> cartList;
    By cartContent = By.xpath("//div[@class='infoWrap']//h3");

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // selenium actions
    public List<WebElement> getProductFromCart() {
        waitForVisibilityOfElement(cartContent);
        return cartList;
    }

    public Boolean productCheck(String productName) {
        return getProductFromCart().stream().anyMatch(cartProd -> cartProd.getText().equalsIgnoreCase(productName));

    }
    public void clickOnCheckout() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(3000);
        getCheckoutButton.click();
    }

}
