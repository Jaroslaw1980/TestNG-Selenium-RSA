package rsa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import rsa.TestComponents.BaseTest;

import java.time.Duration;


public class Mielona extends BaseTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
//        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver", "C:/SeleniumDrivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/client");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

////        // register
////        driver.findElement(By.linkText("Register")).click();
//
//        driver.findElement(By.id("firstName")).sendKeys("");
//        driver.findElement(By.id("login")).click();
//        Thread.sleep(2000);
//        WebElement error = driver.findElement(By.xpath("//div[contains(text(), '*First Name is required')]"));
//        wait.until(ExpectedConditions.visibilityOf(error));
//        System.out.println(error.getText());






        driver.findElement(By.id("userEmail")).sendKeys("YaroBaro@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("YaroBaro$4");
        driver.findElement(By.id("login")).click();
//
////
////        // automation practice dashboard
////        driver.findElement(By.xpath("//h3"));
////
////        // dashboard/home button
////        driver.findElement(By.xpath("//button[@routerlink='/dashboard/']")).click();
////
//        // dashboard/ orders button
//        driver.findElement(By.xpath("//button[@routerlink='/dashboard/myorders']")).click();
////
////        // dashboard/ cart button
////        driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
////
////        // dashboard/ sign out button
////        driver.findElement(By.xpath("//i[@class='fa fa-sign-out']")).click();
//
//        // your orders page headtext
//        driver.findElement(By.xpath("//h1[contains(text(), 'Your Orders')]"));
//

//        List<WebElement> productList1 = driver.findElements(By.cssSelector(".mb-3"));
//        for(WebElement ele : productList1){
//            if(ele.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("adidas original")){
//                ele.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//            }
//        }
//
//        List<WebElement> productList = driver.findElements(By.cssSelector(".mb-3"));
//        System.out.println(productList.size());
//        WebElement prod = productList.stream().filter(product->product.
//                findElement(By.cssSelector("b"))
//                .getText()
//                .equalsIgnoreCase("adidas original"))
//                .findFirst()
//                .orElse(null);
//        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();


        Thread.sleep(2000);
        driver.close();
        }
}
