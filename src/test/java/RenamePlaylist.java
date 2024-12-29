import org.example.LoginPage;
import org.example.PlayListPage;
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
    LoginPage loginPage = null;
    PlayListPage playListPage = null;

    @Test
    public void renamePlayListByDoubleClick() {
        loginPage = new LoginPage(driver);
        playListPage = new PlayListPage(driver);
        loginPage.login("iana.kocharian@testpro.io", "CwqOPgQw");
        playListPage.getPlusButton().click();
        playListPage.getNewPlayListButton().click();
        playListPage.getNewPlayListNameField().sendKeys(currentPlayListName);
        playListPage.getNewPlayListNameField().sendKeys(Keys.ENTER);
        WebElement playList = driver.findElement(By.xpath(String.format("//a[contains(text(), '%s')]", currentPlayListName)));
        actions.doubleClick(playList).perform();
        for (int i = 0; i < currentPlayListName.length(); i++) {
            playListPage.getPlayListInput().sendKeys(Keys.BACK_SPACE);
        }
        playListPage.getPlayListInput().sendKeys(newPlayListName);
        playListPage.getPlayListInput().sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(playList));
        Assert.assertEquals(playList.getText(), newPlayListName);
        playListPage.deletePlayListByButton(newPlayListName);
    }

//    @AfterMethod
//    public void deletePlayList() {
//        WebElement playList = driver.findElement(By.xpath(String.format("//a[contains(text(), '%s')]", newPlayListName)));
//        actions.contextClick(playList).perform();
//        WebElement deleteButton = driver.findElement(By.xpath("//li [contains(text(), 'Delete')]"));
//        deleteButton.click();
//    }
}
