import org.example.driver.DriverManager;
import org.example.pages.RegistrationFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {
    protected WebDriver driver;
    private RegistrationFormPage registrationFormPage;

//    @DataProvider(name = "data-provider")
//    public Object[][] dpMethod() {
//        return new Object[][]{{"Alex"}, {"Alex"}};
//    }

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        registrationFormPage = new RegistrationFormPage(driver);
    }

    @Test // (dataProvider = "data-provider")
    public void checkRegistrationFormData() {
        registrationFormPage.enterFirstName("Alex");
        registrationFormPage.enterLastName("Akavity");
        registrationFormPage.clickButton();
        registrationFormPage.enterMobilePhoneNumber("7529545499");
        registrationFormPage.clickDropDown("NCR");
        registrationFormPage.uploadPictureInput("G:\\home\\akavity\\dev\\course-qa-automation-engineer\\" +
                "MyFirstTestProject\\src\\main\\resources\\2.jpg");
        registrationFormPage.clickSubmitButton();

        WebElement userDataText = driver.findElement(By.xpath(".//tr[1]/td[1]/following-sibling::td"));

        Assert.assertTrue(userDataText.getText().contains("Alex Akavity"));
    }
}
