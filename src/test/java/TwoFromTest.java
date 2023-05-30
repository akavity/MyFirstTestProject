import org.example.pages.RegistrationFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TwoFromTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private RegistrationFormPage registrationFormPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "G:\\Installation\\chromedriver.exe");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        registrationFormPage = new RegistrationFormPage(driver, wait);
    }

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{{"Basil"}, {"Alex"}};
    }

    @Test(dataProvider = "data-provider")
    public void checkRegistrationFormData(String name) {
        registrationFormPage.enterFirstName(name);
        registrationFormPage.enterLastName("Akavity");
        registrationFormPage.clickButton();
        registrationFormPage.enterMobilePhoneNumber("7529545499");
        registrationFormPage.clickDropDown("NCR");
        registrationFormPage.uploadPictureInput("G:\\home\\akavity\\dev\\course-qa-automation-engineer\\" +
                "MyFirstTestProject\\src\\main\\resources\\2.jpg");
        registrationFormPage.clickSubmitButton();

        WebElement userDataText = driver.findElement(By.xpath(".//tr[1]/td[1]/following-sibling::td"));

        Assert.assertTrue(userDataText.getText().contains("Basil Akavity") ||
                userDataText.getText().contains("Alex Akavity"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
