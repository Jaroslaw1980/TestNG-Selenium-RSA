package rsa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rsa.abstractComponents.BasePage;

import java.util.List;

public class ProductCataloge extends BasePage {

    WebDriver driver;
    @FindBy(css = ".mb-3")
    List<WebElement> productsList;
    By products = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.id("toast-container");
    @FindBy(css = "[routerlink*='/dashboard/cart']")
    WebElement getCartButton;

    public ProductCataloge(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // selenium actions
    public List<WebElement> getProductList() {
        waitForVisibilityOfElement(products);
        return productsList;
    }

    public WebElement getProductByName(String productName) {
        return getProductList().stream().filter(product -> product.findElement(By.cssSelector("b"))
                        .getText()
                        .equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);
    }

    public void addProductToCart(String productName) {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
        waitForVisibilityOfElement(toastMessage);
        waitForInvisibilityOfElement(toastMessage);
    }

    public void clickCartButton() {
        getCartButton.click();
    }

}
