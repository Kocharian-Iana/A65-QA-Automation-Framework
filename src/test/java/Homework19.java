import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
@Test
    public void deletePlaylist()  {
    login("iana.kocharian@testpro.io", "CwqOPgQw");
    WebElement plusButton = driver.findElement(By.cssSelector(".fa.fa-plus-circle.create"));
    plusButton.click();
    WebElement NewPlayListButton = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
    NewPlayListButton.click();
    WebElement newPlayListNameField = driver.findElement(By.cssSelector("input[placeholder='↵ to save']"));
    newPlayListNameField.sendKeys("TestPlayList");
    newPlayListNameField.sendKeys(Keys.ENTER);
    WebElement playList = driver.findElement(By.xpath("//a[contains(text(), 'TestPlayList')]"));
    Actions actions = new Actions(driver);
    actions.contextClick(playList).perform();
    WebElement deleteButton = driver.findElement(By.xpath("//li [contains(text(), 'Delete')]"));
    deleteButton.click();
    WebElement toastNotification = driver.findElement(By.xpath("//div[contains(text(),'Deleted playlist \"TestPlayList.\"')]"));
    Assert.assertTrue(toastNotification.isDisplayed());
}
}
