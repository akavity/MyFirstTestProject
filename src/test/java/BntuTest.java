import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BntuTest {
    @Test
    public void checkRegistrationFromDataBntu() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "G:\\Installation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://bntu.by/user/login");

        WebElement loginField = driver.findElement(By.xpath("//input[@type=\"username\"]"));
        loginField.sendKeys("BasilAka");

        WebElement passwordField = driver.findElement(By.xpath("//input[@type=\"password\"]"));
        passwordField.sendKeys("12345");

        WebElement studentAccount = driver.findElement(By.xpath("//label[@class=\"custom-control-label\"]"));
        studentAccount.click();

        WebElement buttonGo = driver.findElement(By.xpath("//button[@class=\"buttonGo\"]"));
        buttonGo.click();

        driver.quit();
    }
}
