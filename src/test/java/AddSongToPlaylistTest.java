import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddSongToPlaylistTest extends BaseTest {
    @Test(groups = "Smoke")
    public void addSongToPlaylist() throws InterruptedException {
        WebElement loginField = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));

        loginField.sendKeys("iana.kocharian@testpro.io");
        passwordField.sendKeys("CwqOPgQw");
        submitButton.click();
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.sendKeys("BossStatus");
        searchField.sendKeys(Keys.ENTER);
        WebElement viewAllButton = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllButton.click();
        WebElement highlightSongInTheList = driver.findElement(By.xpath("/html//section[@id='songResultsWrapper']//table[@class='items']//td[@class='title']"));
        highlightSongInTheList.click();
        WebElement addToButton = driver.findElement(By.cssSelector(".btn-add-to"));
        addToButton.click();
        WebElement createNewPlaylist = driver.findElement(By.cssSelector("#songResultsWrapper [required]"));
        createNewPlaylist.sendKeys("test1");
        createNewPlaylist.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        String testMessage = successMessage.getText();
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(testMessage.contains("Created playlist \"test1.\""));
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylistButton.click();
        WebElement okButton = driver.findElement(By.cssSelector(".ok"));
        okButton.click();
    }

}