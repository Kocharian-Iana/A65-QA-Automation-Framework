import org.example.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    RegistrationPage registrationPage = null;
    @Test(groups = "Smoke")
    public void registrationNavigation() {
        registrationPage = new RegistrationPage(driver);
        registrationPage.getRegistrationButton().click();
        registrationPage.getEmailField();
        Assert.assertTrue(registrationPage.getEmailField().isDisplayed());
    }
}
