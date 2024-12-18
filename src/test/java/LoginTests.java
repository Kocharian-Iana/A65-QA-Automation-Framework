import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test(groups = "Smoke")
    public void loginTest() {
        login("iana.kocharian@testpro.io", "CwqOPgQw");
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
        //Assert.assertEquals(driver.getCurrentUrl(),"https://qa.koel.app/#!/home");
    }

    @Test(groups = "Regression", dataProvider = "incorrectCredentials", dataProviderClass = DataProviderCredentials.class)
    public void loginWithIncorrectCredentials(String email,String password) {
        login(email,password);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }
}
