import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationPage extends BaseTest {
    @Test(groups = "Smoke")
    public void registrationNavigation() {
        WebElement registrationButton = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationButton.click();
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        Assert.assertTrue(emailField.isDisplayed());
    }
}