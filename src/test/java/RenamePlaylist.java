import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RenamePlaylist extends BaseTest {
    String currentPlayListName = "Test";
    String newPlayListName = "Succeed";

    @Test
    public void renamePlayListByDoubleClick() {

        login("iana.kocharian@testpro.io", "CwqOPgQw");
        WebElement plusButton = driver.findElement(By.cssSelector(".fa.fa-plus-circle.create"));
        plusButton.click();
        WebElement newPlayListButton = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        newPlayListButton.click();
        WebElement playListNameField = driver.findElement(By.cssSelector("input[placeholder='↵ to save']"));
        playListNameField.sendKeys(currentPlayListName);
        playListNameField.sendKeys(Keys.ENTER);
        WebElement playList = driver.findElement(By.xpath(String.format("//a[contains(text(), '%s')]", currentPlayListName)));

        actions.doubleClick(playList).perform();
        WebElement playListInput = driver.findElement(By.cssSelector("[data-testid = 'inline-playlist-name-input']"));
        for (int i = 0; i < currentPlayListName.length(); i++) {
            playListInput.sendKeys(Keys.BACK_SPACE);
        }
        playListInput.sendKeys(newPlayListName);
        playListInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(playList));
        Assert.assertEquals(playList.getText(), newPlayListName);

    }

    @AfterMethod
    public void deletePlayList() {
        WebElement playList = driver.findElement(By.xpath(String.format("//a[contains(text(), '%s')]", newPlayListName)));
        actions.contextClick(playList).perform();
        WebElement deleteButton = driver.findElement(By.xpath("//li [contains(text(), 'Delete')]"));
        deleteButton.click();
    }
}
