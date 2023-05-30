import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "G:\\Installation\\chromedriver.exe");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void checkRegistrationFormData() {

        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
//      WebElement firstNameField = driver.findElement(By.id("firstName"));
        firstNameField.sendKeys("Basil");

        WebElement lastNameField = driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]"));
        lastNameField.sendKeys("Akavity");

        WebElement maleRadioButton = driver.findElement(By.xpath("//label[@for=\"gender-radio-1\"]"));
        maleRadioButton.click();

        WebElement mobilePhoneNumberField = driver.findElement(By.xpath("//input[@placeholder=\"Mobile Number\"]"));
        mobilePhoneNumberField.sendKeys("7529545499");

        WebElement uploadPictureInput = driver.findElement(By.id("uploadPicture"));
        uploadPictureInput.sendKeys("G:\\home\\akavity\\dev\\course-qa-automation-engineer\\MyFirstTestProject\\src\\main\\resources\\2.jpg");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type=\"submit\"]")));
//      WebElement submitButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        submitButton.click();

        WebElement userDataText = driver.findElement(By.xpath(".//tr[1]/td[1]/following-sibling::td"));

        Assert.assertTrue(userDataText.getText().contains("Basil Akavity"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
