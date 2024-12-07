import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginTest() {
        login("iana.kocharian@testpro.io", "CwqOPgQw");
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
        //Assert.assertEquals(driver.getCurrentUrl(),"https://qa.koel.app/#!/home");
    }
    @Test
    public void loginWithIncorrectPassword() {
        login("iana.kocharian@testpro.io", "incorrectPassword");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }
    @Test
    public void loginWithIncorrectEmail() {
        login("incorrect@Email.com", "CwqOPgQw");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }
}