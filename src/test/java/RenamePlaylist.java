import org.example.LoginPage;
import org.example.PlayListPage;
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
        playListPage.createPlayList(currentPlayListName);
        playListPage.renamePlayListName(currentPlayListName, newPlayListName);
        Assert.assertEquals(playListPage.getPlayListByName(newPlayListName).getText(), newPlayListName);
        Assert.assertTrue(playListPage.getPlayListByName(newPlayListName).isDisplayed());
        playListPage.deletePlayListByButton(newPlayListName);
    }

    @AfterMethod
    public void rollBackChanges() {
        playListPage = new PlayListPage(driver);
        playListPage.renamePlayListName(newPlayListName, currentPlayListName);
    }
}
