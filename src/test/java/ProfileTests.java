import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.UUID;

public class ProfileTests extends BaseTest{
    @Test
    public void changeProfileName(){
        String newName = UUID.randomUUID().toString();
        login("iana.kocharian@testpro.io", "CwqOPgQw");
        WebElement avatar = driver.findElement(By.cssSelector("#userBadge img"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#userBadge img")));
        avatar.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#inputProfileCurrentPassword")));
        WebElement currentPasswordField = driver.findElement(By.cssSelector("#inputProfileCurrentPassword"));
        currentPasswordField.clear();
        currentPasswordField.sendKeys("CwqOPgQw");
        WebElement profileNameField = driver.findElement(By.cssSelector("#inputProfileName"));
        profileNameField.clear();
        profileNameField.sendKeys(newName);
        WebElement saveButton = driver.findElement(By.cssSelector(".btn-submit"));
        saveButton.click();
        Assert.assertEquals(newName,profileNameField.getText());
    }
}
