import org.example.HomePage;
import org.example.LoginPage;
import org.example.PlayListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CreatePlaylistTest extends BaseTest {
    PlayListPage playListPage = null;
    HomePage homePage = null;

    @Test
    public void createPlayList() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("iana.kocharian@testpro.io", "CwqOPgQw");
        homePage = new HomePage(driver);
        int previousSize = homePage.getAllPlayLists().size();
        playListPage = new PlayListPage(driver);
        playListPage.createPlayList("CreatePlayListTest");
        playListPage.getSuccessMessage();
        int actualSize = homePage.waitForUpdatedPlayLists(previousSize).size();
        Assert.assertNotEquals(actualSize, previousSize);
    }

    @AfterMethod
    public void rollBackChanges() {
        playListPage = new PlayListPage(driver);
        playListPage.deletePlayListByButton("CreatePlayListTest");
    }
}
