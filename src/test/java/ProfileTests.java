import org.example.HomePage;
import org.example.LoginPage;
import org.example.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTests extends BaseTest {
    LoginPage loginPage = null;
    ProfilePage profilePage = null;

    @Test(description = "check if the profile name has been changed correctly", groups = "Smoke")
    public void changeProfileName() {
        loginPage = new LoginPage(driver);
        String newName = UUID.randomUUID().toString();
        loginPage.login("iana.kocharian@testpro.io", "CwqOPgQw");
        profilePage = new ProfilePage(driver);
        profilePage.getProfileAvatar(wait).click();
        profilePage.getCurrentPasswordField(wait).clear();
        profilePage.getCurrentPasswordField(wait).sendKeys("CwqOPgQw");
        WebElement profileNameField = driver.findElement(By.cssSelector("#inputProfileName"));
        profileNameField.clear();
        profileNameField.sendKeys(newName);
        WebElement saveButton = driver.findElement(By.cssSelector(".btn-submit"));
        saveButton.click();
        WebElement userNameLebel = driver.findElement(By.cssSelector("span .name"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span .name"), newName));
        Assert.assertEquals(newName, userNameLebel.getText());
    }
}
