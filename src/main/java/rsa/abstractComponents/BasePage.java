package rsa.abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rsa.pageObjects.OrderPage;
import rsa.pageObjects.ProductCataloge;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    @FindBy(xpath = "//button[@routerlink='/dashboard/']")
    WebElement getHomeButton;
    @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
    WebElement getOrdersButton;
    @FindBy(xpath = "//i[@class='fa fa-sign-out']")
    WebElement getSignOutButton;
    @FindBy(xpath = "//h3")
    WebElement getMainPageButton;

    public ProductCataloge productCataloge;
    public OrderPage orderPage;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // method to use cart button on the header


    public ProductCataloge getMainPageButton() {
        getMainPageButton.click();
        productCataloge = new ProductCataloge(driver);
        return productCataloge;
    }

    public ProductCataloge getHomeButton() {
        getHomeButton.click();
        productCataloge = new ProductCataloge(driver);
        return productCataloge;
    }

    public OrderPage getOrderButton(){
        getOrdersButton.click();
        orderPage = new OrderPage(driver);
        return orderPage;
    }

    public void setGetSignOutButton(){
        getSignOutButton.click();
    }


    // wait for visibility of the element on the page
    public void waitForVisibilityOfElement(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForVisibilityOfWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }


    // wait for the invisibility of the element on the page
    public void waitForInvisibilityOfElement(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

    public void waitForInvisibilityOfWebElement(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(findBy));
    }
}

