import org.example.pages.RegistrationBntuFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TwoBntuTest {
    private WebDriver driver;
    private RegistrationBntuFormPage registrationBntuFormPage;

    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.chrome.driver", "G:\\Installation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://bntu.by/user/login");
        registrationBntuFormPage = new RegistrationBntuFormPage(driver);
    }

    @Test
    public void checkRegistrationFromDataBntu() {
        registrationBntuFormPage.enterLogin("BasilAka");
        registrationBntuFormPage.enterPassword("12345");
        registrationBntuFormPage.clickStudentAccount();
        registrationBntuFormPage.clickButtonGo();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
