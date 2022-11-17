package rsa.TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import rsa.pageObjects.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public LandingPage landingPage;
    public RegisterPage registerPage;
    public ProductCataloge productCataloge;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public ConfirmationPage confirmationPage;


    @BeforeMethod(alwaysRun = true)
    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream(System.
                getProperty("user.dir") + "/src/main/java/rsa/resources/GlobalData.properties");
        prop.load(file);

        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");

        if (browserName.contains("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if (browserName.contains("headless")) {
                chromeOptions.addArguments("headless");
            }
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().setSize(new Dimension(1440, 900));

        } else if (browserName.contains("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            if (browserName.contains("headless")) {
                firefoxOptions.addArguments("headless");
            }
            driver = new FirefoxDriver();
            driver.manage().window().setSize(new Dimension(1440, 900));
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    public List<HashMap<String, String>> getJsonDataToMap(String path) throws IOException {

        // read json to string
        String jsonContent = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);

        //read string to hashmap
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.
                readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
                });
        return data;
    }

    public String getScreenShoot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File("C:\\Projects\\SeleniumJava" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return "C:\\Projects\\SeleniumJava" + testCaseName + ".png";

    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchLandingPageObject() {
        this.landingPage = new LandingPage(driver);
        return this.landingPage;
    }

    @BeforeMethod(alwaysRun = true)
    public RegisterPage launchRegisterObject() {
        this.registerPage = new RegisterPage(driver);
        return this.registerPage;
    }

    @BeforeMethod(alwaysRun = true)
    public ProductCataloge launchProductCatalogueObject() {
        this.productCataloge = new ProductCataloge(driver);
        return this.productCataloge;
    }

    @BeforeMethod(alwaysRun = true)
    public CartPage launchCartPageObject() {
        this.cartPage = new CartPage(driver);
        return this.cartPage;
    }

    @BeforeMethod(alwaysRun = true)
    public CheckoutPage launchCheckoutPageObject() {
        this.checkoutPage = new CheckoutPage(driver);
        return this.checkoutPage;

    }

    @BeforeMethod(alwaysRun = true)
    public ConfirmationPage launchConfirmationPageObject() {
        this.confirmationPage = new ConfirmationPage(driver);
        return this.confirmationPage;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
