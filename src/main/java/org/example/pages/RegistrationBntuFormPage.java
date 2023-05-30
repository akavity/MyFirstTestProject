package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationBntuFormPage {
    private WebDriver driver;
    @FindBy(xpath = "//input[@type=\"username\"]")
    private WebElement loginField;
    @FindBy(xpath = "//input[@type=\"password\"]")
    private WebElement passwordField;
    @FindBy(xpath = "//label[@class=\"custom-control-label\"]")
    private WebElement studentAccountButton;
    @FindBy(xpath = "//button[@class=\"buttonGo\"]")
    private WebElement buttonGo;

    public RegistrationBntuFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterLogin(String name) {
        loginField.sendKeys(name);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickStudentAccount() {
        studentAccountButton.click();
    }

    public void clickButtonGo() {
        buttonGo.click();
    }
}
