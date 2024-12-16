import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RenamePlaylist extends BaseTest {
    @Test
    public void renamePlayListByDoubleClick() {
        login("iana.kocharian@testpro.io", "CwqOPgQw");
        WebElement plusButton = driver.findElement(By.cssSelector(".fa.fa-plus-circle.create"));
        plusButton.click();
        WebElement NewPlayListButton = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        NewPlayListButton.click();
        WebElement PlayListNameField = driver.findElement(By.cssSelector("input[placeholder='↵ to save']"));
        PlayListNameField.sendKeys("Test");
        PlayListNameField.sendKeys(Keys.ENTER);
        WebElement playList = driver.findElement(By.xpath("//a[contains(text(), 'Test')]"));
        actions.doubleClick(playList).perform();
        WebElement playListEditing = driver.findElement(By.cssSelector("li.editing input[data-testid='inline-playlist-name-input']"));
        playListEditing.sendKeys("Succeed");
        playListEditing.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(playList));
        Assert.assertEquals(playList.getText(), "TestSucceed");
        //нужно удалить вконце плейлист!! доделать!!
    }
}
