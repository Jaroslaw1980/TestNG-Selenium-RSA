package rsa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rsa.abstractComponents.BasePage;

import java.util.List;

public class OrderPage extends BasePage {

    WebDriver driver;
    @FindBy(xpath = "//h1[contains(text(), 'Your Orders')]")
    WebElement getOrderPageText;

    @FindBy(xpath = "//table//tbody/tr/td[2]")
    List<WebElement> getOrderList;

    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean findOrder(String order) {
        return getOrderList.stream()
                .anyMatch(ele -> ele.getText().equalsIgnoreCase(order));
    }

}
