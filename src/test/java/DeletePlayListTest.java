import org.example.HomePage;
import org.example.LoginPage;
import org.example.PlayListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePlayListTest extends BaseTest {
    LoginPage loginPage = null;
    HomePage homePage = null;
    PlayListPage playListPage = null;

    @Test
    public void deletePlaylist() {
        String playListName = "TestPlayList";
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        playListPage = new PlayListPage(driver);
        loginPage.login("iana.kocharian@testpro.io", "CwqOPgQw");
        playListPage.createPlayList("TestPlayList");
        playListPage.deletePlayListByContextMenu(wait, actions, playListName);
        Assert.assertTrue(homePage.getToastNotification(wait).isDisplayed());
    }
}
