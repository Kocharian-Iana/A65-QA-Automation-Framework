import org.example.HomePage;
import org.example.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    LoginPage loginPage = null;
    HomePage homePage = null;

    @Test(groups = "Smoke")
    public void loginTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("iana.kocharian@testpro.io", "CwqOPgQw");
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getAvatar().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/#!/home");
    }

    @Test(groups = "Regression", dataProvider = "incorrectCredentials", dataProviderClass = DataProviderCredentials.class)
    public void loginWithIncorrectCredentials(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/");
    }
}
