package rsa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import rsa.abstractComponents.BasePage;

public class RegisterPage extends BasePage {
    WebDriver driver;

    @FindBy(id = "firstName")
    WebElement getFirstNameField;

    @FindBy(xpath = "//div[contains(text(), '*First Name is required')]")
    WebElement getFirstNameError;

    @FindBy(id = "lastName")
    WebElement getLastNameField;

    @FindBy(id = "userEmail")
    WebElement getUserEmailField;

    @FindBy(xpath = "//div[contains(text(), '*Email is required')]")
    WebElement getEmailError;

    @FindBy(id = "userMobile")
    WebElement getPhoneNumberField;

    @FindBy(xpath = "//div[contains(text(), '*Phone Number is required')]")
    WebElement getPhoneError;

    @FindBy(xpath = "//select[contains(@class, 'custom-select')]")
    WebElement getOccupationDropDown;

    @FindBy(xpath = "//input[@value='Male']")
    WebElement getGenderMaleCheckbox;

    @FindBy(xpath = "//input[@value='Female']")
    WebElement getGenderFemaleCheckbox;

    @FindBy(id = "userPassword")
    WebElement getUserPasswordField;

    @FindBy(xpath = "//div[contains(text(), '*Password is required')]")
    WebElement getPasswordError;

    @FindBy(id = "confirmPassword")
    WebElement getConfirmPasswordField;

    @FindBy(xpath = "//div[contains(text(), 'Confirm Password is required')]")
    WebElement getConfirmPasswordError;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement getAdultAgeCheckbox;

    @FindBy(xpath = "//div[contains(text(), '*Please check above checkbox')]")
    WebElement getAdultCheckboxError;

    @FindBy(id = "login")
    WebElement getSubmitRegisterButton;


    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // actions

    public void enterFirstName(String firstName) {
        getFirstNameField.sendKeys(firstName);
    }

    public String firstNameError() {
        return getFirstNameError.getText();
    }


    public void enterLastName(String lastName) {
        getLastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        getUserEmailField.sendKeys(email);
    }

    public String emailError() {
        return getEmailError.getText();
    }

    public void enterPhoneNumber(String number) {
        getPhoneNumberField.sendKeys(number);
    }

    public String phoneNumberError() {
        return getPhoneError.getText();
    }

    public void chooseOccupation(String occupation) {
        WebElement occupationList = getOccupationDropDown;
        occupationList.click();
        Select dropDownOccupation = new Select(occupationList);
        dropDownOccupation.selectByVisibleText(occupation);
        occupationList.click();
    }

    public void chooseGenderMale() {
        getGenderMaleCheckbox.click();
    }

    public void chooseGenderFemale() {
        getGenderFemaleCheckbox.click();
    }

    public void enterPassword(String password) {
        getUserPasswordField.sendKeys(password);
    }

    public String passwordError() {
        return getPasswordError.getText();
    }

    public void enterConfirmPassword(String confirmPassword) {
        getConfirmPasswordField.sendKeys(confirmPassword);
    }

    public String confirmPasswordError() {
        return getConfirmPasswordError.getText();
    }

    public void clickAdultCheckbox() {
        getAdultAgeCheckbox.click();
    }

    public String adultCheckboxError(){
        return getAdultCheckboxError.getText();
    }

    public void clickSubmitRegisterButton() {
        getSubmitRegisterButton.click();
    }
}
