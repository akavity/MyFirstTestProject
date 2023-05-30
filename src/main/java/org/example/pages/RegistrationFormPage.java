package org.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationFormPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder=\"Last Name\"]")
    private WebElement lastNameField;

    @FindBy(xpath = "//label[@for=\"gender-radio-1\"]")
    private WebElement maleRadioButton;

    @FindBy(xpath = "//input[@placeholder=\"Mobile Number\"]")
    private WebElement mobilePhoneNumberField;

    @FindBy(id = "react-select-3-input")
    private WebElement dropDown;

    @FindBy(id = "uploadPicture")
    private WebElement picture;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitButton;

    //     вариант с By
//    private By firstNameField = By.id("firstName");

    public RegistrationFormPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void clickButton() {
        maleRadioButton.click();
    }

    public void enterMobilePhoneNumber(String mobilePhoneNumber) {
        mobilePhoneNumberField.sendKeys(mobilePhoneNumber);
    }

    public void clickDropDown(String state) {
        dropDown.sendKeys(state);
        dropDown.sendKeys(Keys.RETURN);
    }

    public void uploadPictureInput(String path) {
        picture.sendKeys(path);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
