import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class Homework17 extends BaseTest {
   @Test
    public void addSongToPlaylist() throws InterruptedException {
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");
       WebDriver driver = new ChromeDriver(options);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       driver.get("https://qa.koel.app/");
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
       WebElement successMessage = driver.findElement(By.cssSelector(".alertify-logs"));
      String testMessage = successMessage.getText();
      // падает на ассерте?
      Assert.assertTrue(successMessage.isDisplayed());
      Assert.assertTrue(testMessage.contains("Created playlist 'test1.'"));

      WebElement deletePlaylistButton = driver.findElement(By.cssSelector(".btn-delete-playlist"));
      deletePlaylistButton.click();
      WebElement okButton = driver.findElement(By.cssSelector(".ok"));
      okButton.click();
      driver.quit();


    }

}
